package jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 *  使用GetMedian()方法获取当前读取数据的中位数。
 */

/*
 前言：
 Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，比如下面反转比较，完成大顶堆。
 
 思路：
 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 
 注：
 1、为了实现平均分配，可以在数据的总数目是偶数时把新数据插入最小堆，否则插入最大堆
 2、如果要插入最小堆的数据比最大堆的数据要小，则把这个新数据插入最大堆中，接着把最大堆中最大的数据插入最小堆中
 */
 
/*
offer，add区别：

一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。

这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。



poll，remove区别：

remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，

但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。



peek，element区别：

element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null
 */
 
public class Solution_InsertAndGetMedium
{
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>()
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
       count ++;
       if ((count & 1) == 0) { // 判断偶数的高效写法
           if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
               maxHeap.offer(num);
               num = maxHeap.poll();
           }
           minHeap.offer(num);
       } else {
           if(!minHeap.isEmpty() && num > minHeap.peek()) {
               minHeap.offer(num);
               num = minHeap.poll();
           }
           maxHeap.offer(num);
       }
    
    }
    
    public Double GetMedian() {
        if (count == 0)
            throw new RuntimeException("no available number !");
        double result;
        // 总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1) {
            result = maxHeap.peek();
        }else {
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    
    }
}

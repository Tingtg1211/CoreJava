package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class Solution_GetLeastNumbers
{
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length || k <= 0)
            return arrayList;
        int start = 0;
        int end = input.length - 1;
        int index = Partition(start, end, input);
        while (index != k - 1)
        {
            if (index > k - 1)
            {
                end = index - 1;
                index = Partition(start, end, input);
            }
            else
            {
                start = index + 1;
                index = Partition(start, end, input);
            }
        }
        for (int i = 0; i < k; i++)
        {
            arrayList.add(input[i]);
        }
        return arrayList;
        
    }
    
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length || k == 0)
        {
            return arrayList;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1); //从大到小排列
            }
        });
        for (int i = 0; i < input.length; i++)
        {
            if (maxHeap.size() != k)
            {
                maxHeap.offer(input[i]);
            }
            else if (maxHeap.peek() > input[i])
            {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        
        for (Integer integer : maxHeap)
        {
            arrayList.add(integer);
        }
        return arrayList;
        
    }
    
    private int Partition(int start, int end, int[] input)
    {
        int i, j, temp, t;
        if (start > end)
        {
            return 0;
        }
        i = start;
        j = end;
        temp = input[start];
        while (i < j)
        {
            while (i < j && temp <= input[j])
            {
                j--;
            }
            
            while (i < j && temp >= input[i])
            {
                i++;
            }
            if (i < j)
            {
                t = input[j];
                input[j] = input[i];
                input[i] = t;
            }
        }
        
        input[start] = input[i];
        input[i] = temp;
        return i;
        
    }
}

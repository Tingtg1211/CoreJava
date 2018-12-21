package jianzhi;

// 隐形的大数问题:m和n都在int型能表达的范围内但把他们拼接起来有可能溢出
// 数组里的数字拼接起来，位数一定相同，因此比较大小只需要按照字符串大小的比较规则
// 比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
// 如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        String str = "";
        for (int i = 0; i < numbers.length; i ++) {
            for (int j = i + 1; j < numbers.length; j ++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for (int i = 0; i < numbers.length; i ++){
            str += String.valueOf(numbers[i]);
        }
        return str;
    }
    
    public String PrintMinNumber_2(int[] numbers) {
        String str = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i ++){
            list.add(numbers[i]);
        }
    
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                 String s1 = o1 + "" + o2;
                 String s2 = o2 + "" + o1;
                 return s1.compareTo(s2);
            }
        });
        
        for (int j : list) {
            str += j;
        }
        return str;
    
    }
}

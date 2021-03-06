package com.algorithm.LeetCode;

/**67.
 * Given two binary strings, return their sum (also a binary string).

   For example,
   a = "11"
   b = "1"
   Return "100".
 */
public class Solution_addBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0)
                sum += a.charAt(i --) - '0'; //将该字符变为对应的数值
            if(j >= 0)
                sum += b.charAt(j --) - '0';
            sb.append(sum % 2);
            carry = sum / 2;

        }
        if (carry != 0) sb.append(carry);  //因为逆序，逆转后0无效
        return sb.reverse().toString(); //sb为逆序，需要逆转

    }
}

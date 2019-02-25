package jianzhi;

/**
 * 题目: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

public class Solution_multiply {
    // 参考剑指offer p313
    // 可以把B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1] 看成C[i]=A[0]*A[1]*...*A[i-1] 和D[i]=A[i+1]*...*A[n-1]的乘积
    // 其中C[i] = A[i-1]*C[i-1] , D[i]= D[i + 1] * A[i + 1]
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            // 先计算下三角连乘，由图中的自上而下顺序计算
            for (int i = 1; i < length; i ++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            // 计算上三角,由图中的自下而上顺序计算
            for (int j = length - 2; j >=0; j --) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}

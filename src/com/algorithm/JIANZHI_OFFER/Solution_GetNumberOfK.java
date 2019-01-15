package jianzhi;

public class Solution_GetNumberOfK {
    //因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
    //这两个数应该插入的位置，然后相减即可。
    // 看见有序肯定就是二分查找了，值得一提的是，不要拘泥于递归，要会循环写法
    public int GetNumberOfK(int [] array , int k) {
        return BiSearch(array, k + 0.5) - BiSearch(array, k - 0.5);
    }
    
    // 注意array数组是int类型，num是double类型，所以不会存在array[mid]=num的情况，也就不会存在死循环。
    private static int BiSearch(int [] array, double num) {
        int s = 0, e = array.length -1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if(array[mid] < num) {
                s = mid + 1;
            }else if (array[mid] > num){
                e = mid - 1;
            }
            
        }
        return s;
    
    }
    
    // 法二：由于数组有序，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置
    public int GetNumberOfK_2(int [] array, int k) {
        int lower = GetLower(array, k);
        int upper = GetUpper(array, k);
        return upper - lower + 1;
        
    }
    
    private int GetLower(int [] array, int k){
        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if(array[mid] < k) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
    
    private int GetUpper(int [] array, int k){
        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if(array[mid] <= k) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
    
        }
        return end;
        
    
    }
    public static void main(String[] args) {
        int[] array = {1};
        int num = BiSearch(array, 1.5) - BiSearch(array, 0.5);
        System.out.print(num);
    }
    
    
}

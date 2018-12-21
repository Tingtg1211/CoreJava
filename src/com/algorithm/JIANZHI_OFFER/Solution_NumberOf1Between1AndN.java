package jianzhi;

public class Solution_NumberOf1Between1AndN
{
    public int NumberOf1Between1AndN_Solution(int n)
    {
        int number = 0;
        for (int i = 1; i <= n; i++)
        {
            number += NumberOf1(i);
            
        }
        return number;
    }
    
    private int NumberOf1(int n)
    {
        int number = 0;
        while (n != 0)
        {
            if (n % 10 == 1)
            {
                number++;
            }
            n = n / 10;
        }
        return number;
    }
}

package com.github.toyset.mireyntest2;

public class Util
{

    private static final int[] DENOMINATIONS = { 5, 10, 25, 50 };
    
    
    public static int countWaysToProduceGivenAmountOfMoney(int cents)
    {
        if(cents < 0)
        {
            throw new IllegalArgumentException();
        }
        
        return countForLevel(cents, DENOMINATIONS.length - 1);
    }
    
    private static int countForLevel(int cents, int level)
    {
        if(level == 0)
        {
            return cents/DENOMINATIONS[0] + 1;
        }
        
        int count = 0;
        do
        {
            count += countForLevel(cents, level-1);
            cents -= DENOMINATIONS[level];
        }
        while(cents > 0);
        
        return count;
    }
}

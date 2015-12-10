package com.github.toyset.mireyntest1;

public class ExtLib
{

    public long eval(long a, long p)
    {
        long result = 1;
        for(int i=0; i<p; ++i)
        {
            result *= a;
        }
        
        return result;
    }
}

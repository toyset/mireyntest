package com.github.toyset.mireyntest1;

import org.junit.Assert;
import org.junit.Test;

import com.github.toyset.mireyntest1.Evaluator;
import com.github.toyset.mireyntest1.ExtLib;

public class EvaluatorTest
{

    @Test
    public void testEvaluate()
    {
        final long[] data = new long[1000000];
        for(int i=0; i<data.length; ++i)
        {
            data[i] = i;
        }
        
        final long[] result = Evaluator.evaluate(data, 3);
        final long[] refResult = refEvaluate(data, 3);
        
        Assert.assertArrayEquals(refResult, result);
    }
    
    private static long[] refEvaluate(long[] data, int p)
    {
        final ExtLib extLib = new ExtLib();
        final long[] result = new long[data.length];
        
        for(int i=0; i<data.length; ++i)
        {
            result[i] = extLib.eval(data[i], p);
        }
        
        return result;
    }
}

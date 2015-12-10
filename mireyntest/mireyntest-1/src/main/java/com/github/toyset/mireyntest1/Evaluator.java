package com.github.toyset.mireyntest1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Evaluator
{

    private static final ForkJoinPool POOL = new ForkJoinPool();
    
    
    public static long[] evaluate(long[] data, int p)
    {
        final long[] result = new long[data.length];
        final ForkJoinTask<?> task = new EvaluatingTask(data, result, p, 0, data.length);
        
        POOL.submit(task);
        
        task.join();
        
        return result;
    }
}

package com.github.toyset.mireyntest1;

import java.util.concurrent.RecursiveAction;

public class EvaluatingTask extends RecursiveAction
{

    private static final long serialVersionUID = -1343366092310507436L;
    
    private static final int SURPLUS_THRESHOLD = 4;
    private static final int SIZE_THRESHOLD = 10000;
    
    
    private final ExtLib extLib = new ExtLib();
    
    private final long[] data;
    private final long[] result;
    
    private final int p;
    
    private final int from;
    private final int to;
    
    
    public EvaluatingTask(long[] data, long[] result, int p, int from, int to)
    {
        this.data = data;
        this.result = result;
        
        this.p = p;
        
        this.from = from;
        this.to = to;
    }
    
    @Override
    protected void compute()
    {
        if((to - from) <= SIZE_THRESHOLD || 
            getSurplusQueuedTaskCount() >= SURPLUS_THRESHOLD)
        {
            for(int i=from; i<to; ++i)
            {
                result[i] = extLib.eval(data[i], p);
            }
        }
        else
        {
            final int mid = (to + from) >>> 1;
            
            invokeAll(
                new EvaluatingTask(data, result, p, from, mid), 
                new EvaluatingTask(data, result, p, mid, to));
        }
    }

}

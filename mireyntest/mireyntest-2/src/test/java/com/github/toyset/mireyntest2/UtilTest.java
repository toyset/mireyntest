package com.github.toyset.mireyntest2;

import org.junit.Assert;
import org.junit.Test;

import com.github.toyset.mireyntest2.Util;

public class UtilTest
{

    @Test
    public void countWaysToProduceGivenAmountOfMoneyTest11_4()
    {
        final int count = Util.countWaysToProduceGivenAmountOfMoney(11);
        
        Assert.assertEquals(4, count);
    }
}

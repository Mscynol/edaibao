package com.alexis.edaibao.core;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author cc-zj
 * @create 2022-04-13 14:46
 */
public class AssertTests {
    @Test
    public void test1(){
        Object o = null;
        if (o == null) {
            throw new IllegalArgumentException("参数错误");
        }
    }
    @Test
    public void test2(){
        Object o = null;
        Assert.assertNotNull("参数错误",o);
    }
}

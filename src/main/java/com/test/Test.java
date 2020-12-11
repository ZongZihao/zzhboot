package com.test;

import com.test.sort.SortTester;
import com.zzh.core.ZzhApplication;
import com.zzh.core.ioc.BeanFactory;

/**
 * @ClassName : test
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-07-15 17:27
 */

public class Test {

    public static void main(String[] args) throws Exception {

        ZzhApplication.run(Test.class);

        SortTester tester = (SortTester) BeanFactory.getBean(SortTester.class);

        tester.sort();
    }

}


package com.test;

import com.zzh.ZzhApplication;
import com.zzh.container.MyContainer;
import com.zzh.test.SortTester;

/**
 * @ClassName : test
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-07-15 17:27
 */

public class Test {

    public static void main(String[] args) throws Exception {

        ZzhApplication.run(Test.class);

        SortTester tester = (SortTester) MyContainer.getBean(SortTester.class);

        tester.sort();
    }

}


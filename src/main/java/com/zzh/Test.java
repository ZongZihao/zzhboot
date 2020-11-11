package com.zzh;

import com.zzh.container.MyContainer;
import com.zzh.test.SortTester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


package com.zzh;

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
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
            list.add(1);
        }

        ZzhApplication.run(Test.class);
    }

}


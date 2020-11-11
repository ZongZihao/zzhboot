package com.zzh.test;


import com.zzh.container.Autowired;
import com.zzh.container.Component;
import com.zzh.sort.SelectSort;
import com.zzh.sort.Sortable;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @ClassName : SortTester
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:45
 */
@Component
public class SortTester {

    @Autowired
    private SelectSort sortable;

    public void sort(){
//        Sortable sortable = new SelectSort();
        Long time = sortTimeCalculate(x -> sortable.sort(x, Comparator.comparingInt(y -> y)), 1000, true);

        System.out.println(time);
    }

    private List<Integer> createList(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            Random random = new Random();
            list.add(random.nextInt(num));
        }
        return list;
    }

    private Long sortTimeCalculate(Consumer<List<Integer>> consumer, int num, boolean isPrint){
        Long t1 = System.currentTimeMillis();
        List<Integer> list = createList(num);
        consumer.accept(list);
        Long t2 = System.currentTimeMillis();

        if(isPrint){
            System.out.println(list);
        }

        return t2 - t1;
    }

}

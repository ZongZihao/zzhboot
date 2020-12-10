package com.zzh.test;


import com.zzh.container.Autowired;
import com.zzh.container.Component;
import com.zzh.sort.BubbleSort;
import com.zzh.sort.SelectSort;
import com.zzh.sort.Sortable;

import java.nio.channels.Selector;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName : SortTester
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:45
 */
@Component
public class SortTester {

    @Autowired
    private BubbleSort sortable;

    public void sort(){
//        Sortable sortable = new SelectSort();
        sortTimeCalculate(x -> sortable.sort(x, Comparator.comparingInt(y -> y)), 2000, false);

        sortTimeCalculate(x -> Collections.sort(Arrays.asList(x)), 2000, false);

    }

    private Integer[] createList(int num){
        Integer[] list = new Integer[num];
        for(int i = 0; i < num; i++){
            Random random = new Random();
            list[i] = random.nextInt(num);
        }
        return list;
    }

    private Long sortTimeCalculate(Consumer<Integer[]> consumer, int num, boolean isPrint){
        Long t1 = System.currentTimeMillis();
        Integer[] list = createList(num);
        consumer.accept(list);
        Long t2 = System.currentTimeMillis();

        if(isPrint){
            String str = Stream.of(list).map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(str);
        }

        System.out.println((t2 - t1) / 1000 + "." + (t2 - t1) % 1000 + "ms");

        return t2 - t1;
    }

}

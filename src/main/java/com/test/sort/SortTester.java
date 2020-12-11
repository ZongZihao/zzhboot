package com.test.sort;


import com.zzh.annotation.Autowired;
import com.zzh.annotation.Component;

import java.util.*;
import java.util.function.Consumer;
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

        int num = 10000;

//        Sortable sortable = new SelectSort();
        System.out.print(sortable.getSorterName() + ": ");
        sortTimeCalculate(x -> sortable.sort(x, Comparator.comparingInt(y -> y)), num, false);

        System.out.print("系统排序: ");
        sortTimeCalculate(Arrays::sort, num, false);

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

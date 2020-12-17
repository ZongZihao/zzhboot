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
    private List<Sortable> sortableList;

    public void sort(){

        int num = 10000000;

        for (Sortable sortable : sortableList) {
            System.out.print(sortable.getSorterName() + ": ");
            sortTimeCalculate(sortable, Comparator.comparingInt(y -> y), num, false, true);
        }

        System.out.print("系统排序: ");
        Integer[] tmpList = createList(num);
        Long t1 = System.currentTimeMillis();
        Arrays.sort(tmpList);
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / 1000 + "." + (t2 - t1) % 1000 + "s");

    }

    private Integer[] createList(int num){
        Integer[] list = new Integer[num];
        for(int i = 0; i < num; i++){
            Random random = new Random();
            list[i] = random.nextInt(num);
        }
        return list;
    }

    private Long sortTimeCalculate(Sortable sortable, Comparator<Integer> comparator, int num, boolean isPrint, boolean isCheck){
        Integer[] list = createList(num);

        Long t1 = System.currentTimeMillis();
        sortable.sort(list, comparator);
        Long t2 = System.currentTimeMillis();

        if(isPrint){
            String str = Stream.of(list).map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(str);
        }

        if(isCheck){
            if(SortChecker.checkSort(list, comparator)){
                System.out.println("pass");
            }else{
                System.out.println("fail");
            }
        }

        System.out.println((t2 - t1) / 1000 + "." + (t2 - t1) % 1000 + "s");

        return t2 - t1;
    }

}

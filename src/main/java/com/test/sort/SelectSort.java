package com.test.sort;

import com.zzh.annotation.Component;

import java.util.*;

/**
 * @ClassName : SelectSort
 * @Description : 选择排序
 * @Author : 宗子豪
 * @Date: 2020-06-29 09:24
 */
@Component
public class SelectSort implements Sortable {

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        if(list == null || list.length <= 1){
            return;
        }

        for(int i = 0; i < list.length; i++){
            //先定义待置换的位置为最小值
            T min = list[i];
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++){
                T current = (T) list[j];
                //如果当前比最小的小, 则记录
                if(comparator.compare(current, min) < 0){
                    min = current;
                    minIndex = j;
                }
                //如果是最后一个, 将最小的和索引i位置调换
                if(j == list.length - 1){
                    this.swap(list, i, minIndex);
                }
            }
        }

    }

    @Override
    public String getSorterName() {
        return "选择排序";
    }
}

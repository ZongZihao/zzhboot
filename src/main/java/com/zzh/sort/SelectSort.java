package com.zzh.sort;

import com.zzh.container.Component;

import java.util.*;

/**
 * @ClassName : SelectSort
 * @Description : 选择排序
 * @Author : 宗子豪
 * @Date: 2020-06-29 09:24
 */
@Component
public class SelectSort implements Sortable {

    public String name = "选择排序";

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        if(list == null || list.size() <= 1){
            return;
        }

        Object[] array = list.toArray();

        for(int i = 0; i < array.length; i++){
            //先定义待置换的位置为最小值
            T min = (T) array[i];
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                T current = (T) array[j];
                //如果当前比最小的小, 则记录
                if(comparator.compare(current, min) < 0){
                    min = current;
                    minIndex = j;
                }
                //如果是最后一个, 将最小的和索引i位置调换
                if(j == list.size() - 1){
                    this.swap(array, i, minIndex);
                }
            }
        }

        //重新复制给List
        ListIterator<T> iterator = list.listIterator();
        for(Object e : array){
            iterator.next();
            iterator.set((T) e);
        }
    }

    /**
     * 调换两个元素位置
     */
    private void swap(Object[] a, int o1, int o2){

        Object tmp = a[o1];

        a[o1] = a[o2];

        a[o2] = tmp;


    }
}

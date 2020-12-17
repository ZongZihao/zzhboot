package com.test.sort;

import com.zzh.annotation.Component;

import java.util.Comparator;

/**
 * @ClassName : InsertSort
 * @Description : 插入排序
 * @Author : 宗子豪
 * @Date: 2020-12-16 14:48
 */
//@Component
public class InsertSort implements Sortable{

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {

        for(int i = 1; i < list.length; i++){
            //待插入已排序区间的值
            T value = list[i];
            int j = i - 1;
            for(; j >= 0; j--){
                //已排序区间
                if(comparator.compare(value, list[j]) < 0){
                    //移动位置
                    list[j + 1] = list[j];
                }else{
                    break;
                }
            }
            list[j + 1] = value;
        }

    }

    @Override
    public String getSorterName() {
        return "插入排序";
    }
}

package com.zzh.sort;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName : Sortable
 * @Description : 可排序接口
 * @Author : 宗子豪
 * @Date: 2020-06-29 09:27
 */

public interface Sortable {

    /**
     * 排序
     * @param list 传入列表
     * @param comparator 比较器
     */
    <T> void sort(T[] list, Comparator<T> comparator);

    /**
     * 获取排序方式名称
     * @return
     */
    String getSorterName();

    /**
     * 调换数组中两个元素的位置
     * @param a
     * @param o1
     * @param o2
     * @param <T>
     */
    default <T> void swap(T[] a, int o1, int o2){

        T tmp = a[o1];

        a[o1] = a[o2];

        a[o2] = tmp;
    }

}

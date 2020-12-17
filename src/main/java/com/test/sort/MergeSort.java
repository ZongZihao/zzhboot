package com.test.sort;

import com.zzh.annotation.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName : MergeSort
 * @Description : 归并排序
 * @Author : 宗子豪
 * @Date: 2020-12-17 10:47
 */
@Component
public class MergeSort implements Sortable{


    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {

        int p = 0;
        int r = list.length - 1;
        mergeSort(list, p, r, comparator);
    }

    private <T> void mergeSort(T[] list, int p, int r, Comparator<T> comparator){

        if(p >= r){
            //基线条件 如果不能够在分解
            return;
        }

        int q = (r + p) / 2;

        mergeSort(list, p, q, comparator);
        mergeSort(list, q + 1, r, comparator);

        //执行合并
        merge(list, p, q, r, comparator);

    }

    /**
     * 合并两个已排序好的数组
     * @param list
     * @param p
     * @param q
     * @param r
     * @param comparator
     * @param <T>
     */
    private <T> void merge(T[] list, int p, int q, int r, Comparator<T> comparator){
        //开辟临时数组
        @SuppressWarnings({"unchecked"})
        T[] tmpList = (T[]) Array.newInstance(list.getClass().getComponentType(), r - p + 1);
        int i = p;
        int j = q + 1;
        int cursor = 0;

        while(i <= q && j <= r){
            T a = list[i];
            T b = list[j];
            if(comparator.compare(a, b) <= 0){
                tmpList[cursor] = a;
                i++;
            }else{
                tmpList[cursor] = b;
                j++;
            }
            cursor++;
        }

        //看哪个还有剩余元素
        while(i <= q){
            tmpList[cursor] = list[i];
            i++;
            cursor++;
        }
        while(j <= r){
            tmpList[cursor] = list[j];
            j++;
            cursor++;
        }

        //重新将临时数据赋值给原数组
        int scanCursor = 0;
        for(int k = p; k <= r; k++, scanCursor++){
            list[k] = tmpList[scanCursor];
        }

    }

    @Override
    public String getSorterName() {
        return "归并排序";
    }
}

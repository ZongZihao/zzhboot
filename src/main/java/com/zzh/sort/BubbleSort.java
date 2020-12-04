package com.zzh.sort;

import com.zzh.container.Component;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName : BubbleSort
 * @Description : 冒泡排序
 * @Author : 宗子豪
 * @Date: 2020-09-24 12:13
 */
@Component
public class BubbleSort implements Sortable {

    public String name = "冒泡排序";

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {

        if(list == null || list.length <= 1){
            return;
        }

        for(int i = 0; i < list.length - 1; i++){

            boolean hasChange = false;

            for(int j = 0; j < list.length - 1; j++) {
                //对比判断调换两个相邻元素位置
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    this.swap(list, j + 1, j);
                    hasChange = true;
                }
            }

            if(!hasChange){
                return;
            }
        }

    }

    @Override
    public String getSorterName() {
        return "冒泡排序";
    }
}

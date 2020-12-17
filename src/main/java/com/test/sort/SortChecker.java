package com.test.sort;

import java.util.Comparator;

/**
 * @ClassName : SortCheker
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-12-16 16:36
 */

public class SortChecker {

    public static <T> boolean checkSort(T[] list, Comparator<T> comparator){
        for(int i = 1; i < list.length; i++){
            if(comparator.compare(list[i], list[i - 1]) < 0){
                return false;
            }
        }
        return true;
    }

}

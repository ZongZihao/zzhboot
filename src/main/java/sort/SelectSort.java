package sort;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName : SelectSort
 * @Description : 选择排序
 * @Author : 宗子豪
 * @Date: 2020-06-29 09:24
 */

public class SelectSort implements Sortable{

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        if(list == null || list.size() <= 1){
            return;
        }

        T min = list.get(1);

    }
}

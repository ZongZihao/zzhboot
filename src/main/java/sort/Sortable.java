package sort;

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
    <T> void sort(List<T> list, Comparator<T> comparator);

}

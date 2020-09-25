package sort;

import com.sun.javafx.collections.SortableList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @ClassName : sort
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-06-29 09:23
 */

public class Sort {

    public static void main(String[] args){

        Sortable sortable = new SelectSort();

        Long time = sortTimeCalculate(x -> sortable.sort(x, Comparator.comparingInt(y -> y)), 1000, true);

        System.out.println(time);
    }

    public static List<Integer> createList(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            Random random = new Random();
            list.add(random.nextInt(num));
        }
        return list;
    }

    public static Long sortTimeCalculate(Consumer<List<Integer>> consumer, int num, boolean isPrint){
        Long t1 = System.currentTimeMillis();
        List<Integer> list = createList(num);
        consumer.accept(list);
        Long t2 = System.currentTimeMillis();

        if(isPrint){
            System.out.println(list);
        }

        return t2 - t1;
    }

}

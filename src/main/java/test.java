import proxy.SayHello;
import proxy.SayHelloImpl;
import proxy.SayHelloProxy;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ClassName : test
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-07-15 17:27
 */

public class test {

    public static void main(String[] args) {

        int num = 1;

        new ArrayList<Integer>() {{
            add(1);
        }}.forEach(x -> {
            System.out.println(num);
        });
    }

}


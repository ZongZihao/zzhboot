package proxy;

/**
 * @ClassName : SayHelloImpl
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-08-26 12:17
 */

public class SayHelloImpl implements SayHello{
    @Override
    public void sayHello(String name, Integer year) {
        String str = String.format("Hello, name: %s, age: %d", name, year);
        System.out.println(str);
    }
}

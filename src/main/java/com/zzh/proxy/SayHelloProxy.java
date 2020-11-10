package com.zzh.proxy;

import com.zzh.proxy.SayHello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName : SayHelloProxy
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-08-26 12:18
 */

public class SayHelloProxy {

    private SayHello sayHello;

    public SayHelloProxy(SayHello sayHello){
        this.sayHello = sayHello;
    }

    public Object getProxyInstance(){
        Object proxyInstance = Proxy.newProxyInstance(sayHello.getClass().getClassLoader(), sayHello.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("before say hello");
            Object ret = method.invoke(sayHello, args);
            System.out.println("after say hello");
            return ret;
        });
        return proxyInstance;
    }

}

package com.zzh.container;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : MyContainer
 * @Description : 容器!
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:47
 */

public class MyContainer {

    private static Map<String, Object> contextBeanMap;

    public static void addBean(String name, Object bean){
        if(contextBeanMap == null){
            contextBeanMap = new HashMap<>();
        }
        contextBeanMap.put(name, bean);
    }

    public static Object getBean(Field field){
        Class clazz = field.getType();
        //todo 暂时不考虑接口
        return getBean(clazz);
    }

    public static Object getBean(Class clazz){
        String key = clazz.getPackage().getName().concat(".").concat(clazz.getName());
        //todo 暂时不考虑接口
        return contextBeanMap.get(key);
    }

}

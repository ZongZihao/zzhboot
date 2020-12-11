package com.zzh.core.ioc;

import com.zzh.annotation.Component;
import com.zzh.common.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : MyContainer
 * @Description : 容器!
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:47
 */

public class BeanFactory {

    public static Map<String, Object> CONTEXT_BEAN = new ConcurrentHashMap<>();

    /**
     * 加载Bean
     */
    public static void loadBean(){

        for (Class<?> aClass : ClassFactory.CLASSES.get(Component.class)) {
            String beanFullName = getFullQualifierName(aClass);
            Object o = ReflectionUtil.newInstance(aClass);
            CONTEXT_BEAN.put(beanFullName, o);
        }
    }

    public static Object getBean(Field field){
        Class<?> clazz = field.getType();
        return getBean(clazz);
    }

    public static Object getBean(String fullName){
        return CONTEXT_BEAN.get(fullName);
    }

    public static Object getBean(Class<?> clazz){
        String beanFullName = getFullQualifierName(clazz);
        return CONTEXT_BEAN.get(beanFullName);
    }

    /**
     * 获取类的全限定名
     * @param clazz
     * @return
     */
    public static String getFullQualifierName(Class<?> clazz){
        return clazz.getPackage().getName().concat(".").concat(clazz.getName());
    }

}

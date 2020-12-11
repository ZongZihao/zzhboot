package com.zzh.common.utils;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @ClassName : ReflectionUtil
 * @Description : 反射工具类
 * @Author : 宗子豪
 * @Date: 2020-12-10 14:58
 */

public class ReflectionUtil {

    /**
     * 获取指定包下 所有被注解标注的类
     * @param packagesName 指定包命
     * @param annotation 指定注解
     * @return
     */
    public static Set<Class<?>>scanAnnotatedClass(String[] packagesName, Class<? extends Annotation> annotation){
        Reflections reflections = new Reflections(packagesName, new TypeAnnotationsScanner());
        Set<Class<?>> annotatedClass = reflections.getTypesAnnotatedWith(annotation, true);
        return annotatedClass;
    }

    /**
     * 获取指定包下, 指定接口的所有实现类
     * @param packageNames 指定报名
     * @param interfaceClass 指定接口类
     * @param <T>
     * @return
     */
    public static <T> Set<Class<? extends T>> getSubClass(String[] packageNames, Class<T> interfaceClass){
        Reflections reflections = new Reflections(packageNames);
        return reflections.getSubTypesOf(interfaceClass);
    }

    /**
     * 实例化一个类
     * @param clazz
     * @return
     */
    public static Object newInstance(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 为示例属性赋值
     * @param obj
     * @param field
     * @param value
     */
    public static void setFieldValue(Object obj, Field field, Object value)  {
        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

}

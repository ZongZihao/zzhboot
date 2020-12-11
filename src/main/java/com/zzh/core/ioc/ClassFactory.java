package com.zzh.core.ioc;

import com.zzh.annotation.Component;
import com.zzh.common.utils.ReflectionUtil;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : ClassFacory
 * @Description : 类工程
 * @Author : 宗子豪
 * @Date: 2020-12-11 10:57
 */

public class ClassFactory {

    public static final Map<Class<? extends Annotation>, Set<Class<?>>> CLASSES = new ConcurrentHashMap<>();

    /**
     * 加载类文件
     * @param packageNames 包名
     */
    public static void loadClass(String[] packageNames){
        Set<Class<?>> classWithComponent = ReflectionUtil.scanAnnotatedClass(packageNames, Component.class);
        CLASSES.put(Component.class, classWithComponent);
    }

}

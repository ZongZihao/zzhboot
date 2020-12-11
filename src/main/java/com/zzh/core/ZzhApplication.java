package com.zzh.core;

import com.zzh.core.ioc.AutowiredBeanInitialization;
import com.zzh.core.ioc.BeanFactory;
import com.zzh.core.ioc.ClassFactory;

/**
 * @ClassName : ZzhApplication
 * @Description : 我的应用程序
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:48
 */

public class ZzhApplication {

    /**
     * 将传入方法的类所属包下的所有类进行扫描
     * @param rootClazz
     */
    public static void run(Class<?> rootClazz) throws Exception {

        //获取包名
        String[] packageNames = new String[]{rootClazz.getPackage().getName()};

        //加载所有需要加载的类
        ClassFactory.loadClass(packageNames);

        //实例化所有类到容器
        BeanFactory.loadBean();

        //注入依赖
        AutowiredBeanInitialization autowiredBeanInitialization = new AutowiredBeanInitialization(packageNames);
        BeanFactory.CONTEXT_BEAN.values().forEach(autowiredBeanInitialization::initialize);

    }


}

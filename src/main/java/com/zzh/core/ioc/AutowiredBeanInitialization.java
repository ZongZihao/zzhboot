package com.zzh.core.ioc;

import com.zzh.annotation.Autowired;
import com.zzh.common.utils.ReflectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @ClassName : AutowiredBeanInitialization
 * @Description : 自动装配初始化类
 * @Author : 宗子豪
 * @Date: 2020-12-11 11:31
 */

public class AutowiredBeanInitialization {

    private final String[] packageNames;

    public AutowiredBeanInitialization(String[] packageNames){
        this.packageNames = packageNames;
    }

    /**
     * 对类属性注入依赖
     * @param beanInstance
     */
    public void initialize(Object beanInstance) {

        Class<?> clazz = beanInstance.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(Autowired.class)){
                field.setAccessible(true);
                Object fieldValue = BeanFactory.getBean(field);
                ReflectionUtil.setFieldValue(beanInstance, field, fieldValue);
            }
        }

    }


}

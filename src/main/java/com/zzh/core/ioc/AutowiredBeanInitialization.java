package com.zzh.core.ioc;

import com.zzh.annotation.Autowired;
import com.zzh.annotation.Component;
import com.zzh.common.utils.ReflectionUtil;
import com.zzh.exception.InterfaceNotHaveImplementedClassException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

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
                Object fieldValue = processAutowiredAnnotationField(field);
                ReflectionUtil.setFieldValue(beanInstance, field, fieldValue);
            }
        }

    }

    /**
     * 处理被autowired标记的属性
     * @param beanField
     * @return
     */
    public Object processAutowiredAnnotationField(Field beanField){
        Class<?> beanFieldClass = beanField.getType();
        String fullName = BeanFactory.getFullQualifierName(beanFieldClass);
        Object instance;
        if(beanFieldClass.isInterface()){
            @SuppressWarnings("unchecked")
            Set<Class<?>> subClasses = ReflectionUtil.getSubClass(packageNames, (Class<Object>) beanFieldClass);
            //去掉所有不带注解的
            subClasses.removeIf(x -> !x.isAnnotationPresent(Component.class));
            if(subClasses.size() == 0){
                throw new InterfaceNotHaveImplementedClassException(beanField.getName() + "is interface and do not have implemented class exception");
            }
            if(subClasses.size() == 1){
                Class<?> subClass =subClasses.iterator().next();
                fullName = BeanFactory.getFullQualifierName(subClass);
            }
            if(subClasses.size() > 1){
                //todo 根据@Qualified查找
            }
        }
        instance = BeanFactory.getBean(fullName);
        if(instance == null){
            //todo throw exception
        }
        return instance;

    }


}

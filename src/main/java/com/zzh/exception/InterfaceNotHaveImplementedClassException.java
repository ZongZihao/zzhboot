package com.zzh.exception;

/**
 * @ClassName : InteterfaceNotHaveImplementedClassException
 * @Description : 未找到接口实现类异常
 * @Author : 宗子豪
 * @Date: 2020-12-11 15:13
 */

public class InterfaceNotHaveImplementedClassException extends RuntimeException {

    public InterfaceNotHaveImplementedClassException(String message){
        super(message);
    }

}

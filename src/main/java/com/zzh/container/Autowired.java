package com.zzh.container;

import java.lang.annotation.*;

/**
 * @ClassName : Autowired
 * @Description :
 * @Author : 宗子豪
 * @Date: 2020-11-11 15:15
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
}

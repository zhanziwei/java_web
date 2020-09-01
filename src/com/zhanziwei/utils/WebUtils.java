package com.zhanziwei.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParam2Bean(Map value, T bean) {
        try {

            BeanUtils.populate(bean, value);
            System.out.println(bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str){
        return Integer.parseInt(str);
    }

}

package org.audience.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

/**
 * author:Audience
 * date:2018/9/10
 * time:11:34
 */
@Component
public class BeansUtils implements ApplicationContextAware{
    private static ApplicationContext context;

    public static <T> T getBean(Class<T> bean){
        return context.getBean(bean);
    }

    public static <T> T getBean(String var1, @Nullable Class<T> var2){
        return context.getBean(var1,var2);
    }

    public static ApplicationContext getContext(){
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeansUtils.context=applicationContext;
    }
}

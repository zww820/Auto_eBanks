package org.audience.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.text.MessageFormat;
import java.util.Properties;

/**
 * author:Audience
 * date:2018/9/6
 * time:15:49
 */
public class PropertyPlaceholderConfigurer
        extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

    private static Properties props;

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.props = props;
    }

    public  static String getProperty(String key){
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public static String getProperty(String key, String[] str) {
        return MessageFormat.format(props.getProperty(key), str);
    }
}

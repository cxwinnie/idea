package cn.xuxianda.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringPropertiesUtil implements ApplicationContextAware {
    public static final String KEY = "propertiesBean";
    private static ApplicationContext applicationContext;
 
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
    	SpringPropertiesUtil.applicationContext = applicationContext;
    }
 
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
 
    /**
     * 获取配置文件中的内容
     *
     * @param keyName
     * @return
     */
    public static String parseStr(String keyName) {
    	PropertyPlaceholderConfigurer pc = (PropertyPlaceholderConfigurer) applicationContext
                .getBean(KEY);
    	CustomizedPropertyPlaceholderConfigurer cp = (CustomizedPropertyPlaceholderConfigurer)pc;
        //return cp.getContextProperty(keyName).toString();
    	return null;
    }
 
    /**
     * 获取配置文件中的内容
     *
     * @param keyName
     * @return
     */
    public static int parseInt(String keyName) {
        CustomizedPropertyPlaceholderConfigurer cp = (CustomizedPropertyPlaceholderConfigurer) applicationContext
                .getBean(KEY);
        //return Integer.parseInt(cp.getContextProperty(keyName).toString());
        return 0;
    }
 
    /**
     * 获取配置文件中的内容
     *
     * @param keyName
     * @return
     */
    public static double parseDouble(String keyName) {
        CustomizedPropertyPlaceholderConfigurer cp = (CustomizedPropertyPlaceholderConfigurer) applicationContext
                .getBean(KEY);
        //return Double.parseDouble(cp.getContextProperty(keyName).toString());
        return 0;
    }
}
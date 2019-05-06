package com.zheng.my.shop.web.admin.commons.context;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringContext implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext;

    public void destroy() throws Exception {
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    /**
     * 使用 ApplicationContext, 根据 beanId 获取实例
     * @param beanId
     * @param <T>
     * @return Bean 对象
     */
    public static <T> T getBean(String beanId) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    /**
     * 使用 ApplicationContext, 根据 class 获取实例
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return applicationContext.getBean(clazz);
    }

    public static void assertContextInjected() {
        Validate.validState(applicationContext != null,
                "applicationContext 尚未在web.xml中初始化");
    }
}

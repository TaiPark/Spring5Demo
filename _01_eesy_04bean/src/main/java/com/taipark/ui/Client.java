package com.taipark.ui;

import com.taipark.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//模拟一个表现层，用于调用业务层
public class Client {
    //获取spring容器的IoC核心容器，并根据ID获取对象
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据ID获取Bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");

        as.saveAccount();
    }
}

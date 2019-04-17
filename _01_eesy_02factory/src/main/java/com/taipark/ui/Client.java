package com.taipark.ui;

import com.taipark.factory.BeanFactory;
import com.taipark.service.IAccountService;
import com.taipark.service.impl.AccountServiceImpl;

//模拟一个表现层，用于调用业务层
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for(int i = 0; i < 5; ++i){
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
        }
        //as.saveAccount();
    }
}

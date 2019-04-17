package com.taipark.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//一个创建Bean对象的工厂：创建service与dao对象的。
//Bean：可重用组件
//JavaBean：JavaBean > 实体类，用Java语言编写的可重用组件。
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;
    //定义一个Map用于存放要创建的对象，称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }
    //根据Bean的名称获取Bean对象
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }
}

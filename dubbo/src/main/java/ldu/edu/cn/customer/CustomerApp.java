package ldu.edu.cn.customer;

import ldu.edu.cn.provider.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CustomerApp {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/customer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        System.out.println(providerService.SayHello("请对我说 Hello"));
        System.in.read();

    }
}

unversioned
package ldu.edu.cn.customer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import ldu.edu.cn.provider.service.ProviderService;


import java.io.IOException;

public class CustomerApi {
    public static void main(String[] args) throws IOException {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("customer");
        applicationConfig.setOwner("hackma");

        // 连接注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        //引用远程服务
        ReferenceConfig<ProviderService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(ProviderService.class);
        reference.setVersion("1.0.0");
        ProviderService providerService = reference.get();
        System.out.println(providerService.SayHello("Dubbo Api ........"));
        System.in.read();
    }
}

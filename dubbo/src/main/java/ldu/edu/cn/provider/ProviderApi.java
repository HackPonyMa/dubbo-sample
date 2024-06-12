package ldu.edu.cn.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import ldu.edu.cn.provider.service.ProviderService;
import ldu.edu.cn.provider.service.impl.ProviderServiceImpl;

import java.io.IOException;
import java.util.HashMap;

public class ProviderApi {
    public static void main(String[] args) throws IOException {
        // 服务实现类
        ProviderService providerService = new ProviderServiceImpl();

        // 应用当前配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");
        applicationConfig.setOwner("hackma");
        applicationConfig.setParameters(new HashMap<String, String>(){
            {
                put("qos.enable", String.valueOf(true));
                put("qos.accept.foreign.ip", String.valueOf(false));
                put("qos.port", "55555");
            }
        });

        // 连接注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 服务提供方协议设置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        // 服务提供方暴露接口
        ServiceConfig<ProviderService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        service.setProtocol(protocolConfig);
        service.setInterface(ProviderService.class);
        service.setRef(providerService);
        service.setVersion("1.0.0");
        service.export();

        System.in.read();
    }
}

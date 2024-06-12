package ldu.edu.cn.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import ldu.edu.cn.provider.annotation.ProviderServiceAnnotation;
import org.springframework.stereotype.Service;

/**
 * 注解方式的service
 */

@Service
public class ConsumerAnnotationService {

    @Reference
    private ProviderServiceAnnotation providerServiceAnnotation;

    public String doSayHello(String name) {
        return providerServiceAnnotation.SayHello(name);
    }
}

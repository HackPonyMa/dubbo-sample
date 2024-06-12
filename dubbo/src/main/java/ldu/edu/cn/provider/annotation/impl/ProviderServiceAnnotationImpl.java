package ldu.edu.cn.provider.annotation.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ldu.edu.cn.provider.annotation.ProviderServiceAnnotation;

/**
 * 注解实现dubbo服务
 */
@Service(timeout = 500)
public class ProviderServiceAnnotationImpl implements ProviderServiceAnnotation {
    @Override
    public String SayHello(String world) {
        return world;
    }
}

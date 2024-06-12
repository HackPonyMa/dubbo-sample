package ldu.edu.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ldu.edu.cn.provider.service.ProviderService;

/**
 * 注解的方式实现
 */
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String SayHello(String world) {
        return world;
    }
}

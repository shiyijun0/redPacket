package cm.bdqn.packet.service;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        System.out.println("自定义缓存，使用第一参数作为缓存key. params = " + Arrays.toString(objects));
        // 仅仅用于测试，实际不可能这么写
        return objects + "0";
    }
}

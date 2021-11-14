package com.njupt.swg;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @Author swg.
 * @Date 2021/11/14 14:24
 * @CONTACT 317758022@qq.com
 * @DESC     第四步：项目启动类，原来的入口不能直接用了，需要另外一种外部tomcat启动的方式
 */
public class WarStarterSwgApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 指向Application这个Springboot启动类
        return builder.sources(SwgApplication.class);
    }
}

package cn.edu.gliet.companyinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: GlobalCorsConfig
 * @Description:cn.edu.gliet.companyinfo
 * @Auther:刘华哲
 * @Version: 1.0
 * @create 2019/10/21 20:05
 */
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径
        registry.addMapping("/**")
        // 放行哪些原始域
        .allowedOrigins("*")
        // 放行哪些请求方式
        .allowedMethods("*")
        // 是否允许携带 cookie
        .allowCredentials(true)
        // 放行哪些头部信息
        .allowedHeaders("*");
    }
}

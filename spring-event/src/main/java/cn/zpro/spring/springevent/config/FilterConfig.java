//package cn.zpro.spring.springevent.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean registrationBean() {
//        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new MyFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//
//        //排除不需要过滤的请求
//        Set<String> stringSet = new HashSet<>();
//        stringSet.add("/api/user/login");
//        //String urls = StringUtils.join(stringSet.toArray(),",");
//        //filterRegistrationBean.addInitParameter("exclusions",urls);
//        return filterRegistrationBean;
//    }
//}
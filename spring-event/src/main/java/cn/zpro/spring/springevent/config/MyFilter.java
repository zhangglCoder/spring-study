//package cn.zpro.spring.springevent.config;
//
//import javax.servlet.*;
//import javax.servlet.FilterConfig;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class MyFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    String path = "https://img-blog.csdnimg.cn/img_convert/2ed0d7af40095c21456bab6acb841675.png";
//
//    String path2 = "https://file.sijibao.com/wyyt-image/2022/05/12/%E6%9D%83%E9%99%90%E5%BC%80%E9%80%9A%E9%9C%80%E6%B1%82_ea93775931694f8f9fa54bc7c5de6054.png";
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException { // do something 处理request 或response
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String ip = request.getRemoteAddr();
//
//
//        String url = request.getRequestURL().toString();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d = new Date();
//        String date = sdf.format(d);
//        System.out.printf("%s %s 访问了 %s%n", date, ip, url);
//        long time = d.getTime();
//        if(time % 2 ==0){
//            response.sendRedirect(path);
//        }else {
//            response.sendRedirect(path2);
//        }
//
//        return;
//        //filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
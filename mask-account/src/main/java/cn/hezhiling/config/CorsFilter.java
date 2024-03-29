package cn.hezhiling.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    /*
    * value、origins属性：配置允许访问的源，如: http://anxminise.cc，*表示允许全部的域名
        methods属性：配置跨域请求支持的方式，如：GET、POST，且一次性返回全部支持的方式
        maxAge属性：配置预检请求的有效时间， 单位是秒，表示：在多长时间内，不需要发出第二次预检请求
        allowCredentials属性：配置是否允许发送Cookie，用于 凭证请求， 默认不发送cookie
        allowedHeaders属性：配置允许的自定义请求头，用于 预检请求
        exposedHeaders属性：配置响应的头信息， 在其中可以设置其他的头信息，不进行配置时， 默认可以获取到Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma字段
    *
    * */

    /**
     * value、origins属性：配置允许访问的源，如: http://anxminise.cc，*表示允许全部的域名
     * methods属性：配置跨域请求支持的方式，如：GET、POST，且一次性返回全部支持的方式
     * maxAge属性：配置预检请求的有效时间， 单位是秒，表示：在多长时间内，不需要发出第二次预检请求
     * allowCredentials属性：配置是否允许发送Cookie，用于 凭证请求， 默认不发送cookie
     * allowedHeaders属性：配置允许的自定义请求头，用于 预检请求
     * exposedHeaders属性：配置响应的头信息， 在其中可以设置其他的头信息，不进行配置时， 默认可以获取到Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma字段
     *
     * @param req   req
     * @param res   rep
     * @param chain chain
     * @throws IOException      io
     * @throws ServletException servletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.info("=========cors filter=========");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        if (request.getHeader("Origin") != null) {
            logger.info("-----------Origin:" + request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        } /*else {
            logger.info("-----------Origin-else:http://106.55.250.100:8180");
            response.setHeader("Access-Control-Allow-Origin", "http://106.55.250.100:8180");
        }*/
        //      *不允许携带认证头和cookies
        // 如果不是80端口,需要将端口加上,如果是集群,则用Nginx的地址,同理不是80端口要加上端口
        response.setHeader("Access-Control-Allow-Origin", "http://106.55.152.41:8186");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}

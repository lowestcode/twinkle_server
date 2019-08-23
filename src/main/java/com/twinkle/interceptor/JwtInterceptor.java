package com.twinkle.interceptor;

import com.twinkle.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 拦截器，拦截权限不足的操作
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            try {
                if (claims != null) {
                    if("admin".equals(claims.get("roles"))){//如果是管理员
                        request.setAttribute("admin_claims", token);
                    }
                    if("user".equals(claims.get("roles"))){//如果是用户
                        request.setAttribute("user_claims", token);
                    }
                }
            }catch (Exception e){
                throw new RuntimeException("令牌有误");
            }
        }
        return true;
    }
}

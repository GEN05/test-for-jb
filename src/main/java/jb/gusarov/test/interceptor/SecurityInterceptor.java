package jb.gusarov.test.interceptor;

import jb.gusarov.test.controller.IndexPage;
import jb.gusarov.test.controller.Page;
import jb.gusarov.test.domain.User;
import jb.gusarov.test.security.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    private IndexPage indexPage;

    @Autowired
    public void setIndexPage(IndexPage indexPage) {
        this.indexPage = indexPage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (Page.class.isAssignableFrom(method.getDeclaringClass())) {
                if (method.getAnnotation(Guest.class) != null) {
                    return true;
                }
                User user = indexPage.getUser(request.getSession());
                if (user != null)
                    return true;
                indexPage.putMessage(request.getSession(), "Access is denied");
                response.sendRedirect("/enter");
                return false;
            }
        }

        return true;
    }
}

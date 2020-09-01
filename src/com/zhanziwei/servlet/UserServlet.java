package com.zhanziwei.servlet;

import com.zhanziwei.bean.User;
import com.zhanziwei.service.UserService;
import com.zhanziwei.service.impl.UserServiceImpl;
import com.zhanziwei.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParam2Bean(req.getParameterMap(), new User());
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        User loginUser = userService.login(user);
        if (loginUser == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("userName",user.getUsername());

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        User user = WebUtils.copyParam2Bean(req.getParameterMap(), new User());

        WebUtils.copyParam2Bean(req.getParameterMap(), user);
        if("abcde".equalsIgnoreCase(code)) {
            if(userService.existsUserName(user.getUsername())) {
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("userName", user.getUsername());
                req.setAttribute("email", user.getEmail());
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.register(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("userName", user.getUsername());
            req.setAttribute("email", user.getEmail());
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

}

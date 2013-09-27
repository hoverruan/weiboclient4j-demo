package com.github.hoverruan.weiboclient4j.demo.api;

import weiboclient4j.WeiboClientException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutApiServlet extends ApiGetServlet {
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException, WeiboClientException {
        session.invalidate();
    }
}

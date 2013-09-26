package com.github.hoverruan.weiboclient4j.demo.api;

import com.github.hoverruan.weiboclient4j.demo.DemoConstants;
import weiboclient4j.WeiboClient;
import weiboclient4j.WeiboClientException;
import static weiboclient4j.utils.JsonUtils.writeObjectAsString;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ApiServlet extends HttpServlet implements DemoConstants {

    protected void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendError(500, "Internal Server Error");
            return;
        }

        try {
            req.setCharacterEncoding(DEFAULT_ENCODING);
            doHandle(req, resp, session);
        } catch (WeiboClientException e) {
            throw new ServletException("weibo error", e);
        }
    }

    protected abstract void doHandle(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException, WeiboClientException;

    protected <T> void renderJsonResponse(HttpServletResponse resp, T obj) throws IOException {
        resp.setContentType(DemoConstants.JSON);

        PrintWriter out = resp.getWriter();
        out.println(writeObjectAsString(obj));
        out.flush();
    }

    protected WeiboClient getWeiboClient(HttpSession session) {
        String accessToken = (String) session.getAttribute(ACCESS_TOKEN);

        return new WeiboClient(accessToken);
    }
}

package com.github.hoverruan.weiboclient4j.demo;

import weiboclient4j.WeiboClient;
import weiboclient4j.WeiboClientException;
import weiboclient4j.oauth2.SinaWeibo2AccessToken;
import static weiboclient4j.utils.StringUtils.isBlank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CallbackServlet extends HttpServlet implements DemoConstants {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendError(500, "Internal Server Error");
            return;
        }

        String code = req.getParameter("code");
        if (isBlank(code)) {
            resp.sendError(400, "Bad Request");
            return;
        }

        String clientId = (String) session.getAttribute(CLIENT_ID);
        String clientSecret = (String) session.getAttribute(CLIENT_SECRET);

        WeiboClient client = new WeiboClient(clientId, clientSecret);
        try {
            SinaWeibo2AccessToken accessToken = client.getAccessTokenByCode(code, CALLBACK);
            session.setAttribute(ACCESS_TOKEN, accessToken.getToken());
            session.setAttribute(UID, accessToken.getUid());

            resp.sendRedirect("/#/main");
        } catch (WeiboClientException e) {
            throw new ServletException("Failed to get access token", e);
        }
    }
}

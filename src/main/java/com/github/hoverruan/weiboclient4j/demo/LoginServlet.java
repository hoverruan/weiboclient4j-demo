package com.github.hoverruan.weiboclient4j.demo;

import weiboclient4j.WeiboClient;
import weiboclient4j.oauth2.DisplayType;
import weiboclient4j.oauth2.ResponseType;
import static weiboclient4j.utils.StringUtils.isBlank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet implements DemoConstants {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("clientId");
        String clientSecret = req.getParameter("clientSecret");

        if (isBlank(clientId) || isBlank(clientSecret)) {
            resp.sendError(400, "Bad Request");
            return;
        }

        WeiboClient client = new WeiboClient(clientId, clientSecret);
        String authorizationUrl = client.getAuthorizationUrl(ResponseType.Code, DisplayType.Default, null, CALLBACK);

        HttpSession session = req.getSession(true);
        session.setAttribute(CLIENT_ID, clientId);
        session.setAttribute(CLIENT_SECRET, clientSecret);

        resp.sendRedirect(authorizationUrl);
    }
}

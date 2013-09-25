package com.github.hoverruan.weiboclient4j.demo.api;

import weiboclient4j.WeiboClient;
import weiboclient4j.WeiboClientException;
import weiboclient4j.model.User;
import weiboclient4j.params.P;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InfoApiServlet extends ApiGetServlet {

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws IOException, WeiboClientException {
        String accessToken = (String) session.getAttribute(ACCESS_TOKEN);
        Long uid = (Long) session.getAttribute(UID);

        WeiboClient client = new WeiboClient(accessToken);
        User user = client.getUserService().show(P.uid(uid));

        renderJsonResponse(resp, new Info(accessToken, user));
    }
}

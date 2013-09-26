package com.github.hoverruan.weiboclient4j.demo.api;

import weiboclient4j.StatusService;
import weiboclient4j.WeiboClient;
import weiboclient4j.WeiboClientException;
import weiboclient4j.model.Timeline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeTimelineApiServlet extends ApiGetServlet {
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException, WeiboClientException {
        WeiboClient client = getWeiboClient(session);

        StatusService statusService = client.getStatusService();
        Timeline timeline = statusService.getHomeTimeline();

        renderJsonResponse(resp, timeline);
    }
}

package com.dina.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author xuhongda on 2020/12/29
 * com.dina.controller
 * car-crash-animation
 */
@WebServlet("/getData")
public class GetDataController extends HttpServlet {

    private Logger log = LoggerFactory.getLogger(GetDataController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException {
        String eventLogId = req.getParameter("eventLogId");
        String str = (String)GetCarCrashPointController.concurrentHashMap.get(eventLogId);
        if (str != null && !"".equals(str)){
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(str);
        }else {
            log.warn("points is empty!!!");
        }

    }
}

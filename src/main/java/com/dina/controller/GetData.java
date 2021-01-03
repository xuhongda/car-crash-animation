package com.dina.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getData")
public class GetData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException {
        String eventLogId = req.getParameter("eventLogId");
        String str = (String)PpController.concurrentHashMap.get(eventLogId);
        System.out.println(str);
        //写回去
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(str);

    }
}

package com.dina.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xuhongda on 2020/12/24
 * com.dina.controller
 * car-crash-animation
 */

@WebServlet("/carCrash")
public class CarCrashController extends HttpServlet {

    private Properties properties = new Properties();

    private Logger log = LoggerFactory.getLogger(CarCrashController.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String deviceId = request.getParameter("deviceId");
        if (deviceId != null && !"".equals(deviceId)){
            log.info("deviceId = {} get crash point List ",deviceId);
            Map<String,String> map = new HashMap<>(1);
            map.put("key",deviceId);
            try{
                String result = HttpUtil.doPost(map, Config.getConfig("pointListUrl"));
                log.info("point = {}",result);
                //写回去
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(result);
            }catch (Exception e){
                log.warn("get crash point error");
                log.warn("exception",e);
            }
        }else {
            log.warn("deviceId is null can't get crash data!");
        }

    }


}


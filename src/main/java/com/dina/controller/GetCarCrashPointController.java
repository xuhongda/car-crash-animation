package com.dina.controller;


import com.dina.utils.Config;
import com.dina.utils.HttpUtil;
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
 * @author xuhongda on 2020/12/29
 * com.dina.controller
 * car-crash-animation
 */
@WebServlet("/getCarCrashPoint")
public class GetCarCrashPointController extends HttpServlet {


    private Logger log = LoggerFactory.getLogger(GetCarCrashPointController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String deviceId = req.getParameter("deviceId");
        String eventLogId = req.getParameter("eventLogId");

        if (deviceId != null && !"".equals(deviceId)){
            log.info("deviceId = {} get crash point ",deviceId);
            Map<String,Object> map = new HashMap<>(1);
            map.put("cmd","roadlenVspWxDeviceEventDetail");

            Map<String,String> map2 = new HashMap<>(3);
            map2.put("deviceId","81044301899");
            map2.put("eventLogId","2c9481f6734d8a1801736e24989a2fd1");
            map2.put("mapType","mapType");
            map.put("params",map2);

            Map<String,String> map3 = new HashMap<>();
            map3.put("userName","foshan@yxgl");
            map3.put("password","");
            map3.put("appName","");
            map3.put("encryptMethod","0");
            map3.put("ua","web");
            map3.put("sdk","");
            map3.put("appVersion","");
            map3.put("mapType","baidu");
            map3.put("corpId","");
            map3.put("deptId","");

            map.put("auth",map3);

            String result = HttpUtil.doPost(map, Config.getConfig("API_URl"));
            log.info("result = {}",result);
            //写回去
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println(result);

        }else {
            log.warn("deviceId is null can't get crash data!");
        }

    }
}

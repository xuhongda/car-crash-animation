package com.dina.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongda on 2020/12/24
 * com.dina.controller
 * car-crash-animation
 */
@Slf4j
@WebServlet("/carCrash")
public class CarCrashController extends HttpServlet {

    private CloseableHttpClient httpClient = HttpClientBuilder.create().build();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String deviceId = request.getParameter("deviceId");
        if (deviceId != null && !"".equals(deviceId)){
            log.info("deviceId = {} get crash point ",deviceId);
            Map<String,String> map = new HashMap<>(1);
            map.put("key",deviceId);
            ObjectMapper mapper = new ObjectMapper();
            String params = mapper.writeValueAsString(map);
            //start a request ...
            HttpPost post = new HttpPost();
            post.setURI(URI.create("http://localhost:8017/car"));
            post.setHeader("Content-Type", "application/json;charset=utf8");
            StringEntity stringEntity = new StringEntity(params);
            post.setEntity(stringEntity);
            try{
                CloseableHttpResponse httpResponse = httpClient.execute(post);
                HttpEntity entity = httpResponse.getEntity();
                String s = EntityUtils.toString(entity);
                //写回去
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(s);
            }catch (Exception e){
                log.warn("get crash point error");
                log.warn("exception",e);
            }finally {
                httpClient.close();
            }
        }else {
            log.warn("deviceId is null can't get crash data!");
        }

    }

}

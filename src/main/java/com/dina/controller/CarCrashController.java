package com.dina.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
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
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xuhongda on 2020/12/24
 * com.dina.controller
 * car-crash-animation
 */
@Slf4j
@WebServlet("/carCrash")
public class CarCrashController extends HttpServlet {

    Properties properties = new Properties();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String deviceId = request.getParameter("deviceId");
        if (deviceId != null && !"".equals(deviceId)){
            log.info("deviceId = {} get crash point ",deviceId);
            Map<String,String> map = new HashMap<>(1);
            map.put("key",deviceId);
            ObjectMapper mapper = new ObjectMapper();
            String params = mapper.writeValueAsString(map);

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost();
            post.setHeader("Content-Type", "application/json;charset=utf8");
            StringEntity stringEntity = new StringEntity(params);
            post.setEntity(stringEntity);
            try{
                String url = getConfig("url");
                post.setURI(URI.create(url));
                CloseableHttpResponse httpResponse = httpClient.execute(post);
                HttpEntity entity = httpResponse.getEntity();
                String s = EntityUtils.toString(entity);
                log.info("point = {}",s);
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

    /**
     * get config params
     * @param name config's name
     * @return config's value
     */
   private String getConfig(String name) throws IOException {
       String path ="/config.properties";
       InputStream resourceAsStream = this.getClass().getResourceAsStream(path);
       properties.load(resourceAsStream);
       return properties.getProperty(name);
    }



}


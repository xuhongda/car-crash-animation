package com.dina.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * @author xuhongda on 2020/12/29
 * com.dina.controller
 * car-crash-animation
 */
public class HttpUtil {

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * @param map 请求参数
     * @param url 访问地址
     * @return result
     */
    public static String doPost(Map map,String url) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String params = mapper.writeValueAsString(map);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost();
        post.setHeader("Content-Type", "application/json;charset=utf8");
        StringEntity stringEntity = new StringEntity(params);
        post.setEntity(stringEntity);
        String result = null;
        try {
            post.setURI(URI.create(url));
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        }catch (Exception e){
            log.info("exception =",e);
        }finally {
            httpClient.close();
        }
        return result;

    }
}

package com.dina.utils;

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

/**
 * @author xuhongda on 2020/12/29
 * com.dina.controller
 * car-crash-animation
 */
public class HttpUtil {

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * @param params 请求参数
     * @param url    访问地址
     * @return result
     */
    public static String doPost(String params, String url) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost();
        post.setHeader("Content-Type", "application/json;charset=utf8");
        String result = null;
        try {
            StringEntity stringEntity = new StringEntity(params);
            post.setEntity(stringEntity);
            post.setURI(URI.create(url));
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            log.warn("http exception =", e);
        } finally {
            httpClient.close();
        }
        return result;

    }
}

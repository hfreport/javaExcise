package com.wins.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {


    public static CloseableHttpClient reqeust(String url) {



        CloseableHttpClient client = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name","111"));
        params.add(new BasicNameValuePair("password","123456"));

        HttpEntity entity = null;
        try {

            entity = new UrlEncodedFormEntity(params, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpPost request = new HttpPost(url);
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        request.setHeader("accept","*/*");
        request.setEntity(entity);

        CloseableHttpResponse response = null;

        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.getStatusLine().getStatusCode());

        if (response.getStatusLine().getStatusCode() == 200) {
            try {

                String res = EntityUtils.toString(response.getEntity());

                System.out.println(res);
                EntityUtils.consume(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return client;
    }

    public static void main(String[] args) {
        reqeust("https://www.baidu.com");
    }
}

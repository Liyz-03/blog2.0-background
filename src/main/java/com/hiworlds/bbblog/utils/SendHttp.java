package com.hiworlds.bbblog.utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URISyntaxException;

public class SendHttp {

    /**
     * @param address 请求全路径
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String getHttpData(String address) throws URISyntaxException, IOException {
        String strResp = null;
        HttpGet httpGet = new HttpGet(address);
        CloseableHttpClient client3 = HttpClients.createDefault();
        HttpResponse resp;
        resp = client3.execute(httpGet);
        if (resp.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
            strResp = EntityUtils.toString(resp.getEntity());
        }
        return strResp;
    }
}

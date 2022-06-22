package ru.mikhaylin.spring;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class ProcessingClient {
    public static String processingPinChange(String pin, String pan) {
        String response = "";
        String url = "http://localhost:8083/processingPinChange";
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("Content-type","text/xml; charset=ISO-8859-1");
        NameValuePair nameValuePair1 = new NameValuePair("pin", pin);
        NameValuePair nameValuePair2 = new NameValuePair("pan", pan);
        method.setQueryString(new NameValuePair[]{nameValuePair1, nameValuePair2});
        try {
            client.executeMethod(method);
            response = method.getResponseBodyAsString();
            method.releaseConnection();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        if (response.equals("200")) {
            return "200";
        } else {
            return "500";
        }
    }
}

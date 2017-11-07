package com.lgardias.fx.communication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgardias.fx.model.Book;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ApacheClient {
    private final String urlPost = "http://localhost:8080/book";
    private final ObjectMapper mapper = new ObjectMapper();

    public void createBook(Book book) {

        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(urlPost);
        httpPost.addHeader("Content-Type", "application/json");


        try {
            httpPost.setEntity(new StringEntity(bookToJson(book)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String bookToJson(Book book) {
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}

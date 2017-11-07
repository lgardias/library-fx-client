package com.lgardias.fx.communication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgardias.fx.model.Book;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

public class ApacheClient {
    private final String urlPost = "http://localhost:8080/book";
    private final String urlGet = "http://localhost:8080/books";
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

    public List<Book> getBooks(){
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(urlGet);
        httpGet.addHeader("Content-Type","application/json");

        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpResponse.getEntity().getContent()));
                StringBuffer result  = new StringBuffer();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
               // jsonToObject(result.toString());
                //System.out.println(result.toString());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    private List<Book> jsonToObject(String value){
//
//        List<Book> books = new LinkedList<>();
//        try {
//            JSONObject myjson = new JSONObject(value);
//            JSONArray jsonArray = myjson.getJSONArray("");
//            for (int i = 0 ; i < jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject.toString());
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
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

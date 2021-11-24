/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author DELL
 */
public class BillApi {
    private BillApi(){
        
    }
    
    public static boolean insertBill(Double total, String date, String list) throws IOException{
//        OkHttpClient client = new OkHttpClient().newBuilder()
//            .build();
//         MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//          RequestBody body = RequestBody.create(mediaType, "total=10&date=2015-12-25 15:30:00&lists=[{productId:1,count:3},{productId:2,count:5}]");
//          Request request = new Request.Builder()
//            .url("localhost:8080/StoreApi/add-bill")
//            .method("POST", body)
//            .addHeader("Content-Type", "application/x-www-form-urlencoded")
//            .build();
//          Response response = client.newCall(request).execute();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/StoreApi/add-bill");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("total", String.valueOf(total)));
        params.add(new BasicNameValuePair("date", date));
        params.add(new BasicNameValuePair("lists", list));
        
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        
        HttpResponse httpResponse = client.execute(httpPost);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("==========="+json_string);
        return true;
    }
    
}

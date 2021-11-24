/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

/**
 *
 * @author DELL
 */
public class ProductApi {

    public static void updateProduct(Integer id, String name, Double price, String category) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
RequestBody body = RequestBody.create(mediaType, "name="+name+" &price="+price+"&category="+category+"&id="+id+"");
Request request = new Request.Builder()
  .url("http://localhost:8080/StoreApi/update")
  .method("POST", body)
  .addHeader("Content-Type", "application/x-www-form-urlencoded")
  .build();
Response response = client.newCall(request).execute();
    }

   
    private ProductApi() {
    }
    
     public static void addProduct(String name, Double price, String category) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
         .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "name="+name+"&price="+price+"&category="+category+"");
        Request request = new Request.Builder()
        .url("http://localhost:8080/StoreApi/add")
        .method("POST", body)
        .addHeader("Content-Type", "application/x-www-form-urlencoded")
        .build();
        Response response = client.newCall(request).execute();
    }
     
     public static void deleteProduct(int id) throws IOException{
         OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
            .url("http://localhost:8080/StoreApi/delete?id="+id)
            .method("DELETE", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = client.newCall(request).execute();
     }

    
    
    public static List<Product> getProductsByName(String name) throws IOException, URISyntaxException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/StoreApi/product");
        URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("name", name)
        .build();
        ((HttpRequestBase) httpGet).setURI(uri);
        System.out.println("product by name: " + httpGet.getURI());
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Product> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), Product.class));
        }
        return lists;
    }
    
    public static List<Product> getProductsByCategory(String category) throws IOException, URISyntaxException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/StoreApi/product");
        URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("category", category)
        .build();
        ((HttpRequestBase) httpGet).setURI(uri);
        System.out.println("product by category: " + httpGet.getURI());
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Product> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), Product.class));
        }
        return lists;
    }
    
    public static List<Object> getCategory() throws IOException, URISyntaxException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/StoreApi/category");
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        return array.toList();
    }
    
    
}

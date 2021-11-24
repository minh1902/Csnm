/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author DELL
 */
public class UserApi {
    private UserApi(){
        
    }
    
    public static boolean checkLogin(String username, String password) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "username="+username+"&password="+password);
        Request request = new Request.Builder()
            .url("http://localhost:8080/StoreApi/login")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = client.newCall(request).execute();
        String json_string = response.body().string();
       
        JSONObject jsonObject = new JSONObject(json_string);
        if(jsonObject.get("username").equals(username)){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        try {
            checkLogin("minh", "1");
        } catch (IOException ex) {
            Logger.getLogger(UserApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

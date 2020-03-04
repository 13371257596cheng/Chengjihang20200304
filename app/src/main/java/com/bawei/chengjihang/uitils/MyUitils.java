package com.bawei.chengjihang.uitils;

import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyUitils {
    private static MyUitils myUitils=new MyUitils();

    public MyUitils(){

    }

    public static MyUitils getInstance() {
        return myUitils;
    }

    public void getJson(String path,ICallwork iCallwork){
        try {
            URL url=new URL(path);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.getHeaderField("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            int responseCode = conn.getResponseCode();
            if (responseCode==200){
                InputStream inputStream=conn.getInputStream();
                int len=0;
                byte[] buffer=new byte[1024];
                StringBuilder sb=new StringBuilder();
                while ((inputStream.read(buffer))!=-1){
                    String s=new String(buffer,0,len);
                    sb.append(s);
                }
                inputStream.close();
                if(iCallwork==null){
                    iCallwork.getSuccess(path);
                }

            }else {
                iCallwork.getError(path);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    Handler handler=new Handler();

    public interface ICallwork{
        void getSuccess(String json);
        void getError(String msg);
    }

    
}

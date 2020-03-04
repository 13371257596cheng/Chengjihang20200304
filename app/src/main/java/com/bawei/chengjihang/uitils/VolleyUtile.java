package com.bawei.chengjihang.uitils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chengjihang.base.App;

public class VolleyUtile {
    RequestQueue mQueue;

    public VolleyUtile(){
        mQueue= Volley.newRequestQueue(App.getContext());
    }

    private static class SingleInstance{
        public static final VolleyUtile INSTAMCE=new VolleyUtile();
    }

    public static VolleyUtile getInstance() {
        return SingleInstance.INSTAMCE;
    }
    public void doGet(String url, final ICallwork iCallwork){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    iCallwork.getSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallwork.getError(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }




    public interface ICallwork{
        void getSuccess(String json);
        void getError(String msg);
    }

}

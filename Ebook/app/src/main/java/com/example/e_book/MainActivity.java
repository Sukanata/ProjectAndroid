package com.example.e_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MenuAdapter menuAdapter;
    private RecyclerView recyclerView;
    private ArrayList<menu> menus;
    int jumdata;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menus=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson(){
        String url="https://obatpusing.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                jumdata = response.length();
                try {
                    for (int i = 0; i < jumdata; i++) {
                        JSONObject data = response.getJSONObject(i);
                        String gambarmenu = data.getString("gambar");
                        String namamenu = data.getString("nama");
                        String hargamenu = data.getString("harga");
                        String keteranganmenu = data.getString("keterangan");
                        menus.add(new menu(namamenu, hargamenu, gambarmenu, keteranganmenu));
                    }
                    menuAdapter = new MenuAdapter(MainActivity.this, menus);
                    recyclerView.setAdapter(menuAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

    });
        requestQueue.add(request);
    }
}

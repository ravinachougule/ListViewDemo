package com.example.listviewdemojava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    ListView listVw;
    Button add;
    EditText etVal;
    List<String> ds=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listVw=(ListView)findViewById(R.id.lstView);

        ds.add("Android");
        ds.add("ios");
        ds.add("Ubuntu");
        ds.add("Windows");

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
        listVw.setAdapter(adapter);
        etVal=(EditText)findViewById(R.id.etAddLst) ;
        add=(Button)findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ds.add(etVal.getText().toString());
                listVw.setAdapter(adapter);
                etVal.setText("");
                adapter.notifyDataSetChanged();
            }
        });
        listVw.setOnItemClickListener(this::onItemClick);
    }
    private  void onItemClick(AdapterView<?> adapterView,View view,int pos,long id){
        String osAtPos=adapter.getItem(pos);
        etVal.setText(osAtPos);
    }
}

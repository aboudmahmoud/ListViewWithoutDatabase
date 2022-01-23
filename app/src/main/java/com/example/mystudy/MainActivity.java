package com.example.mystudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button btnAdd;
    EditText ET;
    MyAdpater adapter;
    int pos;
    static int staus=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        btnAdd = (Button) findViewById(R.id.btn_list_add);
        ET = (EditText) findViewById(R.id.EditText);
        ArrayList<String> names = new ArrayList<>();
        names.add("aboud");
        names.add("ali");
        names.add("rayed");

        //ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
         adapter = new MyAdpater(this, android.R.layout.simple_list_item_1, names);

        lv.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (staus==0)
                {
                    adapter.AddItem(ET.getText().toString());
                }
                else
                {
                    adapter.setItem(pos,ET.getText().toString());
                    staus=0;
                }

                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   String name=adapter.getdata(i);
                String name = ((MyAdpater)(adapterView.getAdapter())).getdata(i);
               // Toast.makeText(MainActivity.this,"pos is" +i,Toast.LENGTH_LONG).show();
                ET.setText(name);
                pos=i;
                staus=1;

            }
        });

    }
}
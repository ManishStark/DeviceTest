package com.sibaken.devicetest;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

class TestItem{
    private String Name;
    private int No;

    public TestItem(String Name, int No){
        this.Name = Name;
        this.No = No;
    }
}

public class MainActivity extends Activity {        //タイトル表示の場合 → extends AppCompatActivity
    public static final String TAG = "DeviceTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "MainActivity");

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);    //タイトルバー非表示（setContentViewの前にコールする必要あり）
        setContentView(R.layout.activity_main);

        //ListViewに表示させる内容
        List<String> MainList = new ArrayList<String>();

        TestItem TestItem[] ={
                new TestItem("test", 10),
                new TestItem("test2", 10)
        };

            MainList.add("加速度センサー");
            MainList.add("ジャイロセンサー");
            MainList.add("照度センサー");
            MainList.add("磁界センサー");
            MainList.add("傾きセンサー");
            MainList.add("圧力センサー");
            MainList.add("近接センサー");
            MainList.add("温度センサー");
            MainList.add("GPS");
            MainList.add("スピーカー");
            MainList.add("マイク");
            MainList.add("電池残量");
            MainList.add("タッチスクリーン");
            MainList.add("デバイス情報");

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainList);

        ListView MainListView = (ListView) findViewById(R.id.MainListView);

        MainListView.setAdapter(Adapter);

        MainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick");

                String text = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

                if (2 == position) {
                    // インテントの生成
                    Intent intent = new Intent(MainActivity.this, SensorActivity.class);

                    // SubActivity の起動
                    startActivity(intent);
                }
            }
        });
    }
}
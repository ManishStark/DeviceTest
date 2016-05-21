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


public class MainActivity extends Activity {        //タイトル表示の場合 → extends AppCompatActivity

    //テストアイテムの項目を設定
    final String TestItemList[] ={
            Common.NAME_ACCELEROMETOR,
            Common.NAME_GYROSCOPE,
            Common.NAME_LIGHT,
            Common.NAME_MAGNETIC_FIELD,
            Common.NAME_ORIENTATION,
            Common.NAME_PRESSURE,
            Common.NAME_PROXIMITY,
            Common.NAME_TEMPERATURE,
            Common.NAME_GRAVITY,
            Common.NAME_LINEAR_ACCELERATION,
            Common.NAME_ROTATION_VECTOR,
            Common.NAME_AMBIENT_TEMPERATURE,
            Common.NAME_RELATIVE_HUMIDITY,
            "End"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Common.TAG, "MainActivity");

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);    //タイトルバー非表示（setContentViewの前にコールする必要あり）
        setContentView(R.layout.activity_main);

        //テストアイテムリスト生成
        TestItemList TestItemList = new TestItemList();


        //テストアイテムの項目をリストビューに設定
        List<String> MainList = new ArrayList<String>();
        for(int index = 0; "End" != TestItemList.TestItem[index].Name; index++) {
            MainList.add(TestItemList.TestItem[index].Name);
        }


        //リストビューのレイアウトを設定
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainList);

        //リストビューの設定
        ListView MainListView = (ListView) findViewById(R.id.MainListView);
        MainListView.setAdapter(Adapter);

        /*
         * リストビューのアイテムが押された時の処理
         */
        MainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i(Common.TAG, "onItemClick");

                //リストに表示していたアイテム名をトーストで表示
                String text = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

                // 次画面へのインテントの生成
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                //押されたリスト番号を次画面に渡す（次画面でどのアイテムがタッチされたか判断するため）
                intent.putExtra("TestItemNo", position);
                // 次画面へ移動
                startActivity(intent);
            }
        });
    }
}
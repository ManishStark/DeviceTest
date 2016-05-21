package com.sibaken.devicetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.List;


public class SensorActivity extends Activity implements SensorEventListener {        //タイトル表示の場合 → extends AppCompatActivity

    private SensorManager mSensorManager;
    private boolean mIsSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);          //タイトルバー非表示（setContentViewの前にコールする必要あり）
        setContentView(R.layout.activity_sensor);

        // 現在のintentを取得する
        Intent intent = getIntent();
        //前画面でどのリスト番号が押されたかを取得する
        int TestItemNo = intent.getIntExtra("TestItemNo", 0);

        //テストアイテムリスト生成
        TestItemList TestItemList = new TestItemList();

        //ここで不要なテキストを消す
        TextView SenserText = (TextView) findViewById(R.id.senser);
        SenserText.setText("");

        //センサー取得値を表示するテキストビュー取得
        TextView TextView = (TextView) findViewById(R.id.senser1);
        TextView.setText(TestItemList.TestItem[TestItemNo].Name);

        //センサーマネージャー取得
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = null;

        //センサーリスト取得
        sensors = mSensorManager.getSensorList(TestItemList.TestItem[TestItemNo].Type);
        //該当のセンサーが1つ以上搭載されているかを判断
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            //該当のセンサーが搭載されていた場合はセンサーを取得
            mIsSensor = mSensorManager.registerListener(this, sensor, TestItemList.TestItem[TestItemNo].Type);

        } else {
            //該当のセンサーが搭載されていなければその旨を表示
            TextView ACCELEROMETER = (TextView) findViewById(R.id.senser);
            ACCELEROMETER.setText(TestItemList.TestItem[TestItemNo].Name + "がありません");
        }

        // シークバーオブジェクトを取得
        SeekBar SeekBar = (SeekBar) findViewById(R.id.seekBar);

        SeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
                TextView TextView = (TextView) findViewById(R.id.textView);
                int prg = seekBar.getProgress();
                TextView.setText("更新速度：" + String.format("%.1f", prg * 0.05) + " s");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        // センサーの精度が変更されると呼ばれる
        Log.d(Common.TAG, "onAccuracyChanged");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        TextView SenserText = (TextView) findViewById(R.id.senser);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)//加速度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_ACCELEROMETER : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                    "Y = " + event.values[1] + "m/s^2\n" +
                    "Z = " + event.values[2] + "m/s^2");
        }

        else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)//ジャイロセンサー
        {
//            Log.v("Activity", "Sensor.TYPE_GYROSCOPE : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            SenserText.setText("X = " + event.values[0] + "rad/s\n" +
                    "Y = " + event.values[1] + "rad/s\n" +
                    "Z = " + event.values[2] + "rad/s");
        }

        else if (event.sensor.getType() == Sensor.TYPE_LIGHT)//照度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_LIGHT :" + event.values[0]);
            SenserText.setText(event.values[0] + "lux");
        }

        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)//地磁気センサー
        {
//            Log.v("Activity", "Sensor.TYPE_MAGNETIC_FIELD : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            SenserText.setText("X = " + event.values[0] + "μT\n" +
                                                    "Y = " + event.values[1] + "μT\n" +
                                                    "Z = " + event.values[2] + "μT");
        }

        else if (event.sensor.getType() == Sensor.TYPE_ORIENTATION)//傾きセンサー
        {
//            Log.v("Activity", "Sensor.TYPE_ORIENTATION : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            SenserText.setText("X = " + event.values[0] + "deg\n" +
                                             "Y = " + event.values[1] + "deg\n" +
                                             "Z = " + event.values[2] + "deg");
        }

        else if (event.sensor.getType() == Sensor.TYPE_PRESSURE)//圧力センサー
        {
//            Log.v("Activity", "Sensor.TYPE_PRESSURE : event.values[0]);
            SenserText.setText(event.values[0] + "hPa");
        }

        else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY)//近接センサー
        {
//            Log.v("Activity", "Sensor.TYPE_PROXIMITY : event.values[0] );
            SenserText.setText("X = " + event.values[0] + "cm");
        }

        else if (event.sensor.getType() == Sensor.TYPE_TEMPERATURE)//温度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_TEMPERATURE : event.values[0] );
            SenserText.setText( event.values[0] + "℃");
        }

        else if (event.sensor.getType() == Sensor.TYPE_GRAVITY)//重力センサー
        {
//            Log.v("Activity", "Sensor.TYPE_GRAVITY : X = " + event.values[0] + "Y = " + event.values[1] + "Z = " + event.values[2] );
            SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                                        "Y = " + event.values[1] + "m/s^2\n" +
                                        "Z = " + event.values[2] + "m/s^2");
        }

        else if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION)//直線化速度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_TYPE_LINEAR_ACCELERATION : X = " + event.values[0] + "Y = " + event.values[1] + "Z = " + event.values[2] );
            SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                                        "Y = " + event.values[1] + "m/s^2\n" +
                                        "Z = " + event.values[2] + "m/s^2");
        }

        else if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR)//回転ベクトルセンサー
        {
//            Log.v("Activity", "Sensor.TYPE_ROTATION_VECTOR : event.values[0] );
            SenserText.setText("X = " + event.values[0] + "\n" +
                    "Y = " + event.values[1] + "\n" +
                    "Z = " + event.values[2] + "");
        }

        else if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)//温度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_AMBIENT_TEMPERATURE : event.values[0] );
            SenserText.setText( event.values[0] + "℃");
        }

        else if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY)//湿度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_RELATIVE_HUMIDITY : event.values[0] );
            SenserText.setText( event.values[0] + "%");
        }
    }
}


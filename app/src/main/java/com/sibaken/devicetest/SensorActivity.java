package com.sibaken.devicetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.Switch;
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

        String TestItem[] = intent.getStringArrayExtra("TestItemList");
        int TestItemNo = intent.getIntExtra("TestItemNo", 0);

        switch(TestItem[TestItemNo])
        {
            case Common.NAME_ACCELEROMETOR :
                break;
            
            case Common.NAME_GYROSCOPE :
                break;

            case Common.NAME_LIGHT :
                break;

            case Common.NAME_MAGNETIC_FIELD :
                break;

            case Common.NAME_ORIENTATION :
                break;

            case Common.NAME_PRESSURE :
                break;

            case Common.NAME_PROXIMITY :
                break;

            case Common.NAME_TEMPERATURE :
                break;

            case Common.NAME_GRAVITY :
                break;

            case Common.NAME_LINEAR_ACCELERATION :
                break;

            case Common.NAME_ROTATION_VECTOR :
                break;

            case Common.NAME_AMBIENT_TEMPERATURE :
                break;

            case Common.NAME_RELATIVE_HUMIDITY :
                break;

        }
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //照度センサー
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


        } else {
            TextView LIGHT = (TextView) findViewById(R.id.LIGHT);
            LIGHT.setText("照度センサーがありません");
        } //加速度センサー
        sensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, Sensor.TYPE_ACCELEROMETER);

        } else {
            TextView ACCELEROMETER = (TextView) findViewById(R.id.ACCELEROMETER);
            ACCELEROMETER.setText("加速度センサーがありません");
        }

        //地磁気センサー
        sensors = mSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, Sensor.TYPE_MAGNETIC_FIELD);

        } else {
            TextView MAGNETIC_FIELD = (TextView) findViewById(R.id.MAGNETIC_FIELD);
            MAGNETIC_FIELD.setText("地磁気センサーがありません");
        }

        //ジャイロセンサー
        sensors = mSensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, Sensor.TYPE_GYROSCOPE);

        } else {
            TextView MAGNETIC_FIELD = (TextView) findViewById(R.id.GYROSCOPE);
            MAGNETIC_FIELD.setText("ジャイロセンサーがありません");
        }

        //傾きセンサー
        sensors = mSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, Sensor.TYPE_ORIENTATION);

        } else {
            TextView ORIENTATION = (TextView) findViewById(R.id.ORIENTATION);
            ORIENTATION.setText("傾きセンサーがありません");
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

        if (event.sensor.getType() == Sensor.TYPE_LIGHT)//照度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_LIGHT :" + event.values[0]);
            TextView LIGHT = (TextView) findViewById(R.id.LIGHT);
            LIGHT.setText("照度\n" + event.values[0] + " lux");
        }
        else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)//加速度センサー
        {
//            Log.v("Activity", "Sensor.TYPE_ACCELEROMETER : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            TextView ACCELEROMETER = (TextView) findViewById(R.id.ACCELEROMETER);
            ACCELEROMETER.setText("重力加速度 \nX = " + event.values[0] + "m/s^2\n" +
                    "Y = " + event.values[1] + "m/s^2\n" +
                    "Z = " + event.values[2] + "m/s^2\n");
        }
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)//地磁気センサー
        {
//            Log.v("Activity", "Sensor.TYPE_MAGNETIC_FIELD : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            TextView MAGNETIC_FIELD = (TextView) findViewById(R.id.MAGNETIC_FIELD);
            MAGNETIC_FIELD.setText("地磁気センサー \nX = " + event.values[0] + "μT\n" +
                    "Y = " + event.values[1] + "μT\n" +
                    "Z = " + event.values[2] + "μT\n");
        }
        else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)//ジャイロセンサー
        {
//            Log.v("Activity", "Sensor.TYPE_GYROSCOPE : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            TextView GYROSCOPE = (TextView) findViewById(R.id.GYROSCOPE);
            GYROSCOPE.setText("ジャイロセンサー \nX = " + event.values[0] + "rad/s\n" +
                    "Y = " + event.values[1] + "rad/s\n" +
                    "Z = " + event.values[2] + "rad/s\n");
        }

        else if (event.sensor.getType() == Sensor.TYPE_ORIENTATION)//傾きセンサー
        {
//            Log.v("Activity", "Sensor.TYPE_ORIENTATION : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
            TextView GYROSCOPE = (TextView) findViewById(R.id.ORIENTATION);
            GYROSCOPE.setText("傾きセンサー \nX = " + event.values[0] + "deg\n" +
                    "Y = " + event.values[1] + "deg\n" +
                    "Z = " + event.values[2] + "deg\n");
        }

    }
}


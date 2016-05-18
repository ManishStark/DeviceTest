package com.sibaken.devicetest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.List;


public class SensorActivity extends Activity implements SensorEventListener {        //タイトル表示の場合 → extends AppCompatActivity

    public static final String TAG = "DeviceTest";
    private SensorManager mSensorManager;
    private boolean mIsSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);          //タイトルバー非表示（setContentViewの前にコールする必要あり）
        setContentView(R.layout.activity_sensor);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //照度センサ
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


        } else {
            TextView LIGHT = (TextView) findViewById(R.id.LIGHT);
            LIGHT.setText("照度センサーがありません");
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
        Log.d(TAG, "onAccuracyChanged");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT)//照度センサー
        {
            Log.v("Activity", "Sensor.TYPE_LIGHT :" + event.values[0]);
            TextView LIGHT = (TextView) findViewById(R.id.LIGHT);
            LIGHT.setText("照度\n" + event.values[0] + " lux");
        }

    }
}


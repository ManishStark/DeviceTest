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

        String TestItem[] = intent.getStringArrayExtra("TestItemList");
        int TestItemNo = intent.getIntExtra("TestItemNo", 0);

        //ここで不要なテキストを消す
        TextView SenserText = (TextView) findViewById(R.id.senser);
        SenserText.setText("");

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = null;
        TextView TextView = (TextView) findViewById(R.id.senser1);

        switch(TestItem[TestItemNo])
        {
            case Common.NAME_ACCELEROMETOR :
                TextView.setText(Common.NAME_ACCELEROMETOR);
                //加速度センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);

                } else {
                    TextView ACCELEROMETER = (TextView) findViewById(R.id.senser);
                    ACCELEROMETER.setText(Common.NAME_ACCELEROMETOR + "がありません");
                }

                break;
            
            case Common.NAME_GYROSCOPE :
                TextView.setText(Common.NAME_GYROSCOPE);
                //ジャイロセンサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);

                } else {
                    TextView ACCELEROMETER = (TextView) findViewById(R.id.senser);
                    ACCELEROMETER.setText(Common.NAME_GYROSCOPE + "がありません");
                }

                break;

            case Common.NAME_LIGHT :
                TextView.setText(Common.NAME_LIGHT);
                //照度センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_LIGHT + "がありません");
                }

                break;

            case Common.NAME_MAGNETIC_FIELD :
                TextView.setText(Common.NAME_MAGNETIC_FIELD);
                //地磁気センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_MAGNETIC_FIELD + "地磁気センサーがありません");
                }
                break;

            case Common.NAME_ORIENTATION :
                TextView.setText(Common.NAME_ORIENTATION);
                //傾きセンサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_ORIENTATION + "がありません");
                }
                break;

            case Common.NAME_PRESSURE :
                TextView.setText(Common.NAME_PRESSURE);
                //圧力センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_PRESSURE);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_PRESSURE + "がありません");
                }
                break;

            case Common.NAME_PROXIMITY :
                TextView.setText(Common.NAME_PROXIMITY);
                //近接センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_PROXIMITY + "がありません");
                }
                break;

            case Common.NAME_TEMPERATURE :
                TextView.setText(Common.NAME_TEMPERATURE);
                //温度センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText( Common.NAME_TEMPERATURE + "がありません");
                }
                break;

            case Common.NAME_GRAVITY :
                TextView.setText(Common.NAME_GRAVITY);
                //重力センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_GRAVITY);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_GRAVITY + "がありません");
                }
                break;

            case Common.NAME_LINEAR_ACCELERATION :
                TextView.setText(Common.NAME_LINEAR_ACCELERATION);
                //直線化速度センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_LINEAR_ACCELERATION);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_LINEAR_ACCELERATION + "がありません");
                }
                break;

            case Common.NAME_ROTATION_VECTOR :
                TextView.setText(Common.NAME_ROTATION_VECTOR);
                //回転ベクトルセンサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_ROTATION_VECTOR + "がありません");
                }
                break;

            case Common.NAME_AMBIENT_TEMPERATURE :
                TextView.setText(Common.NAME_AMBIENT_TEMPERATURE);
                //温度センサー(最新)
                sensors = mSensorManager.getSensorList(Sensor.TYPE_AMBIENT_TEMPERATURE);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_AMBIENT_TEMPERATURE + "がありません");
                }
                break;

            case Common.NAME_RELATIVE_HUMIDITY :
                TextView.setText(Common.NAME_RELATIVE_HUMIDITY);
                //湿度センサー
                sensors = mSensorManager.getSensorList(Sensor.TYPE_RELATIVE_HUMIDITY);
                if (sensors.size() > 0) {
                    Sensor sensor = sensors.get(0);
                    mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


                } else {
                    TextView LIGHT = (TextView) findViewById(R.id.senser);
                    LIGHT.setText(Common.NAME_RELATIVE_HUMIDITY + "がありません");
                }
                break;

        }
        /*

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


*/

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


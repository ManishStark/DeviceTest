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

        //センサー名表示（タイトル表示）
        TextView TextView = (TextView) findViewById(R.id.senser1);
        TextView.setText(TestItemList.TestItem[TestItemNo].Name);

        /////////////////////////////////////////
        //　センサー取得表示に関する処理

        //センサーマネージャー取得
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = null;

        //センサーリスト取得
        sensors = mSensorManager.getSensorList(TestItemList.TestItem[TestItemNo].Type);
        //該当のセンサーが1つ以上搭載されているかを判断
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            //該当のセンサーが搭載されていた場合はセンサーを取得
            mIsSensor = mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);

        } else {
            //該当のセンサーが搭載されていなければその旨を表示
            TextView SenserTitle = (TextView) findViewById(R.id.senser);
            SenserTitle.setText(TestItemList.TestItem[TestItemNo].Name + "がありません");
        }

        /////////////////////////////////////////
        //　シークバーに関する処理

        // シークバーオブジェクトを取得
        SeekBar SeekBar = (SeekBar) findViewById(R.id.seekBar);
        /*
         * シークバーに関する処理
         */
        SeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            //シークバーが変更された（シークバーが触られた）
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

    /*
     * センサーの制度が更新された
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        // センサーの精度が変更されると呼ばれる
        Log.d(Common.TAG, "onAccuracyChanged");
    }

    /*
     * センサーが更新された
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        TextView SenserText = (TextView) findViewById(R.id.senser);

        switch (event.sensor.getType()){

            //加速度センサー
            case Sensor.TYPE_ACCELEROMETER :
                //Log.v("Activity", "Sensor.TYPE_ACCELEROMETER : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
                SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                                    "Y = " + event.values[1] + "m/s^2\n" +
                                    "Z = " + event.values[2] + "m/s^2");
                break;

            //ジャイロセンサー
            case Sensor.TYPE_GYROSCOPE :
                //Log.v("Activity", "Sensor.TYPE_GYROSCOPE : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
                SenserText.setText("X = " + event.values[0] + "rad/s\n" +
                                    "Y = " + event.values[1] + "rad/s\n" +
                                    "Z = " + event.values[2] + "rad/s");
                break;

            //照度センサー
            case Sensor.TYPE_LIGHT :
                //Log.v("Activity", "Sensor.TYPE_LIGHT :" + event.values[0]);
                SenserText.setText(event.values[0] + "lux");
                break;

            //地磁気センサー
            case Sensor.TYPE_MAGNETIC_FIELD :
                //Log.v("Activity", "Sensor.TYPE_MAGNETIC_FIELD : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
                SenserText.setText("X = " + event.values[0] + "μT\n" +
                                    "Y = " + event.values[1] + "μT\n" +
                                    "Z = " + event.values[2] + "μT");
                break;

            //傾きセンサー
            case Sensor.TYPE_ORIENTATION :
                //Log.v("Activity", "Sensor.TYPE_ORIENTATION : X = " + event.values[0] + "Y = " + event.values[1] + "Z  = " + event.values[2]);
                SenserText.setText("X = " + event.values[0] + "deg\n" +
                                    "Y = " + event.values[1] + "deg\n" +
                                    "Z = " + event.values[2] + "deg");
                break;

            //圧力センサー
            case Sensor.TYPE_PRESSURE :
                //Log.v("Activity", "Sensor.TYPE_PRESSURE : event.values[0]);
                SenserText.setText(event.values[0] + "hPa");
                break;

            //近接センサー
            case Sensor.TYPE_PROXIMITY :
                //Log.v("Activity", "Sensor.TYPE_PROXIMITY : event.values[0] );
                SenserText.setText("X = " + event.values[0] + "cm");
                break;

            //温度センサー
            case Sensor.TYPE_TEMPERATURE :
                //Log.v("Activity", "Sensor.TYPE_TEMPERATURE : event.values[0] );
                SenserText.setText( event.values[0] + "℃");
                break;

            //重力センサー
            case Sensor.TYPE_GRAVITY :
                //Log.v("Activity", "Sensor.TYPE_GRAVITY : X = " + event.values[0] + "Y = " + event.values[1] + "Z = " + event.values[2] );
                SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                                    "Y = " + event.values[1] + "m/s^2\n" +
                                    "Z = " + event.values[2] + "m/s^2");
                break;

            //直線化速度センサー
            case Sensor.TYPE_LINEAR_ACCELERATION :
                //Log.v("Activity", "Sensor.TYPE_TYPE_LINEAR_ACCELERATION : X = " + event.values[0] + "Y = " + event.values[1] + "Z = " + event.values[2] );
                SenserText.setText("X = " + event.values[0] + "m/s^2\n" +
                                    "Y = " + event.values[1] + "m/s^2\n" +
                                    "Z = " + event.values[2] + "m/s^2");
                break;

            //回転ベクトルセンサー
            case Sensor.TYPE_ROTATION_VECTOR :
                //Log.v("Activity", "Sensor.TYPE_ROTATION_VECTOR : event.values[0] );
                SenserText.setText("X = " + event.values[0] + "\n" +
                                    "Y = " + event.values[1] + "\n" +
                                    "Z = " + event.values[2] + "");
                break;

            //温度センサー
            case Sensor.TYPE_AMBIENT_TEMPERATURE :
                //Log.v("Activity", "Sensor.TYPE_AMBIENT_TEMPERATURE : event.values[0] );
                SenserText.setText( event.values[0] + "℃");
                break;

            //湿度センサー
            case Sensor.TYPE_RELATIVE_HUMIDITY :
                //Log.v("Activity", "Sensor.TYPE_RELATIVE_HUMIDITY : event.values[0] );
                SenserText.setText( event.values[0] + "%");
                break;
        }
    }
}


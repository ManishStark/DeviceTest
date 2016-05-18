package com.sibaken.devicetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

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
}

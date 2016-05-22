package com.sibaken.devicetest;

import android.hardware.Sensor;

class Common {

    //ログタグ名
    public static final String TAG = "DeviceTest";

    /*
     *　リストに表示するセンサ名定義
     */
    //Android1.6で対応
    public static final String NAME_ACCELEROMETOR = "加速度センサー";    //
    public static final String NAME_GYROSCOPE = "ジャイロセンサー";
    public static final String NAME_LIGHT = "照度センサー";
    public static final String NAME_MAGNETIC_FIELD = "磁界センサー";
    public static final String NAME_ORIENTATION = "傾きセンサー";         //API Level 8でTYPE_ORIENTATIONは非推奨となった
    public static final String NAME_PRESSURE = "圧力センサー";
    public static final String NAME_PROXIMITY = "近接センサー";
    public static final String NAME_TEMPERATURE = "温度センサー";         //TYPE_AMBIENT_TEMPERATUREの追加によりTYPE_TEMPERATUREは非推奨となった
    //Android2.3で追加
    public static final String NAME_GRAVITY = "重力センサー";
    public static final String NAME_LINEAR_ACCELERATION	 = "直線化速度センサー";
    public static final String NAME_ROTATION_VECTOR	 = "回転ベクトルセンサー";
    //Android4.0で追加
    public static final String NAME_AMBIENT_TEMPERATURE	 = "温度センサー(最新)";
    public static final String NAME_RELATIVE_HUMIDITY	 = "湿度センサー";

    //以下今後追加したいもの
  /*
    "GPS",
    "スピーカー",
    "マイク",
    "電池残量",
    "タッチスクリーン",
    "デバイス情報",*/
}

/*
 *　テストアイテム構造体
 */
class TestItem {
    public String Name;     //センサーの名前
    public int Type;       //センサーのタイプ
    public String Help;

        //コンストラクタ
    TestItem(String Name, int Type, String Help){
        this.Name = Name;
        this.Type = Type;
        this.Help = Help;
    }
}

/*
 *　テストアイテムリスト構造体
 */
class TestItemList {
    public TestItem TestItem[] = {
            //       センサーの名前（リストに表示される） //センサーのタイプ（センサー取得時の定義）  //センサーの説明
            new TestItem(Common.NAME_ACCELEROMETOR,         Sensor.TYPE_ACCELEROMETER,           "説明文1"),
            new TestItem(Common.NAME_GYROSCOPE,             Sensor.TYPE_GYROSCOPE,                 "説明文2"),
            new TestItem(Common.NAME_LIGHT,                  Sensor.TYPE_LIGHT,                     "説明文3"),
            new TestItem(Common.NAME_MAGNETIC_FIELD,        Sensor.TYPE_MAGNETIC_FIELD,          "説明文4"),
            new TestItem(Common.NAME_ORIENTATION,           Sensor.TYPE_ORIENTATION,              "説明文5"),
            new TestItem(Common.NAME_PRESSURE,               Sensor.TYPE_PRESSURE,                 "説明文6"),
            new TestItem(Common.NAME_PROXIMITY,              Sensor.TYPE_PROXIMITY,                "説明文7"),
            new TestItem(Common.NAME_TEMPERATURE,            Sensor.TYPE_TEMPERATURE,             "説明文8"),
            new TestItem(Common.NAME_GRAVITY,                Sensor.TYPE_GRAVITY,                  "説明文9"),
            new TestItem(Common.NAME_LINEAR_ACCELERATION,  Sensor.TYPE_LINEAR_ACCELERATION,    "説明文10"),
            new TestItem(Common.NAME_ROTATION_VECTOR,       Sensor.TYPE_ROTATION_VECTOR,         "説明文11"),
            new TestItem(Common.NAME_AMBIENT_TEMPERATURE,  Sensor.TYPE_AMBIENT_TEMPERATURE,    "説明文12"),
            new TestItem(Common.NAME_RELATIVE_HUMIDITY,     Sensor.TYPE_RELATIVE_HUMIDITY,      "説明文13"),
            new TestItem("End", -1, ""),
    };
}
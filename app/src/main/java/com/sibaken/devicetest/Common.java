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

    //コンストラクタ
    TestItem(String Name, int Type){
        this.Name = Name;
        this.Type = Type;
    }
}

/*
 *　テストアイテムリスト構造体
 */
class TestItemList {
    public TestItem TestItem[] = {
            //           センサーの名前（リストに表示される） //センサーのタイプ（センサー取得時の定義）
            new TestItem(Common.NAME_ACCELEROMETOR,         Sensor.TYPE_ACCELEROMETER),
            new TestItem(Common.NAME_GYROSCOPE,             Sensor.TYPE_GYROSCOPE),
            new TestItem(Common.NAME_LIGHT,                  Sensor.TYPE_LIGHT),
            new TestItem(Common.NAME_MAGNETIC_FIELD,        Sensor.TYPE_MAGNETIC_FIELD),
            new TestItem(Common.NAME_ORIENTATION,           Sensor.TYPE_ORIENTATION),
            new TestItem(Common.NAME_PRESSURE,               Sensor.TYPE_PRESSURE),
            new TestItem(Common.NAME_PROXIMITY,              Sensor.TYPE_PROXIMITY),
            new TestItem(Common.NAME_TEMPERATURE,            Sensor.TYPE_TEMPERATURE),
            new TestItem(Common.NAME_GRAVITY,                Sensor.TYPE_GRAVITY),
            new TestItem(Common.NAME_LINEAR_ACCELERATION,  Sensor.TYPE_LINEAR_ACCELERATION),
            new TestItem(Common.NAME_ROTATION_VECTOR,       Sensor.TYPE_ROTATION_VECTOR),
            new TestItem(Common.NAME_AMBIENT_TEMPERATURE,  Sensor.TYPE_AMBIENT_TEMPERATURE),
            new TestItem(Common.NAME_RELATIVE_HUMIDITY,     Sensor.TYPE_RELATIVE_HUMIDITY),
            new TestItem("End", 10),
    };
}
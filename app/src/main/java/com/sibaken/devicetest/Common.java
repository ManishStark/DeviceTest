package com.sibaken.devicetest;

public class Common {

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

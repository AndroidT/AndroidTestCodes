package com.example.androidtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

public class PhoneInfoAct extends Activity {
	
	private TextView textView;
	private String phoneInfo="";
	
	// -1��û������ 1��WIFI���� 2��wap���� 3��net����   
	private final static int WIFI = -1;
	private final static int CMWAP = 2;
	private final static int CMNET = 3;
	private static TelephonyManager tm;
	private WifiInfo wifiInfo;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("�ֻ���Ϣ");
		setContentView(R.layout.phone_infos);
		
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);    
        wifiInfo = wifiManager.getConnectionInfo();    
        
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		
		textView = (TextView) findViewById(R.id.phone_infos);
		
		getPhoneInfo();
		
		textView.setText("�ֻ���Ϣ��\n" + phoneInfo);
	}
	
	private void getPhoneInfo() {

		 //���ַ�ʽ��service���޷�ʹ�ã�    
        DisplayMetrics dm = new DisplayMetrics();    
        getWindowManager().getDefaultDisplay().getMetrics(dm);    
        int width = dm.widthPixels;              //��    
        int height = dm.heightPixels;           //��    
     
//        //��service��Ҳ�ܵõ��ߺͿ�    
//        WindowManager mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);    
//        width = mWindowManager.getDefaultDisplay().getWidth();    
//        height = mWindowManager.getDefaultDisplay().getHeight();    
		
        String simOperator = getSimOperatorNameStr(Integer.parseInt(tm.getSimOperator()));
        
        int apnType = getNetStatus(this);
        
		phoneInfo += " imei��" + tm.getDeviceId();
		phoneInfo += ",\n imsi��" + tm.getSubscriberId();
		phoneInfo += ",\n mType��" + android.os.Build.MODEL;
		phoneInfo += ",\n mMobileNum��" + tm.getLine1Number();
		phoneInfo += ",\n mSimOperator��" + simOperator + "/"+ tm.getSimOperatorName();

		phoneInfo += ",\n width��" + width;
		phoneInfo += ",\n height��" + height;
		
		phoneInfo += ",\n networkid��" + wifiInfo.getNetworkId();
		phoneInfo += ",\n ssid��" + wifiInfo.getSSID();
		phoneInfo += ",\n ip address��" + wifiInfo.getIpAddress();
		phoneInfo += ",\n mac address��" + wifiInfo.getMacAddress();
		phoneInfo += ",\n apnType��" + apnType;
		
		
	    phoneInfo += "\n\n BOARD: " + android.os.Build.BOARD;  
	    phoneInfo += ",\n BOOTLOADER: " + android.os.Build.BOOTLOADER;  
	    //BRAND ��Ӫ��  
	    phoneInfo += ",\n BRAND: " + android.os.Build.BRAND;  
	    phoneInfo += ",\n CPU_ABI: " + android.os.Build.CPU_ABI;  
	    phoneInfo += ",\n CPU_ABI2: " + android.os.Build.CPU_ABI2;  
	    //DEVICE ����  
	    phoneInfo += ",\n DEVICE: " + android.os.Build.DEVICE;  
	    //DISPLAY ��ʾ  
	    phoneInfo += ",\n DISPLAY: " + android.os.Build.DISPLAY;  
	    //ָ��  
	    phoneInfo += ",\n FINGERPRINT: " + android.os.Build.FINGERPRINT;  
	    //HARDWARE Ӳ��  
	    phoneInfo += ",\n HARDWARE: " + android.os.Build.HARDWARE;  
	    phoneInfo += ",\n HOST: " + android.os.Build.HOST;  
	    phoneInfo += ",\n ID: " + android.os.Build.ID;  
	    //MANUFACTURER ��������  
	    phoneInfo += ",\n MANUFACTURER: " + android.os.Build.MANUFACTURER;  
	    //MODEL ����  
	    phoneInfo += ",\n MODEL: " + android.os.Build.MODEL;  
	    //PRODUCT ��Ʒ
	    phoneInfo += ",\n PRODUCT: " + android.os.Build.PRODUCT;  
	    phoneInfo += ",\n RADIO: " + android.os.Build.RADIO;  
	    phoneInfo += ",\n RADITAGSO: " + android.os.Build.TAGS;  
	    phoneInfo += ",\n TIME: " + android.os.Build.TIME;  
	    phoneInfo += ",\n TYPE: " + android.os.Build.TYPE;  
	    phoneInfo += ",\n USER: " + android.os.Build.USER;  
	    //VERSION.RELEASE �̼��汾  
	    phoneInfo += ",\n VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE;  
	    phoneInfo += ",\n VERSION.CODENAME: " + android.os.Build.VERSION.CODENAME;  
	    //VERSION.INCREMENTAL �����汾  
	    phoneInfo += ",\n VERSION.INCREMENTAL: " + android.os.Build.VERSION.INCREMENTAL;  
	    //VERSION.SDK SDK�汾  
	    phoneInfo += ",\n VERSION.SDK: " + android.os.Build.VERSION.SDK;  
	    phoneInfo += ",\n VERSION.SDK_INT: " + android.os.Build.VERSION.SDK_INT;  
	}

	private String getSimOperatorNameStr(int i) {
		StringBuilder simOperNameStr = new StringBuilder();
		simOperNameStr.append(i);
		switch (i) {
		case 46000:
			simOperNameStr.append("/�й��ƶ�");
			return simOperNameStr.toString();
		case 46001:
			simOperNameStr.append("/�й���ͨ");
			return simOperNameStr.toString();
		case 46002:
			simOperNameStr.append("/�й��ƶ�");
			return simOperNameStr.toString();
		case 46003:
			simOperNameStr.append("/�й�����");
			return simOperNameStr.toString();
		case 46005:
			simOperNameStr.append("/�й��ƶ�");
			return simOperNameStr.toString();
		case 46006:
			simOperNameStr.append("/�й���ͨ");
			return simOperNameStr.toString();
		case 46007:
			simOperNameStr.append("/�й��ƶ�");
			return simOperNameStr.toString();
		case 46020:
			simOperNameStr.append("/�й���ͨ");
			return simOperNameStr.toString();
		default:
			return simOperNameStr.toString();
		}
	}
	
	/**   
     * ��ȡ��ǰ������״̬ 
     *    
     * @param context   
     * @return   
     */   
    public static int getNetStatus(Context context) {
        int netStatus = -1;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
  
        if (networkInfo == null) {
            return netStatus;
        }
        
        int nStatus = networkInfo.getType();
        if (nStatus == ConnectivityManager.TYPE_MOBILE) {
            if (networkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
                netStatus = CMNET;// ����
            } else {
                netStatus = CMWAP;// �ƶ�����ͨ
            }
        } else if (nStatus == ConnectivityManager.TYPE_WIFI) {
            netStatus = WIFI;
        }
        return netStatus;
    }
    
    public static int getNetType(Context context){
    	int netType = -1;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nStatus = networkInfo.getSubtype();
        Log.i("liuz", "nStatus..." + nStatus);
        switch (nStatus) {
		case TelephonyManager.NETWORK_TYPE_1xRTT:
			
			break;

		default:
			break;
		}
        return netType;
    }
    
}

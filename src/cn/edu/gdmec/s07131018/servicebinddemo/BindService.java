package cn.edu.gdmec.s07131018.servicebinddemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class BindService extends Service {
	public double PI = 3.1415926;
	private final IBinder mBinder = new mBinder();
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"bind", 1000).show();
		return mBinder;
	}
	public double Avg(long a,long b){
		return (a+b)/2;
		
	}
	public class mBinder extends Binder{
		public BindService getService(){
			return BindService.this;
		}
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Toast.makeText(this,"create", 1000).show();
		super.onCreate();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(this,"destroy", 1000).show();
		super.onDestroy();
	}
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"unbind", 1000).show();
		return super.onUnbind(intent);
	}
	
}

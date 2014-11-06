package cn.edu.gdmec.s07131018.servicebinddemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv;
	private boolean isCreate = false;
	private BindService myService;
	private Intent intent = new Intent("cn.edu.gdmec.serviceBind");
	public ServiceConnection mConn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			myService = ((BindService.mBinder) service).getService();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void Bind(View view) {
		bindService(intent, mConn, Context.BIND_AUTO_CREATE);
		isCreate = true;
	}

	public void Unbind(View view) {
		if(isCreate){
			isCreate=false;
			unbindService(mConn);
		}
	}

	public void Avg(View view) {
		if (isCreate) {
			long a = Math.round(Math.random()*100);
			long b = Math.round(Math.random()*100);
			tv.setText("("+a+"+"+b+")/2="+String.valueOf(myService.Avg(a, b)));
		}
	}

	public void PI(View view) {
		if(isCreate){
			tv.setText(String.valueOf(myService.PI));
		}
	}
}

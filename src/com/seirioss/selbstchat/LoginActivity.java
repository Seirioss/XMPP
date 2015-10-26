package com.seirioss.selbstchat;

import com.seirioss.util.ConnectionCheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button loginButton;
	
	private ConnectionCheck connectionCheck;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		usernameEditText = (EditText)findViewById(R.id.usernameEdit);
		passwordEditText = (EditText)findViewById(R.id.passwordEdit);
		loginButton = (Button)findViewById(R.id.loginButton);
		
		new Thread(new Runnable() {              //新线程，访问网络
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Looper.prepare();
				connectionCheck = new ConnectionCheck();
		if (!connectionCheck.isNetworkConnected(LoginActivity.this)) {
			Toast.makeText(LoginActivity.this, "Network is Offline!", Toast.LENGTH_SHORT).show();
		}else {
			if (connectionCheck.isConnectToServer()) {
				Toast.makeText(LoginActivity.this, "Server Online!", Toast.LENGTH_SHORT);
				Log.e("SelbstChat", "Server Online!");
			}else Toast.makeText(LoginActivity.this, "Server Offline!", Toast.LENGTH_SHORT).show();
		}
		        Looper.loop();
			}
		}).start();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (usernameEditText.getText().equals(null)) {
					Toast.makeText(LoginActivity.this, "Please input Username", Toast.LENGTH_SHORT).show();
				}else if (passwordEditText.getText().equals(null)) {
					Toast.makeText(LoginActivity.this, "Please input Password", Toast.LENGTH_SHORT).show();
				}//else if (connectionCheck.isRightAccount(usernameEditText.getText().toString(), passwordEditText.getText().toString())) {
				 //	Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				 //	startActivity(intent);
				//}
			}
		});
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
}

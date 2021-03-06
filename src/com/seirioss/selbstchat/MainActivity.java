package com.seirioss.selbstchat;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.seirioss.util.*;


public class MainActivity extends Activity{

	private TextView received;
	private EditText sending;
	private Button sendButton;
	private Button connectButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        received = (TextView)findViewById(R.id.msgreceived);
        sending = (EditText)findViewById(R.id.msgsending);
        sendButton = (Button)findViewById(R.id.sendbutton);
        connectButton = (Button)findViewById(R.id.connection);
        
        connectButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*if (ConnectionCheck.isNetworkConnected(MainActivity.this)) {
					Toast.makeText(MainActivity.this, "APP is Online", Toast.LENGTH_SHORT).show();
					if (ConnectionCheck.conServer()) {     //��openfire��������ע��
						Toast.makeText(MainActivity.this, "Already Sign in!", Toast.LENGTH_SHORT).show();
					}
				}else {
					Toast.makeText(MainActivity.this, "APP is Offline", Toast.LENGTH_SHORT).show();
				} */
			}
		});
    }
    
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

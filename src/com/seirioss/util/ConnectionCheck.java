package com.seirioss.util;

import java.security.PublicKey;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import android.R.string;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class ConnectionCheck {
	
	private XMPPConnection connection;
	
	public ConnectionCheck() {
		// TODO Auto-generated constructor stub
		ConnectionConfiguration config = new ConnectionConfiguration(Constant.LOCALHOST, Constant.PORT);
		config.setSASLAuthenticationEnabled(false);	
		try {
			connection = new XMPPConnection(config);
			connection.connect();
		//	connection.login("seirioss", "zdsaz689");
		//	connection.login("seirioss", "zdsaz689");
		} catch (XMPPException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public boolean isConnectToServer() {
		if (connection == null) {
			return false;
		}else return true;
	}
	
	public boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
	/*public boolean isRightAccount(String username, String password) {
		if (username.equals("seirioss") && password.equals("zdsaz689")) {
			try {
				connection.login(username, password);
				return true;
			} catch (XMPPException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			return false;
		}
	}*/

	public boolean conServer() {
		ConnectionConfiguration config = new ConnectionConfiguration(Constant.LOCALHOST, Constant.PORT);
		config.setSASLAuthenticationEnabled(false);	
		try {
			connection = new XMPPConnection(config);
			connection.connect();	
			try {
				if (connection == null) {				
					return false;
				}else {
					connection.login("seirioss", "zdsaz689");
					return true;
				}
			} catch (XMPPException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return false;
		} catch (XMPPException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
}

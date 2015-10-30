package com.seirioss.util;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import android.util.Log;


public class ChatManagment {
	
	private XMPPConnection connection;
	private ConnectionCheck connectionCheck = new ConnectionCheck();
	
	private ChatManager chatManager;
	
	private Chat chat;
	
	public ChatManagment() {
		connection = connectionCheck.getConnection();
		chatManager = connection.getChatManager();
	}
	
	public void receiveMessage() {
		chatManager.addChatListener(new ChatManagerListener() {
			
			@Override
			public void chatCreated(Chat chat, boolean createdLocally) {
				// TODO Auto-generated method stub
				chat.addMessageListener(new MessageListener() {
					
					@Override
					public void processMessage(Chat chat, Message message) {
						// TODO Auto-generated method stub
					    final String msg = message.getBody();
					    showReceiveMessage(msg);
					}
				});
			}
		});
	}
	
	public String showReceiveMessage(String msg) {
		return msg;
	}
	
	
	
	public void sendMessage(final String msg, String to) {
		chat = chatManager.createChat(to + "@dell" , null);
		try {
			Log.e("selbstChat", "sendingMessage");
			chat.sendMessage(msg);
		} catch (XMPPException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

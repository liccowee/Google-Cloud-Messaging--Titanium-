package com.activate.gcm;

import java.io.IOException;
import java.util.HashMap;
import org.appcelerator.titanium.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMBroadcastReceiver;
import com.activate.gcm.C2dmModule;
import static com.activate.gcm.CommonUtilities.SENDER_ID;
//import com.keyview.souguide.C2DMReceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class GCMIntentService extends GCMBaseIntentService {

	private static final String LCAT = "C2DMReceiver";

	private static final String REGISTER_EVENT = "registerC2dm";
	private static final String UNREGISTER_EVENT = "unregister";
	private static final String MESSAGE_EVENT = "message";
	private static final String ERROR_EVENT = "error";

	public GCMIntentService(){
		super(SENDER_ID);
	}

	@Override
	public void onRegistered(Context context, String registrationId){
		Log.d(LCAT, "Registered: " + registrationId);

		C2dmModule.getInstance().sendSuccess(registrationId);
	}

	@Override
	public void onUnregistered(Context context, String registrationId) {
		Log.d(LCAT, "Unregistered");

		C2dmModule.getInstance().fireEvent(UNREGISTER_EVENT, new HashMap());
	}

	@Override
	protected void onMessage(Context context, Intent intent) {
		Log.d(LCAT, "Message received");

		HashMap data = new HashMap();
		for (String key : intent.getExtras().keySet()) {
			Log.d(LCAT, "Message key: " + key + " value: "
					+ intent.getExtras().getString(key));

			String eventKey = key.startsWith("data.") ? key.substring(5) : key;
			data.put(eventKey, intent.getExtras().getString(key));
		}
		if (C2dmModule.getInstance() == null) {
			int icon = 0x7f02000a; // get this from R.java
			CharSequence tickerText = "Notification Ticker Here";
			long when = System.currentTimeMillis();

			CharSequence contentTitle = "Notification Title"; // expanded message title
			CharSequence contentText = "Notification Content"; // expanded
																			// message
																			// text

			Intent notificationIntent = new Intent(this, GCMIntentService.class);

			Intent launcherintent = new Intent("android.intent.action.MAIN");
			launcherintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.		FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			launcherintent
					.setComponent(ComponentName
							.unflattenFromString("[package name]/[package name].[activity name]"));
			launcherintent.addCategory("android.intent.category.LAUNCHER");
			

			PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
					launcherintent, 0);

			// the next two lines initialize the Notification, using the
			// configurations above

			Notification notification = new Notification(icon, tickerText, when);
			
			notification.defaults = Notification.DEFAULT_ALL;
			notification.flags = Notification.FLAG_AUTO_CANCEL;
			notification.setLatestEventInfo(context, contentTitle, contentText,
					contentIntent);
			String ns = Context.NOTIFICATION_SERVICE;
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
			mNotificationManager.notify(1, notification);
		} else
			C2dmModule.getInstance().sendMessage(data);
	}

	@Override
	public void onError(Context context, String errorId) {
		Log.e(LCAT, "Error: " + errorId);

		C2dmModule.getInstance().sendError(errorId);
	}

	@Override
	public boolean onRecoverableError(Context context, String errorId) {
		Log.e(LCAT, "RecoverableError: " + errorId);

		C2dmModule.getInstance().sendError(errorId);

		return true;
	}

}

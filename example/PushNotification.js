/**
 * @author Activate
 */


exports.pushNotification = function()
{
	var hostURL = "http://YOUR_HOST_URL/register?";
	
	var gcm = require('com.activate.gcm');
	Ti.API.info('module gcm is => ' + gcm);
	
	Ti.API.info('Registering...');
	
	gcm.registerC2dm
	( 
		{
			success:function(e)
			{
				Ti.API.info('JS registration success event: ' + e.registrationId);
				alert('Yeah JS registration success event: ' + e.registrationId);
				alert('Sender ID:' + gcm.getSenderId());
				alert('Registration ID:' + gcm.getRegistrationId());
				
				var appName = Ti.App.name;
				var appVersion = Ti.App.version;
				
				var deviceUUID = Ti.Platform.macaddress; // Ti.Network.remoteDeviceUUID;
				var deviceName = Ti.Platform.username;
				var deviceModel = Ti.Platform.model;
				var deviceSystemVersion = Ti.Platform.version;
				var deviceToken = e.deviceToken;
				var regId = e.registrationId;
				
				//deviceUUID = deviceUUID.replace(/-/ig,'');
				//deviceToken = deviceToken.replace(/<>/ig, '');

				
				var host = hostURL;
				var urlString = host;
				/*urlString += "&appname=" + appName;
				urlString += "&appversion=" + appVersion;
				urlString += "&deviceuid=" + deviceUUID;
				urlString += "&devicetoken=" + deviceToken;
				urlString += "&devicename=" + deviceName;
				urlString += "&devicemodel=" + deviceModel;
				urlString += "&deviceversion=" + deviceSystemVersion;*/
				urlString += "regId=" + regId;
				
				var loader = Ti.Network.createHTTPClient();
				loader.setTimeout(60000);
				
				loader.onload = function(evt)
				{
					alert(evt);
				}
				
				loader.open('GET', urlString, false);
				loader.send();
				
				alert(urlString);
			},
			error:function(e)
			{
				Ti.API.error("Error during registration : " + e.error);
				alert("Error during registration : " + e.error);
				
				var message;
				if(e.error == "ACCOUNT_MISSING")
				{
					message = "No Google account found; you will need to add on in order to activate notifications";
				}

				Titanium.UI.createAlertDialog
				(
					{
						title:'Push Notification Setup',
						message:message,
						buttonNames:['OK']
					}
				).show();
			},
			callback:function(e) // called when a push notification is received
			{
				Ti.API.info('JS message event: ' + JSON.stringify(e.data));
				alert('JS message event: ' + JSON.stringify(e.data));
				
				/*var intent = Ti.Android.createIntent
				(
					{
						action:Ti.Android.ACTION_MAIN,
						flags:Ti.Android.FLAG_ACTIVITY_NEW_TASK | Ti.Android.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED,
						packageName:'com.activate.mohh',
						className:'com.activate.mohh.mohhActivity'
					}
				);
				
				// This is fairly static: Not much need to be altered here
				var pending = Ti.Android.createPendingIntent
				(
					{
						activity:Ti.Android.currentActivity,
						intent:intent,
						type:Ti.Android.PENDING_INTENT_FOR_ACTIVITY
					}
				);
				
				var notification = Ti.Android.createNotification
				(
					{
						contentIntent:pending,
						contentTitle:'New Message',
						contentText:e.data.message,
						tickerText:'New Message'
					}
				);
				
				Ti.Android.NotificationManager.notify(1, notification);*/
			}
		}
	);
}
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

				//same as e.data
				//var data = Ti.App.Properties.getString("com.activate.gcm.last_data","");
				//data = JSON.parse(data);
				//Ti.App.Properties.removeProperty("com.activate.gcm.last_data");
				//Ti.App.Properties.hasProperty("com.activate.gcm.last_data");
				//Ti.Android.NotificationManager.cancelAll();

			}
		}
	);
}
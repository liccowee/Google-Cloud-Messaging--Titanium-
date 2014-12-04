# Google-Cloud-Messaging--Titanium- #

A Titanium module for registering a device with GCM and handling notifications sent to the device.

Android platform are using c2dm for push notification, but because c2dm have stopped accept new user, so we have decide to use the new service that google provided which is Google Cloud Messaging (GCM).
Current Latest version is 0.5

## Topics Covered ##

1. Change Log
1. How to use this module in a Titanium project (for people that use my pre-built module)
1. Sending Notifications (from a server)
1. Steps to build module for Titanium (Mac Users) (for people that who want to create their own gcm module)
1. Documents

## Change Log ##

### v0.6 ###

- Fixed most of the issue.
- Compatible with Titanium SDK 3.2.0 and higher including 3.2.3

### v0.5 ###

  - Fixed push notification id which does not replace the notification in you list.
  - Integrated vibration and sound property when sending message from server.
    Example php message: 

    
    $gcm = new GCM();
    $registatoin_ids = array($regId);
    $message = array(title => 'title', message => $message, ticker => $message, vibrate => 1, sound => 'default');
    $result = $gcm->send_notification($registatoin_ids, $message);

### v0.3 ###

- Changed from getSystemProperties() to getAppProperties() at C2dmModule.java and GCMIntentService.java
- fixed clicking on the notification does what is expected
- Changed behaviour so that if message is null we don't display a notification
- able to push notification by vibration

### v0.2 ###

- stop to use SENDER_ID
- remove senderID from the parameters of "registerC2dm"
- auto generate permission in timodule.xml
- store the wall push data into "com.activate.gcm.last_data" (stringified json)
- call the callback (will not work if app isn't running and V8)

## How to use this module in a Titanium project ##

1. Copy the .zip into your titanium project at root level. You may use my zip module as well, inside /dist/com.activate.gcm-android-0.1.zip. Double click on the zip file, the zip should be unzip inside the folder name "module".
1. Insert some properties into tiapp.xml. I have upload my project tiapp.xml to this project, please navigate to /example/tiapp.xml for the references.
1. After that, you also can refer to the /example/PushNotification.js as reference how to use push notification android in titanium. I have provided example into it.

### tiapp.xml properties ###

Add these to your tiapp.xml file inside the ti:app group.

    <property name="com.activate.gcm.sender_id" type="string">?????</property>
    <property name="com.activate.gcm.icon" type="int">?????</property>
    <property name="com.activate.gcm.component" type="string">?????</property>

#### com.activate.gcm.sender_id ####

This is your sender ID from Google (**not** your server's API key).

#### com.activate.gcm.icon ####

This is the icon that will be shown in the Android notification centre.

1. Build the app for Android
1. Go to your build directory and search for R.java
1. In the R.java file, with the directory path matching your package id, find this property:
  `public static final int appicon=`
1. Convert the number to decimal (tip: google: `[number] in decimal`)
1. Place the decimal number in the tiapp.xml property as shown above.

### com.activate.gcm.component ###

This is a path to the activity that will be launched when the Android user taps to open a notification.

A Titanium App would normall launch the main activity.

The format is:

    <package name>/<package name>.<activity name>
    
eg:

    com.appcelerator.notificationsample/com.appcelerator.notificationsample.NotificationSampleActivity
    
(the main activity name always ends in "Activity")

For a similar case, see the Titanium documentation:

http://docs.appcelerator.com/platform/latest/#!/api/Titanium.Android.NotificationManager

"The Intent object associated with the notification determines what happens when the user clicks on the notification. In this case, we simply launch the application. The intent in this sample uses a className to identify the activity to launch."

"A Titanium application's main activity generally has the class name:"

    <app_id>.<Appname>Activity

"For example, in this case the test application has the app ID com.appcelerator.notificationsample and app name NotificationSample, so the activity class name is:"

    com.appcelerator.notificationsample.NotificationSampleActivity

"You can also find the activity's class name by looking in the build/android folder of your Titanium project."

## Sending Notifications ##

For a notification to appear (in the notification center), include these properties of the the `data` object of a standard GCM HTTP post:

- title
- message

To add *optional* alert sounds and vibrations use:

- sound - `true` or a string with the wav file name (optional)
- vibrate - `true` (optional)

For a silent notification containing data only, simply do not include the properties above. The data will still be received by the app.

JSON example:

    { "data": {
      "title": "Title",
      "message": "Message",
      "sound": true,
      "vibrate": "sound.wav",
      },
      "registration_ids": ["4", "8", "15", "16", "23", "42"]
    }
    
For more info, see: http://developer.android.com/google/gcm/http.html

## Steps to build module for Titanium (from source) ##

1. You have to get the android sdk manager, and download the google gcm from there.

1. Get the ANT 1.8 from >> http://ant.apache.org/bindownload.cgi, ANT 1.8 use to create module project and compile use for titanium use.

1. Using terminal to create module project for titanium by runing the command below.

  `/Users/Library/Application\ Support/Titanium/mobilesdk/osx/1.8.2/titanium.py create --platform=android --type=module --id=YOUR_PROJECT_ID --android=YOUR_ANDROID_SDK_PATH`

  For example: `--id=com.activate.gcm, --android=/Applicatoins/android-sdk`

1. Once the module project create success, copy the gcm/gcm-client/src folder from you have downloaded at Android SDK Manager into the module src folder.

1. Please make changes of the sdk path at the build.properties, such as titanium.platoform, android.platform, google.apis, and android.ndk

1. Now what you want to do is create the interface class between Java native code with titanium javascript using the Kroll Method. For more information please read here:

  https://wiki.appcelerator.org/display/guides/Android+Module+Development+Guide

  You also can take my source code as reference on how to create the interface. The source code is provided in this project which inside /src folder.

1. After complete setup all the class and interface, using ANT 1.8 to compile the module. To compile the module, we have to compile on build.xml. Now, navigate the ANT using terminal and type the command as follow.

  `/Users/Desktop/ANT/apache-ant-1.8.4/bin/ant -buildfile /Users/Desktop/gcm/build.xml`

1. After all success compile, the terminal should prompt BUILD SUCCESSFUL, and navigate to folder /dist, inside have the zip file and jar file. 

1. Finally, you have complete and success create the module, now look at "How to use this module at titanium."

## Documents ##

- Website: http://developer.android.com/guide/google/gcm/index.html

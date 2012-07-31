Google-Cloud-Messaging--Titanium-
=================================
Android platform are using c2dm for push notification, but because c2dm have stopped accept new user, so we have decide to use the new service that google provided which is Google Cloud Messaging (GCM).


Topic Covered
-------------
1. Steps to create module for Titanium use. (Mac Users) (For people that who want to create their own gcm module)
2. How to use this module at titanium. (For people that use my created module)


Steps to create module for Titanium use
---------------------------------------
1. You have to get the android sdk manager, and download the google gcm from there.

2. Get the ANT 1.8 from >> http://ant.apache.org/bindownload.cgi, ANT 1.8 use to create module project and compile use for titanium use.

3. Using terminal to create module project for titanium by runing the command below.

    /Users/Library/Application\ Support/Titanium/mobilesdk/osx/1.8.2/titanium.py create --platform=android --type=module --id=YOUR_PROJECT_ID --android=YOUR_ANDROID_SDK_PATH
	
	For example my --id=com.activate.gcm, --android=/Applicatoins/android-sdk
	
4. Once the module project create success, copy the gcm/gcm-client/src folder from you have downloaded at Android SDK Manager into the module src folder.

5. Now what you want to do is create the interface class between Java native code with titanium javascript using the Kroll Method. For more information please read here >> https://wiki.appcelerator.org/display/guides/Android+Module+Development+Guide
You also can take my source code as reference on how to create the interface. The source code is provided in this project which inside /src folder.

6. After complete setup all the class and interface, using ANT 1.8 to compile the module. To compile the module, we have to compile on build.xml. Now, navigate the ANT using terminal and type the command as follow.
	
	/Users/Desktop/ANT/apache-ant-1.8.4/bin/ant -buildfile /Users/Desktop/gcm/build.xml
	
7. After all success compile, the terminal should prompt BUILD SUCCESSFUL, and navigate to folder /dist, inside have the zip file and jar file. 

Finally, you have complete and success create the module, now look at "How to use this module at titanium."



How to use this module at titanium.
-------------
1. Copy the .zip into your titanium project at root level. Double click on the zip file, the zip should be unzip inside the folder name "module".

2. Insert some data into tiapp.xml. As below:
	
	<modules>
		<module platform="android" version="0.1">YOUR_GCM_MODULE_ID</module>
	<modules>
	
I have upload my project tiapp.xml to this project, please navigate to /example/tiapp.xml for the references.

3. After that, you also can refer to the /example/PushNotification.js as reference how to use push notification android in titanium. I have provided example into it.


Document
------------------
   * Website: [http://developer.android.com/guide/google/gcm/index.html]
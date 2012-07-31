package com.activate.gcm;

import java.util.HashMap;

import org.appcelerator.kroll.runtime.rhino.KrollBindings;

public class GcmGeneratedBindings
{
	public static void init()
	{
		KrollBindings.addExternalBinding("com.activate.gcm.C2dmModule", com.activate.gcm.C2dmModulePrototype.class);
	}
}
/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

package com.activate.gcm;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollInvocation;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.KrollProxySupport;
import org.appcelerator.kroll.KrollRuntime;

import org.appcelerator.kroll.common.TiConfig;

import org.appcelerator.kroll.runtime.rhino.KrollBindings;
import org.appcelerator.kroll.runtime.rhino.KrollGeneratedBindings;
import org.appcelerator.kroll.runtime.rhino.Proxy;
import org.appcelerator.kroll.runtime.rhino.ProxyFactory;
import org.appcelerator.kroll.runtime.rhino.RhinoRuntime;
import org.appcelerator.kroll.runtime.rhino.TypeConverter;
import org.appcelerator.kroll.common.Log;

import java.util.HashMap;

import com.activate.gcm.C2dmModule;

import org.appcelerator.kroll.KrollModulePrototype;


public class C2dmModulePrototype extends KrollModulePrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "C2dmModulePrototype";
	private static final String CLASS_TAG = "C2dmModule";
	private static C2dmModulePrototype c2dmModulePrototype;


	public static C2dmModulePrototype getProxyPrototype()
	{
		return c2dmModulePrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		c2dmModulePrototype = null;
	}

	public C2dmModulePrototype()
	{
		if (c2dmModulePrototype == null && getClass().equals(C2dmModulePrototype.class)) {
			c2dmModulePrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

		isModule = true;
	}

	public Scriptable getPrototype()
	{
		if (this == c2dmModulePrototype) {
			return KrollModulePrototype.getProxyPrototype();
		}
		return c2dmModulePrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return KrollModulePrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(C2dmModule.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public void registerC2dm(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "registerC2dm()");
		}

		try {
		C2dmModule proxy = (C2dmModule) ((Proxy) thisObj).getProxy();
		if (args.length < 2) {
			throw new IllegalArgumentException("registerC2dm: Invalid number of arguments. Expected 2 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;
		java.util.HashMap arg1;
		arg1 = (java.util.HashMap) TypeConverter.jsObjectToJavaObject(args[1], thisObj) ;

		proxy.registerC2dm(arg0, arg1);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void unregister(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "unregister()");
		}

		try {
		C2dmModule proxy = (C2dmModule) ((Proxy) thisObj).getProxy();

		proxy.unregister();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public Object getRegistrationId(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "getRegistrationId()");
		}

		try {
		C2dmModule proxy = (C2dmModule) ((Proxy) thisObj).getProxy();

		java.lang.String javaResult = proxy.getRegistrationId();

		String rhinoResult = (String) javaResult;
	
			return rhinoResult;

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			return Undefined.instance;
		}
	}

	public Object getSenderId(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "getSenderId()");
		}

		try {
		C2dmModule proxy = (C2dmModule) ((Proxy) thisObj).getProxy();

		java.lang.String javaResult = proxy.getSenderId();

		String rhinoResult = (String) javaResult;
	
			return rhinoResult;

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			return Undefined.instance;
		}
	}


	// Dynamic properties

// #string_id_map#

	// Prototype IDs
	private static final int
		Id_constructor = 1
,		// Property IDs
		// Method IDs
		Id_registerC2dm = 2,
		Id_unregister = 3,
		Id_getRegistrationId = 4,
		Id_getSenderId = 5
;
		

	public static final int MAX_PROTOTYPE_ID = 5;

	protected int getMaxPrototypeId()
	{
		return MAX_PROTOTYPE_ID;
	}

	@Override
	protected int findPrototypeId(String s)
	{
		int id = 0;
// #generated# Last update: 2012-07-30 18:30:44 GMT+08:00
        L0: { id = 0; String X = null; int c;
            L: switch (s.length()) {
            case 10: X="unregister";id=Id_unregister; break L;
            case 11: c=s.charAt(0);
                if (c=='c') { X="constructor";id=Id_constructor; }
                else if (c=='g') { X="getSenderId";id=Id_getSenderId; }
                break L;
            case 12: X="registerC2dm";id=Id_registerC2dm; break L;
            case 17: X="getRegistrationId";id=Id_getRegistrationId; break L;
            }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
            break L0;
        }
// #/generated#
		return id;
	}

// #/string_id_map#

	@Override
	protected void initPrototypeId(int id)
	{
		String name;
		int arity;
		switch (id) {
			case Id_constructor:
				arity = 0;
				name = "constructor";
				break;
			case Id_registerC2dm:
				arity = 2;
				name = "registerC2dm";
				break;
			case Id_unregister:
				arity = 0;
				name = "unregister";
				break;
			case Id_getRegistrationId:
				arity = 0;
				name = "getRegistrationId";
				break;
			case Id_getSenderId:
				arity = 0;
				name = "getSenderId";
				break;
			default:
				super.initPrototypeId(id);
				return;
		}
		initPrototypeMethod(CLASS_TAG, id, name, arity);
	}

	@Override
	public Object execIdCall(IdFunctionObject f,
		Context cx, Scriptable scope, Scriptable thisObj, Object[] args)
	{
		if (!f.hasTag(CLASS_TAG)) {
			return super.execIdCall(f, cx, scope, thisObj, args);
		}

		while (thisObj != null && !(thisObj instanceof C2dmModulePrototype)) {
			thisObj = thisObj.getPrototype();
		}

		C2dmModulePrototype proxy = (C2dmModulePrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_registerC2dm:
				 registerC2dm(cx, thisObj, args);
				return Undefined.instance;
			case Id_unregister:
				 unregister(cx, thisObj, args);
				return Undefined.instance;
			case Id_getRegistrationId:
				return getRegistrationId(cx, thisObj, args);
				
			case Id_getSenderId:
				return getSenderId(cx, thisObj, args);
				
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}



	public static final int MAX_INSTANCE_ID = -1;


	@Override
	public String getClassName()
	{
		return CLASS_TAG;
	}
}

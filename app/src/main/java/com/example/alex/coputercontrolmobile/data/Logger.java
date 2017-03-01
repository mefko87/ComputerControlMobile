package com.example.alex.coputercontrolmobile.data;


import android.util.Log;

public class Logger {

	private static final boolean SHOW_LOGS = true;
	private static final String LOG_TAG = "DebugTag";

	public static void logD(String message) {
		if (SHOW_LOGS) {
			Log.d(LOG_TAG, message);
		}
	}

	public static void logI(String message) {
		if (SHOW_LOGS) {
			Log.i(LOG_TAG, message);
		}
	}

	public static void logE(String message) {
		if (SHOW_LOGS) {
			Log.e(LOG_TAG, message);
		}
	}

	public static void logV(String message) {
		if (SHOW_LOGS) {
			Log.v(LOG_TAG, message);
		}
	}

	public static void logW(String message) {
		if (SHOW_LOGS) {
			Log.w(LOG_TAG, message);
		}

	}
}
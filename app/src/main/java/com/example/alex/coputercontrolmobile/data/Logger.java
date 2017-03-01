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
}

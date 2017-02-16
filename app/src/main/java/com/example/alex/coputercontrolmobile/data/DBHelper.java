package com.example.alex.coputercontrolmobile.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABAASE_NAME = "DBtest.db";
	public static final int DATABASE_VERSION = 2;
	private Context mContext;
	private XMLParser mParser = new XMLParser();
	private String LOG_TAG = "myLogs";

	public DBHelper(Context context) throws IOException, XmlPullParserException {
		super(context, DATABAASE_NAME, null, DATABASE_VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {

		mParser.getmQueryList().clear();
		try {
			mParser.onCreateParse(mContext);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int listsize = mParser.getmQueryList().size();
		for (int i = 0; i < listsize; i++) {
			if (mParser.getmQueryList().get(i).length() > 10) {
				sqLiteDatabase.execSQL(mParser.getmQueryList().get(i));
				Log.d(LOG_TAG, "onCreate: " + mParser.getmQueryList().size() + mParser.getmQueryList().get(i));
			}
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		mParser.getmQueryList().clear();
		try {
			mParser.onUpdateParse(mContext);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!mParser.getmQueryList().isEmpty()) {
			int listsize = mParser.getmQueryList().size();
			for (int c = 0; c < listsize; c++) {
				if (mParser.getmQueryList().get(c).length() > 10) {
					sqLiteDatabase.execSQL(mParser.getmQueryList().get(c));
					Log.d(LOG_TAG, "onUpgrade: " + mParser.getmQueryList().size() + mParser.getmQueryList().get(c));
				}
			}
		} else {
			Log.d(LOG_TAG, "onUpgrade: " + " No query for upgrade");
		}
	}


}

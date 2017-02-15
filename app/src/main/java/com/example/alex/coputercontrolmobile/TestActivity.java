package com.example.alex.coputercontrolmobile;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.alex.coputercontrolmobile.data.DBHelper;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class TestActivity extends Activity {

	private DBHelper mDBHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			mDBHelper = new DBHelper(this);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		SQLiteDatabase db = mDBHelper.getWritableDatabase();
	}
}
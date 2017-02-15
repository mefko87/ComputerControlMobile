package com.example.alex.coputercontrolmobile;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ComputerControlDatabase extends SQLiteOpenHelper {

	static final String DBNAME = "DB.db ";
	static final String TABLE_COMPUTER_PROFILES = "TableComputerProfiles";
	static final String TABLE_HOTKEYS = "TableHotkeys";
	static final String KEY_ID = "_id";
	static final String COMPUTER_NUMBER = "PCNumber";
	static final String COMPUTER_NAME = "PCName";
	static final String COMPUTER_IP = "PCIP";
	static final String HOTKEY_NAME = "HotkeyName";
	static final String HOTKEY_COMBINATION = "HotkeyKombination";
	static final String HOTKEY_GROUP = "HotkeyGroup";
	static final String HOTKEY_PRIORITY = "HotkeyPriority";
	static final int DB_VERSION = 1;


	public ComputerControlDatabase(Context context) {


		super(context, DBNAME, null, DB_VERSION);


	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE IF NOT EXISTS "
				+ TABLE_COMPUTER_PROFILES
				+ " (Field1 VARCHAR, Field2 INT(3));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int i, int i1) {
		db.execSQL("DROP TABLE IF EXIST " + TABLE_COMPUTER_PROFILES);


		onCreate(db);
	}

}


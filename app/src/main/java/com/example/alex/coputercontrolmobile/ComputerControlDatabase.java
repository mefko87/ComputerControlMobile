package com.example.alex.coputercontrolmobile;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ComputerControlDatabase extends SQLiteOpenHelper {

	static final String DBNAME = "ComputerControlDatabase ";
	static final String TABLE_COMPUTER_PROFILES = "TableComputerProfiles";
	static final String TABLE_HOTKEYS = "TableHotkeys";
	static final String COMPUTER_NUMBER = "PCNumber";
	static final String COMPUTER_NAME = "PCName";
	static final String COMPUTER_IP = "PCIP";
	static final String HOTKEY_NAME = "HotkeyName";
	static final String HOTKEY_COMBINATION = "HotkeyKombination";
	static final String HOTKEY_GROUP = "HotkeyGroup";
	static final String HOTKEY_PRIORITY = "HotkeyPriority";
	static final int DB_VERSION = 1;


	public ComputerControlDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, DBNAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE + TABLE_COMPUTER_PROFILES ("
				+ "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "COMPUTER_NUMBER,"
				+ "COMPUTER_NAME,"
				+ "COMPUTER_IP" +
				");");

		db.execSQL("CREATE TABLE + TABLE_HOTKEYS ("
				+ "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "HOTKEY_NAME,"
				+ "HOTKEY_COMBINATION,"
				+ "HOTKEY_GROUP,"
				+ "HOTKEY_PRIORITY" + ");"
		);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int i, int i1) {
		db.execSQL("DROP TABLE IF EXIST " + TABLE_COMPUTER_PROFILES);
		db.execSQL("DROP TABLE IF EXIST " + TABLE_HOTKEYS);

		onCreate(db);
	}

}


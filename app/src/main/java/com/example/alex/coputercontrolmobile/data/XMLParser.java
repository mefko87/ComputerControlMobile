package com.example.alex.coputercontrolmobile.data;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
	private String LOG_TAG = "myLogs";
	private List<String> mQueryList = new ArrayList<String>();

	public XMLParser() throws IOException, XmlPullParserException {

	}

	public List<String> getmQueryList() {
		return mQueryList;
	}


	public void onUpdateParse(Context context) throws XmlPullParserException, IOException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setValidating(false);
		XmlPullParser xpp = factory.newPullParser();
		InputStream raw = context.getApplicationContext().getAssets().open("db_upgrades.xml");
		xpp.setInput(raw, null);

		int eventType = xpp.getEventType();
		String currentTag = null;
		String curentUserVersion = null;
		while (eventType != XmlPullParser.END_DOCUMENT) {

			if (eventType == XmlPullParser.START_TAG) {
				currentTag = xpp.getName();
				if (xpp.getAttributeCount() != 0) {
					curentUserVersion = xpp.getAttributeValue(0);
				}
			} else if (eventType == XmlPullParser.TEXT) {
				if ("query".equals(currentTag)) {
					if (Integer.parseInt(curentUserVersion) >= DBHelper.DATABASE_VERSION) {
						mQueryList.add(xpp.getText());
					}
				}
			}
			eventType = xpp.next();

		}
	}

	public void onCreateParse(Context context) throws XmlPullParserException, IOException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setValidating(false);
		XmlPullParser xpp = factory.newPullParser();
		InputStream raw = context.getApplicationContext().getAssets().open("db_upgrades.xml");
		xpp.setInput(raw, null);
		int eventType = xpp.getEventType();
		String currentTag = null;

		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				currentTag = xpp.getName();
			} else if (eventType == XmlPullParser.TEXT) {
				if ("query".equals(currentTag)) {

					mQueryList.add(xpp.getText());
				}
			}
			eventType = xpp.next();
		}
	}
}


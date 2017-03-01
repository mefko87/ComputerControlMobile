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

	private List<String> mQueryList = new ArrayList<String>();
	private static final String tagToParse = "query";
	private static final String mVersion = "version";
	private static final String mainTag = "db";

	public XMLParser() throws IOException, XmlPullParserException {

	}

	public List<String> getQueryList() {
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
		String currentUserVersion = null;
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				currentTag = xpp.getName();
				if (xpp.getName().equals(mainTag) && xpp.getAttributeName(0).equals(mVersion)) {
					currentUserVersion = xpp.getAttributeValue(0);
				}

			} else if (eventType == XmlPullParser.TEXT) {
				if (currentTag.equals(tagToParse) && Integer.parseInt(currentUserVersion) >= DBHelper.DATABASE_VERSION) {
					if (xpp.getText().length() > 8) {

						Logger.logD("Parse from " + currentTag + ": " + xpp.getText());

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
				if (currentTag.equals(tagToParse)) {
					if (xpp.getText().length() > 8) {
						Logger.logD("Parse from " + currentTag + ": " + xpp.getText());
						mQueryList.add(xpp.getText());
					}
				}
			}
			eventType = xpp.next();
		}
	}


}


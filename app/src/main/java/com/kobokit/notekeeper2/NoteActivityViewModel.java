package com.kobokit.notekeeper2;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
	public static final String ORIGINAL_COURSE_ID = "com.kobokit.notekeeper2.ORIGINAL_COURSE_ID";
	public static final String ORIGINAL_COURSE_TITLE = "com.kobokit.notekeeper2.ORIGINAL_COURSE_TITLE";
	public static final String ORIGINAL_COURSE_TEXT = "com.kobokit.notekeeper2.ORIGINAL_COURSE_TEXT";

	public String mOriginalNoteCourseId;
	public String mOriginalNoteText;
	public String mOriginalNoteTitle;
	public boolean mIsNewlyCreated = true;

	public void saveState(Bundle outState) {
		outState.putString(ORIGINAL_COURSE_ID, mOriginalNoteCourseId);
		outState.putString(ORIGINAL_COURSE_TITLE, mOriginalNoteTitle);
		outState.putString(ORIGINAL_COURSE_TEXT, mOriginalNoteText);
	}

	public void restoreState(Bundle instate) {
		mOriginalNoteCourseId = instate.getString(ORIGINAL_COURSE_ID);
		mOriginalNoteTitle = instate.getString(ORIGINAL_COURSE_TITLE);
		mOriginalNoteText = instate.getString(ORIGINAL_COURSE_TEXT);

	}
}

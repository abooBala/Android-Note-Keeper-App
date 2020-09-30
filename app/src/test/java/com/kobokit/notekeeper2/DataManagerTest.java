package com.kobokit.notekeeper2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManagerTest {

	@Test
	public void createNewNote() {

		DataManager dm = DataManager.getInstance();
		final CourseInfo courses = dm.getCourse("android_async");
		final String noteTitle = "Test note title";
		final String noteText = "This is the body text of my test note";

		int noteIndex = dm.createNewNote();
		NoteInfo newNote = dm.getNotes().get(noteIndex);
		newNote.setCourse(courses);
		newNote.setTitle(noteTitle);
		newNote.setText(noteText);

		NoteInfo compareNote = dm.getNotes().get(noteIndex);
		assertEquals(compareNote.getCourse(), courses);
		assertEquals(compareNote.getTitle(), noteTitle);
		assertEquals(compareNote.getText(), noteText);
	}
}
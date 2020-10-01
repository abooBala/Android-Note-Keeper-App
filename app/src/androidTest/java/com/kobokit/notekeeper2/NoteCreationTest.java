package com.kobokit.notekeeper2;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {

	static DataManager sDataManager;

	@BeforeClass
	public static void classSetup() {
		sDataManager = DataManager.getInstance();
	}

	@Rule
	public ActivityTestRule<NoteListActivity> mNoteListActivityActivityTestRule = new ActivityTestRule<>(NoteListActivity.class);

	@Test
	public void createNewNote() {
		final CourseInfo course = sDataManager.getCourse("java_lang");
		final String noteTitle = "Test note title";
		final String noteText = "This is our test note";

		onView(withId(R.id.fab)).perform(click());

		onView(withId(R.id.spinner_courses)).perform(click());
		onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());

		onView(withId(R.id.text_note_title)).perform(typeText(noteTitle));
		onView(withId(R.id.text_note_text)).perform(typeText(noteText),
				closeSoftKeyboard());

		pressBack();

	}

}
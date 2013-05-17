package com.example.runspy.test;

import junit.framework.TestCase;
import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import com.example.runspy.Login;
import com.example.runspy.R;
import com.example.runspy.Registration;
import com.jayway.android.robotium.solo.Solo;

public class RegistrationTest extends ActivityInstrumentationTestCase2<Registration> {

	private Solo solo;
	
	public RegistrationTest() {
		super(Registration.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation());
	}
	
	public void testShortUserName(){
		getActivity();
		solo.enterText(0, "aa");
		solo.enterText(1, "password");
		solo.enterText(2, "password");
		solo.enterText(3, "my@email.com");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testShortPassword(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "pw");
		solo.enterText(2, "pw");
		solo.enterText(3, "my@email.com");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	public void testShortNoUserName(){
		getActivity();
		solo.enterText(0, "");
		solo.enterText(1, "password");
		solo.enterText(2, "password");
		solo.enterText(3, "my@email.com");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testNoPassword(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "");
		solo.enterText(2, "");
		solo.enterText(3, "my@email.com");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testPasswordMisMatch(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "password");
		solo.enterText(2, "wordpass");
		solo.enterText(3, "my@email.com");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testIncorrectEmail(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "password");
		solo.enterText(2, "password");
		solo.enterText(3, "!@#$%^");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testNoEmail(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "password");
		solo.enterText(2, "password");
		solo.enterText(3, "");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testSuccess(){
		getActivity();
		solo.enterText(0, "username");
		solo.enterText(1, "password");
		solo.enterText(2, "password");
		solo.enterText(3, "my@gmail.com");
		solo.clickOnImageButton(0);
		assertTrue(solo.waitForActivity(Login.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}

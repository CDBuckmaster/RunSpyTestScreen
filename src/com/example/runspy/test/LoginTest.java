package com.example.runspy.test;

import junit.framework.TestCase;
import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import com.example.runspy.Login;
import com.example.runspy.R;
import com.example.runspy.Registration;
import com.example.runspy.Menu;
import com.jayway.android.robotium.solo.Solo;

public class LoginTest extends ActivityInstrumentationTestCase2<Login> {

	private Solo solo;
	public LoginTest() {
		super(Login.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation());
	}
	
	public void testNoUserName(){
		getActivity();
		solo.enterText(0, "");
		solo.enterText(1, "admin");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Menu.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testNoPassword(){
		getActivity();
		solo.enterText(0, "admin");
		solo.enterText(1, "");
		solo.clickOnImageButton(0);
		assertFalse(solo.waitForActivity(Menu.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}
	
	public void testSuccess(){
		getActivity();
		solo.enterText(0, "admin");
		solo.enterText(1, "admin");
		solo.clickOnImageButton(0);
		assertTrue(solo.waitForActivity(Menu.class.getSimpleName()));
		//solo.assertCurrentActivity("message", Login.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}

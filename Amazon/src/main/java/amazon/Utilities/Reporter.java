/**
 * Copyright (c) DXC 2020.
 * All Rights Reserved.
 *
 * ver          Creator          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.01     Mohamed Moustafa    03/02/2020  - Script continued.
 */
package amazon.Utilities;



import io.qameta.allure.Allure; 

public class Reporter {

	private static final Boolean RECORD_VIDEO = true;
	


	/**
	 * Method to add system out print ln into allure report and console 
	 * @param text insert text to be displayed in console and allure report
	 */
	public static void Log(String text) {
		Allure.step(text);
		System.out.println(text);
	}




	public static Boolean getRecordVideo() {
		return RECORD_VIDEO;
	}
}

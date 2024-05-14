package com.qa.testrailmanager;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.util.Map;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;


public class TestRailManager {
	
	public static String TEST_RUN_ID = "1";
	
	public static String TEST_RAIL_USERNAME = "";
	public static String TEST_RAIL_PASSWORD = "";
	
	
	public static String TEST_RAIL_ENGINEURL = "https://vineelaamaraneni.testrail.io/";
	
	public static int TEST_CASE_PASS_STATUS = 1;
	public static int TEST_CASE_FAIL_STATUS = 5;
	
	public static void addResultsForTestcase(String testCaseid, int status, String error) 
			throws MalformedURLException, IOException, APIException {
		String testrunID = TEST_RUN_ID;
		APIClient client = new APIClient(TEST_RAIL_ENGINEURL);
		client.setUser(TEST_RAIL_USERNAME);
		client.setPassword(TEST_RAIL_PASSWORD);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("status_id", status);
		data.put("comment","This is executed via test automation code" + error);
		client.sendPost("add_result_for_case/"+testrunID+"/"+testCaseid, data);		
		
	}
}
	

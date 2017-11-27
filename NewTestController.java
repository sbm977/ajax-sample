/**
 * 
 */
package com.remittance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author user
 *
 */
@Controller 
public class NewTestController {
	
	@RequestMapping(method = RequestMethod.GET,value="/new/balle")
	public String newController() {
		return "Customer/newTest";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="new/ajax/balle")
	@ResponseBody
	public Map<String,String> findValue(@RequestParam(value = "value") String val) {
		Map<String, String> mapResponse = new HashMap<String, String>();
		mapResponse.put("status","success");
		int converted = Integer.parseInt(val) * 120;
		mapResponse.put("converted",String.valueOf(converted));
		System.out.println(val + " THIS IS VAL");
		return mapResponse;
	}
}

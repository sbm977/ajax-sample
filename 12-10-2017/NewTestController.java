/**
 * 
 */
package com.remittance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public Map<String,HashMap<String,String>> findValue(@RequestParam(value = "value") String val) {
		HashMap<String, String> mapDepositAmountResponse = new HashMap<String, String>();
		Map<String, HashMap<String,String>> responseMap = new HashMap<String, HashMap<String,String>>();
		
		int converted = Integer.parseInt(val) * 120;
		//10 k - 1% 
		//10k - 2%
		//nk - 3%
		//get all the interest list as per deposited amount in the list from backend 
		//the below one is hard code
		List<Double> interestList  = new ArrayList<Double>();
		interestList.add(1.0);
		interestList.add(2.0);
		interestList.add(3.0);
		HashMap<String, String> interestMap = new HashMap<String,String>();
			for (int i=0;i<interestList.size();i++) {
				interestMap.put("interest"+(i+1), interestList.get(i).toString());
			}
//		for (double i: interestList) {
//			String interestName = "interest"+counter+1;
//			interestMap.put(interestName, String.valueOf(i));
//			i++;
//		}
		mapDepositAmountResponse.put("status","success");
		mapDepositAmountResponse.put("converted",String.valueOf(converted));
		
		//now put the values within responseMap
		responseMap.put("results", mapDepositAmountResponse);
		responseMap.put("interests", interestMap);
		
		System.out.println(val + " THIS IS VAL");
		return responseMap;
	}
}

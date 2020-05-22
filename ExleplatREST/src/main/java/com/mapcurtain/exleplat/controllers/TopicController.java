package com.mapcurtain.exleplat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapcurtain.exleplat.services.TopicService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class TopicController {
	
	@Autowired
	private TopicService topicSvc;
	
	// userSvc?
	
	// get list of all topics  ## is this public??
	
	// get list of topics by search term ## pub?
	
	// create topic ## make sure to add author
	
	// edit topic ## need to confirm current author, or potentially add request?
		// do I need to add a table to db for change requests?
	
	
	
	

}

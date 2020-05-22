package com.mapcurtain.exleplat.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapcurtain.exleplat.entities.Topic;
import com.mapcurtain.exleplat.services.TopicService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class TopicController {
	
	@Autowired
	private TopicService topicSvc;
	
	// userSvc?
	
	// get list of all topics  ## is this public??
	@GetMapping(value = "topics")
	public List<Topic> getAllTopics(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal){
		List<Topic> topics = new ArrayList<>();
		
		return topics;
	}
	
	// get single topic
	@GetMapping(value = "topics/{id}")
	public Topic getSingleTopic(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("id") Integer id) {
		Topic topic = new Topic();
		
		return topic;
	}
		
	// create topic ## make sure to add author
	@PostMapping(value = "topics")
	public Topic postNewTopic(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@RequestBody Topic topic) {
		
		return topic;
	}
	
	// edit topic ## need to confirm current author, or potentially add request?
		// do I need to add a table to db for change requests?
	@PutMapping(value = "topics/{id}")
	public Topic editTopic(HttpServletRequest req,
			HttpServletResponse res,
			Principal principal,
			@PathVariable("id") Integer id,
			@RequestBody Topic topic) {
		
		
		return topic;
	}
	
	
	

}

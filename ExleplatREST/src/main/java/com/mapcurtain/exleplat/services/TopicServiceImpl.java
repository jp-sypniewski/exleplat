package com.mapcurtain.exleplat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapcurtain.exleplat.repositories.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepo;

}

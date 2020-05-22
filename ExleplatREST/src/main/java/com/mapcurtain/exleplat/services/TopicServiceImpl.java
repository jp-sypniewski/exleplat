package com.mapcurtain.exleplat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapcurtain.exleplat.entities.Topic;
import com.mapcurtain.exleplat.repositories.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Override
	public List<Topic> getAllTopics(){
		List<Topic> topics = topicRepo.findAll();
		return topics;
	}
	
	@Override
	public Topic getTopicById(int id) {
		Optional<Topic> opt = topicRepo.findById(id);
		if (opt.isPresent()) {
			Topic topic = opt.get();
			return topic;
		}
		return null;
	}
	
	@Override
	public Topic createNewTopic(Topic topic) {
		
		// TODO add principal param, verify, add user/author to topic
		
		topic = topicRepo.saveAndFlush(topic);
		return topic;
	}
	
	@Override
	public Topic updateTopic(int id, Topic topic) {
		
		// TODO add principal param, confirm it matches the topic already in the database
		
		Optional<Topic> opt = topicRepo.findById(id);
		if (opt.isPresent()) {
			Topic managedTopic = opt.get();
			managedTopic.setTitle(topic.getTitle());
			managedTopic.setContent(topic.getContent());
			managedTopic = topicRepo.saveAndFlush(managedTopic);
			return managedTopic;
		}
		return null;
	}

}

package com.mapcurtain.exleplat.services;

import java.util.List;

import com.mapcurtain.exleplat.entities.Topic;

public interface TopicService {

	List<Topic> getAllTopics();

	Topic getTopicById(int id);

	Topic createNewTopic(Topic topic);

	Topic updateTopic(int id, Topic topic);

}

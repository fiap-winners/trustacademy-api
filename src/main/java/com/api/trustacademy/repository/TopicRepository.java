package com.api.trustacademy.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.trustacademy.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}

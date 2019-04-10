package com.api.trustacademy.repositories;

import org.springframework.data.repository.CrudRepository;
import com.api.trustacademy.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {}

package com.api.trustacademy.serializers;

import com.api.trustacademy.models.Course;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CourseSerializer extends JsonSerializer<Course> {

  @Override
  public void serialize(Course course, JsonGenerator jsonGen,
                        SerializerProvider serProv) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeNumberField("id", course.getId());
    jsonGen.writeStringField("name", course.getName());
    jsonGen.writeEndObject();

  }

}

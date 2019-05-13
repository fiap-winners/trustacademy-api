package com.api.trustacademy.serializers;

import com.api.trustacademy.models.Student;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class StudentSerializer extends JsonSerializer<Student> {

  @Override
  public void serialize(Student student, JsonGenerator jsonGen,
                        SerializerProvider serProv) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeNumberField("id", student.getId());
    jsonGen.writeStringField("name", student.getName());
    jsonGen.writeEndObject();

  }

}

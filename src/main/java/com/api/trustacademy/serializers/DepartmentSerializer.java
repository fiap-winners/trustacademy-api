package com.api.trustacademy.serializers;

import com.api.trustacademy.models.Department;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DepartmentSerializer extends JsonSerializer<Department> {

  @Override
  public void serialize(Department department, JsonGenerator jsonGen,
                        SerializerProvider serProv) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeNumberField("id", department.getId());
    jsonGen.writeStringField("name", department.getName());
    jsonGen.writeEndObject();

  }

}

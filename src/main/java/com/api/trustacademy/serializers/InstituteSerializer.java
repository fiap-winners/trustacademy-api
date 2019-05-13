package com.api.trustacademy.serializers;

import com.api.trustacademy.models.Institute;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class InstituteSerializer extends JsonSerializer<Institute> {

  @Override
  public void serialize(Institute institute, JsonGenerator jsonGen,
                        SerializerProvider serProv) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeNumberField("id", institute.getId());
    jsonGen.writeStringField("name", institute.getName());
    jsonGen.writeStringField("code", institute.getCode());
    jsonGen.writeEndObject();

  }

}

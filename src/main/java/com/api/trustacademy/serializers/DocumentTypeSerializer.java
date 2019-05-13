package com.api.trustacademy.serializers;

import com.api.trustacademy.models.DocumentType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DocumentTypeSerializer extends JsonSerializer<DocumentType> {

  @Override
  public void serialize(DocumentType documentType, JsonGenerator jsonGen,
                        SerializerProvider serProv) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeNumberField("id", documentType.getId());
    jsonGen.writeStringField("name", documentType.getName());
    jsonGen.writeEndObject();

  }

}

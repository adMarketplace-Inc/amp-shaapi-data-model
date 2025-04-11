package com.admarketplace.shaapi.api.model.v1;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;

class FailureTest {

  @Test
  void testSerializeFailure() throws JsonProcessingException {
    //GIVEN
    String source = getFailureAsJson();
    Failure expectedFailure = getFailureAsObject();

    //WHEN
    Failure failure = new ObjectMapper().readValue(source, Failure.class);

    //THEN
    assertEquals(expectedFailure, failure);
  }

  @Test
  void testDeserializeFailure() throws JsonProcessingException {
    //GIVEN
    Failure source = getFailureAsObject();
    String expected = getFailureAsJson();

    //WHEN
    String failure = new ObjectMapper().writeValueAsString(source);

    //THEN
    assertThatJson(failure).isEqualTo(expected);
  }

  public Failure getFailureAsObject() {
    ProductIdentifier productIdentifier = ProductIdentifier.builder()
        .id("B07PY8L6C6")
        .country("")
        .language("")
        .build();

    List<String> messages = List.of("Field language is required.", "Field country is required.");

    return new Failure(406, productIdentifier, messages);
  }

  public String getFailureAsJson() {
    return """
        {
          "status" : 406,
           "product":
           {
             "id": "B07PY8L6C6",
             "country": "",
             "language": ""
            },
            "messages": ["Field language is required.", "Field country is required."]
        }
        """;
  }
}

package com.admarketplace.shaapi.api.model.v1;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;

class ShaapiResponseTest {

  @Test
  void testSerializeFailure() throws JsonProcessingException {
    //GIVEN
    String source = getSnaapiResponseAsJson();
    ShaapiResponse expectedFailure = getShaapiResponseAsObject();

    //WHEN
    ShaapiResponse shaapiResponse = new ObjectMapper().readValue(source, ShaapiResponse.class);

    //THEN
    assertEquals(expectedFailure, shaapiResponse);
  }

  @Test
  void testDeserializeFailure() throws JsonProcessingException {
    //GIVEN
    ShaapiResponse source = getShaapiResponseAsObject();
    String expected = getSnaapiResponseAsJson();

    //WHEN
    String shaapiResponse = new ObjectMapper().writeValueAsString(source);

    //THEN
    assertThatJson(shaapiResponse).isEqualTo(expected);
  }

  public ShaapiResponse getShaapiResponseAsObject() {
    ProductIdentifier productIdentifier1 = ProductIdentifier.builder()
        .id("B07PY8L6C6")
        .country("US")
        .language("en")
        .build();

    ProductIdentifier productIdentifier2 = ProductIdentifier.builder()
        .id("A07PY8L6C7")
        .country("US")
        .language("en")
        .build();

    List<String> messages1 = List.of("Field language is required.", "Field country is required.");
    List<String> messages2 = List.of("Malformed content: unable to parse the record.");

    Failure failure1 = new Failure(406, productIdentifier1, messages1);
    Failure failure2 = new Failure(422, productIdentifier2, messages2);
    return new ShaapiResponse("Partial success: Some records failed validation.", List.of(failure1, failure2));
  }

  public String getSnaapiResponseAsJson() {
    return """
            {
              "message": "Partial success: Some records failed validation.",
              "results": [
                {
                  "status": 406,
                  "product": {
                    "id": "B07PY8L6C6",
                    "country": "US",
                    "language": "en"
                  },
                  "messages": [
                    "Field language is required.",
                    "Field country is required."
                  ]
                },
                {
                  "status": 422,
                  "product": {
                    "id": "A07PY8L6C7",
                    "country": "US",
                    "language": "en"
                  },
                  "messages": [
                    "Malformed content: unable to parse the record."
                  ]
                }
              ]
            }
        """;
  }
}

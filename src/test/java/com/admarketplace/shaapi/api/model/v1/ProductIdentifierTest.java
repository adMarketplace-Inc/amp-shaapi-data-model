package com.admarketplace.shaapi.api.model.v1;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ProductIdentifierTest {


  @Test
  void testSerializeProductIdentifier() throws JsonProcessingException {
    //GIVEN
    String source = getProductIdentifierAsJson();
    ProductIdentifier expectedproductIdentifier = getProductIdentifierAsObject();

    //WHEN
    ProductIdentifier productIdentifier = new ObjectMapper().readValue(source, ProductIdentifier.class);

    //THEN
    assertEquals(expectedproductIdentifier, productIdentifier);
  }

  @Test
  void testDeserializeProductIdentifier() throws JsonProcessingException {
    //GIVEN
    ProductIdentifier source = getProductIdentifierAsObject();
    String expected = getProductIdentifierAsJson();

    //WHEN
    String productIdentifier = new ObjectMapper().writeValueAsString(source);

    //THEN
    assertThatJson(productIdentifier).isEqualTo(expected);
  }

  public ProductIdentifier getProductIdentifierAsObject() {
    return ProductIdentifier.builder()
        .id("B07PY8L6C6")
        .country("US")
        .language("en")
        .build();
  }

  public String getProductIdentifierAsJson() {
    return """
        {
           "id": "B07PY8L6C6",
           "country": "US",
           "language": "en"
        }
        """;
  }
}

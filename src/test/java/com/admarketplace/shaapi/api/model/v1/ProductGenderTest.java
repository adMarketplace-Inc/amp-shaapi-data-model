package com.admarketplace.shaapi.api.model.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductGenderTest {

  public static Stream<Arguments> productGenderEnumsDataProvider() {
    return Stream.of(
        Arguments.arguments(ProductGender.MALE, "male"),
        Arguments.arguments(ProductGender.FEMALE, "female"),
        Arguments.arguments(ProductGender.UNISEX, "unisex"),
        Arguments.arguments(ProductGender.UNKNOWN, "unknown"),
        Arguments.arguments(ProductGender.UNKNOWN, "something")
    );
  }


  @ParameterizedTest
  @MethodSource("productGenderEnumsDataProvider")
  void testProductGenderEnums(ProductGender expectedProductGender, String sourceValue) {
    // WHEN
    ProductGender actual = ProductGender.fromValue(sourceValue);

    // THEN
    assertEquals(expectedProductGender, actual);
  }

  @Test
  void testGetValue() {
    assertEquals(ProductGender.UNISEX.getValue(), "unisex");
  }
}

package com.admarketplace.shaapi.api.model.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductAgeGroupTest {

  public static Stream<Arguments> productAgeGroupEnumsDataProvider() {
    return Stream.of(
        arguments(ProductAgeGroup.NEWBORN, "newborn"),
        arguments(ProductAgeGroup.INFANT, "infant"),
        arguments(ProductAgeGroup.TODDLER, "toddler"),
        arguments(ProductAgeGroup.KIDS, "kids"),
        arguments(ProductAgeGroup.ADULT, "adult"),
        arguments(ProductAgeGroup.UNKNOWN, "unknown"),
        arguments(ProductAgeGroup.UNKNOWN, "something")
    );
  }

  @ParameterizedTest
  @MethodSource("productAgeGroupEnumsDataProvider")
  void testProductAgeGroupEnums(ProductAgeGroup expectedProductAgeGroup, String sourceValue) {
    //WHEN
    ProductAgeGroup actual = ProductAgeGroup.fromValue(sourceValue);

    //THEN
    assertEquals(expectedProductAgeGroup, actual);
  }

  @Test
  void testGetValue() {
    assertEquals(ProductAgeGroup.KIDS.getValue(), "kids");
  }
}

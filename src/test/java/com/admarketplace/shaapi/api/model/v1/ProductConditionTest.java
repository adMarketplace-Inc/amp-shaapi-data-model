package com.admarketplace.shaapi.api.model.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductConditionTest {

  public static Stream<Arguments> productConditionEnumsDataProvider() {
    return Stream.of(
        Arguments.arguments(ProductCondition.NEW, "new"),
        Arguments.arguments(ProductCondition.REFURBISHED, "refurbished"),
        Arguments.arguments(ProductCondition.USED, "used"),
        Arguments.arguments(ProductCondition.UNKNOWN, "unknown"),
        Arguments.arguments(ProductCondition.UNKNOWN, "something")
    );
  }

  @ParameterizedTest
  @MethodSource("productConditionEnumsDataProvider")
  void testProductConditionEnums(ProductCondition expectedProductCondition, String sourceValue) {
    // WHEN
    ProductCondition actual = ProductCondition.fromValue(sourceValue);

    // THEN
    assertEquals(expectedProductCondition, actual);
  }

  @Test
  void testGetValue() {
    assertEquals(ProductCondition.REFURBISHED.getValue(), "refurbished");
  }
}

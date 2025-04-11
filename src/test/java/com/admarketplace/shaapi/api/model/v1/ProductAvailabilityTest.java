package com.admarketplace.shaapi.api.model.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductAvailabilityTest {

  public static Stream<Arguments> productAvailabilityEnumsDataProvider() {
    return Stream.of(
        Arguments.arguments(ProductAvailability.IN_STOCK, "in_stock"),
        Arguments.arguments(ProductAvailability.OUT_OF_STOCK, "out_of_stock"),
        Arguments.arguments(ProductAvailability.PREORDER, "preorder"),
        Arguments.arguments(ProductAvailability.BACKORDER, "backorder"),
        Arguments.arguments(ProductAvailability.UNKNOWN, "unknown"),
        Arguments.arguments(ProductAvailability.UNKNOWN, "something")
    );
  }

  @ParameterizedTest
  @MethodSource("productAvailabilityEnumsDataProvider")
  void testProductAvailabilityEnums(ProductAvailability expectedProductAvailability, String sourceValue) {
    // WHEN
    ProductAvailability actual = ProductAvailability.fromValue(sourceValue);

    // THEN
    assertEquals(expectedProductAvailability, actual);
  }

  @Test
  void testGetValue() {
    assertEquals(ProductAvailability.IN_STOCK.getValue(), "in_stock");
  }
}

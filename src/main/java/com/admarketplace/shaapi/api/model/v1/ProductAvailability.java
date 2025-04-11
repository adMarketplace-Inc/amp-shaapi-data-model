package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the availability status of a product.
 * Each constant corresponds to a specific availability state of a product, such as in stock, out of stock, etc.
 */
public enum ProductAvailability {

  /**
   * Represents a product that is currently in stock.
   */
  IN_STOCK("in_stock"),

  /**
   * Represents a product that is currently out of stock.
   */
  OUT_OF_STOCK("out_of_stock"),

  /**
   * Represents a product that is available for preorder.
   */
  PREORDER("preorder"),

  /**
   * Represents a product that is on backorder.
   */
  BACKORDER("backorder"),

  /**
   * Represents an unknown availability status.
   * This is the default value when a string does not match any predefined availability status.
   */
  UNKNOWN("unknown");

  private final String value;

  /**
   * Constructs a ProductAvailability enum with the given value.
   *
   * @param value The string value associated with the product availability status.
   */
  ProductAvailability(String value) {
    this.value = value;
  }

  /**
   * Gets the string value associated with the ProductAvailability.
   *
   * @return The string value of the availability status.
   */
  @JsonValue
  public String getValue() {
    return value;
  }

  /**
   * Converts a string value to its corresponding ProductAvailability enum.
   * If the string value doesn't match any defined availability status, the method returns {@link ProductAvailability#UNKNOWN}.
   *
   * @param value The string value to convert.
   * @return The corresponding ProductAvailability enum, or {@link ProductAvailability#UNKNOWN} if no match is found.
   */
  @JsonCreator
  public static ProductAvailability fromValue(String value) {
    for (ProductAvailability availability : values()) {
      if (availability.value.equalsIgnoreCase(value)) {
        return availability;
      }
    }
    return UNKNOWN;
  }
}

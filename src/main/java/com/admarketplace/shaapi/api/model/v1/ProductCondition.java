package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the condition of a product.
 * Each constant corresponds to a specific product condition, such as new, refurbished, or used.
 */
public enum ProductCondition {

  /**
   * Represents a new product in unused condition.
   */
  NEW("new"),

  /**
   * Represents a refurbished product, typically restored to a like-new condition.
   */
  REFURBISHED("refurbished"),

  /**
   * Represents a used product, which has been previously owned or used.
   */
  USED("used"),

  /**
   * Represents an unknown or undefined product condition.
   * This is the default value when a string does not match any predefined product condition.
   */
  UNKNOWN("unknown");

  private final String value;

  /**
   * Constructs a ProductCondition enum with the given value.
   *
   * @param value The string value associated with the product condition.
   */
  ProductCondition(String value) {
    this.value = value;
  }

  /**
   * Gets the string value associated with the ProductCondition.
   *
   * @return The string value of the product condition.
   */
  @JsonValue
  public String getValue() {
    return value;
  }

  /**
   * Converts a string value to its corresponding ProductCondition enum.
   * If the string value doesn't match any predefined product condition, the method returns {@link ProductCondition#UNKNOWN}.
   *
   * @param value The string value to convert.
   * @return The corresponding ProductCondition enum, or {@link ProductCondition#UNKNOWN} if no match is found.
   */
  @JsonCreator
  public static ProductCondition fromValue(String value) {
    for (ProductCondition condition : values()) {
      if (condition.value.equalsIgnoreCase(value)) {
        return condition;
      }
    }
    return UNKNOWN;
  }
}

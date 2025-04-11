package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the gender specification of a product.
 * Each constant corresponds to a specific gender category, such as male, female, or unisex.
 */
public enum ProductGender {

  /**
   * Represents products intended for males.
   */
  MALE("male"),

  /**
   * Represents products intended for females.
   */
  FEMALE("female"),

  /**
   * Represents products intended for both males and females (unisex).
   */
  UNISEX("unisex"),

  /**
   * Represents an unknown or undefined gender category.
   * This is the default value when a string does not match any predefined gender.
   */
  UNKNOWN("unknown");

  private final String value;

  /**
   * Constructs a ProductGender enum with the given value.
   *
   * @param value The string value associated with the product gender.
   */
  ProductGender(String value) {
    this.value = value;
  }

  /**
   * Gets the string value associated with the ProductGender.
   *
   * @return The string value of the gender category.
   */
  @JsonValue
  public String getValue() {
    return value;
  }

  /**
   * Converts a string value to its corresponding ProductGender enum.
   * If the string value doesn't match any predefined gender category, the method returns {@link ProductGender#UNKNOWN}.
   *
   * @param value The string value to convert.
   * @return The corresponding ProductGender enum, or {@link ProductGender#UNKNOWN} if no match is found.
   */
  @JsonCreator
  public static ProductGender fromValue(String value) {
    for (ProductGender gender : values()) {
      if (gender.value.equalsIgnoreCase(value)) {
        return gender;
      }
    }
    return UNKNOWN;
  }
}

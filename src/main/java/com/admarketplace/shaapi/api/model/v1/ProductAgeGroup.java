package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing different product age groups.
 * Each age group corresponds to a specific category of product, such as newborn, infant, etc.
 */
public enum ProductAgeGroup {
  /**
   * Represents products intended for newborns.
   */
  NEWBORN("newborn"),

  /**
   * Represents products intended for infants.
   */
  INFANT("infant"),

  /**
   * Represents products intended for toddlers.
   */
  TODDLER("toddler"),

  /**
   * Represents products intended for kids.
   */
  KIDS("kids"),

  /**
   * Represents products intended for adults.
   */
  ADULT("adult"),

  /**
   * Represents an unknown or undefined age group.
   * This is the default value when a string does not match any predefined age group.
   */
  UNKNOWN("unknown");

  private final String value;

  /**
   * Constructs a ProductAgeGroup enum with the given value.
   *
   * @param value The string value associated with the product age group.
   */
  ProductAgeGroup(String value) {
    this.value = value;
  }

  /**
   * Gets the string value associated with the ProductAgeGroup.
   *
   * @return The string value of the age group.
   */
  @JsonValue
  public String getValue() {
    return value;
  }


  /**
   * Converts a string value to its corresponding ProductAgeGroup enum.
   * If the string value doesn't match any defined age group, the method returns {@link ProductAgeGroup#UNKNOWN}.
   *
   * @param value The string value to convert.
   * @return The corresponding ProductAgeGroup enum, or {@link ProductAgeGroup#UNKNOWN} if no match is found.
   */
  @JsonCreator
  public static ProductAgeGroup fromValue(String value) {
    for (ProductAgeGroup ageGroup : values()) {
      if (ageGroup.value.equalsIgnoreCase(value)) {
        return ageGroup;
      }
    }
    return UNKNOWN;
  }
}

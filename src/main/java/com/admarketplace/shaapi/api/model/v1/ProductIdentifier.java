package com.admarketplace.shaapi.api.model.v1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Represents a product identifier, including details such as the product ID, country, and language.
 * This class serves as a way to uniquely identify a product across different regions and languages.
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ProductIdentifier {

  /**
   * The unique identifier for the product.
   * This can be an alphanumeric code or any other form of unique ID for the product.
   */
  protected String id;

  /**
   * The country where the product is associated or available.
   * Acceptable format is <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> (e.g., "US" for the United States).
   */
  protected String country;

  /**
   * The language in which the product information is provided or localized.
   * Acceptable format is <a href="https://en.wikipedia.org/wiki/List_of_ISO_639_language_codes">ISO 639-1</a> (e.g., "en" for English,
   * "fr" for French).
   */
  protected String language;
}

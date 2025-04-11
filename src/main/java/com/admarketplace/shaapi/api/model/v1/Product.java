package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

/**
 * Represents a product with various attributes such as title, description, pricing, and availability.
 * This class extends {@link ProductIdentifier} to include detailed information about the product.
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends ProductIdentifier {

  /**
   * The top-level domain (TLD) of the product's associated website.
   */
  private String tld;

  /**
   * The parent ID that identifies the product's parent or related product.
   */
  @JsonProperty("parent_id")
  private String parentId;

  /**
   * The title of the product.
   */
  private String title;

  /**
   * A description of the product, providing additional details.
   */
  private String description;

  /**
   * A URL linking to the product page.
   */
  private String link;

  /**
   * A mobile-optimized link to the product page.
   */
  @JsonProperty("mobile_link")
  private String mobileLink;

  /**
   * A URL linking to an image of the product.
   */
  @JsonProperty("image_link")
  private String imageLink;

  /**
   * The brand of the product.
   */
  private String brand;

  /**
   * The Global Trade Item Number (GTIN) associated with the product.
   */
  private String gtin;

  /**
   * The Manufacturer Part Number (MPN) of the product.
   */
  private String mpn;

  /**
   * The Google product category associated with the product.
   */
  @JsonProperty("google_product_category")
  private String googleProductCategory;

  /**
   * The type of product, as defined by the seller or category.
   */
  @JsonProperty("product_type")
  private String productType;

  /**
   * The availability status of the product (e.g., in stock, out of stock).
   */
  private ProductAvailability availability;

  /**
   * The date when the product will be available or became available.
   * Acceptable date format is <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
   */
  @JsonProperty("availability_date")
  private String availabilityDate;

  /**
   * The price of the product.
   */
  private BigDecimal price;

  /**
   * The sale price of the product, if available.
   */
  @JsonProperty("sale_price")
  private BigDecimal salePrice;

  /**
   * The member price of the product, if available.
   */
  @JsonProperty("member_price")
  private BigDecimal memberPrice;

  /**
   * The cost of shipping for the product.
   */
  private BigDecimal shipping;

  /**
   * The currency in which the product's price is specified (e.g., USD, EUR).
   * Acceptable currency format is <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a>
   */
  private String currency;

  /**
   * The condition of the product (e.g., new, used, refurbished).
   */
  private ProductCondition condition;

  /**
   * The gender for which the product is intended (e.g., male, female, unisex).
   */
  private ProductGender gender;

  /**
   * The age group for which the product is intended (e.g., newborn, infant, toddler).
   */
  @JsonProperty("age_group")
  private ProductAgeGroup ageGroup;

  /**
   * The color of the product.
   */
  private String color;
  /**
   * The size of the product.
   */
  private String size;
}

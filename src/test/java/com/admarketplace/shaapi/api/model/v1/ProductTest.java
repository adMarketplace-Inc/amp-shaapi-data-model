package com.admarketplace.shaapi.api.model.v1;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;


class ProductTest {

  @Test
  void testSerializeProduct() throws JsonProcessingException {
    //GIVEN
    Product expectedProduct = getProductAsObject();
    String source = getProductAsJson();

    //WHEN
    Product product = new ObjectMapper().readValue(source, Product.class);

    //THEN
    assertEquals(expectedProduct, product);
  }

  @Test
  void testDeserializeProduct() throws JsonProcessingException {
    //GIVEN
    Product source = getProductAsObject();
    String expectedProduct = getProductAsJson();

    //WHEN
    String product = new ObjectMapper().writeValueAsString(source);

    //THEN
    assertThatJson(product).isEqualTo(expectedProduct);
  }

  private Product getProductAsObject() {
    return Product.builder()
        .id("B07PY8L6C6")
        .tld(".com")
        .country("US")
        .language("en")
        .parentId("B07PY8L6C7")
        .title("La Vane 7 inch Metal Furniture Legs, ...")
        .description("La Vane 7 inch Metal Furniture Legs, ...")
        .link("https://www.amazon.com/Furniture-Vane-Triangle-Replacement…")
        .mobileLink("https://m.amazon.com/Furniture-Vane-Triangle-Replace…")
        .imageLink("https://m.media-amazon.com/images/I/61903KsEvjL.jpg")
        .brand("La Vane")
        .gtin("8789221335000")
        .mpn("L:1207022-02-175/b74")
        .googleProductCategory("Home > Furniture")
        .productType("Outdoor Power Tools > Replacement Parts & Accessories…")
        .availability(ProductAvailability.IN_STOCK)
        .availabilityDate("2025-02-21")
        .price(new BigDecimal("21.99"))
        .salePrice(new BigDecimal("19.99"))
        .memberPrice(new BigDecimal("18.99"))
        .shipping(new BigDecimal("5.99"))
        .currency("USD")
        .condition(ProductCondition.NEW)
        .gender(ProductGender.UNISEX)
        .ageGroup(ProductAgeGroup.ADULT)
        .color("red")
        .size("28.34 in x 33.46 in x 26 in")
        .build();
  }

  private String getProductAsJson() {
    return """
         {
            "id":"B07PY8L6C6",
            "tld":".com",
            "country":"US",
            "language":"en",
            "parent_id":"B07PY8L6C7",
            "title": "La Vane 7 inch Metal Furniture Legs, ...",
            "description": "La Vane 7 inch Metal Furniture Legs, ...",
            "link": "https://www.amazon.com/Furniture-Vane-Triangle-Replacement…",
            "mobile_link": "https://m.amazon.com/Furniture-Vane-Triangle-Replace…",
            "image_link": "https://m.media-amazon.com/images/I/61903KsEvjL.jpg",
            "brand": "La Vane",
            "gtin": "8789221335000",
            "mpn": "L:1207022-02-175/b74",
            "google_product_category": "Home > Furniture",
            "product_type": "Outdoor Power Tools > Replacement Parts & Accessories…",
            "availability": "in_stock",
            "availability_date": "2025-02-21",
            "price": 21.99,
            "sale_price": 19.99,
            "member_price": 18.99,
            "shipping": 5.99,
            "currency": "USD",
            "condition": "new",
            "gender": "unisex",
            "age_group": "adult",
            "color": "red",
            "size": "28.34 in x 33.46 in x 26 in"
           }
        """;
  }
}

package com.admarketplace.shaapi.api.model.v1;

import java.util.List;

/**
 * Represents a failure response that includes a status code, a product identifier, and a list of error messages.
 *
 * @param status   The HTTP status code indicating the failure type.
 * @param product  The product identifier associated with the failure.
 * @param messages A list of error messages providing more details about the failure.
 */
public record Failure(
    int status,
    ProductIdentifier product,
    List<String> messages
) {
}

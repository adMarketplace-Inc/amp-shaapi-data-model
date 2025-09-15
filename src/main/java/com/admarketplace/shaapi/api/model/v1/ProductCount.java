package com.admarketplace.shaapi.api.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a count summary of products associated with an account.
 * <p>
 * This record returns counts for products in active state
 * for a given account identifier.
 * </p>
 *
 * <p>Example JSON structure:</p>
 * <pre>
 * {
 *   "account_id": "12345",
 *   "available_count": 120,
 * }
 * </pre>
 *
 * @param accountId       The unique identifier of the account.
 * @param availableCount  The number of active products for the account.
 */
public record ProductCount(
    @JsonProperty("account_id")
    String accountId,
    @JsonProperty("available_count")
    Long availableCount
) {
}

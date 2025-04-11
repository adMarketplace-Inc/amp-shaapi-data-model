package com.admarketplace.shaapi.api.model.v1;

import java.util.List;

/**
 * Represents a response from the SHA API.
 * Contains a message and a list of failure details, which provide additional information about the response.
 *
 * @param message A  message that provides information about the response.
 * @param results A list of {@link Failure} objects that provide detailed information about any failures or issues.
 */
public record ShaapiResponse(
    String message,
    List<Failure> results
) {
}

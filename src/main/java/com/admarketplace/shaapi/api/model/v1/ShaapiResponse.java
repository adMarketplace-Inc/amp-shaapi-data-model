package com.admarketplace.shaapi.api.model.v1;

/**
 * Generic wrapper returned by all SHAAPI endpoints.
 *
 * @param message human-readable description supplied by backend
 * @param results payload specific to the invoked endpoint
 * @param <T>     type of the {@code results} payload
 */
public record ShaapiResponse<T>(String message, T results) {}

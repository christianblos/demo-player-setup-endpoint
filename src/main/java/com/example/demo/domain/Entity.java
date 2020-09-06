package com.example.demo.domain;

/**
 * This is a marker interface that is used on all entities.
 * <p>
 * In real project it could be used to scan for all entity classes
 * in order to add them to the whitelist.
 * <p>
 * In this demo project it's just used in the PlayerSetupController
 * to add a Jackson MixIn to all entities so only IDs are returned
 * by the endpoint.
 */
public interface Entity {

}

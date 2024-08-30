package com.umesh.test_store_selenium_testng.tests.model;

/**
 * Represents user credentials consisting of an email and a password.
 * This immutable record is used to encapsulate user login information
 * in a clean and concise manner.
 * 
 * @author Umesh Deshmukh
 */
public record Credentials(String email, String password) {
}

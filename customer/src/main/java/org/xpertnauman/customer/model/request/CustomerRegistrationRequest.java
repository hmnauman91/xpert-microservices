package org.xpertnauman.customer.model.request;

/**
 * Created on nauman.
 * Created on 08/10/2023.
 */


public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email)
{
}

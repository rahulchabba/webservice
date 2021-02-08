/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

package com.spring.java8.demo;

import javax.ws.rs.*;

@Path("/employee")
public class Employee {
    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello, World!";
    }
}
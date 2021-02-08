/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

package com.spring.java8.demo.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
    Integer id;
    float temperature;
    String cityName;

}

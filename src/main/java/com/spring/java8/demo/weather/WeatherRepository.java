/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

package com.spring.java8.demo.weather;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class WeatherRepository {

    Map mSave = new HashMap<Integer,Weather>();

    public Weather save(Weather weather) {
        System.out.println("DATA SAVED");
        Integer id = new Random().nextInt(100);
       return (Weather) mSave.putIfAbsent(weather.getId(), weather);
    }

    public Optional<Object> findById(Integer id) {
        return  Optional.of(mSave.get(id));
    }

    public Object deleteById(Integer id) {
        System.out.println(mSave.remove(id));
        return true;
    }

    public List<Weather> findAll() {
        return (List<Weather>) mSave.keySet().stream().map((keys)->{
            System.out.println(keys);
        return mSave.get(keys); }).collect(Collectors.toList());
    }
}

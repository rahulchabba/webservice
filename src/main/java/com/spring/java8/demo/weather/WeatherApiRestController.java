/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

package com.spring.java8.demo.weather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class WeatherApiRestController {


@Autowired
WeatherRepository weatherRepository;

@RequestMapping(value ="/weather", method = RequestMethod.POST )
 public ResponseEntity save(@RequestBody  Weather weather) {
	Weather id= weatherRepository.save(weather);
	return ResponseEntity.status(201).body(id);
 }

 @RequestMapping(value="/weather/{id}",method = RequestMethod.GET , produces = { "application/json" })
 public ResponseEntity getWeatherForecast(@PathVariable Integer id) {
   Optional<Object> data= weatherRepository.findById(id);
   if(data.isPresent()){
       System.out.println(data.get());
   return 	ResponseEntity.ok().body(data.get());
   }else{
     return 	ResponseEntity.status(404).body(null);
   }
  }

  @RequestMapping(value="/weather",method = RequestMethod.GET , produces = { "application/json" })
 public ResponseEntity getWeatherForecastAll() {

   List<Weather> data= weatherRepository.findAll();

    Collections.sort(data, new Comparator<Weather>(){
     public int compare(Weather w, Weather w1){
         return w.getId().compareTo(w1.getId());
     }
   });

   return 	ResponseEntity.ok().body(data);
  }


  @RequestMapping(value="/weather/{id}",method = RequestMethod.DELETE )
 public ResponseEntity deleteWeather(@PathVariable Integer id) {
    Optional<Object> data= weatherRepository.findById(id);
   if(data.isPresent()){
    weatherRepository.deleteById(id);
    return 	ResponseEntity.status(204).body(null);
   }else{
     return 	ResponseEntity.status(404).body(null);
   }

   }

}

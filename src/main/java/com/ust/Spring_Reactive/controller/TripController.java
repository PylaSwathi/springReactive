package com.ust.Spring_Reactive.controller;


import com.ust.Spring_Reactive.dto.Tripdto;
import com.ust.Spring_Reactive.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/addtrip")
    public Mono<Tripdto> addtrip(@RequestBody Mono<Tripdto> trip){
        return tripService.addTrip(trip);
    }

    @GetMapping("/gettrips")
    public Flux<Tripdto> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/gettrip/{id}")
    public Mono<Tripdto> getTripById(@PathVariable String id){
        return tripService.getTripById(id);

    }

    @PutMapping("/updatetrip/{id}")
    public Mono<Tripdto> updateTrip(@PathVariable String id, @RequestBody Mono<Tripdto> trip){
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/deletetrip/{id}")
    public Mono<Void> deleteTrip(@PathVariable String id){
        return tripService.deleteTrip(id);
    }

    @GetMapping("/gettrip/budget/{min}/{max}")
    public Flux<Tripdto> getTripsByBudget(@PathVariable int min,@PathVariable int max){
        return tripService.findByBudget(min,max);
    }

    @GetMapping("/gettripbystatus/{status}")
    public Flux<Tripdto> getTripsByStatus(@PathVariable String status){
        return tripService.findByStatus(status);
    }

    @GetMapping("/gettripbyrating/{rating}")
    public Flux<Tripdto> getTripsByRating(@PathVariable int rating){
        return tripService.findByRating(rating);
    }

}

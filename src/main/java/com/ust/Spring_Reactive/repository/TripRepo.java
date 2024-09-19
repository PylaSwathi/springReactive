package com.ust.Spring_Reactive.repository;

import com.ust.Spring_Reactive.dto.Tripdto;
import com.ust.Spring_Reactive.entity.Trip;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TripRepo extends ReactiveMongoRepository<Trip,String> {
    Flux<Tripdto> findAllByPriceBetween(int min, int max);

    Flux<Trip> findAllByStatus(String status);

    Flux<Trip> findAllByRating(int rating);
}

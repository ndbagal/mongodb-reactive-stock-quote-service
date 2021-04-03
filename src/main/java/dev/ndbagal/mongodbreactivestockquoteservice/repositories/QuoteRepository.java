package dev.ndbagal.mongodbreactivestockquoteservice.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.ndbagal.mongodbreactivestockquoteservice.domain.Quote;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

}

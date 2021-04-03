package dev.ndbagal.mongodbreactivestockquoteservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.ndbagal.mongodbreactivestockquoteservice.client.StockQuoteClient;
import dev.ndbagal.mongodbreactivestockquoteservice.domain.Quote;
import reactor.core.publisher.Flux;

//@Component
public class QuoteRunner implements CommandLineRunner {

  private final StockQuoteClient stockQuoteClient;

  @Override
  public void run(String... args) throws Exception {
    Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();

    quoteFlux.subscribe(System.out::println);
  }

  public QuoteRunner(StockQuoteClient stockQuoteClient) {
    this.stockQuoteClient = stockQuoteClient;
  }

}

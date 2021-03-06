package dev.ndbagal.mongodbreactivestockquoteservice.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import dev.ndbagal.mongodbreactivestockquoteservice.domain.Quote;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Setter
@Component
@ConfigurationProperties("dev")
public class StockQuoteClient {

  private String host;
  private String port;
  private String path;

  public Flux<Quote> getQuoteStream() {
    String url = new StringBuilder("http://").append(host).append(":").append(port).toString();

    log.debug("URL is: {}", url);

    return WebClient.builder().baseUrl(url).build().get().uri(path).accept(MediaType.APPLICATION_NDJSON).retrieve()
        .bodyToFlux(Quote.class);
  }
}

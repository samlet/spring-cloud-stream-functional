package com.cloud.stream.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Configuration
@Slf4j
@Controller
public class WebFn {
    @Bean
    public Function<Flux<String>, Flux<String>> lowercase2() {
        return flux -> flux.map(value -> value.toLowerCase());
    }

    /*
    POST: http://localhost:9001/lowercase2|wrapInQuotes
        Plain: Any string
    GET: http://localhost:9001/words|lowercase2|wrapInQuotes
        NO BODY
     */
    @Bean
    public Function<String, String> wrapInQuotes() {
        return s -> "\"" + s + "\"";
    }

    @Autowired
    private StreamBridge streamBridge;

    /*
    $ curl -H "Content-Type: text/plain" -X POST -d "hello from the other side" http://localhost:9001
    $ kafka-console-consumer --bootstrap-server localhost:9092 --topic toStream-out-0 --from-beginning
     */
    @RequestMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delegateToSupplier(@RequestBody String body) {
        System.out.println("Sending " + body);
        streamBridge.send("toStream-out-0", body);
    }

    @Bean
    public Function<String, List<Message<String>>> batch() {
        return p -> {
            // 列表中的每条消息将单独发送，从而导致将四条消息发送到输出目标
            List<Message<String>> list = new ArrayList<>();
            list.add(MessageBuilder.withPayload(p + ":1").build());
            list.add(MessageBuilder.withPayload(p + ":2").build());
            list.add(MessageBuilder.withPayload(p + ":3").build());
            list.add(MessageBuilder.withPayload(p + ":4").build());
            return list;
        };
    }

    @Bean
    public Function<Flux<String>, Flux<String>> uppercase() {
        return flux -> flux
                .retryWhen(Retry.backoff(3, Duration.ofMillis(1000)))
                .map(v -> v.toUpperCase());
    }


}

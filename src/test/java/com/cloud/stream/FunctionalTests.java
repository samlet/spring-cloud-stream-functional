package com.cloud.stream;

import com.cloud.stream.kafka.KafkaConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
public class FunctionalTests {

    @Autowired
    private FunctionCatalog catalog;

    @Test
    public void words() throws Exception {
        Function<String, String> function = catalog.lookup(Function.class,
                "toUpperCase");
        assertThat(function.apply("hello")).isEqualTo("HELLO");
    }

    final KafkaConfiguration functions=new KafkaConfiguration();

    @Test
    public void directTest(){
        String output = functions.toUpperCase().apply("foobar");
        assertThat(output).isEqualTo("FOOBAR");
    }

    @Test
    public void testLowercase() {
        Flux<String> output = this.functions.lowercase().apply(Flux.just("FOO", "BAR"));
        List<String> results = output.collectList().block();
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0)).isEqualTo("foo");
        assertThat(results.get(1)).isEqualTo("bar");
    }

    @Test
    public void testHello() {
        String output = this.functions.hello().get();
        assertThat(output).isEqualTo("hello");
    }

    @Test
    public void testWords() {
        Flux<String> output = this.functions.words().get();
        List<String> results = output.collectList().block();
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0)).isEqualTo("foo");
        assertThat(results.get(1)).isEqualTo("bar");
    }
}

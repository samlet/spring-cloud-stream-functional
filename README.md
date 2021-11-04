## Spring Cloud Stream Using Functional Programming

### The technolgies used
- Docker.
- Spring boot 2.5.4 (Stable version at the time of this tuitorial).
- Java 8. (原例是java-11)
- Apache Kafka and zookeeper (Embedded from docker).

### To start zookeeper and kafka using docker
Go to root directory of project
``` shell
$ docker-compose up -d
```

Start main class as spring boot application, the application will be successful.
Here is the console looks like as the producer will run for every 5 seconds will generate a random number and publishes to final topic that is intended for consumption.

``` log
/Library/Java/JavaVirtualMachines/jdk-11.0.9.jdk/Contents/Home/bin/java -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.......jar:/Users/ereshgorantla/Documents/Dev/gradle-6.5.1/caches/modules-2/files-2.1/com.google.code.findbugs/jsr305/3.0.2/25ea2e8b0c338a877313bd4672d3fe056ea78f0d/jsr305-3.0.2.jar com.cloud.stream.SpringCloudStreamFunctionalProgrammingApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.4)

2021-08-26 12:40:26.830  INFO 2917 --- [           main] udStreamFunctionalProgrammingApplication : Starting SpringCloudStreamFunctionalProgrammingApplication using Java 11.0.9 on Ereshs-MacBook-Pro.local with PID 2917 (/Users/ereshgorantla/Documents/Dev/My Work/medium/spring-cloud/spring-cloud-stream-examples/spring-cloud-stream-functional-programming/build/classes/java/main started by ereshgorantla in /Users/ereshgorantla/Documents/Dev/My Work/medium/spring-cloud/spring-cloud-stream-examples)
2021-08-26 12:40:26.832  INFO 2917 --- [           main] udStreamFunctionalProgrammingApplication : No active profile set, falling back to default profiles: default
2021-08-26 12:40:27.362  INFO 2917 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'errorChannel' has been explicitly defined. Therefore, a default PublishSubscribeChannel will be created.
2021-08-26 12:40:27.372  INFO 2917 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'integrationHeaderChannelRegistry' has been explicitly defined. Therefore, a default DefaultHeaderChannelRegistry will be created.
2021-08-26 12:40:27.420  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.integration.config.IntegrationManagementConfiguration' of type [org.springframework.integration.config.IntegrationManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.426  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationJmxConfiguration' of type [org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationJmxConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.433  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration' of type [org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.436  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mbeanServer' of type [com.sun.jmx.mbeanserver.JmxMBeanServer] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.447  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'integrationChannelResolver' of type [org.springframework.integration.support.channel.BeanFactoryChannelResolver] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.448  INFO 2917 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'integrationDisposableAutoCreatedBeans' of type [org.springframework.integration.config.annotation.Disposables] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2021-08-26 12:40:27.651  INFO 2917 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 9001 (http)
2021-08-26 12:40:27.658  INFO 2917 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-08-26 12:40:27.659  INFO 2917 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.52]
2021-08-26 12:40:27.725  INFO 2917 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-08-26 12:40:27.725  INFO 2917 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 866 ms
2021-08-26 12:40:28.188  INFO 2917 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Creating binder: kafka
2021-08-26 12:40:28.277  INFO 2917 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Caching the binder: kafka
2021-08-26 12:40:28.277  INFO 2917 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Retrieving cached binder: kafka
2021-08-26 12:40:28.304  INFO 2917 --- [           main] o.s.c.s.m.DirectWithAttributesChannel    : Channel 'application.fizzBuzzProcessor-in-0' has 1 subscriber(s).
2021-08-26 12:40:28.305  INFO 2917 --- [           main] reactor.Flux.Map.1                       : onSubscribe(FluxMap.MapSubscriber)
2021-08-26 12:40:28.306  INFO 2917 --- [           main] reactor.Flux.Map.1                       : request(unbounded)
2021-08-26 12:40:28.311  INFO 2917 --- [           main] o.s.c.s.m.DirectWithAttributesChannel    : Channel 'application.fizzBuzzConsumer-in-0' has 1 subscriber(s).
2021-08-26 12:40:28.474  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel errorChannel
2021-08-26 12:40:28.527  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel fizzBuzzProducer_integrationflow.channel#0
2021-08-26 12:40:28.539  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel fizzBuzzProcessor-out-0
2021-08-26 12:40:28.558  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel fizzBuzzProcessor-in-0
2021-08-26 12:40:28.562  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel nullChannel
2021-08-26 12:40:28.567  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel fizzBuzzProducer-out-0
2021-08-26 12:40:28.571  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageChannel fizzBuzzConsumer-in-0
2021-08-26 12:40:28.577  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageHandler fizzBuzzProducer_integrationflow.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
2021-08-26 12:40:28.615  INFO 2917 --- [           main] o.s.i.monitor.IntegrationMBeanExporter   : Registering MessageHandler _org.springframework.integration.errorLogger
2021-08-26 12:40:28.627  INFO 2917 --- [           main] o.s.i.endpoint.EventDrivenConsumer       : Adding {logging-channel-adapter:_org.springframework.integration.errorLogger} as a subscriber to the 'errorChannel' channel
2021-08-26 12:40:28.627  INFO 2917 --- [           main] o.s.i.channel.PublishSubscribeChannel    : Channel 'application.errorChannel' has 1 subscriber(s).
2021-08-26 12:40:28.628  INFO 2917 --- [           main] o.s.i.endpoint.EventDrivenConsumer       : started bean '_org.springframework.integration.errorLogger'
2021-08-26 12:40:28.644  INFO 2917 --- [           main] o.s.i.endpoint.ReactiveStreamsConsumer   : started bean 'fizzBuzzProducer_integrationflow.org.springframework.integration.config.ConsumerEndpointFactoryBean#0'
2021-08-26 12:40:28.645  INFO 2917 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Retrieving cached binder: kafka
2021-08-26 12:40:28.709  INFO 2917 --- [           main] o.s.c.s.b.k.p.KafkaTopicProvisioner      : Using kafka topic for outbound: numbers
2021-08-26 12:40:28.712  INFO 2917 --- [           main] o.a.k.clients.admin.AdminClientConfig    : AdminClientConfig values: 
	bootstrap.servers = [localhost:9092]
	 --- [           main] org.apache.kafka.common.metrics.Metrics  : Closing reporter org.apache.kafka.common.metrics.JmxReporter
2021-08-26 12:40:29.186  INFO 2917 --- [           main] org.apache.kafka.common.metrics.Metrics  : Metrics reporters closed
2021-08-26 12:40:29.187  INFO 2917 --- [           main] o.a.kafka.common.utils.AppInfoParser     : App info kafka.consumer for consumer-anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0-1 unregistered
2021-08-26 12:40:29.215  INFO 2917 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'numbers.anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0.errors' has 1 subscriber(s).
2021-08-26 12:40:29.215  INFO 2917 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'numbers.anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0.errors' has 0 subscriber(s).
2021-08-26 12:40:29.215  INFO 2917 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'numbers.anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0.errors' has 1 subscriber(s).
2021-08-26 12:40:29.215  INFO 2917 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'numbers.anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0.errors' has 2 subscriber(s).
2021-08-26 12:40:29.229  INFO 2917 --- [           main] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values: 
	allow.auto.create.topics = true
	auto.commit.interval.ms = 100
	org.apache.kafka.common.serialization.ByteArrayDeserializer

2021-08-26 12:40:29.389  INFO 2917 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0-2, groupId=anonymous.ac088754-30d4-45e9-87c3-071bc7a661d0] (Re-)joining group
2021-08-26 12:40:29.390  INFO 2917 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.7.1
2021-08-26 12:40:29.390  INFO 2917 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 61dbce85d0d41457
2021-08-26 12:40:29.390  INFO 2917 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1629961829390
2021-08-26 12:40:29.390  INFO 2917 --- [           main] o.a.k.clients.consumer.KafkaConsumer     : [Consumer clientId=consumer-anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847-4, groupId=anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847] Subscribed to topic(s): fizz-buzz

.........

2021-08-26 12:40:32.422  INFO 2917 --- [container-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847-4, groupId=anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847] Finished assignment for group at generation 1: {consumer-anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847-4-70428fe6-70b3-41d9-8280-b8105e0ce762=Assignment(partitions=[fizz-buzz-0])}
2021-08-26 12:40:32.480  INFO 2917 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847-4, groupId=anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847] Successfully synced group in generation Generation{generationId=1, memberId='consumer-anonymous.4673ffb3-55d5-49fe-8cbb-9b8934ba3847-4-70428fe6-70b3-41d9-8280-b8105e0ce762', protocol='range'}

....

2021-08-26 12:40:34.165  INFO 2917 --- [container-0-C-1] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 61dbce85d0d41457
2021-08-26 12:40:34.165  INFO 2917 --- [container-0-C-1] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1629961834165
2021-08-26 12:40:34.171  INFO 2917 --- [ad | producer-4] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-4] Cluster ID: jGpZSsM1QYyHKuc0Eu2XLA
2021-08-26 12:40:34.181  INFO 2917 --- [container-0-C-1] c.cloud.stream.kafka.KafkaConfiguration  : Consumer Received : Fizz
2021-08-26 12:40:39.060  INFO 2917 --- [     parallel-1] reactor.Flux.Map.2                       : onNext(7061)
2021-08-26 12:40:39.070  INFO 2917 --- [container-0-C-1] reactor.Flux.Map.1                       : onNext(7061)
2021-08-26 12:40:39.079  INFO 2917 --- [container-0-C-1] c.cloud.stream.kafka.KafkaConfiguration  : Consumer Received : 7061
2021-08-26 12:40:44.054  INFO 2917 --- [     parallel-1] reactor.Flux.Map.2                       : onNext(1952)
2021-08-26 12:40:44.061  INFO 2917 --- [container-0-C-1] reactor.Flux.Map.1                       : onNext(1952)
2021-08-26 12:40:44.067  INFO 2917 --- [container-0-C-1] c.cloud.stream.kafka.KafkaConfiguration  : Consumer Received : 1952
2021-08-26 12:40:49.053  INFO 2917 --- [     parallel-1] reactor.Flux.Map.2                       : onNext(4424)
2021-08-26 12:40:49.061  INFO 2917 --- [container-0-C-1] reactor.Flux.Map.1                       : onNext(4424)
2021-08-26 12:40:49.067  INFO 2917 --- [container-0-C-1] c.cloud.stream.kafka.KafkaConfiguration  : Consumer Received : 4424
-------------

```
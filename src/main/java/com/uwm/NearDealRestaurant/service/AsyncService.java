package com.uwm.NearDealRestaurant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async("customExecutor")
    public void executeAsyncTask() {
        logger.info("Stating task in thread :- " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        logger.info("task completed");

    }

    // practice completable future

    public void test(){
         CompletableFuture.runAsync(()->{
            System.out.println("Asynchronous task started "+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            logger.info("task completed"+Thread.currentThread().getName());
        }).join();
    }

    public CompletableFuture<String> processPayment(String productId){
            return CompletableFuture.supplyAsync(()->{
                System.out.println("In process payment " +productId+" - "+Thread.currentThread().getName());
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "payment success";

            });
    }


    // Step 2: Inventory Service
    private static CompletableFuture<String> checkInventory(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Checking inventory for Product: " + productId);
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }            return "Product Available";
        });
    }

    // Step 3: Shipping Service
    private static CompletableFuture<String> generateShippingLabel(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Generating Shipping Label for Order: " + orderId);
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }            return "Shipping Label Generated";
        });
    }



    //learn mono and flux
    public void testingMonoAndFLux(){
        Mono<String> mono = Mono.just("hello");
        mono.subscribe(System.out::println);
    }

}

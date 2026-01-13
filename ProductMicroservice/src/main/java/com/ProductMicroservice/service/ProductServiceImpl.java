package com.ProductMicroservice.service;

import com.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import com.ProductMicroservice.rest.CreateProductRestModel;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService{

    KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @Override
 /*   public String createProduct(CreateProductRestModel productRestModel) {
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId,
                productRestModel.getTitle(),
                productRestModel.getPrice(),productRestModel.getQuantity());

       CompletableFuture<SendResult<String,ProductCreatedEvent>> future =
               kafkaTemplate.send("product-created-events-topic",productId,productCreatedEvent);
       future.whenComplete((result,exception)->{
        if(exception!=null){
            LOGGER.error("****** Failed to send message: {}", exception.getMessage());
        }else{
            LOGGER.info("******* Message sent Successfully: {}", result.getRecordMetadata());
        }
       });
       LOGGER.info("****** Returning product id");
        return productId;
    }*/


    //synchronous
    public String createProduct(CreateProductRestModel productRestModel) throws Exception{
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId,
                productRestModel.getTitle(),
                productRestModel.getPrice(),productRestModel.getQuantity());

        LOGGER.info("Before publishing a product created event");
       SendResult<String,ProductCreatedEvent> result =
                kafkaTemplate.send("product-created-events-topic",productId,productCreatedEvent).get();

       LOGGER.info("Partition: "+result.getRecordMetadata().partition());
       LOGGER.info("Topic: "+result.getRecordMetadata().topic());
       LOGGER.info("Offsets: "+result.getRecordMetadata().offset());

        LOGGER.info("****** Returning product id");
        return productId;
    }

}

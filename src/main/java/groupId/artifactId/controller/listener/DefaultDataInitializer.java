package groupId.artifactId.controller.listener;

import groupId.artifactId.core.dto.ProductCreationDtoBuilder;
import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class DefaultDataInitializer implements ServletContextListener {

    IProductService productService = ProductService.getInstance();
        
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            productService.add(ProductCreationDtoBuilder.create().setName("PC").setPrice(1500).setDiscount(200).
                    setDescription("New and fashionable").build());
            productService.add(ProductCreationDtoBuilder.create().setName("Laptop").setPrice(1200).setDiscount(100).
                    setDescription("light weight").build());
            productService.add(ProductCreationDtoBuilder.create().setName("Headphones").setPrice(350).setDiscount(50).
                    setDescription("Cool").build());
            productService.add(ProductCreationDtoBuilder.create().setName("Smartphone").setPrice(800).setDiscount(100).
                    setDescription("New and fashionable").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}



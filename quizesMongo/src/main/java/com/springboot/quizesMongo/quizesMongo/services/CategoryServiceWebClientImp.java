package com.springboot.quizesMongo.quizesMongo.services;

import com.springboot.quizesMongo.quizesMongo.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
public class CategoryServiceWebClientImp implements CategoryService{

    private final WebClient.Builder webClientBuilder;
    private final WebClient webClient;

    public CategoryServiceWebClientImp(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
        this.webClient = webClientBuilder.baseUrl("lb://CATEGORY-SERVICE").build();
    }
    @Override
    public CategoryDto findById(String categoryId) {
        try{
            return this.webClient
                    .get()
                    .uri("/api/v1/categories/{categoryId}",categoryId)
                    .retrieve()
                    .bodyToMono(CategoryDto.class)
                    .block();

        }
        catch (WebClientResponseException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                System.out.println("Not Found");
            }
            else if(e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)){
                System.out.println("Internal server");
            }
        }
        return null;

    }

    @Override
    public List<CategoryDto> findAll() {
        return this.webClient
                .get()
                .uri("api/v1/categories/getAll")
                .retrieve()
                .bodyToFlux(CategoryDto.class)
                .collectList()
                .block();
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
       return this.webClient
               .post()
               .uri("/api/v1/categories")
               .bodyValue(categoryDto)
               .retrieve()
               .bodyToMono(CategoryDto.class)
               .block();
    }

    @Override
    public CategoryDto update(String categoryId, CategoryDto categoryDto) {
        return this.webClient
                .put()
                .uri("/api/v1/categories/{categoryId}",categoryId)
                .bodyValue(categoryDto)
                .retrieve()
                .bodyToMono(CategoryDto.class)
                .block();
    }

    @Override
    public void delete(String categoryId) {
        this.webClient
                .delete()
                .uri("api/v1/categories/{categoryId}",categoryId)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}

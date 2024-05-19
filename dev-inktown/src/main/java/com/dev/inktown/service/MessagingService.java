package com.dev.inktown.service;


import com.dev.inktown.model.MessageReqDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MessagingService {

    private WebClient webclient;

    public MessagingService(WebClient.Builder webClientBuilder){
        String BASE_URL_TEXT_LOCAL = "https://api.textlocal.in";
        this.webclient = webClientBuilder.baseUrl(BASE_URL_TEXT_LOCAL).build();
    }

    public Mono<String> sendSms(MessageReqDto messageReqDto){
        messageReqDto.setMessage(String.format("Your Order : %s has been moved %s stage. ",messageReqDto.getOrderId(), messageReqDto.getOrderStatus()));
        String apiKey = "apikey=" + "yourapiKey";
        String message = "&message=" + messageReqDto.getMessage();
        String sender = "&sender=" + "TXTLCL";
        String numbers = "&numbers=" + messageReqDto.getMobileNumber();
        String reqBody = apiKey+numbers+message+sender;

        return webclient.post()
                .uri("/send/?")
                .body(BodyInserters.fromValue(reqBody))
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(throwable -> Mono.just(throwable.getMessage()));
    }
}

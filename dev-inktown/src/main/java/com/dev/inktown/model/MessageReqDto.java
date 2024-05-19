package com.dev.inktown.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MessageReqDto {
    String message;
    String mobileNumber;
    OrderStatus orderStatus;
    String orderId;

}

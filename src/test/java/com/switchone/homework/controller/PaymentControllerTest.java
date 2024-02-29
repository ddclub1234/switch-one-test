package com.switchone.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchone.homework.constant.Currency;
import com.switchone.homework.constant.Status;
import com.switchone.homework.dto.ApprovalRequest;
import com.switchone.homework.dto.EstimateRequest;
import com.switchone.homework.dto.PaymentDetailRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("잔액 조회 테스트")
    void getBalanceTest() throws Exception {
        Long userId = 1000L;
        mvc.perform(get("/api/payment/balance/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("userId").value(userId))
                .andExpect(jsonPath("balance").value(9600.0))
                .andExpect(jsonPath("currency").value(Currency.USD.toString()))
                .andDo(print());
    }

    @Test
    @DisplayName("결제 예상 결과 조회 테스트")
    void getEstimateTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        EstimateRequest request = EstimateRequest.builder()
                .userId(1000L)
                .amount(1500.00)
                .currency(Currency.USD)
                .destination(1000L)
                .build();

        mvc.perform(post("/api/payment/estimate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("estimatedTotal").value(1575.0))
                .andExpect(jsonPath("fees").value(75.0))
                .andDo(print());
    }

    @Test
    @DisplayName("결제 승인 요청 테스트")
    void registerApprovalTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        PaymentDetailRequest detailRequest = PaymentDetailRequest.builder()
                                            .cardNumber("1234-5678-9123-4567")
                                            .cvv("123")
                                            .expireDate("12/24")
                                            .build();

        ApprovalRequest request = ApprovalRequest.builder()
                .userId(1000L)
                .amount(1500.00)
                .currency(Currency.USD)
                .merchantId(1000L)
                .paymentMethod("creditCard")
                .paymentDetails(detailRequest)
                .build();

        mvc.perform(post("/api/payment/approval")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value(Status.APPROVED.getDesc()))
                .andDo(print());
    }
}

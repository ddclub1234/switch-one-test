package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstimateResponse {
    private Double estimatedTotal;
    private Double fees;
    private Currency currency;

    public static EstimateResponse from(Double estimatedTotal, Double fees, Currency currency){
        return EstimateResponse.builder()
                .estimatedTotal(estimatedTotal)
                .fees(fees)
                .currency(currency)
                .build();
    }
}

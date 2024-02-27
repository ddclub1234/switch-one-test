package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstimateResponse {
    private Double estimatedTotal;
    private Float fees;
    private Currency currency;
}

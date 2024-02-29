package com.switchone.homework.dto;

import com.switchone.homework.constant.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstimateRequest {
    @NotNull
    private Double amount;
    @NotNull
    private Currency currency;
    @NotNull
    private Long destination;
    @NotNull
    private Long userId;
}

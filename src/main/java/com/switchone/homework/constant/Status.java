package com.switchone.homework.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    APPROVED("approved");

    private final String desc;
}

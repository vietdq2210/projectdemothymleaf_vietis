package com.vietis.projectdemo_vietis.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    USER(0),
    ADMIN(1);
    private final int value;
}

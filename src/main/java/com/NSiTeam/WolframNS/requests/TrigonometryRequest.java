package com.NSiTeam.WolframNS.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrigonometryRequest {
    private Double angle;
    private Integer terms;
}

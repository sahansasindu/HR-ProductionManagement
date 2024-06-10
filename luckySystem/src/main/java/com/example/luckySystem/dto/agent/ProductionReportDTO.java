package com.example.luckySystem.dto.agent;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductionReportDTO {

    private long amount;
    private String batchCode;
    private String finishedState;

}

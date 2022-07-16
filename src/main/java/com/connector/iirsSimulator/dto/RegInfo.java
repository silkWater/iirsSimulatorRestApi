package com.connector.iirsSimulator.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegInfo {
    private LocalDateTime time;
    private List<Stations> stations;
}
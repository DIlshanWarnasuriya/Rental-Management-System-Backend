package org.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private Integer id;
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
    private Boolean available;
}

package org.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental {
    private Integer id;
    private Date rentalDate;
    private Date expectedDate;
    private Date returnDate;
    private Integer dueDate;
    private Double fine;
    private Double totalCost;
    private Integer customerId;
    private Integer itemId;
}

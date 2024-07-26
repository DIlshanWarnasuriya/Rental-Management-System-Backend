package org.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rental")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

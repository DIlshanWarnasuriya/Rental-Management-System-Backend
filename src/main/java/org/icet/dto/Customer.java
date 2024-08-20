package org.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String nic;
    private String name;
    private String contact;
    private String address;
}

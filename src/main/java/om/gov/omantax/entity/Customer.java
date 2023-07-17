package om.gov.omantax.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends User {

    @Column(name = "FULL_NAME")
    private String fullName;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals = new ArrayList<>();

}
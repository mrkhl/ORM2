package om.gov.omantax.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "RENTALS")
public class Rental {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "RENTING_AMOUNT")
    private double rentingAmount;

    @ManyToOne
    private Property property;

    @ManyToOne
    private Customer customer;

}

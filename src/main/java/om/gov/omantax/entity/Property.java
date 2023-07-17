package om.gov.omantax.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DAY_RENTAL_PRICE")
    private double dayRentalPrice;

    @ManyToOne
    private PropertyOwner propertyOwner;

    @OneToMany(mappedBy = "property")
    private List<Rental> rentals = new ArrayList<>();
}
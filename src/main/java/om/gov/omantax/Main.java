package om.gov.omantax;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import om.gov.omantax.entity.Customer;
import om.gov.omantax.entity.Property;
import om.gov.omantax.entity.PropertyOwner;
import om.gov.omantax.entity.Rental;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setFullName("Abu Mohammed");
        customer.setEmail("abumohammed@email.com");
        customer.setPassword("Abu@123");

        Customer customer1 = new Customer();
        customer1.setFullName("Abu Ahmed");
        customer1.setEmail("abuAhmed@email.com");
        customer1.setPassword("Abu@456");

        PropertyOwner propertyOwner  = new PropertyOwner();
        propertyOwner.setEmail("mohammed@email.com");
        propertyOwner.setPhoneNumber("97364188");
        propertyOwner.setPassword("4567");

        PropertyOwner propertyOwner1  = new PropertyOwner();
        propertyOwner1.setEmail("khalfan@email.com");
        propertyOwner1.setPhoneNumber("99808550");
        propertyOwner1.setPassword("1234");




        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MohammedPersis.jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();




        em.persist(customer);
        em.persist(customer1);
        em.persist(propertyOwner1);
        em.persist(propertyOwner);

        PropertyOwner foundPropertyOwner1 = em.find(PropertyOwner.class, 1);
        PropertyOwner foundPropertyOwner2 = em.find(PropertyOwner.class, 2);

        Property property = new Property();
        property.setName("Apartment");
        property.setDayRentalPrice(50.00);
        property.setPropertyOwner(foundPropertyOwner1);

        Property property1 = new Property();
        property1.setName("Apartment1");
        property1.setDayRentalPrice(60.00);
        property1.setPropertyOwner(foundPropertyOwner1);

        Property property2 = new Property();
        property2.setName("car2");
        property2.setDayRentalPrice(20.00);
        property2.setPropertyOwner(foundPropertyOwner2);

        Property property3 = new Property();
        property3.setName("car3");
        property3.setDayRentalPrice(15.50);
        property3.setPropertyOwner(foundPropertyOwner2);

        em.persist(property1);
        em.persist(property2);
        em.persist(property3);
        em.persist(property);




        Customer foundCustomer = em.find(Customer.class, 1);
        Property foundProperty = em.find(Property.class, 1);

        Rental rental1 = new Rental();
        rental1.setStartDate(LocalDate.of(1990, 1, 1));
        rental1.setEndDate(LocalDate.of(1999, 1,1));
        rental1.setRentingAmount(10000);
        rental1.setCustomer(foundCustomer);
        rental1.setProperty(foundProperty);
        em.persist(rental1);

        Customer foundCustomer2 = em.find(Customer.class,2);
        Property foundProperty2 = em.find(Property.class,2);
        Rental rental2 = new Rental();
        rental2.setStartDate(LocalDate.of(2023,12,1));
        rental2.setEndDate(LocalDate.of(2023,12,30));
        rental2.setRentingAmount(10000);
        rental2.setCustomer(foundCustomer2);
        rental2.setProperty(foundProperty2);
        em.persist(rental2);


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
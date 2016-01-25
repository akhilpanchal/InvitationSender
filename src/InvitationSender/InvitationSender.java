package InvitationSender;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * InvitationSender.java -  Sends invitation to customers
 *                          Entry point for the InvitationSender Application
 * Created by Akhil Panchal on 1/21/2016.
 */
public class InvitationSender {

    public static void main (String[] args) {

        ICustomerReader customerReader = new JsonCustomerReader();
        List<Customer> customerList = null;
        customerList = customerReader.getAllCustomers("customers.txt");
        /*  The list is filtered by using a lambda expression
        */
        customerList = customerList.stream()
                .filter(e -> (e.calculateDistanceFrom(53.3381985, -6.2592576) < 100))
                .sorted(new CustomerIDComparator())
                .collect(Collectors.toList());

        /*  Invite each customer */
        for(Customer customer : customerList) {
            // Simply displaying the UserID and Name
            System.out.println(customer);
        }
    }
}

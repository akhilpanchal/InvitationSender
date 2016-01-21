package InvitationSender;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * InvitationSender.java -  Sends invitation to customers
 *                          Entry point for the InvitationSender Application
 * Created by Akhil Panchal on 1/21/2016.
 */
public class InvitationSender {

    public static void main (String[] args) {

        ICustomerReader customerReader = new JsonCustomerReader();
        List<Customer> customerList = null;
        try {
            customerList = customerReader.getAllCustomers("customers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*  The coordinates of the Office and the radius are passed to the DistanceCustomerFilter
            in order to filter out customers outside the specified radius of the office.
        */
        ICustomerFilter distanceFilter = new DistanceCustomerFilter(53.3381985,-6.2592576,100);
        customerList = distanceFilter.filter(customerList);
        /*  Sorting customers according to UserIDs */
        Collections.sort(customerList, new CustomerIDComparator());

        /*  Invite each customer */
        for(Customer customer : customerList) {
            // Simply displaying the UserID and Name
            System.out.println(customer);
        }
    }
}

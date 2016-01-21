package InvitationSender;

import java.util.Comparator;

/**
 * CustomerIDComparator.java - Comparator for sorting customers according to their UserIds
 * Created by Akhil on 1/21/2016.
 */
public class CustomerIDComparator implements Comparator<Customer> {

    public int compare(Customer customer1, Customer customer2) {
        return customer1.getUserId().compareTo(customer2.getUserId());
    }
}

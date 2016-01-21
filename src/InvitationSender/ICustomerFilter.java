package InvitationSender;

import java.util.List;

/**
 * ICustomerFilter.java - Interface that filters a list of customer instances
 * Created by Akhil Panchal on 1/20/2016.
 */
public interface ICustomerFilter {

    public List<Customer> filter(List<Customer> list);
}

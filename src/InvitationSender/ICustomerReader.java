package InvitationSender;

import java.io.IOException;
import java.util.List;

/**
 * ICustomerReader.java - Interface that reads customer information from a source
 *                        Implementers should return a list of Customer instances
 * Created by Akhil Panchal on 1/21/2016.
 */
public interface ICustomerReader {

    public List<Customer> getAllCustomers(String filePath) throws IOException;
}

package InvitationSender;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JsonCustomerReader.java - Implements the CustomerReader Interface.
 *                           Reads Customer Information from a JSON File
 * Created by Akhil Panchal on 1/20/2016.
 */
public class JsonCustomerReader implements ICustomerReader{

    /*  Returns a list of Customer instances read from the JSON File */
    public List<Customer> getAllCustomers(String filePath) {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStream));
            String recordString;
            JSONParser parser = new JSONParser();

            while((recordString = fileReader.readLine()) != null) {
                JSONObject jsonObject = (JSONObject)parser.parse(recordString);
                customers.add(
                        createCustomerFromJson(jsonObject)
                );
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return customers;
    }

    /*  Returns a Customer instance from JSON record  */
    private Customer createCustomerFromJson(JSONObject record) {

        Customer customer = new Customer();
        try {
            customer.setUserId((Long)record.get("user_id"));
            customer.setName((String)record.get("name"));
            customer.setLatitude(Double.parseDouble((String)record.get("latitude")));
            customer.setLongitude(Double.parseDouble((String) record.get("longitude")));
            //System.out.println(customer);

        } catch (Exception pe) {
            System.out.println(pe);
        }
        return customer;
    }
}


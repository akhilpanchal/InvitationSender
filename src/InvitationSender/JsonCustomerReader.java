package InvitationSender;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JsonCustomerReader.java - Implements the CustomerReader Interface.
 *                           Reads Customer Information from a JSON File
 * Created by Akhil Panchal on 1/20/2016.
 */
public class JsonCustomerReader implements ICustomerReader{

    /*  Returns a list of Customer instances read from the JSON File */
    public List<Customer> getAllCustomers(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        JSONParser parser = new JSONParser();
        List<Customer> customers = new ArrayList<Customer>();
        File jsonFile = new File(filePath);
        List<String> recordStrings = getRecords(jsonFile);
        try {
            for (String recordString : recordStrings) {
                Object jsonObject = parser.parse(recordString);
                Customer customer = createCustomerFromJson((JSONObject)jsonObject);
                customers.add(customer);
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

    /*  Returns JSON record strings from the JSON File */
    private List<String> getRecords(File fin) throws IOException {
        List<String> recordStrings= new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(fin));
        String line = null;
        while ((line = br.readLine()) != null) {
            // System.out.println(line);
            recordStrings.add(line);
        }
        br.close();
        return recordStrings;
    }
}


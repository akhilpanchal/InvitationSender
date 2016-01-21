package InvitationSender;

import java.util.ArrayList;
import java.util.List;

/**
 * DistanceCustomerFilter.java - Implements the ICustomerFilter interface
 *                               Constructor accepts origin (Office) coordinates and radius.
 *                               Filters out the customers that are outside the given radius,
 *                               considering the origin (Office) as the centre.
 * Created by Akhil Panchal on 1/20/2016.
 */
public class DistanceCustomerFilter implements ICustomerFilter {

    private double distance;
    private double originLatitude;
    private double originLongitude;

    public DistanceCustomerFilter(double originLatitude, double originLongitude, long radius)
    {
        this.distance = radius;
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
    }

    @Override
    public List<Customer> filter(List<Customer> customers) {

        List<Customer> resultList = new ArrayList<Customer>();
        for(Customer customer : customers) {
            if(this.getDistanceFromOrigin(customer) < this.distance) {
                resultList.add(customer);
            }
        }
        return resultList;
    }

    /*  Calculates distance in kms between the coordinates through the surface of the earth.
    *   Radius of Earth is taken as 6371 kms.
    */
    private double getDistanceFromOrigin(Customer customer) {
        double distanceFromOrigin = 0;
        double customerLatitudeRadians = Math.toRadians(customer.getLatitude());
        double originLatitudeRadians = Math.toRadians(originLatitude);
        double delLongitude = Math.toRadians(Math.abs(originLongitude - customer.getLongitude()));

        double centralAngle = Math.acos(
                (Math.sin(originLatitudeRadians) * Math.sin(customerLatitudeRadians))
        +       (Math.cos(originLatitudeRadians) * Math.cos(customerLatitudeRadians) * Math.cos(delLongitude))
        );

        distanceFromOrigin = Double.valueOf(6371) * centralAngle;
        customer.setDistanceFromOrigin(distanceFromOrigin);
        return distanceFromOrigin;
    }
}

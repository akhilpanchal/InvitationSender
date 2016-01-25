package InvitationSender;

/**
 * Customer.java - Holds information about a customer
 * Created by Akhil Panchal on 1/20/2016.
 */
public class Customer {

    private String name;
    private Long userId;
    private double latitude;
    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder customer = new StringBuilder();
        customer.append("UserID: ").append(userId).append('\t');
        customer.append("Name: ").append(name);
        return customer.toString();
    }

    /*  Caluclates distance of the customer from the given coordinates*/
    public double calculateDistanceFrom(double originLatitude, double originLongitude) {
        double distanceFromOrigin = 0;
        double customerLatitudeRadians = Math.toRadians(this.latitude);
        double originLatitudeRadians = Math.toRadians(originLatitude);
        double delLongitude = Math.toRadians(Math.abs(originLongitude - this.longitude));

        double centralAngle = Math.acos(
                (Math.sin(originLatitudeRadians) * Math.sin(customerLatitudeRadians))
                        +       (Math.cos(originLatitudeRadians) * Math.cos(customerLatitudeRadians) * Math.cos(delLongitude))
        );

        distanceFromOrigin = Double.valueOf(6371) * centralAngle;
        return distanceFromOrigin;
    }
}



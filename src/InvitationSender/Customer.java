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

    public double getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    public void setDistanceFromOrigin(double distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    private double distanceFromOrigin;

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
        /*customer.append(latitude).append('\t');
        customer.append(longitude).append('\t');
        customer.append(distanceFromOrigin);*/
        return customer.toString();
    }
}



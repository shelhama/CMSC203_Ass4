package application;


public class Property {
    private String propertyName;    // Name of the property
    private String city;            // City where the property is located
    private double rentalAmount;    // Rental amount of the property
    private String owner;           // Owner of the property
    private Plot plot;              // Plot of the property

    // Parameterized constructor with all attributes including plot details
    public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Parameterized constructor with property name, city, rental amount, and owner
    // Initializes plot with default values
    public Property(String propertyName, String city, double rentalAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot values (0, 0, 1, 1)
    }

    // Copy constructor to create a new Property instance from an existing Property object
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentalAmount = otherProperty.rentalAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot); // Copy of the plot
    }

    // Getter and Setter methods for propertyName, city, rentalAmount, owner, and plot
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getRentalAmount() { return rentalAmount; }
    public void setRentalAmount(double rentalAmount) { this.rentalAmount = rentalAmount; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public Plot getPlot() { return plot; }
    public void setPlot(Plot plot) { this.plot = plot; }

    // Override toString to represent the property in the specified format
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentalAmount;
    }
}

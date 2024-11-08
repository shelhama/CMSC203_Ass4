package application;

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmtFee;
    private Property[] properties;
    private int propertyCount;
    private Plot plot;

    public static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;

    // Constructors
    public ManagementCompany(String name, String taxID, double mgmtFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(ManagementCompany other) {
        this(other.name, other.taxID, other.mgmtFee);
        this.plot = new Plot(other.plot);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = other.propertyCount;
        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
    }

    // Add Property methods (3 overloaded versions)
    public int addProperty(Property property) {
        if (propertyCount >= MAX_PROPERTY) 
        	return -1; // Array is full
        if (property == null) return -2; // Property is null
        if (!plot.encompasses(property.getPlot())) return -3; // Out of bounds
        for (int i = 0; i < propertyCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // Overlap detected
        }
        properties[propertyCount] = new Property(property);
        return propertyCount++;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to calculate total rent
    public double getTotalRent() {
        double totalRent = 0;
     
        for (int i = 0; i < propertyCount; i++) {
            totalRent += properties[i].getRentalAmount();
        }
        return totalRent;
    }

    // Method to find the index of the property with the highest rent
    private int maxRentPropertyIndex() {
        if (propertyCount == 0) return -1;
        int maxIndex = 0;
        double maxRent = properties[0].getRentalAmount();
        for (int i = 1; i < propertyCount; i++) {
            if (properties[i].getRentalAmount() > maxRent) {
                maxRent = properties[i].getRentalAmount();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentProperty() {
        int index = maxRentPropertyIndex();
        if (index == -1) return null;
        return properties[index];
    }

    // Checks if the properties array is full
    public boolean isPropertiesFull() {
        return propertyCount <= MAX_PROPERTY;
    }

    // Returns the number of properties currently managed
    public int getPropertiesCount() {
        return propertyCount;
    }

    // Checks if the management fee is valid (between 0 and 100)
    public boolean isManagementFeeValid() {
        return mgmtFee >= 0 && mgmtFee <= 100;
    }

    // Removes the last property in the array
    public void removeLastProperty() {
        if (propertyCount > 0) {
            properties[--propertyCount] = null;
        }
    }

    // Override toString to display management company information
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < propertyCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n");
        sb.append("Total management Fee: ").append(mgmtFee * getTotalRent() / 100).append("\n");
        return sb.toString();
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmtFee() { return mgmtFee; }
    public Plot getPlot() { return plot; }

	public boolean checkForOverlap(Plot plot2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Property getProperty(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by olga.
 */
public class Lamp implements Cloneable{

    private long lampId;
    private double consumption;
    private String address;
    private String city;
    private String longitude;
    private String latitude;
    private String model;
    private long timestamp;
    private long lastSubstitutionDate;
    private long residualLifeTime;
    private boolean stateOn;
    private double lightIntensity;

    public Lamp() {}
    
    public Lamp(long lampId, double lightIntensity, String address, long timestamp){
        this.lampId = lampId;
        this.lightIntensity = lightIntensity;
        this.address = address;
        this.timestamp = timestamp;
        this.residualLifeTime = timestamp - lastSubstitutionDate;
    }

    public Lamp(long lampId, double consumption, String city, String address, long timestamp) {
        this.lampId = lampId;
        this.consumption = consumption;
        this.city = city;
        this.address = address;
        this.timestamp = timestamp;
    }

    public Lamp(String city, double consumption, long timestamp) {
        this.city = city;
        this.consumption = consumption;
        this.timestamp = timestamp;
    }

    public Lamp(long lampId, double consumption, String city, String address, long lastSubstitutionDate, long timestamp){
        this.lampId = lampId;
        this.consumption = consumption;
        this.city = city;
        this.address = address;
        this.timestamp = timestamp;
        this.lastSubstitutionDate = lastSubstitutionDate;
        this.residualLifeTime = timestamp - lastSubstitutionDate;
    }

    public long getLampId() {
        return lampId;
    }

    public void setLampId(long lampId) {
        this.lampId = lampId;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getLastSubstitutionDate() {
        return lastSubstitutionDate;
    }

    public void setLastSubstitutionDate(long lastSubstitutionDate) {
        this.lastSubstitutionDate = lastSubstitutionDate;
    }

    public long getResidualLifeTime() {
        return residualLifeTime;
    }

    public void setResidualLifeTime(long residualLifeTime) {
        this.residualLifeTime = residualLifeTime;
    }

    public boolean isStateOn() {
        return stateOn;
    }

    public void setStateOn(boolean stateOn) {
        this.stateOn = stateOn;
    }
    
	public double getLightIntensity() {
		return lightIntensity;
	}

	public void setLightIntensity(double lightIntensity) {
		this.lightIntensity = lightIntensity;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

    @Override
    public Lamp clone() throws CloneNotSupportedException {
        return (Lamp) super.clone();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.lampId).append(", ");
        sb.append("intensity : ").append(this.lightIntensity).append(", ");
        sb.append(this.address).append(", ");
        sb.append("timestamp : ").append(this.timestamp);

        return sb.toString();
    }
    
    public static Lamp fromString(String line) {

        String[] tokens = line.split(",");
        if (tokens.length != 2) {
            throw new RuntimeException("Invalid record: " + line);
        }

        Lamp ride = new Lamp();

        try {
            ride.lampId = Long.parseLong(tokens[0]);
            ride.consumption = Long.parseLong(tokens[1]);

        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Invalid record: " + line, nfe);
        }

        return ride;
    }
    
    public static String toJson(Lamp l) {

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = new String("");
        try {
            jsonInString = mapper.writeValueAsString(l);
            return jsonInString;

        } catch (JsonProcessingException e) {
            return null;
        }

    }

}
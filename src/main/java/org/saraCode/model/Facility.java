package org.saraCode.model;

public class Facility {
	private Integer facilityID;
	private String name;
	private String location;
	private String phoneNumber;
	private Integer numOfRooms;
	public Integer occupiedRooms;

	public Integer getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(Integer numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	public Integer getOccupiedRooms() {
		return occupiedRooms;
	}

	public void setOccupiedRooms(Integer occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
	}

}

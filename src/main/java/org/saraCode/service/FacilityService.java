package org.saraCode.service;

import java.util.List;

import org.saraCode.dao.FacilityDAO;
import org.saraCode.dao.FacilityMaintenanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {

	@Autowired
	private FacilityDAO facilityDAO;

	public List<String> listFacilities() {
		facilityDAO = facilityDAO = getDAOObject(facilityDAO);
		List<String> facilitiesList = facilityDAO.listFacilities();
		return facilitiesList;
	}

	public List<String> getFacilityInformation(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		List<String> facilityInfo = facilityDAO.getFacilityDetails(facilityId);
		return facilityInfo;

	}

	public Integer requestAvailableCapacity(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		Integer Occupied = facilityDAO.getOccupiedRooms(facilityId);
		Integer totalRooms = facilityDAO.getNumberOfRooms(facilityId);
		Integer capacity = totalRooms - Occupied;
		return capacity;

	}

	public void addNewFacility(String addName, String addLocation, String addPhone, Integer addNumOfRooms) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.addNewFacility(addName, addLocation, addPhone, addNumOfRooms);
		System.out.println(addName + " has been added to the list of facilities");
	}

	public void removeFacility(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.removeFacility(facilityId);
	}

	// Get functionalities

	public String getName(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		return facilityDAO.getName(facilityId);

	}

	public String getLocation(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		return facilityDAO.getLocation(facilityId);

	}

	public String getPhone(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		return facilityDAO.getPhone(facilityId);

	}

	public Integer getNumberOfRooms(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		return facilityDAO.getNumberOfRooms(facilityId);

	}

	public Integer getOccupiedRooms(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		return facilityDAO.getOccupiedRooms(facilityId);

	}

	// Set functionalities

	public void setName(String newName, Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.setName(facilityId, newName);
	}

	public void setLocation(String newLocation, Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.setLocation(facilityId, newLocation);
	}

	public void setPhone(String newPhone, Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.setPhone(facilityId, newPhone);
	}

	public void setNumberOfRooms(Integer newRoomsNum, Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		facilityDAO.setNumberOfRooms(facilityId, newRoomsNum);
	}

	// Occupany Methods

	public void addOccupiedRoom(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		Integer noOfOccupiedRooms = 0;

		if (facilityDAO.getOccupiedRooms(facilityId) == null)
			noOfOccupiedRooms = 0;

		if (facilityDAO.getNumberOfRooms(facilityId) - noOfOccupiedRooms > 0) {
			facilityDAO.updateOccupiedRooms(1, facilityId);
		} else {
			System.out.println("There is no more capacity");
		}

	}

	public void voidOccupiedRoom(Integer facilityId) {
		facilityDAO = getDAOObject(facilityDAO);
		if ((facilityDAO.getOccupiedRooms(facilityId) == 0) || (facilityDAO.getOccupiedRooms(facilityId) < 0)) {
			System.out.println("There are no occupied rooms, all rooms are available");
		} else {
			facilityDAO.updateOccupiedRooms(-1, facilityId);
		}

	}

	private FacilityDAO getDAOObject(FacilityDAO facilityDAO) {
		if (facilityDAO == null) {
			facilityDAO = new FacilityDAO();
		}
		return facilityDAO;
	}

}

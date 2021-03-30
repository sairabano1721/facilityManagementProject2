package org.saraCode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.saraCode.configuration.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacilityDAO {

	@Autowired
	private DBConfig dbHelper;

//Saving information related to facility
	public void addNewFacility(String name, String location, String phone, Integer numOfRooms) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			Integer id = latestFacility();
			if (id == null) {
				id = 1;
			} else {
				id = id + 1;
			}
			String query = "INSERT INTO sql3395846.facilities(idFacilities,Name,Location,phoneNumber,numOfRooms) VALUES("
					+ id + " , " + "'" + name + "','" + location + "'," + phone + "," + numOfRooms + ")";

			System.out.println("***" + query);
			Integer rs = stmt.executeUpdate(query);
			if (rs == 1) {
				System.out.println("Facility saved!!");
			} else {
				System.out.println("Problem in saving");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Removing information related to facility
	public void removeFacility(Integer facilityId) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "DELETE FROM sql3395846.facilities WHERE idFacilities = " + facilityId;
			stmt.executeUpdate(query);
			System.out.println("Facility::" + facilityId + " deleted successfully!!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public List<String> getFacilityDetails(Integer facilityId) {
		List<String> facilityDetails = new ArrayList<String>();
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities where idFacilities = " + facilityId;
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				facilityDetails.add(rs.getString(1)); // getting the ID from the database
				facilityDetails.add(rs.getString(2)); // getting the name from the database
				facilityDetails.add(rs.getString(3)); // getting the Location from the database
				facilityDetails.add(rs.getString(4)); // getting the phone from the database
				facilityDetails.add(rs.getString(5)); // getting the number of rooms from the database
				facilityDetails.add(rs.getString(6)); // getting the number of occupied rooms
			}
			return facilityDetails;
		} catch (Exception e) {
			facilityDetails.add("Error when accessing database");
			return facilityDetails;
		}
	}

	public List<String> listFacilities() {
		List<String> allFacilities = new ArrayList<String>();
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				allFacilities.add(rs.getString(2) + " - id: " + rs.getInt(1));
			return allFacilities;
		} catch (Exception e) {
			allFacilities.add("Error when accessing database");
			return allFacilities;
		}
	}

	public Integer latestFacility() {
		List<Integer> allFacilities = new ArrayList<Integer>();
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select idFacilities from sql3395846.facilities order by idFacilities desc";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				allFacilities.add(rs.getInt(1));

		} catch (Exception e) {
			allFacilities.add(0);

		}
		if (!allFacilities.isEmpty())
			return allFacilities.get(0);
		else
			return null;
	}

	// Get functionalities

	public String getName(Integer SearchID) {
		String returnString = "";
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities where idFacilities = " + SearchID;

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnString = rs.getString(2);
			}

		} catch (Exception e) {
			returnString = e.toString();
		}

		return returnString;

	}

	public String getLocation(Integer SearchID) {
		String returnString = "";
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities where idFacilities = " + SearchID;

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnString = rs.getString(3);
			}

		} catch (Exception e) {
			returnString = e.toString();
		}

		return returnString;

	}

	public String getPhone(Integer SearchID) {
		String returnString = "";
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities where idFacilities = " + SearchID;

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnString = rs.getString(4);
			}

		} catch (Exception e) {
			returnString = e.toString();
		}

		return returnString;

	}

	public Integer getNumberOfRooms(Integer SearchID) {
		Integer returnInt = null;
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select * from sql3395846.facilities where idFacilities = " + SearchID;

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnInt = rs.getInt(5);
			}

		} catch (Exception e) {
			returnInt = 99999999;
		}

		return returnInt;

	}

	// Set functionalities
	public void setName(Integer Id, String newName) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "UPDATE sql3395846.facilities " + "SET Name = " + "'" + newName + "'"
					+ " WHERE idFacilities = " + Id;
			stmt.executeUpdate(query);
			System.out.println("Facility " + Id + "'s name has been updated");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void setLocation(Integer Id, String newLocation) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "UPDATE sql3395846.facilities " + "SET Location = " + "'" + newLocation + "'"
					+ " WHERE idFacilities = " + Id;
			stmt.executeUpdate(query);
			System.out.println("Facility " + Id + "'s location has been updated");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void setPhone(Integer Id, String newPhone) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "UPDATE sql3395846.facilities " + "SET phoneNumber = " + "'" + newPhone + "'"
					+ " WHERE idFacilities = " + Id;
			stmt.executeUpdate(query);
			System.out.println("Facility " + Id + "'s phone number has been updated");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void setNumberOfRooms(Integer Id, Integer newRoomsNum) {
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "UPDATE facilities " + "SET numOfRooms = " + "'" + newRoomsNum + "'"
					+ " WHERE idFacilities = " + Id;
			stmt.executeUpdate(query);
			System.out.println("Facility " + Id + "'s number of rooms has been updated");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void updateOccupiedRooms(Integer change, Integer ID) {
		Integer updateNum = getOccupiedRooms(ID) + change;
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "UPDATE sql3395846.facilities " + "SET OccupiedRooms = " + "'" + updateNum + "'"
					+ " WHERE idFacilities = " + ID;
			stmt.executeUpdate(query);
			System.out.println("Facility " + ID + "'s list of available rooms has been updated");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Integer getOccupiedRooms(Integer ID) {
		Integer occupied = null;
		try {
			dbHelper = getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select OccupiedRooms from sql3395846.facilities where idFacilities = " + ID;
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				occupied = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return occupied;

	}

	private DBConfig getDBDAOObject(DBConfig dbHelper) {
		if (dbHelper == null) {
			return new DBConfig();
		}
		return dbHelper;
	}

}

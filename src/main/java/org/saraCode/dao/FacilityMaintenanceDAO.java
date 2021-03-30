package org.saraCode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.saraCode.configuration.DBConfig;
import org.saraCode.model.FacilityMaintainence;
import org.saraCode.model.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacilityMaintenanceDAO {

	@Autowired
	private DBConfig dbHelper;

	public void addFacilityMaintenance(RequestType requestType, Integer facilityId, Integer roomNum, Boolean status) {
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			Integer latestMaintenanceId = latestMaintenance();
			String query = "INSERT INTO sql3395846.facilities_maintenance(maintenanceId,facilityId,roomNum,status,requestType) VALUES("
					+ latestMaintenanceId + " , " + "" + facilityId + "," + roomNum + "," + status + ",'" + requestType
					+ "')";
			Integer result = stmt.executeUpdate(query);
			if (result == 1) {
				System.out.println("Maintenance saved!!");
			} else {
				System.out.println("Problem in saving");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FacilityMaintainence getFacilityMaintenance(Integer facilityId, Integer roomNum) {
		FacilityMaintainence facilityMaintainence = new FacilityMaintainence();
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select status,requestType,roomNum from facilities_maintenance where facilityId="
					+ facilityId + " and roomNum=" + roomNum;

			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				facilityMaintainence.setFacilityId(facilityId);
				facilityMaintainence.setRequestType(RequestType.valueOf(rs.getString(2)));
				facilityMaintainence.setRoomId(rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return facilityMaintainence;
	}

	public void removeFacilityMaintenance(Integer facilityId, Integer roomNum) {

		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "delete from facilities_maintenance where facilityId=" + facilityId + " and roomNum="
					+ roomNum;
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Facility maintenance  deletion successfully!!");

	}

	public void updateFacilityMaintenance(Integer facilityId, Integer roomNum, RequestType requestType) {

		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "update facilities_maintenance set requestType='" + requestType + "' where facilityId="
					+ facilityId + " and roomNum=" + roomNum;
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Facility maintenance  updation successfully!!");
	}

	private Integer latestMaintenance() {
		List<Integer> allMaintenanceId = new ArrayList<Integer>();
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select maintenanceId from sql3395846.facilities_maintenance order by maintenanceId desc";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				allMaintenanceId.add(rs.getInt(1));

		} catch (Exception e) {
			allMaintenanceId.add(0);

		}
		if (!allMaintenanceId.isEmpty())
			return allMaintenanceId.get(0) + 1;
		return 1;

	}

	private DBConfig getDBDAOObject(DBConfig dbHelper) {
		if (dbHelper == null) {
			return  new DBConfig();
		}
		return dbHelper;
	}

}

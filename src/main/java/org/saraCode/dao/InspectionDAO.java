package org.saraCode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.saraCode.configuration.DBConfig;
import org.saraCode.model.Inspection;
import org.saraCode.model.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InspectionDAO {

	@Autowired
	private DBConfig dbHelper;

	FacilityMaintenanceDAO facilityMaintenanceDAO = new FacilityMaintenanceDAO();

	public void addInspection(Integer roomNum, Integer facilityId, Boolean status, RequestType requestType) {

		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			Integer latestInspectionId = getInspectionId();
			String query = "INSERT INTO sql3395846.inspections(inspectionId,facilityId,roomNum,needMaintenance,requestType) VALUES("
					+ latestInspectionId + " , " + "" + facilityId + "," + roomNum + "," + status + ",'" + requestType
					+ "')";
			Integer result = stmt.executeUpdate(query);
			if (result == 1) {

				System.out.println("Inspection saved!!");
			} else {
				System.out.println("Problem in saving");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Integer getInspectionId() {
		List<Integer> inspectionIds = new ArrayList<>();
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select inspectionId from inspections order by inspectionId desc";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				inspectionIds.add(rs.getInt(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!inspectionIds.isEmpty())
			return inspectionIds.get(0) + 1;

		return 1;
	}

	public Inspection getInspection(Integer facilityId, Integer roomNum) {
		Inspection inspection = new Inspection();
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "select needMaintenance,requestType,roomNum from inspections where facilityId=" + facilityId
					+ " and roomNum=" + roomNum;

			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				inspection.setFacilityId(facilityId);
				inspection.setIsMaintanaceRequired(rs.getBoolean(1));
				inspection.setRequestType(RequestType.valueOf(rs.getString(2)));
				inspection.setRoomId(rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inspection;
	}

	public void removeInspection(Integer facilityId, Integer roomNum) {
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "delete from inspections where facilityId=" + facilityId + " and roomNum=" + roomNum;
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Deletion successfully!!!");
	}

	public void updateInspection(Integer facilityId, Integer roomNum, String requestType) {
		try {
			dbHelper=getDBDAOObject(dbHelper);
			Statement stmt = dbHelper.getConnection().createStatement();
			String query = "update inspections set requestType='" + requestType + "' where facilityId=" + facilityId
					+ " and roomNum=" + roomNum;

			System.out.println(query);
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Updation sucessfully!!");
	}

	private DBConfig getDBDAOObject(DBConfig dbHelper) {
		if (dbHelper == null) {
			return new DBConfig();
		}
		return dbHelper;
	}

}


package org.saraCode;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.saraCode.dao.FacilityMaintenanceDAO;
import org.saraCode.dao.InspectionDAO;
import org.saraCode.model.Inspection;
import org.saraCode.model.RequestType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { App.class })
public class InspectionDAOTest {

	InspectionDAO inspectionDAO = new InspectionDAO();
	FacilityMaintenanceDAO facilityMaintenanceDAO = new FacilityMaintenanceDAO();

	// checking data is saving in inspection table

	@Test
	void saveTests() {
		inspectionDAO.addInspection(1, 1, true, RequestType.BrokenItem);
		inspectionDAO.addInspection(2, 1, false, RequestType.Cleaning);
		inspectionDAO.addInspection(3, 1, false, RequestType.Repair);
		assertNotNull(inspectionDAO.getInspection(1, 1));
		assertNotNull(inspectionDAO.getInspection(1, 2));
		assertNotNull(inspectionDAO.getInspection(1, 3));
	}

	// checking data is saving in inspection table

	@Test
	void facilityMaintenceSavingCheck() {
		inspectionDAO.addInspection(2, 2, true, RequestType.BrokenItem);
		assertNotNull(inspectionDAO.getInspection(1, 1));
		Inspection inspection = inspectionDAO.getInspection(2, 2);
		assertNotNull(inspection);
		assertEquals(2, inspection.getRoomId());
		assertEquals(2, inspection.getFacilityId());
		assertEquals(RequestType.BrokenItem, inspection.getRequestType());
	}

	// deletion check in inspection table

	@Test
	void facilityMaintencedeletionCheck() {
		inspectionDAO.addInspection(2, 4, true, RequestType.Cleaning);
		assertNotNull(inspectionDAO.getInspection(2, 4));
		inspectionDAO.removeInspection(2, 4);
		assertNull(inspectionDAO.getInspection(2, 4).getFacilityId());
	}

	// updation check in inspection table

	@Test
	void facilityMaintenceUpdationCheck() {
		inspectionDAO.addInspection(2, 5, true, RequestType.Cleaning);
		assertNotNull(inspectionDAO.getInspection(5, 2));
		assertEquals(RequestType.Cleaning, inspectionDAO.getInspection(5, 2).getRequestType());
		inspectionDAO.updateInspection(5, 2, RequestType.Repair.toString());
		assertNotNull(inspectionDAO.getInspection(5, 2));
		assertEquals(RequestType.Repair, inspectionDAO.getInspection(5, 2).getRequestType());
	}

}

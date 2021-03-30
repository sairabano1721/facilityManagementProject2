package org.saraCode;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.saraCode.dao.FacilityMaintenanceDAO;
import org.saraCode.model.RequestType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { App.class })
public class FacilityMaintencneTests {

	FacilityMaintenanceDAO facilityMaintenanceDAO = new FacilityMaintenanceDAO();

	// checking data is saving in inspection table
	@Test
	public void saveTests() {
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.BrokenItem, 1, 1, true);
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.Cleaning, 1, 2, true);
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.Repair, 1, 3, true);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(1, 1));
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(1, 2));
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(1, 3));
	}

	// checking data is saving in inspection table

	@Test
	public void facilityMaintenceSavingCheck() {
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.BrokenItem, 2, 1, true);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(2, 1));
		assertEquals(2, facilityMaintenanceDAO.getFacilityMaintenance(2, 1).getFacilityId());
		assertEquals(1, facilityMaintenanceDAO.getFacilityMaintenance(2, 1).getRoomId());
		assertEquals(RequestType.BrokenItem, facilityMaintenanceDAO.getFacilityMaintenance(2, 1).getRequestType());
	}

	// deletion check in inspection table

	@Test
	public void facilityMaintencedeletionCheck() {
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.BrokenItem, 2, 2, true);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(2, 2));
		facilityMaintenanceDAO.removeFacilityMaintenance(2, 2);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(2, 2));
	}

	// updation check in inspection table

	@Test
	public void facilityMaintenceUpdationCheck() {
		facilityMaintenanceDAO.addFacilityMaintenance(RequestType.BrokenItem, 2, 2, true);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(2, 2));
		assertEquals(RequestType.BrokenItem, facilityMaintenanceDAO.getFacilityMaintenance(2, 2).getRequestType());
		facilityMaintenanceDAO.updateFacilityMaintenance(2, 2, RequestType.Cleaning);
		assertNotNull(facilityMaintenanceDAO.getFacilityMaintenance(2, 2));
		assertEquals(RequestType.Cleaning, facilityMaintenanceDAO.getFacilityMaintenance(2, 2).getRequestType());
	}

}

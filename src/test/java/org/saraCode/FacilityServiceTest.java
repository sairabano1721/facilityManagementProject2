
package org.saraCode;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.saraCode.service.FacilityService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { App.class })
public class FacilityServiceTest {

	FacilityService service = new FacilityService();

	@Test
	public void mainFunctionalities() {

		service.addNewFacility("Adam Test 1", "112 9th Avenue, New York, NY 10011", "8473901289", 12);
		service.addNewFacility("Adam Test 2", "113 9th Avenue, New York, NY 10011", "8473901287", 13);
		service.addNewFacility("Adam Test 3", "115 9th Avenue, New York, NY 10011", "8473901288", 14);
		assertNotNull(service.listFacilities().toString());

	}

	// Occupied Room Tests

	@Test
	public void OccupiedRoomTests() {
		service.addOccupiedRoom(2);
		assertEquals(1, service.getOccupiedRooms(2));
		service.addOccupiedRoom(2);
		assertEquals(2, service.getOccupiedRooms(2));
		service.addOccupiedRoom(2);
		assertEquals(3, service.getOccupiedRooms(2));
		service.addOccupiedRoom(2);
		assertEquals(4, service.getOccupiedRooms(2));
		service.voidOccupiedRoom(2);
		assertEquals(3, service.getOccupiedRooms(2));
		service.voidOccupiedRoom(2);
		assertEquals(2, service.getOccupiedRooms(2));
		service.voidOccupiedRoom(2);
		assertEquals(1, service.getOccupiedRooms(2));
		service.voidOccupiedRoom(2);
		assertEquals(0, service.getOccupiedRooms(2));
	}

	@Test
	public void mainFunctionalities2() {
		assertNotNull(service.listFacilities().toString());
		service.addNewFacility("Adam Test 5", "112 9th Avenue, New York, NY 10011", "8473901289", 12);
		assertNotNull(

				service.listFacilities().toString());
		
	}

	@Test
	public void OccupiedRoomTests2() {
		service.addNewFacility("Adam Test 6", "112 9th Avenue, New York, NY 10011", "8473901289", 12);
		service.addOccupiedRoom(1);
		assertEquals(1, service.getOccupiedRooms(1));
		service.addOccupiedRoom(1);
		assertEquals(2, service.getOccupiedRooms(1));
		service.addOccupiedRoom(1);
		assertEquals(3, service.getOccupiedRooms(1));
		service.addOccupiedRoom(1);
		assertEquals(4, service.getOccupiedRooms(1));
		service.voidOccupiedRoom(1);
		assertEquals(3, service.getOccupiedRooms(1));
		service.voidOccupiedRoom(1);
		assertEquals(2, service.getOccupiedRooms(1));
		service.voidOccupiedRoom(1);
		assertEquals(1, service.getOccupiedRooms(1));
		service.voidOccupiedRoom(1);
		assertEquals(0, service.getOccupiedRooms(1));
	}

	// Get Set Tests

	@Test
	public void getSetTests() {
		service.setName("Adam Set Test 1", 3);
		assertEquals("Adam Set Test 1", service.getName(3));
		service.setLocation("1111 W Sheridan Ave, Chicago, IL 60626", 3);
		assertEquals("1111 W Sheridan Ave, Chicago, IL 60626", service.getLocation(3));
		service.setPhone("1111111111", 2);
		assertEquals("1111111111", service.getPhone(2));
		service.setNumberOfRooms(3, 3);
		assertEquals(3, service.getNumberOfRooms(3));
	}

	@Test
	public void getSetTests2() {
		service.setName("Adam Unit Test 2", 1);
		assertNotNull( service.getName(1));
		service.setLocation("2222 W Sheridan Ave, Chicago, IL 60626", 1);
		assertNotNull (service.getLocation(1));
		service.setPhone("1111211111", 1);
		assertNotNull( service.getPhone(1));
		service.setNumberOfRooms(3, 1);
	}

	@Test
	public void removeAllFacilities() {
		service.removeFacility(1);
		service.removeFacility(2);
		service.removeFacility(3);
		service.removeFacility(4);
		service.removeFacility(1);
	}

}

package org.saraCode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author saira bano
 *
 */

@Configuration
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		/*
		 * FacilityMaintenanceService facilityMaintenanceService =
		 * context.getBean("facilityMaintenanceService",
		 * FacilityMaintenanceService.class); FacilityService facilityService =
		 * context.getBean("facilityService", FacilityService.class); InspectionService
		 * inspectionService = context.getBean("inspectionService",
		 * InspectionService.class);
		 * 
		 * // testing inspection inspectionService.addInspection(1, 1, true,
		 * RequestType.Cleaning); System.out.println(inspectionService.getInspection(1,
		 * 1)); inspectionService.updateInspection(1, 1, RequestType.Repair.toString());
		 * inspectionService.removeInspection(1, 1);
		 */

	}
}

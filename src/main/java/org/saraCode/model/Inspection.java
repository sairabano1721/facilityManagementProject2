package org.saraCode.model;

public class Inspection {

	private Integer inspectionId;
	private Boolean isMaintanaceRequired;
	private RequestType requestType;
	private Integer facilityId;
	private Integer roomId;

	public Integer getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(Integer inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Boolean getIsMaintanaceRequired() {
		return isMaintanaceRequired;
	}

	public void setIsMaintanaceRequired(Boolean isMaintanaceRequired) {
		this.isMaintanaceRequired = isMaintanaceRequired;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

}

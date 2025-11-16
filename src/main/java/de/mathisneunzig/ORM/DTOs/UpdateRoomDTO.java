package de.mathisneunzig.ORM.DTOs;

import java.util.UUID;

import de.mathisneunzig.ORM.enums.RoomType;

public class UpdateRoomDTO {

	private String roomNr;
	private String name;
	private int capacity;
	private RoomType type;
	private UUID buildingId;
	
	public UpdateRoomDTO(String roomNr, String name, int capacity, RoomType type, UUID buildingId) {
		super();
		this.roomNr = roomNr;
		this.name = name;
		this.capacity = capacity;
		this.type = type;
		this.buildingId = buildingId;
	}

	public String getRoomNr() {
		return roomNr;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public RoomType getType() {
		return type;
	}

	public UUID getBuildingId() {
		return buildingId;
	}
	
}

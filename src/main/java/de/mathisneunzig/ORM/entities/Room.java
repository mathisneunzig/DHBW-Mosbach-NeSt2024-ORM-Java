package de.mathisneunzig.ORM.entities;

import java.util.UUID;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import de.mathisneunzig.ORM.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Room {
	
	@Id
	@Column(columnDefinition= "VARBINARY(16)", name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name="number")
	@NotNull
	private String roomNr;

	@Column(name="name")
	@NotNull
	private String name;

	@Column(name="capacity")
	private int capacity;

	@Column(name="type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoomType type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "building_id", referencedColumnName = "id")
	private Building building;

	public Room(UUID id, @NotNull String roomNr, @NotNull String name, int capacity, @NotNull RoomType type,
			Building building) {
		super();
		this.id = id;
		this.roomNr = roomNr;
		this.name = name;
		this.capacity = capacity;
		this.type = type;
		this.building = building;
	}

	public Room(@NotNull String roomNr, @NotNull String name, int capacity, @NotNull RoomType type, Building building) {
		super();
		this.roomNr = roomNr;
		this.name = name;
		this.capacity = capacity;
		this.type = type;
		this.building = building;
	}
	
	public Room() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRoomNr() {
		return roomNr;
	}

	public void setRoomNr(String roomNr) {
		this.roomNr = roomNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
}

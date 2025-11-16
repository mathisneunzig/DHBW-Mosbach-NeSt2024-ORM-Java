package de.mathisneunzig.ORM.entities;

import java.sql.Time;
import java.util.UUID;

import de.mathisneunzig.ORM.enums.BuildingType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Building {
	
	@Id
	@Column(columnDefinition= "VARBINARY(16)", name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="is_open_weekend")
	@NotNull
	private Boolean isOpenOnWeekends;

	@Column(name="opening_time")
	@NotNull
	private Time openingTime;

	@Column(name="closing_time")
	@NotNull
	private Time closingTime;
	
	@Column(name="street")
	@NotNull
	private String street;
	
	@Column(name="house_number")
	@NotNull
	private String houseNr;
	
	@Column(name="zip_code")
	@NotNull
	private String zip;
	
	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(name="country")
	@NotNull
	private String country;

	@Column(name="type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private BuildingType type;

	public Building(UUID id, @NotNull String name, @NotNull Boolean isOpenOnWeekends, @NotNull Time openingTime,
			@NotNull Time closingTime, @NotNull String street, @NotNull String houseNr, @NotNull String zip,
			@NotNull String city, @NotNull String country, @NotNull BuildingType type) {
		super();
		this.id = id;
		this.name = name;
		this.isOpenOnWeekends = isOpenOnWeekends;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.street = street;
		this.houseNr = houseNr;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.type = type;
	}

	public Building(@NotNull String name, @NotNull Boolean isOpenOnWeekends, @NotNull Time openingTime,
			@NotNull Time closingTime, @NotNull String street, @NotNull String houseNr, @NotNull String zip,
			@NotNull String city, @NotNull String country, @NotNull BuildingType type) {
		super();
		this.name = name;
		this.isOpenOnWeekends = isOpenOnWeekends;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.street = street;
		this.houseNr = houseNr;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.type = type;
	}
	
	public Building() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isOpenOnWeekends() {
		return isOpenOnWeekends;
	}

	public void setOpenOnWeekends(Boolean isOpenOnWeekends) {
		this.isOpenOnWeekends = isOpenOnWeekends;
	}

	public Time getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Time openingTime) {
		this.openingTime = openingTime;
	}

	public Time getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Time closingTime) {
		this.closingTime = closingTime;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BuildingType getType() {
		return type;
	}

	public void setType(BuildingType type) {
		this.type = type;
	}

}

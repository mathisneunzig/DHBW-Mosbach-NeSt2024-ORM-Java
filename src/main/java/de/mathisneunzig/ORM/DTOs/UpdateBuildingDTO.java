package de.mathisneunzig.ORM.DTOs;

import java.sql.Time;

import de.mathisneunzig.ORM.enums.BuildingType;

public class UpdateBuildingDTO {
	
	private String name;
	private Boolean isOpenOnWeekends;
	private Time openingTime;
	private Time closingTime;
	private String street;
	private String houseNr;
	private String zip;
	private String city;
	private String country;
	private BuildingType type;
	
	public UpdateBuildingDTO(String name, Boolean isOpenOnWeekends, Time openingTime, Time closingTime, String street,
			String houseNr, String zip, String city, String country, BuildingType type) {
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

	public String getName() {
		return name;
	}

	public Boolean getIsOpenOnWeekends() {
		return isOpenOnWeekends;
	}

	public Time getOpeningTime() {
		return openingTime;
	}

	public Time getClosingTime() {
		return closingTime;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public BuildingType getType() {
		return type;
	}
	
}

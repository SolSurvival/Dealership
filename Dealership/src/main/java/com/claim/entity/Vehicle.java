package com.claim.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "make")
	private String make;
	@Column(name = "model")
	private String model;
	@Column(name = "year")
	private String year;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private Double price;
	@Column(name = "pictureUrl")
	private String pictureUrl;
	@Column(name = "isSold")
	private Boolean isSold;
	@Column(name = "daysOnLot")
	private Integer daysOnLot = 0;
	

	public Vehicle() {
	}

	public Vehicle(int id, String model, String make, String year, String description, Double price, Integer daysOnLot) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.description = description;
		this.pictureUrl = "https://kidbucketlist.com.au/wp-content/uploads/2015/02/West-Coast-Customs-Burbank-5.jpg";
		this.price = price;
		this.isSold = false;
		this.daysOnLot = daysOnLot;
		
	}

	public int getId() {
		return this.id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static List<Vehicle> setInitialInventory() {
		Vehicle v1 = new Vehicle(1, "SupaFast", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 0);
		Vehicle v2 = new Vehicle(2, "SupaCool", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 10);
		Vehicle v3 = new Vehicle(3, "SupaHybrid", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 50);
		Vehicle v4 = new Vehicle(4, "SupaDiesel", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 30);
		Vehicle v5 = new Vehicle(5, "SupaSupra", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 70);
		Vehicle v6 = new Vehicle(6, "SupaStang", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 40);
		Vehicle v7 = new Vehicle(7, "SupaSport", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 130);
		Vehicle v8 = new Vehicle(8, "SupaPimpedOut", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 120);
		Vehicle v9 = new Vehicle(9, "SupaSlow", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 150);
		Vehicle v10 = new Vehicle(10, "SupaOldSKool", "WCC Original", "2040", "My Pimped Out Ride", 200000.00, 2000000);
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);
		list.add(v9);
		list.add(v10);
		return list;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}

	public Integer getDaysOnLot() {
		return daysOnLot;
	}

	public void setDaysOnLot(Integer daysOnLot) {
		this.daysOnLot = daysOnLot;
	}


}

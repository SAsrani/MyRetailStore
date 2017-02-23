package com.retail.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RETAIL_MANAGER")
public class RetailManagerDTO {

	@Id
	@GenericGenerator(name = "idIncrement", strategy = "increment")
	@GeneratedValue(generator = "idIncrement")
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SHOP_NAME")
	private String shopName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "LATITUDE")
	private Double latitude = 0D;

	@Column(name = "LOGITUDE")
	private Double longitude = 0D;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}

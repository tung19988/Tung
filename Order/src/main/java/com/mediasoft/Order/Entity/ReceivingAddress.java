package com.mediasoft.Order.Entity;

public class ReceivingAddress {

	private String Country;
	
	private String Province;
	
	private String City;
	
	private String Township;
	
	private String AddressDetail;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getTownship() {
		return Township;
	}

	public void setTownship(String township) {
		Township = township;
	}

	public String getAddressDetail() {
		return AddressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		AddressDetail = addressDetail;
	}
	
	
}

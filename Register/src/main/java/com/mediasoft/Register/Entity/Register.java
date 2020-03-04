package com.mediasoft.Register.Entity;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Register")
public class Register {
	@Transient
    public static final String SEQUENCE_NAME = "register";
	
	@Id
    private long id;
	
	@NotBlank
    @Size(min = 1, max = 30)
	private String first_name;
	
	@NotBlank
    @Size(min = 1, max = 30)
	private String sur_name;
	
    @Size(min = 0, max = 30)
	private String middle_name;
    
    private Integer IC;
    
    @NotBlank
    @Size(min = 5, max = 50)
	private String email;
    
    @Size(min = 0, max = 20)
	private String phone;
	
	@Indexed(unique = true)
	private String user;
	
	@NotBlank
    @Size(min = 0, max = 20)
	private String pass;
	
	private String sex;
	
	@Size(min = 0, max = 200)
	private String address;
	
	@Size(min = 0, max = 50)
	private String city; 
	
	@DBRef
	private Country country_code;
	
	@Size(min = 0, max = 50)
	private String province;
	
	@DBRef
	private Role role;
	
	private long token;
	
	private LocalDate register_date;
	
	private Integer subscription;
	
	private Integer payment;
	
	public Register() {
		super();
	}


	public Register(long id) {
		super();
		this.id = id;
	}

	
	public Country getCountry_code() {
		return country_code;
	}


	public void setCountry_code(Country country_code) {
		this.country_code = country_code;
	}
	
	public Integer getSubscription() {
		return subscription;
	}


	public void setSubscription(Integer subscription) {
		this.subscription = subscription;
	}


	public Integer getPayment() {
		return payment;
	}


	public void setPayment(Integer payment) {
		this.payment = payment;
	}


	public Integer getIC() {
		return IC;
	}


	public void setIC(Integer iC) {
		IC = iC;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public LocalDate getRegister_date() {
		return register_date;
	}


	public void setRegister_date(LocalDate register_date) {
		this.register_date = register_date;
	}


	public long getid() {
		return id;
	}


	public void setid(long id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getSur_name() {
		return sur_name;
	}


	public void setSur_name(String sur_name) {
		this.sur_name = sur_name;
	}


	public String getMiddle_name() {
		return middle_name;
	}


	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public long getToken_id() {
		return token;
	}


	public void setToken_id(long token_id) {
		this.token = token_id;
	}


	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + first_name + ", sur_name=" + sur_name + ", middle_name=" + middle_name
				+ ", email=" + email + ", phone=" + phone + ", user=" + user + ", pass=" + pass + ", sex=" + sex
				+ ", address=" + address + ", city=" + city + ", role=" + role + ", token_id=" + token + "]";
	}
	
	
}

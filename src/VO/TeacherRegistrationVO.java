package VO;

import java.io.Serializable;
import java.util.Date;

public class TeacherRegistrationVO implements Serializable{
	
	private int teacherRegistrationId;
	private String firstName;
	private String middleName;
	private String LastName;
	
	private Long phone;
	private Date birthDate;
	private String gender;
	private String address;
	
	private String city;
	private String country;
	private int postcode;
	
	LoginVO loginVO;
	
	
	public int getTeacherRegistrationId() {
		return teacherRegistrationId;
	}

	public void setTeacherRegistrationId(int teacherRegistrationId) {
		this.teacherRegistrationId = teacherRegistrationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	

}

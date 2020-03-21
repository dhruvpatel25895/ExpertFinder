package VO;

import java.io.Serializable;

public class StudentRequirementVO implements Serializable {
	
	private int studentRequirementId;
	private String time;
	private String day;

	private CityVO cityVO;
	private AreaVO areaVO;
	private LoginVO loginVO;
	
	public int getStudentRequirementId() {
		return studentRequirementId;
	}
	public void setStudentRequirementId(int studentRequirementId) {
		this.studentRequirementId = studentRequirementId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public AreaVO getAreaVO() {
		return areaVO;
	}
	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
}

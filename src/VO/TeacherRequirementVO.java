package VO;

import java.io.Serializable;

public class TeacherRequirementVO implements Serializable {
	
	private int teacherRequirementId;
	private String time;
	private String day;

	private CityVO cityVO;
	private AreaVO areaVO;
	private LoginVO loginVO;
	
	
	
	public int getTeacherRequirementId() {
		return teacherRequirementId;
	}
	public void setTeacherRequirementId(int teacherRequirementId) {
		this.teacherRequirementId = teacherRequirementId;
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

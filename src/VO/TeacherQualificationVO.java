package VO;

import java.io.Serializable;

public class TeacherQualificationVO implements Serializable {

	private int teacherQualificationId;
	private String instituteName;
	private String experienceYear;
	private String experienceDescription;

	private LoginVO loginVO;

	public int getTeacherQualificationId() {
		return teacherQualificationId;
	}

	public void setTeacherQualificationId(int teacherQualificationId) {
		this.teacherQualificationId = teacherQualificationId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(String experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getExperienceDescription() {
		return experienceDescription;
	}

	public void setExperienceDescription(String experienceDescription) {
		this.experienceDescription = experienceDescription;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}

package VO;

import java.io.Serializable;
import java.util.Date;

public class DemoVO implements Serializable{
	
	private int demoId;
	
	private String time;
	private Date date;
	
	private String status;
	
	private LoginVO studentId;
	private LoginVO teacherId;
	
	private StudentRequirementVO studentRequirementId;
	
	private TeacherRequirementVO teacherRequirementId;
	
	
	
	
	public StudentRequirementVO getStudentRequirementId() {
		return studentRequirementId;
	}
	public void setStudentRequirementId(StudentRequirementVO studentRequirementId) {
		this.studentRequirementId = studentRequirementId;
	}
	
	public TeacherRequirementVO getTeacherRequirementId() {
		return teacherRequirementId;
	}
	public void setTeacherRequirementId(TeacherRequirementVO teacherRequirementId) {
		this.teacherRequirementId = teacherRequirementId;
	}
	public int getDemoId() {
		return demoId;
	}
	public void setDemoId(int demoId) {
		this.demoId = demoId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoginVO getStudentId() {
		return studentId;
	}
	public void setStudentId(LoginVO studentId) {
		this.studentId = studentId;
	}
	public LoginVO getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(LoginVO teacherId) {
		this.teacherId = teacherId;
	}
	
	
	

}

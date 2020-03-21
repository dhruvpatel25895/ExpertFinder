package VO;

import java.io.Serializable;

public class ApplyVO implements Serializable{
	
	private int applyId;
	private LoginVO studentId;
	private LoginVO teacherId;
	private StudentRequirementVO studentRequirementId;
	
private TeacherRequirementVO teacherRequirementId;
	
	public TeacherRequirementVO getTeacherRequirementId() {
	return teacherRequirementId;
}
public void setTeacherRequirementId(TeacherRequirementVO teacherRequirementId) {
	this.teacherRequirementId = teacherRequirementId;
}
	
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
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
	public StudentRequirementVO getStudentRequirementId() {
		return studentRequirementId;
	}
	public void setStudentRequirementId(StudentRequirementVO studentRequirementId) {
		this.studentRequirementId = studentRequirementId;
	}
	
	
	
	
	
	
	
	

}

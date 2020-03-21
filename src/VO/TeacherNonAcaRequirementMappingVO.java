package VO;

import java.io.Serializable;

public class TeacherNonAcaRequirementMappingVO implements Serializable {
	
	private int teacherNonAcaRequirementMappingId;
	private int nonAcademicFees;
	
	private CategoryVO  categoryVO;
	private  SubCategoryVO subCategoryVO;
	private NonAcademicSubjectVO nonAcademicSubjectVO;
	private TeacherRequirementVO teacherRequirementVO;
	private LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getTeacherNonAcaRequirementMappingId() {
		return teacherNonAcaRequirementMappingId;
	}
	public void setTeacherNonAcaRequirementMappingId(
			int teacherNonAcaRequirementMappingId) {
		this.teacherNonAcaRequirementMappingId = teacherNonAcaRequirementMappingId;
	}
	
	
	
	public int getNonAcademicFees() {
		return nonAcademicFees;
	}
	public void setNonAcademicFees(int nonAcademicFees) {
		this.nonAcademicFees = nonAcademicFees;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}
	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}
	public NonAcademicSubjectVO getNonAcademicSubjectVO() {
		return nonAcademicSubjectVO;
	}
	public void setNonAcademicSubjectVO(NonAcademicSubjectVO nonAcademicSubjectVO) {
		this.nonAcademicSubjectVO = nonAcademicSubjectVO;
	}
	public TeacherRequirementVO getTeacherRequirementVO() {
		return teacherRequirementVO;
	}
	public void setTeacherRequirementVO(TeacherRequirementVO teacherRequirementVO) {
		this.teacherRequirementVO = teacherRequirementVO;
	}
	
	
	
	
}

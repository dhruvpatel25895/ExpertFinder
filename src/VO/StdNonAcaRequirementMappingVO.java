package VO;

import java.io.Serializable;

public class StdNonAcaRequirementMappingVO implements Serializable {
	
	private int stdNonAcaRequirementMappingId;
	
	private CategoryVO  categoryVO;
	private  SubCategoryVO subCategoryVO;
	private NonAcademicSubjectVO nonAcademicSubjectVO;
	private StudentRequirementVO studentRequirementVO;
	private LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getStdNonAcaRequirementMappingId() {
		return stdNonAcaRequirementMappingId;
	}
	public void setStdNonAcaRequirementMappingId(int stdNonAcaRequirementMappingId) {
		this.stdNonAcaRequirementMappingId = stdNonAcaRequirementMappingId;
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
	public StudentRequirementVO getStudentRequirementVO() {
		return studentRequirementVO;
	}
	public void setStudentRequirementVO(StudentRequirementVO studentRequirementVO) {
		this.studentRequirementVO = studentRequirementVO;
	}
	
	
	
	
}

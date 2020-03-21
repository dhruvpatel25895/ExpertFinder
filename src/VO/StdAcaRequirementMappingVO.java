package VO;

import java.io.Serializable;

public class StdAcaRequirementMappingVO implements Serializable{
	
	private int stdAcaRequirementMappingId;
	
	private CategoryVO categoryVO;
	private SubCategoryVO subCategoryVO;
	private MediumVO mediumVO;
	private StandardVO standardVO;
	private AcademicSubjectVO academicSubjectVO;
	private StudentRequirementVO studentRequirementVO;
	private LoginVO loginVO;
	
	
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getStdAcaRequirementMappingId() {
		return stdAcaRequirementMappingId;
	}
	public void setStdAcaRequirementMappingId(int stdAcaRequirementMappingId) {
		this.stdAcaRequirementMappingId = stdAcaRequirementMappingId;
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
	public MediumVO getMediumVO() {
		return mediumVO;
	}
	public void setMediumVO(MediumVO mediumVO) {
		this.mediumVO = mediumVO;
	}
	public StandardVO getStandardVO() {
		return standardVO;
	}
	public void setStandardVO(StandardVO standardVO) {
		this.standardVO = standardVO;
	}
	public AcademicSubjectVO getAcademicSubjectVO() {
		return academicSubjectVO;
	}
	public void setAcademicSubjectVO(AcademicSubjectVO academicSubjectVO) {
		this.academicSubjectVO = academicSubjectVO;
	}
	public StudentRequirementVO getStudentRequirementVO() {
		return studentRequirementVO;
	}
	public void setStudentRequirementVO(StudentRequirementVO studentRequirementVO) {
		this.studentRequirementVO = studentRequirementVO;
	}
	
	
	
	
	
	
	

}

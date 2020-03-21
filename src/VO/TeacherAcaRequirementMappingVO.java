package VO;

import java.io.Serializable;

public class TeacherAcaRequirementMappingVO implements Serializable {
	
	private int teacherAcaRequirementMappingId;
	private int academicFees;
	
	private CategoryVO categoryVO;
	private SubCategoryVO subCategoryVO;
	private MediumVO mediumVO;
	private StandardVO standardVO;
	private AcademicSubjectVO academicSubjectVO;
	private TeacherRequirementVO teacherRequirementVO;
	private LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getTeacherAcaRequirementMappingId() {
		return teacherAcaRequirementMappingId;
	}
	public void setTeacherAcaRequirementMappingId(int teacherAcaRequirementMappingId) {
		this.teacherAcaRequirementMappingId = teacherAcaRequirementMappingId;
	}
	
	
	
	
	public int getAcademicFees() {
		return academicFees;
	}
	public void setAcademicFees(int academicFees) {
		this.academicFees = academicFees;
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
	public TeacherRequirementVO getTeacherRequirementVO() {
		return teacherRequirementVO;
	}
	public void setTeacherRequirementVO(TeacherRequirementVO teacherRequirementVO) {
		this.teacherRequirementVO = teacherRequirementVO;
	}
	
	
	
	
	

}

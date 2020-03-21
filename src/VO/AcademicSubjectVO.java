package VO;

import java.io.Serializable;

public class AcademicSubjectVO implements Serializable {
	
	private int academicSubjectId;
	private String academicSubjectName;
	private String academicSubjectDesc;
	
	SubCategoryVO subCategoryVO;
	MediumVO mediumVO;
	StandardVO standardVO;
	
	
	public int getAcademicSubjectId() {
		return academicSubjectId;
	}
	public void setAcademicSubjectId(int academicSubjectId) {
		this.academicSubjectId = academicSubjectId;
	}
	public String getAcademicSubjectName() {
		return academicSubjectName;
	}
	public void setAcademicSubjectName(String academicSubjectName) {
		this.academicSubjectName = academicSubjectName;
	}
	public String getAcademicSubjectDesc() {
		return academicSubjectDesc;
	}
	public void setAcademicSubjectDesc(String academicSubjectDesc) {
		this.academicSubjectDesc = academicSubjectDesc;
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
	
		
	

	
	
}

package VO;

import java.io.Serializable;

public class NonAcademicSubjectVO implements Serializable {
	
	private int nonAcademicSubjectId;
	private String nonAcademicSubjectName;
	private String nonAcademicSubjectDesc;
	
	SubCategoryVO subCategoryVO;

	public int getNonAcademicSubjectId() {
		return nonAcademicSubjectId;
	}

	public void setNonAcademicSubjectId(int nonAcademicSubjectId) {
		this.nonAcademicSubjectId = nonAcademicSubjectId;
	}

	public String getNonAcademicSubjectName() {
		return nonAcademicSubjectName;
	}

	public void setNonAcademicSubjectName(String nonAcademicSubjectName) {
		this.nonAcademicSubjectName = nonAcademicSubjectName;
	}

	public String getNonAcademicSubjectDesc() {
		return nonAcademicSubjectDesc;
	}

	public void setNonAcademicSubjectDesc(String nonAcademicSubjectDesc) {
		this.nonAcademicSubjectDesc = nonAcademicSubjectDesc;
	}

	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}

	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}

	

	
}

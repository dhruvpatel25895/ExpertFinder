package VO;

import java.io.Serializable;

public class MediumVO implements Serializable {
	
	private int mediumId;
	private String mediumName;
	
	SubCategoryVO subCategoryVO;

	

	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}

	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}

	public int getMediumId() {
		return mediumId;
	}

	public void setMediumId(int mediumId) {
		this.mediumId = mediumId;
	}

	public String getMediumName() {
		return mediumName;
	}

	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}

	
}

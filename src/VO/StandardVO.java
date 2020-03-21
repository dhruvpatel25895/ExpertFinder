package VO;

import VO.SubCategoryVO;
import VO.MediumVO;

import java.io.Serializable;

public class StandardVO implements Serializable {
	
	private int standardId;
	private String standardName;
	private String standardDesc;
	
	SubCategoryVO subCategoryVO;
	MediumVO mediumVO;
	
	public int getStandardId() {
		return standardId;
	}
	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public String getStandardDesc() {
		return standardDesc;
	}
	public void setStandardDesc(String standardDesc) {
		this.standardDesc = standardDesc;
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
	
	

	
	
}

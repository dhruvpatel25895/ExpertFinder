package VO;

import java.io.Serializable;

public class TeacherQualificationFileUploadVO implements Serializable {
	
	private int teacherQualificationFileUploadId;
	private String fileName;
	private String filePath;
	private String fileDescription;
	private LoginVO loginVO;
	
	private TeacherQualificationVO teacherQualificationVO;
	

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getTeacherQualificationFileUploadId() {
		return teacherQualificationFileUploadId;
	}

	public void setTeacherQualificationFileUploadId(
			int teacherQualificationFileUploadId) {
		this.teacherQualificationFileUploadId = teacherQualificationFileUploadId;
	}

	
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public TeacherQualificationVO getTeacherQualificationVO() {
		return teacherQualificationVO;
	}

	public void setTeacherQualificationVO(
			TeacherQualificationVO teacherQualificationVO) {
		this.teacherQualificationVO = teacherQualificationVO;
	}
	
	
		
	
	
	
	
	

}

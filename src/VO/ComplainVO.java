package VO;

public class ComplainVO {
	
	private int complainId;
	private String complainName;
	private String complainDesc;
	
	private LoginVO toUserId;
	private LoginVO FromUserId;
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getComplainName() {
		return complainName;
	}
	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}
	public String getComplainDesc() {
		return complainDesc;
	}
	public void setComplainDesc(String complainDesc) {
		this.complainDesc = complainDesc;
	}
	public LoginVO getToUserId() {
		return toUserId;
	}
	public void setToUserId(LoginVO toUserId) {
		this.toUserId = toUserId;
	}
	public LoginVO getFromUserId() {
		return FromUserId;
	}
	public void setFromUserId(LoginVO fromUserId) {
		FromUserId = fromUserId;
	}
	
	
	
	
}

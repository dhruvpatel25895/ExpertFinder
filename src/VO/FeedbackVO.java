package VO;

public class FeedbackVO {
	
	private int feedbackId;
	private String feedbackName;
	private String feedbackDesc;
	private String rating;
	
	
	private LoginVO toUserId;
	private LoginVO FromUserId;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFeedbackName() {
		return feedbackName;
	}
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	public String getFeedbackDesc() {
		return feedbackDesc;
	}
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
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

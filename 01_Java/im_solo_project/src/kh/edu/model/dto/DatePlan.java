package kh.edu.model.dto;

public class DatePlan {
	private String Applicant;
	private String receiver;
	private String dayInfo;

	public DatePlan() {
	}
	

	public DatePlan(String applicant, String receiver, String dayInfo) {
		super();
		Applicant = applicant;
		this.receiver = receiver;
		this.dayInfo = dayInfo;
	}


	public String getApplicant() {
		return Applicant;
	}

	public void setApplicant(String applicant) {
		Applicant = applicant;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getDayInfo() {
		return dayInfo;
	}

	public void setDayInfo(String dayInfo) {
		this.dayInfo = dayInfo;
	}

}

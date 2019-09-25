package com.mavin.egifting.dto;

public class EmailDto {

	private String toEmail;
	private String fromEmail;
	private String emailSubject;

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	@Override
	public String toString() {
		return "EmailDto [toEmail=" + toEmail + ", fromEmail=" + fromEmail + ", emailSubject=" + emailSubject
				+ ", getToEmail()=" + getToEmail() + ", getFromEmail()=" + getFromEmail() + ", getEmailSubject()="
				+ getEmailSubject() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}

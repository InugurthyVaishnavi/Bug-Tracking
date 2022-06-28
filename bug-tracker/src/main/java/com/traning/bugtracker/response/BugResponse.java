package com.traning.bugtracker.response;

import java.util.Date;

import lombok.Data;

@Data
public class BugResponse {
	
	private Long id;
	
	private String bugDescription;
	
	private String createdBy;
	
	private String status;
	
	private Date createdDate;

}

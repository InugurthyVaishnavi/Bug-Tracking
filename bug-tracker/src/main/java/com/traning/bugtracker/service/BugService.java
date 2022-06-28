package com.traning.bugtracker.service;

import java.util.List;

import com.traning.bugtracker.entity.Bug;
import com.traning.bugtracker.response.BugResponse;
import com.traning.bugtracker.response.ErrorResponse;

public interface BugService {
	
	public BugResponse createBug(Bug bug);
	
	public List<BugResponse> listAllBugs();
	
	public BugResponse getBugDetailsById(Long id);
	
	public ErrorResponse deleteBug(Long id);

	
}

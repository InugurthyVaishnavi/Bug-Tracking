package com.traning.bugtracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traning.bugtracker.entity.Bug;
import com.traning.bugtracker.exceptions.ValidationExecption;
import com.traning.bugtracker.repository.BugRepository;
import com.traning.bugtracker.response.BugResponse;
import com.traning.bugtracker.response.ErrorResponse;
import com.traning.bugtracker.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	@Autowired
	private BugRepository bugRepository;

	@Override
	public BugResponse createBug(Bug bug)  {
		verifyBugRequest(bug);//verify the request
		
		if (bug.getId() == null) {//means new request
			bug.setCreatedDate(new Date());
			return setBugResponse(bugRepository.save(bug));
		} else {//update req
			Bug update = bugRepository.getReferenceById(bug.getId());
			
			if(bug.getBugDescription()!=null && bug.getBugDescription()!="") {
				update.setBugDescription(bug.getBugDescription());
			}
			if(bug.getStatus()!=null ) {
				update.setStatus(bug.getStatus());
			}
			
			if(bug.getCreatedBy()!=null) {
				update.setCreatedBy(bug.getCreatedBy());
			}
			
			return setBugResponse(bugRepository.save(update));
		}
	}

	@Override
	public List<BugResponse> listAllBugs() { 
		List<BugResponse> bugResponse = new ArrayList<>();
		for(Bug bug :  bugRepository.findAll()) {
			bugResponse.add(setBugResponse(bug));
		}
		return bugResponse;
	}

	@Override
	public BugResponse getBugDetailsById(Long id) {
		Bug bug = bugRepository.getReferenceById(id);
		return setBugResponse(bug);
	}
	
	
	private BugResponse setBugResponse(Bug bug) {
		BugResponse response = new BugResponse();
		response.setBugDescription(bug.getBugDescription());
		response.setCreatedBy(bug.getCreatedBy().getFirstName());
		response.setCreatedDate(bug.getCreatedDate());
		response.setId(bug.getId());
		response.setStatus(bug.getStatus().getStatus());
		return response;
	}
	
	private void verifyBugRequest(Bug bug)   {
		
		if(Strings.isEmpty(bug.getBugDescription())) {
			throw new ValidationExecption("Bug Description is Empty");
		}
		
		if(bug.getStatus()==null || Strings.isEmpty(bug.getStatus().getStatus())) {
			throw new ValidationExecption("Bug Status should not be  Empty");
		}
		
		if(bug.getCreatedBy()==null) {
			throw new ValidationExecption("Created by should not be Empty");
		}
		
	}

	@Override
	public ErrorResponse deleteBug(Long id) {
		ErrorResponse response = new ErrorResponse();
		Bug bug = bugRepository.getReferenceById(id);
		bugRepository.delete(bug);
		response.setCode("200");
		response.setMessage("Bug is deleted successfully");
		return response;
	}

}

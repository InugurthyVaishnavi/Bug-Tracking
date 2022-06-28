package com.traning.bugtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traning.bugtracker.entity.Bug;
import com.traning.bugtracker.response.BugResponse;
import com.traning.bugtracker.response.ErrorResponse;
import com.traning.bugtracker.service.BugService;

/**
 * @author vinugurt
 *
 */
@RestController
@RequestMapping(path = "/bug")
public class BugController {

	@Autowired
	private BugService bugService;

	

	/**
	 * @return list of bugs
	 */
	@GetMapping(path = "/list")
	private List<BugResponse> listAllBugs() {
		return bugService.listAllBugs();
	}

	/**
	 * @param bug id 
	 * @return bugDetails
	 */
	@GetMapping(path = "/bug/{id}")
	private BugResponse getBugDetailsById(@PathVariable  Long  id) {
		return bugService.getBugDetailsById(id);
	}
	
	/**@param create
	 * @return createBug
	 */
	@PostMapping(path = "/create")
	public BugResponse createBug(@RequestBody Bug bug) {
		return bugService.createBug(bug);
	}

	/**@param update
	 * @return updateBug
	 */
	@PutMapping(path = "/update")
	public BugResponse updateBug(@RequestBody Bug bug){
		return bugService.createBug(bug);
	}
	
	
	/**@param delete
	 * @return deleteBug
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ErrorResponse deleteBug(@PathVariable  Long  id){
		return bugService.deleteBug(id);
	}
	
	//As per the requirement
	/**@param update
	 * @return updateStatus
	 */
	@PutMapping(path = "/updateStatus")
	public BugResponse updateStatus(@RequestBody Bug bug){
		return bugService.createBug(bug);
	}
	
	/**@param update
	 * @return updateBugWithEmp
	 */
	@PutMapping(path = "/updateBugWithEmp")
	public BugResponse updateBugWithEmp(@RequestBody Bug bug) {
		return bugService.createBug(bug);
	}
	
	

}

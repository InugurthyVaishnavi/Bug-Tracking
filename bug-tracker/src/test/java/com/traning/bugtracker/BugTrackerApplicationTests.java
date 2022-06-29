package com.traning.bugtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.traning.bugtracker.entity.Bug;
import com.traning.bugtracker.entity.BugStatus;
import com.traning.bugtracker.entity.Employee;
import com.traning.bugtracker.response.BugResponse;
import com.traning.bugtracker.service.BugService;

@SpringBootTest
class BugTrackerApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	BugService bugService;

	@Test
	@Disabled
	void testListOfBugs()
	{

	}
	@Test
	@Disabled
	void testBugById()
	{
////		{
//		  "id": 1,
//		  "bugDescription": "Test Bug 1111",
//		  "createdBy": null,
//		  "status": "In Progress",
//		  "createdDate": "2022-06-27T12:12:49.445+00:00"
//		}
		
		BugResponse bugResponse = bugService.getBugDetailsById(1L);
		
		assertEquals("Test Bug 1111",bugResponse.getBugDescription());
		assertEquals("In Progress",bugResponse.getStatus());
//		assertEquals("2022-06-27T12:12:49.445+00:00",bugResponse.getCreatedDate());
		assertEquals(1,bugResponse.getId());
		
	}
	
	@Test
	@Disabled
	void createBug()
	{
	
		Bug bug = new Bug();
		
		bug.setBugDescription("This is testing by vaishu");
		Employee empl = new Employee();
		empl.setId(1L);
		bug.setCreatedBy(empl);
		BugStatus status = new BugStatus();
		status.setId(2L);
		status.setStatus("In Progress");
		bug.setStatus(status);
		
		
		BugResponse bugRespone = bugService.createBug(bug);
		assertEquals("In Progress",bugRespone.getStatus());
		
		
	}
	
	@Test
	
	void upadteALLDetailsBug()
	{
		
     Bug bug = new Bug();
     	bug.setId(1L);
		bug.setBugDescription("This is testing by vaishu update");
		Employee empl = new Employee();
		empl.setId(1L);
		bug.setCreatedBy(empl);
		BugStatus status = new BugStatus();
		status.setId(4L);
		status.setStatus("Review");
		bug.setStatus(status);
		
		
		BugResponse bugRespone = bugService.createBug(bug);
		assertEquals("Review",bugRespone.getStatus());
		
	}
	
	
	@Test
	@Disabled
	void updateBugStatus()
	{
		 Bug bug = new Bug();
			
			bug.setBugDescription("This is testing by vaishu");
			Employee empl = new Employee();
			empl.setId(1L);
			bug.setCreatedBy(empl);
			BugStatus status = new BugStatus();
			status.setId(2L);
			status.setStatus("In Progress");
			bug.setStatus(status);
			
			
			BugResponse bugRespone = bugService.createBug(bug);
			assertEquals("In Progress",bugRespone.getStatus());
			
		}
		
		
		
		

	
	
	@Test
	@Disabled
	void updateBugCreatedBy()
	{
		
Bug bug = new Bug();
		
		bug.setBugDescription("This is testing by vaishu");
		Employee empl = new Employee();
		empl.setId(1L);
		bug.setCreatedBy(empl);
		BugStatus status = new BugStatus();
		status.setId(2L);
		status.setStatus("In Progress");
		bug.setStatus(status);
		
		
		BugResponse bugRespone = bugService.createBug(bug);
		assertEquals("In Progress",bugRespone.getStatus());
		
		
	
	}



}

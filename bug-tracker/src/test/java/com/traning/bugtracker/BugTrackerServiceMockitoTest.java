package com.traning.bugtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.traning.bugtracker.entity.Bug;
import com.traning.bugtracker.entity.BugStatus;
import com.traning.bugtracker.entity.Employee;
import com.traning.bugtracker.exceptions.BugExecption;
import com.traning.bugtracker.repository.BugRepository;
import com.traning.bugtracker.response.BugResponse;
import com.traning.bugtracker.service.BugService;
import com.traning.bugtracker.service.impl.BugServiceImpl;





@ExtendWith(SpringExtension.class)
public class BugTrackerServiceMockitoTest {

	 @InjectMocks BugServiceImpl bugServiceImpl;
	 
	 @MockBean	BugRepository bugRepo;
		
    
 // @MockBean - Creates Mock of a class or interface
// 		
 		
 		// Initialization of mock objects
 		@BeforeEach
 		void init() {
 			MockitoAnnotations.openMocks(this);
 		}
	
 		

		@Test
		void testGetBugById() throws  BugExecption {
			
//			BugResponse response = new BugResponse();
//			Mockito.when(bugServiceImpl.getBugDetailsById(2L));
			
			
		
			
			Bug bug = new Bug();
			Employee empl = new Employee();
			empl.setId(1L);
			BugStatus status = new BugStatus();
			status.setId(1L);
			status.setStatus("Open");
			bug.setBugDescription("This is test from mokito");
			
			bug.setCreatedBy(empl);
			
			bug.setStatus(status);
			
			when(bugRepo.getReferenceById(8L)).thenReturn(bug);
			
				

			BugResponse bugRespnse = bugServiceImpl.getBugDetailsById(8L);

			assertEquals("This is test from mokito", bugRespnse.getBugDescription());
		


		}
 		
 		
 		
	
}

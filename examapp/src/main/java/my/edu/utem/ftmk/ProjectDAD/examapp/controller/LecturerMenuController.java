package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Lecturer;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@Controller
public class LecturerMenuController {

	@GetMapping("/lecturer/list")
	public String getLecturer(Model model){
		
		//URI get order types
		String uri ="http://localhost:8080/examapp/api/lecturers";
		
		//get list order types from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Lecturer[]> response = 
				restTemplate.getForEntity(uri, Lecturer[].class);
		
		//Parse JSON data to array of object
		Lecturer lecturers[]=response.getBody();

		//Parse array to a list object
		List<Lecturer> lecturersList = Arrays.asList(lecturers);
		
		//Attach list to model as attribute
		model.addAttribute("lecturers",lecturersList);
		
		return "lecturers";
	}
	
}

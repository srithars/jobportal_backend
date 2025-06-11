package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.modal.Jobs;
import klu.modal.JobsManager;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "*")
public class JobsController {
	
	@Autowired
	JobsManager JM;
	
	@PostMapping("/save")
	public String save(@RequestBody Jobs J)
	{
		return JM.saveJob(J);
	}
	
	@GetMapping("/getjobs")
	public String getJobs()
	{
		return JM.getJobs();
	}
	
	@GetMapping("/getdata/{id}")
	public String getData(@PathVariable("id") Long ID)
	{
		return JM.getData(ID);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long ID)
	{
		return JM.deleteJob(ID);
	}
	
	@GetMapping("/getjobsbypage/{cpage}")
	public String getJobsByPage(@PathVariable("cpage") int CPAGE)
	{
		return JM.getJobsByPage(CPAGE);
	}
}

package klu.modal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;

import klu.repository.JobsRepository;

@Service
public class JobsManager {

	@Autowired
	JobsRepository JR;
	
	//INERT INTO DATABASE
	public String saveJob(Jobs J)
	{
		try
		{
			Long id = J.getId();
			
			JR.save(J); //INSERT
			
			if(id == null)
				return "200::New job has been created";
			else
				return "200::Job details has been updated";
		}catch(Exception e)
		{
			return "404::" + e.getMessage();
		}
	}
	
	//READ FROM DATABASE
	public String getJobs()
	{
		try
		{
			List<Jobs> jobsList = JR.findAll();
			return new GsonBuilder().create().toJson(jobsList);
		}catch (Exception e) 
		{
			return "404::" + e.getMessage();
		}
	}
	
	//READ ONE RECORD BASED ON PRIMARY KEY
	public String getData(Long id)
	{
		try
		{
			Jobs J = JR.findById(id).get();
			return new GsonBuilder().create().toJson(J);
		}catch(Exception e)
		{
			return "404::" + e.getMessage();
		}
	}
	
	//DELETE OPERATION
	public String deleteJob(Long id)
	{
		try
		{
			JR.deleteById(id);
			return "200::Deleted";
		}catch(Exception e)
		{
			return "404::" + e.getMessage();
		}
	}
	
	//READ BASED ON PAGE NO FROM DATABASE
	public String getJobsByPage(int cpage)
	{
		try
		{
			List<Jobs> jobList = JR.findAll(PageRequest.of(cpage, 4)).toList();
			return new GsonBuilder().create().toJson(jobList);
		}catch(Exception e)
		{
			return "404::" + e.getMessage();
		}
	}
}

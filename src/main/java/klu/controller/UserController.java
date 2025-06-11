package klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.modal.EmailManager;
import klu.modal.User;
import klu.modal.UserManager;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserManager UM;
	
	@Autowired
	EmailManager EM;
	
	@PostMapping("/signup")
	public String signup(@RequestBody User U)
	{
		return UM.insertData(U);
	}
	
	@PostMapping("/forgotpassword")
	public String forgotPassword(@RequestBody User U)
	{
		return UM.getPassword(U.getEmailid());
	}
	
	@PostMapping("/signin")
	public String signIn(@RequestBody User U)
	{
		return UM.signIn(U.getEmailid(), U.getPassword());
	}
	
	@PostMapping("/getfullname")
	public String getFullName(@RequestBody Map<String, String> data)
	{
		return UM.getFullName(data.get("csrid"));
	}
}

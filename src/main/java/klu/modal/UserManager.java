package klu.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klu.repository.UserRepository;

@Service
public class UserManager {

	@Autowired
	UserRepository UR;
	
	@Autowired
	EmailManager EM;
	
	@Autowired
	JwtManager JWT;
	
	//INSERT
	public String insertData(User U)
	{
		if(UR.validateEmail(U.getEmailid()) > 0)
			return "401::Email ID already exist!";
		
		UR.save(U); //INSERT INTO DATABASE
		return "200::User has been Registered";
	}
	
	//PASSWORD RECOVERY
	public String getPassword(String emailid)
	{
		User U = UR.findById(emailid).get();
		String subject = "Job Portal:Password Recovery";
		String message = "Dear " + U.getFullname() + "\n\nYour Password is " + U.getPassword();
		return EM.sendEmail(emailid, subject, message);
	}
	
	//SignIn
	public String signIn(String username, String password)
	{
		if(UR.validateCredentials(username, password) == 0)
			return "404::Invalid Credentials";
		
		return "200::" + JWT.generateJWT(username);
	}
	
	//Fetch user's fullname from database
	public String getFullName(String token)
	{
		String emailid = JWT.validateJWT(token);
		if(emailid == "401")
			return "401::Invalid Token";
		
		User U = UR.findById(emailid).get();
		return "200::" + U.getFullname();
	}
}

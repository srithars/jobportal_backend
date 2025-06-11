package klu.modal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;

import klu.repository.MenusRepository;
import klu.repository.UserRepository;

@Service
public class MenusManager {
	
	@Autowired
	MenusRepository MR;
	
	@Autowired
	JwtManager JWT;
	
	@Autowired
	UserRepository UR;
	
	//Get ALL Menu Items
	public String getMenuItems()
	{
		List<String> mlist = new ArrayList<String>();
		for(Menus M : MR.findAll())
		{
			String tmp = new GsonBuilder().create().toJson(M);
			mlist.add(tmp);
		}
		return mlist.toString();
	}
	
	//Get Menu Items based on user Role
	public String getMenuItemsByRole(String token)
	{
		String emailid = JWT.validateJWT(token);
		if(emailid.equals("401"))
			return "401::Invalid Token";
		
		User U = UR.findById(emailid).get();
		List<Menus> menuList = MR.findByRole(U.getRole());
		return new GsonBuilder().create().toJson(menuList);
	}
}

package klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.modal.MenusManager;

@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "*")
public class MenusController {
	
	@Autowired
	MenusManager MM;
	
	@PostMapping("/getmenuitems")
	public String getMenuItems()
	{
		return MM.getMenuItems();
	}
	
	@PostMapping("/getmenusbyrole")
	public String getMenusByRole(@RequestBody Map<String, String> data)
	{
		return MM.getMenuItemsByRole(data.get("csrid"));
	}
}

package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.SkillsModel;
import com.tracker.service.intf.ISkillService;

@CrossOrigin("http://localhost:4200")
@RestController
public class AddSkillController {

	@Autowired
	private ISkillService skillService;
	
	@RequestMapping(value="/addSkill",method=RequestMethod.POST)
	public String addSkill(@RequestBody SkillsModel skillsModel) {
		System.out.println("*****************************************");
		System.out.println("skillsModel : " + skillsModel);
		System.out.println("*****************************************");
		String responseString = null;
		try {
			responseString = skillService.addSkill(skillsModel);
		}catch(Exception e) {
			//throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
}

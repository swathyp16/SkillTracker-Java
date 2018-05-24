package com.skill.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.tracker.model.SkillsModel;
import com.skill.tracker.service.intf.ISkillService;

@CrossOrigin
@RestController
public class AddSkillController {

	@Autowired
	private ISkillService skillService;
	
	
	@RequestMapping(value="/addSkill",method=RequestMethod.POST)
	public String createCategory(@RequestBody SkillsModel skillsModel) {
		String responseString = null;
		try {
			responseString = skillService.addSkill(skillsModel);
		}catch(Exception e) {
			//throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
}

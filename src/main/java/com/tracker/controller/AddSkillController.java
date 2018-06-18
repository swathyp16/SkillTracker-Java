package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.SkillsModel;
import com.tracker.service.intf.ISkillService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddSkillController.
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class AddSkillController {

	/** The skill service. */
	@Autowired
	private ISkillService skillService;
	
	/**
	 * Adds the skill.
	 *
	 * @param skillsModel the skills model
	 * @return the string
	 */
	@RequestMapping(value="/skillTracker/addSkill",method=RequestMethod.POST)
	public String addSkill(@RequestBody SkillsModel skillsModel) {
		String responseString = null;
		try {
			responseString = skillService.addSkill(skillsModel);
		}catch(Exception e) {
			//throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
	
	/**
	 * View all skills.
	 *
	 * @return the list
	 */
	@RequestMapping(value="/skillTracker/viewAllSkills",method=RequestMethod.GET)
	public List<SkillsModel> viewAllSkills() {
		List<SkillsModel> skillList = new ArrayList<SkillsModel>();
		try {
			skillList = skillService.viewAllSkills();
		}catch(Exception e) {
			//throw new BusinessException(e.toString());
		}
		return skillList;
		
	}
	
	/**
	 * Delete skill.
	 *
	 * @param skillsModel the skills model
	 * @return the string
	 */
	@RequestMapping(value="/skillTracker/deleteSkill",method=RequestMethod.POST)
	public String deleteSkill(@RequestBody SkillsModel skillsModel) {
		String responseString = null;
		try {
			responseString = skillService.deleteSkill(skillsModel);
		}catch(Exception e) {
			//throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
}

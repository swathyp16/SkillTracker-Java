package com.tracker.service.intf;

import java.util.List;

import com.tracker.model.SkillsModel;

public interface ISkillService {

	String addSkill(SkillsModel skillsModel);
	
	List<SkillsModel> viewAllSkills();
	
	String deleteSkill(SkillsModel skillsModel);
}

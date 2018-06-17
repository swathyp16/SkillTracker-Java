package com.tracker.service.intf;

import java.util.List;

import com.tracker.model.SkillsModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISkillService.
 */
public interface ISkillService {

	/**
	 * Adds the skill.
	 *
	 * @param skillsModel the skills model
	 * @return the string
	 */
	String addSkill(SkillsModel skillsModel);
	
	/**
	 * View all skills.
	 *
	 * @return the list
	 */
	List<SkillsModel> viewAllSkills();
	
	/**
	 * Delete skill.
	 *
	 * @param skillsModel the skills model
	 * @return the string
	 */
	String deleteSkill(SkillsModel skillsModel);
}

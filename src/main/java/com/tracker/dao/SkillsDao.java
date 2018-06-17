package com.tracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.SkillsEntity;
import com.tracker.repository.SkillsRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillsDao.
 */
@Component
public class SkillsDao {
	
	/** The skills repository. */
	@Autowired
	private SkillsRepository skillsRepository;
	
	
	/**
	 * Adds the skills.
	 *
	 * @param skillsEntity the skills entity
	 */
	public void addSkills(SkillsEntity skillsEntity) {
		skillsRepository.save(skillsEntity);
	}
	
	/**
	 * View all skills.
	 *
	 * @return the list
	 */
	public List<SkillsEntity> viewAllSkills() {
		List<SkillsEntity> skillList = skillsRepository.findAll();
		return skillList;
	}
	
	
	/**
	 * Delete skill.
	 *
	 * @param skillsId the skills id
	 */
	public void deleteSkill(int skillsId) {
		skillsRepository.deleteById(skillsId);
	}
	
	/**
	 * Fetch associate skill names by id.
	 *
	 * @param associateSkillIdList the associate skill id list
	 * @return the list
	 */
	public List<SkillsEntity> fetchAssociateSkillNamesById(List<Integer> associateSkillIdList) {
		return skillsRepository.findSkillNameById(associateSkillIdList);
	}
	

}

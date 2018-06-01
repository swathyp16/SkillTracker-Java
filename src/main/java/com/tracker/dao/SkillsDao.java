package com.tracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.SkillsEntity;
import com.tracker.repository.SkillsRepository;

@Component
public class SkillsDao {
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	
	public void addSkills(SkillsEntity skillsEntity) {
		skillsRepository.save(skillsEntity);
	}
	
	public List<SkillsEntity> viewAllSkills() {
		List<SkillsEntity> skillList = skillsRepository.findAll();
		return skillList;
	}
	
	
	public void deleteSkill(int skillsId) {
		skillsRepository.deleteById(skillsId);
	}
	
	public List<SkillsEntity> fetchAssociateSkillNamesById(List<Integer> associateSkillIdList) {		
		return skillsRepository.findSkillNameById(associateSkillIdList);
	}
	

}

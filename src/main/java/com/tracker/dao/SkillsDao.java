package com.tracker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.SkillsEntity;
import com.tracker.repository.SkillsRepository;

@Component
public class SkillsDao {
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	
	public void addSkills(SkillsEntity skillsEntity) {
		System.out.println("skillsEntity : " + skillsEntity.toString());
		skillsRepository.save(skillsEntity);
	}

}

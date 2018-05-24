package com.skill.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skill.tracker.dao.SkillsDao;
import com.skill.tracker.model.SkillsModel;

@Component
public class SkillServiceImpl {
	
	@Autowired
	private SkillsDao skillsDao;

	public String addSkill(SkillsModel skillsModel) {
		return null;
		
	}
}

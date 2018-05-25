package com.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.SkillsDao;
import com.tracker.entity.SkillsEntity;
import com.tracker.model.SkillsModel;
import com.tracker.service.intf.ISkillService;

@Component
public class SkillServiceImpl implements ISkillService{
	
	@Autowired
	private SkillsDao skillsDao;

	public String addSkill(SkillsModel skillsModel) {
		SkillsEntity skillsEntity = new SkillsEntity();
		skillsEntity.setSkillName(skillsModel.getSkillName());
		skillsDao.addSkills(skillsEntity);
		return CommonConstants.SUCCESS_STRING; 
		
	}
}

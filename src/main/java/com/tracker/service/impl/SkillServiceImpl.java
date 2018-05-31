package com.tracker.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		if(Integer.toString(skillsModel.getSkillId())!= null) {
			skillsEntity.setSkillId(skillsModel.getSkillId());
		}
		skillsEntity.setSkillName(skillsModel.getSkillName());
		skillsDao.addSkills(skillsEntity);
		return CommonConstants.SUCCESS_STRING; 
		
	}
	
	public List<SkillsModel> viewAllSkills() {
		 List<SkillsEntity> skillList = skillsDao.viewAllSkills();
		 List<SkillsModel> skillsModelList = new ArrayList<SkillsModel>(); 
		 SkillsModel skillsModel = null;
		 for(SkillsEntity skillsEntity : skillList) {
			 skillsModel = new SkillsModel();
			 skillsModel.setSkillId(skillsEntity.getSkillId());
			 skillsModel.setSkillName(skillsEntity.getSkillName());
			 skillsModelList.add(skillsModel);
		 }
		return skillsModelList; 
		
	}
	
	public String deleteSkill(SkillsModel skillsModel){
		SkillsEntity skillsEntity = new SkillsEntity();
		skillsEntity.setSkillId(skillsModel.getSkillId());
		skillsDao.deleteSkill(skillsEntity.getSkillId());
		return CommonConstants.SUCCESS_STRING; 
	}
}

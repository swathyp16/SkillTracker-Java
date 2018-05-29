package com.tracker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.AssociateEntity;
import com.tracker.entity.AssociateSkillsEntity;
import com.tracker.repository.AssociateRepository;
import com.tracker.repository.AssociateSkillsRepository;

@Component
public class AssociateDao {

	@Autowired
	private AssociateRepository associateRepository;
	
	@Autowired
	private AssociateSkillsRepository associateSkillsRepository;
	
	
	public void addAssociate(AssociateEntity associateEntity) {
		associateRepository.save(associateEntity);
	}
	
	public void addAssociateSkills(AssociateSkillsEntity associateSkillsEntity) {
		associateSkillsRepository.save(associateSkillsEntity);
	}
	
	
}

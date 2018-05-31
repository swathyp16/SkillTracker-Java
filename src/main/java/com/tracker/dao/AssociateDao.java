package com.tracker.dao;

import java.util.List;

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
	
	public void addAssociateSkills(List<AssociateSkillsEntity> associateSkillsEntity) {
		System.out.println("associateSkillsEntity :" +associateSkillsEntity.toString());
		associateSkillsRepository.saveAll(associateSkillsEntity);
	}
	
	public byte[] getPicUploaded(int id) {
		return associateRepository.findPicById(id);
	}
	
	public List<AssociateEntity> fetchAllAssociateDetails(){
		return associateRepository.findAll();
	}
	
	public List<AssociateSkillsEntity> fetchAssociateSkills() {
		return associateSkillsRepository.findAll();
	}	
	
	public void deleteAssociate(int associateId) {
		associateRepository.deleteById(associateId);
	}
	
	
}

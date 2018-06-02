package com.tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tracker.entity.AssociateEntity;
import com.tracker.entity.AssociateSkillsEntity;
import com.tracker.model.SkillRatingModel;
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
		associateSkillsRepository.saveAll(associateSkillsEntity);
	}
	
	public byte[] getPicUploaded(int id) {
		return associateRepository.findPicById(id);
	}
	
	public List<AssociateEntity> fetchAllAssociateDetails(){
		return associateRepository.findAll();
	}
	
	public List<SkillRatingModel> fetchAssociateSkills(Integer associateId) {
		List<SkillRatingModel> skillIdList = new ArrayList<SkillRatingModel>();
		SkillRatingModel skillRatingModel = null;
		List<AssociateSkillsEntity> associateSkillsList = associateSkillsRepository.findSkillsById(associateId);
		if(!CollectionUtils.isEmpty(associateSkillsList)) {
			for(AssociateSkillsEntity associateSkillsEntity : associateSkillsList) {
				skillRatingModel = new SkillRatingModel();
				skillRatingModel.setSkillId(associateSkillsEntity.getSkillId());
				skillRatingModel.setSkillRating(associateSkillsEntity.getSkillRating());
				skillIdList.add(skillRatingModel);
			}
		}	
		return skillIdList;
	}	
	
	public void deleteAssociate(int associateId) {
		associateRepository.deleteById(associateId);
	}
	
	
	public List<Integer> fetchDistinctAssociates(){
		return associateRepository.fetchDistinctAssociates();
	}
	
	public void saveSkillRating(int skillId, int associateId, int skillRating) {
		associateSkillsRepository.saveSkillRating(associateId,skillId,skillRating);
	}
	
	
}

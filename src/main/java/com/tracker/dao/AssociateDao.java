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

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateDao.
 */
@Component
public class AssociateDao {

	/** The associate repository. */
	@Autowired
	private AssociateRepository associateRepository;
	
	/** The associate skills repository. */
	@Autowired
	private AssociateSkillsRepository associateSkillsRepository;	
	
	
	/**
	 * Adds the associate.
	 *
	 * @param associateEntity the associate entity
	 */
	public void addAssociate(AssociateEntity associateEntity) {
		associateRepository.save(associateEntity);
	} 
	
	/**
	 * Adds the associate skills.
	 *
	 * @param associateSkillsEntity the associate skills entity
	 */
	public void addAssociateSkills(List<AssociateSkillsEntity> associateSkillsEntity) {
		associateSkillsRepository.saveAll(associateSkillsEntity);
	}
	
	/**
	 * Gets the pic uploaded.
	 *
	 * @param id the id
	 * @return the pic uploaded
	 */
	public byte[] getPicUploaded(int id) {
		return associateRepository.findPicById(id);
	}
	
	/**
	 * Fetch all associate details.
	 *
	 * @return the list
	 */
	public List<AssociateEntity> fetchAllAssociateDetails(){
		return associateRepository.findAll();
	}
	
	/**
	 * Fetch associate skills.
	 *
	 * @param associateId the associate id
	 * @return the list
	 */
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
	
	/**
	 * Delete associate.
	 *
	 * @param associateId the associate id
	 */
	public void deleteAssociate(int associateId) {
		associateRepository.deleteById(associateId);
	}
	
	
	/**
	 * Fetch distinct associates.
	 *
	 * @return the list
	 */
	public List<Integer> fetchDistinctAssociates(){
		return associateRepository.fetchDistinctAssociates();
	}
	
	/**
	 * Save skill rating.
	 *
	 * @param skillId the skill id
	 * @param associateId the associate id
	 * @param skillRating the skill rating
	 */
	public void saveSkillRating(int skillId, int associateId, int skillRating) {
		associateSkillsRepository.saveSkillRating(associateId,skillId,skillRating);
	}
	
	
}

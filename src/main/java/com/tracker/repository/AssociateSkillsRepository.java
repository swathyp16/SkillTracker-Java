package com.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.AssociateSkillsEntity;

@Repository
public interface AssociateSkillsRepository extends JpaRepository<AssociateSkillsEntity,Integer> {

	@Query(value=QueryConstants.FETCH_ASSOCIATE_SKILL_BY_ID)
	List<AssociateSkillsEntity> findSkillsById(int skillId);
	
	@Modifying(clearAutomatically = true)
	@Query(value=QueryConstants.SAVE_SKILL_RATING)
	@Transactional
	void saveSkillRating(int associateId, int skillId , int skillRating);
}

package com.tracker.repository;

import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.SkillsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity,Integer> {

	@Query(value=QueryConstants.FETCH_SKILL_NAME_BY_ID)
	List<SkillsEntity> findSkillNameById(int skillId);
	
}

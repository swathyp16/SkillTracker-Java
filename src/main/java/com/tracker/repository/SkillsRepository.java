package com.tracker.repository;

import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.SkillsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// TODO: Auto-generated Javadoc
/**
 * The Interface SkillsRepository.
 */
@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity,Integer> {

	/**
	 * Find skill name by id.
	 *
	 * @param associateSkillIdList the associate skill id list
	 * @return the list
	 */
	@Query(value=QueryConstants.FETCH_SKILL_NAME_BY_ID)
	List<SkillsEntity> findSkillNameById(List<Integer> associateSkillIdList);
	
}

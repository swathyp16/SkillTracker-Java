package com.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.AssociateEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface AssociateRepository.
 */
@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity,Integer> {

	/**
	 * Find pic by id.
	 *
	 * @param id the id
	 * @return the byte[]
	 */
	@Query(value=QueryConstants.FETCH_PIC_BY_ASSOCIATE_ID)
	byte[] findPicById(int id);
	
	/**
	 * Fetch distinct associates.
	 *
	 * @return the list
	 */
	@Query(value=QueryConstants.FETCH_DISTINCT_ASSOCIATE_ID)
	List<Integer> fetchDistinctAssociates();
	
}

package com.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.AssociateEntity;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity,Integer> {

	@Query(value=QueryConstants.FETCH_PIC_BY_ASSOCIATE_ID)
	byte[] findPicById(int id);
	
	@Query(value=QueryConstants.FETCH_DISTINCT_ASSOCIATE_ID)
	List<Integer> fetchDistinctAssociates();
	
}

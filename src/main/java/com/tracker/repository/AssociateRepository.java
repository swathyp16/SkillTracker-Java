package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.AssociateEntity;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity,Integer> {

	@Query(value=QueryConstants.FETCH_PIC_BY_ASSOCIATE_ID)
	byte[] findPicById(int id);
	
}

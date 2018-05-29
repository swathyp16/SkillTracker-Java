package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.AssociateEntity;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity,Integer> {

}

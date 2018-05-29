package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.AssociateSkillsEntity;

@Repository
public interface AssociateSkillsRepository extends JpaRepository<AssociateSkillsEntity,Integer> {

}

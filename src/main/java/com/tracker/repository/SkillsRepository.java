package com.tracker.repository;

import org.springframework.stereotype.Repository;

import com.tracker.entity.SkillsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity,Integer> {

	
}

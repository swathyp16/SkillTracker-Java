package com.skill.tracker.repository;

import org.springframework.stereotype.Repository;

import com.skill.tracker.entity.SkillsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity,Integer> {

}

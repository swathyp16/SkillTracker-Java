package com.tracker.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tracker.controller.AssociateController;
import com.tracker.entity.SkillsEntity;
import com.tracker.repository.SkillsRepository;
import com.tracker.service.impl.AssociateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SkillsDaoTest {
	
	@InjectMocks
	private SkillsDao skillsDao;
	
	@Mock
	private SkillsRepository skillsRepository;
	
	private SkillsEntity skillsEntity;
	
	@Before
	public void setupMock() {
		skillsEntity = new SkillsEntity();
	}

	@Test
	public void test() {
		Mockito.when(skillsRepository.save(skillsEntity)).thenReturn(null);
		skillsDao.addSkills(skillsEntity);
	}
	
	@Test
	public void testDeleteSkill() {
		skillsDao.deleteSkill(123);
	}

}

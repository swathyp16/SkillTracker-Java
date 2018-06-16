package com.tracker.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.SkillsDao;
import com.tracker.entity.SkillsEntity;
import com.tracker.model.SkillsModel;

@RunWith(MockitoJUnitRunner.class)
public class SkillServiceImplTest {

	@InjectMocks
	private SkillServiceImpl skillServiceImpl;
	
	@Mock
	private SkillsDao skillsDao;
	
	private SkillsModel skillsModel;
	
	private List<SkillsModel> skillsList;
	
	private List<SkillsEntity> skillEntityList;
	
	private SkillsEntity skillsEntity;
	
	List<SkillsModel> expected;
	
	@Before
	public void setupMock() {
		skillsModel = new SkillsModel();
		skillsModel.setSkillId(12);
		skillsModel.setSkillName("java");
		skillsModel.setSkillRating(10);
		skillsList = new ArrayList<SkillsModel>();
		skillsList.add(skillsModel);
		expected = new ArrayList<SkillsModel>();
		expected.add(skillsModel);
		skillEntityList = new ArrayList<SkillsEntity>();
		skillsEntity = new SkillsEntity();
		skillsEntity.setSkillId(12);
		skillsEntity.setSkillName("java");
		skillEntityList.add(skillsEntity);
	}
	
	@Test
	public void testAddSkill() {		
		String actual = skillServiceImpl.addSkill(skillsModel);
		assertEquals(CommonConstants.SUCCESS_STRING, actual);
	}
	
	@Test
	public void testViewAllSkills() {			
		Mockito.when(skillsDao.viewAllSkills()).thenReturn(skillEntityList);
		List<SkillsModel> actual = skillServiceImpl.viewAllSkills();
		assertEquals(expected.get(0).getSkillId(), actual.get(0).getSkillId());
		assertEquals(expected.get(0).getSkillName(), actual.get(0).getSkillName());
	}
	
	@Test
	public void testDeleteSkill() {		
		String actual = skillServiceImpl.deleteSkill(skillsModel);
		assertEquals(CommonConstants.SUCCESS_STRING, actual);
	}

}

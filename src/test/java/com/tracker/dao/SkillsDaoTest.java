package com.tracker.dao;

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
import com.tracker.entity.SkillsEntity;
import com.tracker.repository.SkillsRepository;

@RunWith(MockitoJUnitRunner.class)
public class SkillsDaoTest {
	
	@InjectMocks
	private SkillsDao skillsDao;
	
	@Mock
	private SkillsRepository skillsRepository;
	
	private SkillsEntity skillsEntity;
	
	private List<SkillsEntity> skillList;
	
	private List<SkillsEntity> skillListExp;
	
	private List<Integer> associateSkillIdList;
	
	@Before
	public void setupMock() {
		skillsEntity = new SkillsEntity();
		skillsEntity.setSkillId(12);
		skillsEntity.setSkillName("Java");
		skillList = new ArrayList<SkillsEntity>();
		skillList.add(skillsEntity);
		skillListExp = new ArrayList<SkillsEntity>();
		skillListExp.add(skillsEntity);
		associateSkillIdList = new ArrayList<Integer>();
		associateSkillIdList.add(12);
		associateSkillIdList.add(10);
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
	
	@Test
	public void testViewAllSkills() {		
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		List<SkillsEntity> skillsListActual = skillsDao.viewAllSkills();
		assertNotNull(skillsListActual);
		assertEquals(skillListExp.get(0).getSkillId(), skillsListActual.get(0).getSkillId());
		assertEquals(skillListExp.get(0).getSkillName(),skillsListActual.get(0).getSkillName());
	}
	
	@Test
	public void testFetchAssociateSkillNamesById() {		
		Mockito.when(skillsRepository.findSkillNameById(associateSkillIdList)).thenReturn(skillList);		
		List<SkillsEntity> skillsListActual = skillsDao.fetchAssociateSkillNamesById(associateSkillIdList);
		assertNotNull(skillsListActual);
		assertEquals(skillListExp.get(0).getSkillId(), skillsListActual.get(0).getSkillId());
		assertEquals(skillListExp.get(0).getSkillName(),skillsListActual.get(0).getSkillName());
	}

}

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

// TODO: Auto-generated Javadoc
/**
 * The Class SkillsDaoTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillsDaoTest {
	
	/** The skills dao. */
	@InjectMocks
	private SkillsDao skillsDao;
	
	/** The skills repository. */
	@Mock
	private SkillsRepository skillsRepository;
	
	/** The skills entity. */
	private SkillsEntity skillsEntity;
	
	/** The skill list. */
	private List<SkillsEntity> skillList;
	
	/** The skill list exp. */
	private List<SkillsEntity> skillListExp;
	
	/** The associate skill id list. */
	private List<Integer> associateSkillIdList;
	
	/**
	 * Setup mock.
	 */
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

	/**
	 * Test.
	 */
	@Test
	public void test() {
		Mockito.when(skillsRepository.save(skillsEntity)).thenReturn(null);
		skillsDao.addSkills(skillsEntity);
	}
	
	/**
	 * Test delete skill.
	 */
	@Test
	public void testDeleteSkill() {
		skillsDao.deleteSkill(123);
	}
	
	/**
	 * Test view all skills.
	 */
	@Test
	public void testViewAllSkills() {		
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		List<SkillsEntity> skillsListActual = skillsDao.viewAllSkills();
		assertNotNull(skillsListActual);
		assertEquals(skillListExp.get(0).getSkillId(), skillsListActual.get(0).getSkillId());
		assertEquals(skillListExp.get(0).getSkillName(),skillsListActual.get(0).getSkillName());
	}
	
	/**
	 * Test fetch associate skill names by id.
	 */
	@Test
	public void testFetchAssociateSkillNamesById() {		
		Mockito.when(skillsRepository.findSkillNameById(associateSkillIdList)).thenReturn(skillList);		
		List<SkillsEntity> skillsListActual = skillsDao.fetchAssociateSkillNamesById(associateSkillIdList);
		assertNotNull(skillsListActual);
		assertEquals(skillListExp.get(0).getSkillId(), skillsListActual.get(0).getSkillId());
		assertEquals(skillListExp.get(0).getSkillName(),skillsListActual.get(0).getSkillName());
	}

}

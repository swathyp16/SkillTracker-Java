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

import com.tracker.entity.AssociateEntity;
import com.tracker.entity.AssociateSkillsEntity;
import com.tracker.model.SkillRatingModel;
import com.tracker.repository.AssociateRepository;
import com.tracker.repository.AssociateSkillsRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateDaoTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateDaoTest {

	/** The associate dao. */
	@InjectMocks
	private AssociateDao associateDao;
	
	/** The associate repository. */
	@Mock
	private AssociateRepository associateRepository;
	
	/** The associate skills repository. */
	@Mock
	private AssociateSkillsRepository associateSkillsRepository;	
	
	/** The associate entity. */
	private AssociateEntity associateEntity;
	
	/** The associate skills entity list. */
	private List<AssociateSkillsEntity> associateSkillsEntityList;
	
	/** The associate skills entity. */
	private AssociateSkillsEntity associateSkillsEntity;
	
	/** The byte value. */
	private byte[] byteValue;
	
	/** The expected. */
	private byte[] expected;
	
	/** The associate entity list. */
	private List<AssociateEntity> associateEntityList;
	
	/** The expected list. */
	private List<AssociateEntity> expectedList;
	
	/** The associate id list. */
	private List<Integer> associateIdList;
	
	/** The associate id list exp. */
	private List<Integer> associateIdListExp;	
	
	/** The expected skill rating. */
	private List<SkillRatingModel> expectedSkillRating;
	
	/** The skill rating model. */
	private SkillRatingModel skillRatingModel;
	
	/**
	 * Setup mock.
	 */
	@Before
	public void setupMock() {
		associateEntity = new AssociateEntity();
		associateEntity.setAssociateId(12345);
		associateEntity.setGender("male");
		associateEntity.setName("abc");
		associateEntity.setLevel1(true);
		associateEntity.setLevel2(false);
		associateEntity.setLevel3(false);
		associateEntity.setStatusBlue(true);
		associateEntity.setStatusGreen(false);
		associateEntity.setStatusRed(false);
		associateEntity.setStrength("strength");
		associateEntity.setWeakness("weakness");
		associateSkillsEntity = new AssociateSkillsEntity();
		associateSkillsEntity.setAssociateId(12345);
		associateSkillsEntity.setSkillId(12);
		associateSkillsEntity.setSkillRating(10);
		associateSkillsEntityList = new ArrayList<AssociateSkillsEntity>();
		associateSkillsEntityList.add(associateSkillsEntity);
		byteValue = new byte[12];
		expected = new byte[12];
		associateEntityList= new ArrayList<AssociateEntity>();
		associateEntityList.add(associateEntity);
		expectedList= new ArrayList<AssociateEntity>();
		expectedList.add(associateEntity);
		associateIdList = new ArrayList<Integer>();
		associateIdList.add(12345);
		associateIdListExp = new ArrayList<Integer>();
		associateIdListExp.add(12345);
		expectedSkillRating = new ArrayList<SkillRatingModel>();
		skillRatingModel = new SkillRatingModel();
		skillRatingModel.setSkillId(12);
		skillRatingModel.setSkillRating(10);
		expectedSkillRating.add(skillRatingModel);
	}

	
	/**
	 * Test add associate.
	 */
	@Test
	public void testAddAssociate() {
		Mockito.when(associateRepository.save(associateEntity)).thenReturn(associateEntity);
		associateDao.addAssociate(associateEntity);
	}
	
	/**
	 * Test add associate skills.
	 */
	@Test
	public void testAddAssociateSkills() {
		Mockito.when(associateSkillsRepository.saveAll(associateSkillsEntityList)).thenReturn(associateSkillsEntityList);		
		associateDao.addAssociateSkills(associateSkillsEntityList);
	}

	/**
	 * Test get pic uploaded.
	 */
	@Test
	public void testGetPicUploaded() {		
		Mockito.when(associateRepository.findPicById(12)).thenReturn(byteValue);
		byte[]actual = associateDao.getPicUploaded(12);
		assertEquals(expected.length, actual.length);
	}
	
	/**
	 * Test fetch all associate details.
	 */
	@Test
	public void testFetchAllAssociateDetails() {		
		Mockito.when(associateRepository.findAll()).thenReturn(associateEntityList);
		List<AssociateEntity>  actual = associateDao.fetchAllAssociateDetails();
		assertEquals(expectedList.get(0).getAssociateId(), actual.get(0).getAssociateId());
	}
	
	/**
	 * Test fetch distinct associates.
	 */
	@Test
	public void testFetchDistinctAssociates() {		
		Mockito.when(associateRepository.fetchDistinctAssociates()).thenReturn(associateIdList);
		List<Integer> actual = associateDao.fetchDistinctAssociates();
		assertEquals(associateIdListExp.get(0), actual.get(0));
	}
	
	/**
	 * Test fetch associate skills.
	 */
	@Test
	public void testFetchAssociateSkills() {		
		Mockito.when(associateSkillsRepository.findSkillsById(12345)).thenReturn(associateSkillsEntityList);
		List<SkillRatingModel> actual = associateDao.fetchAssociateSkills(12345);
		assertEquals(expectedSkillRating.get(0).getSkillId(), actual.get(0).getSkillId());
		assertEquals(expectedSkillRating.get(0).getSkillRating(), actual.get(0).getSkillRating());
	}
	

	/**
	 * Test save skill rating.
	 */
	@Test
	public void testSaveSkillRating() {
		associateDao.saveSkillRating(12345, 12, 10);
	}
	
	/**
	 * Test delete associate.
	 */
	@Test
	public void testDeleteAssociate() {
		associateDao.deleteAssociate(12345);
	}
	
}

package com.tracker.service.impl;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.AssociateDao;
import com.tracker.dao.SkillsDao;
import com.tracker.entity.AssociateEntity;
import com.tracker.entity.SkillsEntity;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillRatingModel;
import com.tracker.model.SkillsModel;

@RunWith(MockitoJUnitRunner.class)
public class AssociateServiceImplTest {
	
	@InjectMocks
	private AssociateServiceImpl associateServiceImpl;
	
	@Mock
	private AssociateDao associateDao;
	
	@Mock
	private SkillsDao skillsDao;
	
	private AssociateModel associateModel;
	private AssociateModel associateModel1;
	private MultipartFile file;
	private byte[] pic;	
	private List<SkillsModel> skillModelList;
	private SkillsModel skillsModel;
	private List<AssociateEntity> associateList;
	private AssociateEntity associateEntity;
	private List<Integer> associateIdList;
	private List<SkillRatingModel> skillRatingList;
	private SkillRatingModel skillRatingModel;
	private SkillsEntity skillsEntity;
	private List<SkillsEntity> skillsEntityList;
	List<AssociateModel> associateModelExpected;
	
	@Before
	public void setupMock() {
		skillsEntity = new SkillsEntity();
		skillsEntity.setSkillId(12);
		skillsEntity.setSkillName("java");
		skillsEntityList = new ArrayList<SkillsEntity>();
		skillsEntityList.add(skillsEntity);
		skillRatingModel = new SkillRatingModel();
		skillRatingModel.setSkillId(12);
		skillRatingModel.setSkillRating(10);
		skillRatingList = new ArrayList<SkillRatingModel>();
		skillRatingList.add(skillRatingModel);
		associateModel = new AssociateModel();
		skillsModel = new SkillsModel();
		skillsModel.setSkillId(12);
		skillsModel.setSkillName("java");
		skillsModel.setSkillRating(10);
		skillModelList = new ArrayList<SkillsModel>();
		skillModelList.add(skillsModel);
		associateModel.setAssociateId(123);
		associateModel.setName("ABC");
		associateModel.setEmail("a@aol.com");
		associateModel.setAssociateSkills(skillModelList);
		associateModel.setMobileNum(9995);
		associateModel.setLevel1(true);
		associateModel.setLevel2(false);
		associateModel.setLevel3(false);
		associateModel.setRemark("Remark");
		associateModel.setStatusBlue(true);
		associateModel.setStatusGreen(false);
		associateModel.setStatusRed(false);
		associateModel.setStrength("Strength");
		associateModel.setWeakness("Weakness");
		associateModel.setGender("male");
		associateModel1 = new AssociateModel();
		associateModel1.setAssociateId(123);
		associateModel1.setName("ABC");
		associateModel1.setEmail("a@aol.com");
		associateModel1.setAssociateSkills(skillModelList);
		associateModel1.setMobileNum(9995);
		associateModel1.setLevel1(true);
		associateModel1.setLevel2(false);
		associateModel1.setLevel3(false);
		associateModel1.setRemark("Remark");
		associateModel1.setStatusBlue(true);
		associateModel1.setStatusGreen(false);
		associateModel1.setStatusRed(false);
		associateModel1.setStrength("Strength");
		associateModel1.setWeakness("Weakness");
		associateModel1.setGender("female");
		associateList = new ArrayList<>();
		pic = new byte[12];
		associateEntity = new AssociateEntity();
		associateEntity.setAssociateId(123);
		associateEntity.setName("ABC");
		associateEntity.setEmail("a@aol.com");
		associateEntity.setMobile(new BigInteger("9876543210"));
		associateEntity.setLevel1(true);
		associateEntity.setLevel2(false);
		associateEntity.setLevel3(false);
		associateEntity.setRemark("Remark");
		associateEntity.setStatusBlue(true);
		associateEntity.setStatusGreen(false);
		associateEntity.setStatusRed(false);
		associateEntity.setStrength("Strength");
		associateEntity.setWeakness("Weakness");
		associateEntity.setGender("male");
		associateList.add(associateEntity);
		associateIdList = new ArrayList<>();
		associateIdList.add(123);
		associateModelExpected = new ArrayList<>();
		associateModelExpected.add(associateModel);
	}

	@Test
	public void testAddAssociate() throws BusinessException {			
		Mockito.when(associateDao.getPicUploaded(123)).thenReturn(pic);
		associateServiceImpl.addAssociate(associateModel, file); 
	}
	
	@Test
	public void testAddAssociateFemaleGender() throws BusinessException {			
		Mockito.when(associateDao.getPicUploaded(123)).thenReturn(pic);
		associateServiceImpl.addAssociate(associateModel1, file); 
	}
	
	@Test
	public void testFetchAllAssociateDetails() throws BusinessException {
		Mockito.when(associateDao.fetchAllAssociateDetails()).thenReturn(associateList);
		Mockito.when(associateDao.fetchDistinctAssociates()).thenReturn(associateIdList);		
		Mockito.when(associateDao.fetchAssociateSkills(123)).thenReturn(skillRatingList);		
		Mockito.when(skillsDao.fetchAssociateSkillNamesById(Matchers.anyList())).thenReturn(skillsEntityList);
		List<AssociateModel> associateList = associateServiceImpl.fetchAllAssociateDetails(); 
		assertEquals(associateModelExpected.get(0).getAssociateId(), associateList.get(0).getAssociateId());
	}
	
	@Test
	public void testDeleteAssociate() throws BusinessException {
		String actual = associateServiceImpl.deleteAssociate(123); 
		assertEquals(CommonConstants.SUCCESS_STRING, actual);
	}

}

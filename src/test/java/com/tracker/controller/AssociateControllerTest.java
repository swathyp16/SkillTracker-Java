package com.tracker.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tracker.constants.CommonConstants;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.service.impl.AssociateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AssociateControllerTest {

	@InjectMocks
	private AssociateController associateController;
	
	@Mock
	private AssociateServiceImpl associateService;
	
	private String associateData;
	private AssociateModel associateModel;
	private byte[] pic;
	private byte[] picExp;
	private List<AssociateModel> actualResult;
	private List<AssociateModel> expectedResult;	

	@Before
	public void setupMock() {
		pic = new byte[12];
		picExp = new byte[12];
		associateModel = new  AssociateModel();
		associateModel.setAssociateId(123);
		associateModel.setName("ABC");
		actualResult = new ArrayList<>();
		actualResult.add(associateModel);
		expectedResult = new ArrayList<>();
		expectedResult.add(associateModel);
		//associateData =  {"associateSkills":[{"skillId":4,"skillName":"CSS3","skillRating":"14"},{"skillId":4,"skillName":"CSS3","skillRating":"14"}],"statusGreen":false,"statusRed":false,"statusBlue":false,"level1":false,"level2":false,"level3":false,"name":"Anjaly","associateId":"3456","email":"swathy,p16@gmail.com","mobileNum":"21582","remark":"dfdfd","gender":"female","otherSkill":"other skills","strength":"java","weakness":"Python"}

	}
	
	@Test
	@Ignore
	public void testAddAssociate() throws BusinessException {	
		Mockito.when(associateService.addAssociate(associateModel, null)).thenReturn(CommonConstants.SUCCESS_STRING);
		String actualResult = associateController.addAssociate(associateData, null);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(CommonConstants.SUCCESS_STRING, actualResult);
		
	}
	
	@Test
	public void testViewAllAssociates() throws BusinessException {		
		Mockito.when(associateService.fetchAllAssociateDetails()).thenReturn(expectedResult);
		List<AssociateModel> actualResult = associateController.viewAllAssociates();
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult.get(0).getAssociateId(), actualResult.get(0).getAssociateId());
		
	}
	
	@Test
	public void testGetAssociatePic() throws BusinessException {		
		Mockito.when(associateService.getAssociatePicture(1234)).thenReturn(pic);
		byte[] actualResult = associateController.getAssociatePic(1234);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(picExp.length, actualResult.length);
		
	}
	
	@Test
	public void testDeleteAssociate() throws BusinessException {		
		Mockito.when(associateService.deleteAssociate(Matchers.anyInt())).thenReturn(CommonConstants.SUCCESS_STRING);
		String actualResult = associateController.deleteAssociate(12);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(CommonConstants.SUCCESS_STRING, actualResult);		
	}
}

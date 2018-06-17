package com.tracker.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.constants.CommonConstants;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillsModel;
import com.tracker.service.impl.AssociateServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateControllerTest {

	/** The associate controller. */
	@InjectMocks
	private AssociateController associateController;
	
	/** The associate service. */
	@Mock
	private AssociateServiceImpl associateService;
	
	/** The file. */
	private MultipartFile file;
	
	/** The associate model. */
	private AssociateModel associateModel;
	
	/** The pic. */
	private byte[] pic;
	
	/** The pic exp. */
	private byte[] picExp;
	
	/** The actual result. */
	private List<AssociateModel> actualResult;
	
	/** The expected result. */
	private List<AssociateModel> expectedResult;
	
	/** The image file. */
	private byte[] imageFile;

	/**
	 * Setup mock.
	 */
	@Before
	public void setupMock() {
		pic = new byte[12];
		picExp = new byte[12];
		associateModel = new  AssociateModel();
		associateModel.setAssociateId(123);
		associateModel.setName("ABC");
		associateModel.setEmail("a@aol.com");
		associateModel.setAssociateSkills(new ArrayList<SkillsModel>());
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
		actualResult = new ArrayList<>();
		actualResult.add(associateModel);
		expectedResult = new ArrayList<>();
		expectedResult.add(associateModel);
	}
	
	/**
	 * Test add associate.
	 *
	 * @throws BusinessException the business exception
	 * @throws JsonProcessingException the json processing exception
	 */
	@Test
	public void testAddAssociate() throws BusinessException, JsonProcessingException {	
		ObjectMapper mapper = new ObjectMapper();		
		String jsonString = mapper.writeValueAsString(associateModel);
		String actualResult = associateController.addAssociate(jsonString, file);
		Assert.assertNull(actualResult);
		
	}
	 
	/**
	 * Test view all associates.
	 *
	 * @throws BusinessException the business exception
	 */
	@Test
	public void testViewAllAssociates() throws BusinessException {		
		Mockito.when(associateService.fetchAllAssociateDetails()).thenReturn(expectedResult);
		List<AssociateModel> actualResult = associateController.viewAllAssociates();
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult.get(0).getAssociateId(), actualResult.get(0).getAssociateId());
		
	}
	
	/**
	 * Test get associate pic.
	 *
	 * @throws BusinessException the business exception
	 */
	@Test
	public void testGetAssociatePic() throws BusinessException {		
		Mockito.when(associateService.getAssociatePicture(1234)).thenReturn(pic);
		byte[] actualResult = associateController.getAssociatePic(1234);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(picExp.length, actualResult.length);
		
	}
	
	/**
	 * Test delete associate.
	 *
	 * @throws BusinessException the business exception
	 */
	@Test
	public void testDeleteAssociate() throws BusinessException {		
		Mockito.when(associateService.deleteAssociate(Matchers.anyInt())).thenReturn(CommonConstants.SUCCESS_STRING);
		String actualResult = associateController.deleteAssociate(12);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(CommonConstants.SUCCESS_STRING, actualResult);		
	}
}
	
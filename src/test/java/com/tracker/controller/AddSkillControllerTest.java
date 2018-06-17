package com.tracker.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tracker.constants.CommonConstants;
import com.tracker.model.SkillsModel;
import com.tracker.service.impl.SkillServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AddSkillControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddSkillControllerTest {

	/** The add skill controller. */
	@InjectMocks
	private AddSkillController addSkillController;
	
	/** The skill service. */
	@Mock
	private SkillServiceImpl skillService;
	
	/** The skills model. */
	private SkillsModel skillsModel;
	
	/** The skill list. */
	private List<SkillsModel> skillList;
	
	/** The skill list exp. */
	private List<SkillsModel> skillListExp;
	
	/**
	 * Setup mock.
	 */
	@Before
	public void setupMock() {
		skillsModel = new SkillsModel();
		skillsModel.setSkillId(1);
		skillsModel.setSkillName("Java");
		skillsModel.setSkillRating(10);
		skillList = new ArrayList<>();
		skillList.add(skillsModel);
		skillListExp = new ArrayList<>();
		skillListExp.add(skillsModel);
	}
	
	/**
	 * Test add skill.
	 */
	@Test
	public void testAddSkill() {		
		Mockito.when(skillService.addSkill(skillsModel)).thenReturn(CommonConstants.SUCCESS_STRING);
		String actualResult = addSkillController.addSkill(skillsModel);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(CommonConstants.SUCCESS_STRING, actualResult);
	}
	
	/**
	 * Test view all skills.
	 */
	@Test
	public void testViewAllSkills() {		
		Mockito.when(skillService.viewAllSkills()).thenReturn(skillList);
		List<SkillsModel> actualResult = addSkillController.viewAllSkills();
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(skillListExp.get(0).getSkillName(),actualResult.get(0).getSkillName());
		Assert.assertEquals(skillListExp.get(0).getSkillId(),actualResult.get(0).getSkillId());
		Assert.assertEquals(skillListExp.get(0).getSkillRating(),actualResult.get(0).getSkillRating());
	}
	
	/**
	 * Test delete skill.
	 */
	@Test
	public void testDeleteSkill() {		
		Mockito.when(skillService.deleteSkill(skillsModel)).thenReturn(CommonConstants.SUCCESS_STRING);
		String actualResult = addSkillController.deleteSkill(skillsModel);
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(CommonConstants.SUCCESS_STRING, actualResult);
	}

}

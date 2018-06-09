package com.tracker.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.dao.AssociateDao;
import com.tracker.dao.SkillsDao;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;

@RunWith(MockitoJUnitRunner.class)
public class AssociateServiceImplTest {
	
	@InjectMocks
	private AssociateServiceImpl associateServiceImpl;
	
	@Mock
	private AssociateDao associateDao;
	
	@Mock
	private SkillsDao skillsDao;
	
	private AssociateModel associateModel;
	private MultipartFile file;
	
	@Before
	public void setupMock() {
		associateModel = new AssociateModel();
	}

	@Test
	public void testAddAssociate() throws BusinessException {
		
		associateServiceImpl.addAssociate(associateModel, file);
	}

}

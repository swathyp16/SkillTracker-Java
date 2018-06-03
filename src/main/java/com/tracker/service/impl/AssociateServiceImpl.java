package com.tracker.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.AssociateDao;
import com.tracker.dao.SkillsDao;
import com.tracker.entity.AssociateEntity;
import com.tracker.entity.SkillsEntity;
import com.tracker.enums.Gender;
import com.tracker.exception.BusinessException;
import com.tracker.model.AssociateModel;
import com.tracker.model.SkillRatingModel;
import com.tracker.model.SkillsModel;
import com.tracker.service.intf.IAssociateService;

@Component
public class AssociateServiceImpl implements IAssociateService {

	@Autowired
	private AssociateDao associateDao;
	
	@Autowired
	private SkillsDao skillsDao;

	public String addAssociate(AssociateModel associateModel,MultipartFile file) throws BusinessException {
		AssociateEntity associateEntity = new AssociateEntity();
		setDataToAssociateEntity(associateEntity, associateModel,file);
		mapAssociateSkills(associateModel,associateEntity);
		associateDao.addAssociate(associateEntity);
		saveAssociateRating(associateModel);
		return CommonConstants.SUCCESS_STRING; 
		
	}
	
	private void saveAssociateRating(AssociateModel associateModel) {
		for(SkillsModel skillsModel : associateModel.getAssociateSkills()) {
			associateDao.saveSkillRating(skillsModel.getSkillId(),associateModel.getAssociateId(),skillsModel.getSkillRating());
		}
		
	}
	
	public byte[] getAssociatePicture(int id) {
		return associateDao.getPicUploaded(id);
	}
	
	public List<AssociateModel> fetchAllAssociateDetails() {
		List<AssociateEntity> associateEntities = associateDao.fetchAllAssociateDetails();
		List<AssociateModel> associatesList = new ArrayList<AssociateModel>();
		AssociateModel associateModel = null;
		for(AssociateEntity associateEntity: associateEntities) {
			associateModel = new AssociateModel();
			associateModel.setAssociateId(associateEntity.getAssociateId());
			associateModel.setName(associateEntity.getName());
			associateModel.setEmail(associateEntity.getEmail());
			associateModel.setMobileNum(associateEntity.getMobile());
			associateModel.setRemark(associateEntity.getRemark());
			associateModel.setStrength(associateEntity.getStrength());
			associateModel.setWeakness(associateEntity.getWeakness());
			associateModel.setStatusGreen(associateEntity.isStatusGreen());
			associateModel.setStatusBlue(associateEntity.isStatusBlue());
			associateModel.setStatusRed(associateEntity.isStatusRed());
			associateModel.setLevel1(associateEntity.isLevel1());
			associateModel.setLevel2(associateEntity.isLevel2());
			associateModel.setLevel3(associateEntity.isLevel3());
			if(Gender.MALE.getValue().equalsIgnoreCase(associateEntity.getGender())) {
				associateModel.setGender(Gender.MALE.name().toLowerCase());
			}else if(Gender.FEMALE.getValue().equalsIgnoreCase(associateEntity.getGender())) {
				associateModel.setGender(Gender.FEMALE.name().toLowerCase());
			}
			associatesList.add(associateModel);
		}
		findApplicableAssociateIds(associatesList);
		return associatesList;
	}
	
	private void findApplicableAssociateIds(List<AssociateModel> associatesList) {
		List<Integer> associateIdList = associateDao.fetchDistinctAssociates();
		for(Integer associateId : associateIdList) {
			List<SkillRatingModel> associateSkillIdList = associateDao.fetchAssociateSkills(associateId);
			List<Integer> skillIdList = fetchAllSkillIds(associateSkillIdList);
			List<SkillsEntity> skillList = skillsDao.fetchAssociateSkillNamesById(skillIdList);
			SkillsModel skillsModel = null;
			int i= 0;
			for(SkillsEntity skillsEntity : skillList) {
				skillsModel = new SkillsModel();
				skillsModel.setSkillId(skillsEntity.getSkillId());
				skillsModel.setSkillName(skillsEntity.getSkillName());
				if(associateSkillIdList.get(i).getSkillId() == skillsEntity.getSkillId()) {
					skillsModel.setSkillRating(associateSkillIdList.get(i).getSkillRating());
				}				
				setSkillToAssociateModel(associatesList,associateId,skillsModel);
				i++;
			}
			
		}
		
	}	
	
	private List<Integer> fetchAllSkillIds(List<SkillRatingModel> skillRatingModel){
		List<Integer> skillIdList = new ArrayList<Integer>();
		for(SkillRatingModel model :skillRatingModel) {
			skillIdList.add(model.getSkillId());
		}
		return skillIdList;
		
	}
		private void setSkillToAssociateModel(List<AssociateModel> associatesList,Integer associateId,SkillsModel skillsModel){
			int i = 0;
			List<SkillsModel>  newSkillList = new ArrayList<SkillsModel>();
			for(AssociateModel associateModel : associatesList) {
				if(associateModel.getAssociateId() == associateId) {
					if(!CollectionUtils.isEmpty(associatesList.get(i).getAssociateSkills())) {
						associatesList.get(i).getAssociateSkills().add(skillsModel);
					} else {
						associatesList.get(i).setAssociateSkills(newSkillList);
						associatesList.get(i).getAssociateSkills().add(skillsModel);
					}
					
				}
				i++;
			}
		}

	
	private void setDataToAssociateEntity(AssociateEntity associateEntity,AssociateModel associateModel,MultipartFile file) throws BusinessException {
		associateEntity.setAssociateId(associateModel.getAssociateId());
		associateEntity.setName(associateModel.getName());
		associateEntity.setEmail(associateModel.getEmail());
		associateEntity.setMobile(associateModel.getMobileNum());
		associateEntity.setRemark(associateModel.getRemark());
		associateEntity.setStrength(associateModel.getStrength());
		associateEntity.setWeakness(associateModel.getWeakness());
		associateEntity.setStatusGreen(associateModel.isStatusGreen());
		associateEntity.setStatusBlue(associateModel.isStatusBlue());
		associateEntity.setStatusRed(associateModel.isStatusRed());
		associateEntity.setLevel1(associateModel.isLevel1());
		associateEntity.setLevel2(associateModel.isLevel2());
		associateEntity.setLevel3(associateModel.isLevel3());
		if(Gender.MALE.name().equalsIgnoreCase(associateModel.getGender())) {
			associateEntity.setGender(Gender.MALE.getValue());
		} else if(Gender.FEMALE.name().equalsIgnoreCase(associateModel.getGender())) {
			associateEntity.setGender(Gender.FEMALE.getValue());
		}		
		byte[] picInBytes;
		try {
			picInBytes = convertMultipartfileToBytes(file);
		} catch (IOException e) {
			throw new BusinessException(e.toString());
		}
		associateEntity.setPic(picInBytes);
	}
	
	private byte[] convertMultipartfileToBytes(MultipartFile file) throws IOException {
		try {
			return  file.getBytes();
		} catch (IOException e) {
			throw new IOException(e.toString());
		}
	}
	
	private void mapAssociateSkills(AssociateModel associateModel,AssociateEntity associateEntity) {
		List<SkillsEntity> skillsEntityList = new ArrayList<SkillsEntity>();
		SkillsEntity skillsEntity = null;
		for(SkillsModel skillModel :associateModel.getAssociateSkills()) {
			skillsEntity = new SkillsEntity();
			skillsEntity.setSkillId(skillModel.getSkillId());
			skillsEntity.setSkillName(skillModel.getSkillName());
			skillsEntityList.add(skillsEntity);
		}		
		associateEntity.setSkills(skillsEntityList);
		
	}
	
	public String deleteAssociate(int id) {
		associateDao.deleteAssociate(id);
		return CommonConstants.SUCCESS_STRING; 
	}
}

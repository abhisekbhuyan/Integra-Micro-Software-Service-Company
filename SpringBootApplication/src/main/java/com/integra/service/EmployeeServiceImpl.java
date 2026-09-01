package com.integra.service;


import java.util.ArrayList;
import java.util.List;


import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.integra.dto.EmpCanteenRequest;
import com.integra.dto.EmployeeCanteenDetailsDto;
import com.integra.dto.EmployeeDto;
import com.integra.entity.EmployeeCanteenDetailsEntity;
import com.integra.entity.EmployeeEntity;
import com.integra.exception.CommonNullException;
import com.integra.exception.SaveDataException;
import com.integra.repository.EmployeeCanteenDetailsRepository;
import com.integra.repository.EmployeeRepository;
import com.integra.entity.UserMasterEntity;
import com.integra.exception.UserMasterNotFoundException;
import com.integra.repository.UserMasterRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeCanteenDetailsRepository employeeCanteenDetailsRepository;
	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private UserMasterRepository userMasterRepository;
	
	//VALIDATING IF EMP EXISTS IN USER_MASTER
		@Override
		public EmployeeEntity get_empdetails(int emp_id) {
		log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method Start");
		EmployeeEntity get_edetails = employeerepository.get_details_ById(emp_id);
		try {
			log.debug(" EmployeeCanteenDetailsEntity : " + get_edetails.toString());
			if (!get_edetails.equals(null)) {
				log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method initiate");
			} else {
				log.info(" employeeDetails Is Null ");
				throw new CommonNullException();
			}
			}
		 catch (SaveDataException e) {
			log.error("Exception Occured while Saving the Data: " + e);
			throw new SaveDataException();
		} catch (NullPointerException e) {
			log.error("Null Exception Occured: " + e);
			throw new CommonNullException();
		} catch (Exception e) {
			log.error("Exception Occured : " + e);
			e.printStackTrace();
		}
		return get_edetails;
	}
	
	
	// SUPPORT USER DETAILS POST
		@Override
	    public EmployeeCanteenDetailsDto createCanteenEmployee(EmployeeCanteenDetailsDto employee_canteen_details)
	            throws SaveDataException, CommonNullException, UserMasterNotFoundException {
	        log.info("EmployeeServiceImpl: CreateCanteenEmployee Method Start");
	        EmployeeCanteenDetailsEntity employeeCanteenEntity = new EmployeeCanteenDetailsEntity();
	        EmployeeCanteenDetailsDto employeeCanteenDto = new EmployeeCanteenDetailsDto();
	        try {
	            log.debug(" EmployeeCanteenDetailsDto : " + employee_canteen_details.toString());
	            if (Objects.nonNull(employee_canteen_details.getEmp_id())) {
	            	UserMasterEntity userMaster = userMasterRepository.findByempid(employee_canteen_details.getEmp_id());
	                if (userMaster != null) {
	                    
	                    employeeCanteenEntity.setFirst_name(userMaster.getFirstName());
	                    employeeCanteenEntity.setLast_name(userMaster.getLastName());
	                    employeeCanteenEntity.setEmail(userMaster.getEmail());
	                    employeeCanteenEntity.setEmp_id(employee_canteen_details.getEmp_id());
	                    employeeCanteenEntity.setMeal_amount(100);
	                    employeeCanteenEntity.setStatus_code(0);
	                    employeeCanteenEntity.setCreated_date(employee_canteen_details.getCreated_date());
	                    employeeCanteenEntity.setModified_date(employee_canteen_details.getCreated_date());
	                    employeeCanteenEntity.setModified_by(userMaster.getEmail());
	                    employeeCanteenEntity.setCreated_by(userMaster.getEmail());
	                   
	                    // Save the entity
	                    EmployeeCanteenDetailsEntity saveEmployee = employeeCanteenDetailsRepository.save(employeeCanteenEntity);

	                    // Copy properties from saved entity to DTO
	                    BeanUtils.copyProperties(saveEmployee, employeeCanteenDto);
	                    
	                } else {
	                	
	                    throw new UserMasterNotFoundException("User master record not found for emp_id: " + employee_canteen_details.getEmp_id());
	                }

	            } else {
	                log.error(" employeeDto Is Null ");
	                throw new CommonNullException();
	            }
	        } catch (SaveDataException e) {
	            log.error("Exception Occurred while Saving the Data: " + e);
	            throw new SaveDataException();
	        } catch (NullPointerException e) {
	            log.error("Null Exception Occurred: " + e);
	            throw new CommonNullException();
	        } catch (Exception e) {
	            log.error("Exception Occurred : " + e);
	            e.printStackTrace();
	        }
	        return employeeCanteenDto;
	    }
	                    
	             
	                
	
	
	@Override
	public List<EmployeeCanteenDetailsEntity> getCanteenEmployeesbyStatusCode(int id) {
		log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method Start");
		List<EmployeeCanteenDetailsEntity> getid = employeeCanteenDetailsRepository.getByStatusCode(id);
		try {
			log.debug(" EmployeeCanteenDetailsEntity : " + getid.toString());
			if (!getid.isEmpty()) {
				log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method initiate");
			} else {
				log.info(" employeeDetails Is Null ");
				throw new CommonNullException();
			}
			}
		 catch (SaveDataException e) {
			log.error("Exception Occured while Saving the Data: " + e);
			throw new SaveDataException();	
		} catch (NullPointerException e) {
			log.error("Null Exception Occured: " + e);
			throw new CommonNullException();
		} catch (Exception e) {
			log.error("Exception Occured : " + e);
			e.printStackTrace();
		}
		return getid;
	}

	@Override
	public List<EmployeeCanteenDetailsEntity> updateEmployeeStatusCode(EmpCanteenRequest employee, int empId) {
		log.info("EmployeeServiceImpl: UpdateById Method Start");
		List<EmployeeCanteenDetailsDto> existingEmployeeDto = new ArrayList<>();
		 String[] dateParts = employee.getDate().split("-");
	        int year = Integer.parseInt(dateParts[0]);
	        int month = Integer.parseInt(dateParts[1]);

		List<EmployeeCanteenDetailsEntity> employeeCanteenEntity =  employeeCanteenDetailsRepository.getByEmp_Id(empId,month,year);
		employeeCanteenEntity.forEach((n)->{
			n.setStatus_code(employee.getStatus_code());
			employeeCanteenDetailsRepository.save(n);
		});
		
		return employeeCanteenEntity;
	}



	@Override
	public List<EmployeeCanteenDetailsEntity> listAll() {
	    return employeeCanteenDetailsRepository.findAll(Sort.by("id").ascending());
	}	

@Override
public ArrayList<EmployeeCanteenDetailsEntity> getCanteenFinance(EmployeeCanteenDetailsDto employee , int empId) {
	log.info("EmployeeServiceImpl: UpdateById Method Start");
	EmployeeCanteenDetailsDto existingEmployeeDto = new EmployeeCanteenDetailsDto();
	ArrayList<EmployeeCanteenDetailsEntity> existingEmployeeEntity = employeeCanteenDetailsRepository.performSearch(empId,1);
	for(EmployeeCanteenDetailsEntity itr : existingEmployeeEntity) {
		BeanUtils.copyProperties(itr, existingEmployeeDto);
		existingEmployeeDto.setTotal_amount(employeeCanteenDetailsRepository.totalAmount(1));
		existingEmployeeDto.setModified_by("Finance");
		existingEmployeeDto.setModified_date(employee.getModified_date());
		BeanUtils.copyProperties(existingEmployeeDto,itr);
		EmployeeCanteenDetailsEntity emp = employeeCanteenDetailsRepository.save(itr);
		BeanUtils.copyProperties(emp , existingEmployeeDto);
	}
	return existingEmployeeEntity;
}

	@Override
	public List<EmployeeCanteenDetailsEntity> getCanteenEmployeesbyEmployeeId(int id) {
		log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method Start");
		List<EmployeeCanteenDetailsEntity> getid = employeeCanteenDetailsRepository.getByEmployee_Id(id);
		try {
			log.debug(" EmployeeCanteenDetailsEntity : " + getid.toString());
			if (getid.equals(null)) {
				log.info("EmployeeServiceImpl: GetCanteenEmployeesbyId Method initiate");
			} else {
				log.info(" employeeDetails Is Null ");
				throw new CommonNullException();
			}
			}
		 catch (SaveDataException e) {
			log.error("Exception Occured while Saving the Data: " + e);
			throw new SaveDataException();
		} catch (NullPointerException e) {
			log.error("Null Exception Occured: " + e);
			throw new CommonNullException();
		} catch (Exception e) {
			log.error("Exception Occured : " + e);
			e.printStackTrace();
		}
		return getid;
	}


	@Override
	public List<EmployeeCanteenDetailsEntity> filterEmployeesByMonthAndYear(
			List<EmployeeCanteenDetailsEntity> listUsers, int month, int year) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EmployeeDto> getEmployeeCanteenDetailsGrouped(int month, int year) {
		// TODO Auto-generated method stub
		List<EmployeeDto> userArray=employeeList(1,month,year);
		return userArray;
	}


	private List<EmployeeDto> employeeList(int code, int month, int year) {
		// TODO Auto-generated method stub
		List<EmployeeDto> userStatus=new ArrayList<>();
		List<EmployeeEntity> userList=employeerepository.findAll();
		List<EmployeeCanteenDetailsEntity> userData = employeeCanteenDetailsRepository.getByStatusCodeTest(code,month,year);
		userList.forEach((n)->{
			List<EmployeeCanteenDetailsEntity> listSf = userData.stream().filter(e -> e.getEmp_id()==n.getEmp_id()).collect(Collectors.toList());
			if(listSf.size()!=0) {
				EmployeeDto s = new EmployeeDto();
				s.setEmp_id(n.getEmp_id());
				s.setFirst_name(n.getFirst_name());
				s.setLast_name(n.getLast_name());
				s.setEmail(n.getEmail());
				s.setMaxCount(listSf.size());
				s.setTotal(listSf.size()*100);
				userStatus.add(s);
			}
		});
		
		return userStatus;
	}


	@Override
	public List<EmployeeDto> getHrData(int month, int year) {
		
		List<EmployeeDto> userList=employeeList(0,month,year);
		return userList;
	
	}


	@Override
	public List<EmployeeCanteenDetailsEntity> getHrByEmpData(int emp_id, int month, int year) {
		
		List<EmployeeCanteenDetailsEntity> empId_Status=employeeCanteenDetailsRepository.checkForEmpIdAndStatus(emp_id,month,year);
		return empId_Status;
	}
}
//--------------------------------------------------------------------------
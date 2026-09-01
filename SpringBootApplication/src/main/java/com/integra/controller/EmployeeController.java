package com.integra.controller;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integra.Excel.EmployeeExcelExporter;
import com.integra.dto.EmpCanteenRequest;
import com.integra.dto.EmployeeCanteenDetailsDto;
import com.integra.dto.EmployeeDto;
import com.integra.dto.ResponseMessageDto;
import com.integra.entity.EmployeeCanteenDetailsEntity;
import com.integra.entity.EmployeeEntity;
import com.integra.entity.UserMasterEntity;
import com.integra.service.EmployeeService;
import com.integra.utils.CommonUtils;

import jakarta.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RequestMapping("/integra/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//VALIDATES WHETHER EMP EXISTS OR NO
		@GetMapping("/validate/{emp_id}")
	    public ResponseMessageDto get_empdetails(@PathVariable("emp_id") int emp_id) {
	    	log.info("EmployeeController: get_empdetails Method Start");
	    	EmployeeEntity emp_details = employeeService.get_empdetails(emp_id);	
			if (null != emp_details) {
				if(emp_details.equals(null)) {
					return CommonUtils.createSuccessResponse(200, "SUCCESS - NO RECORDS EXIST", "Null",
							emp_details);
					
					
				}else {
				log.info("EmployeeController: get_empdetails Method End");
				return CommonUtils.createSuccessResponse(200, "SUCCESS", "Fetched",
						emp_details);
				}
			} else {
				log.info("EmployeeController: get_empdetails Method End");
				return CommonUtils.createErrorResponse(402, "ERROR",
						"Unable to get your Data");
			}
	    }
		
	@PostMapping(value = "/create")
	public ResponseMessageDto createCanteenEmployee(@RequestBody EmployeeCanteenDetailsDto canteen_approval_statusDto) {
		log.info("EmployeeController: CreateCanteenEmployee Method Start");
		EmployeeCanteenDetailsDto createEmployee = employeeService.createCanteenEmployee(canteen_approval_statusDto);
		if (createEmployee.getEmp_id()!=null && createEmployee.getCreated_date()!=null) {
			log.info("EmployeeController: CreateCanteenEmployee Method End");
			return CommonUtils.createSuccessResponse(200, "SUCCESS", "Created",
					createEmployee);
		} else {
			log.info("EmployeeCont+roller: CreateCanteenEmployee Method End");
			return CommonUtils.createErrorResponse(400, "ERROR",
					"Unable to Save your Data");
		}
	}

	@GetMapping("/status/{statusId}")
    public ResponseMessageDto getCanteenEmployeeByStatusCode(@PathVariable("statusId") int statusId) {
    	log.info("EmployeeController: GetEmployeeStatusById Method Start");
    	List<EmployeeCanteenDetailsEntity> employeeStatus = employeeService.getCanteenEmployeesbyStatusCode(statusId);
    	
		if (null != employeeStatus) {
			if(employeeStatus.isEmpty()) {
				return CommonUtils.createSuccessResponse(200, "SUCCESS - NO RECORDS EXIST", "Null",
						employeeStatus);
				
				
			}else {
			log.info("EmployeeController: GetEmployeeStatusById Method End");
			return CommonUtils.createSuccessResponse(200, "SUCCESS", "Fetched",
					employeeStatus);
			}
		} else {
			log.info("EmployeeController: GetEmployeeStatusById Method End");
			return CommonUtils.createErrorResponse(402, "ERROR",
					"Unable to get your Data");
		}
    }
	
	@GetMapping("/hr")
    public ResponseMessageDto getHrData(@RequestParam(value = "date", required = false) String date) {
	    log.info("EmployeeController: getCanteenEmployeeByEmployeeId Method Start");

	    String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);

        String searchDate = String.format("%d-%02d", year, month);

        // Call the repository or service method to get grouped employee details
        List<EmployeeDto> groupedEmployeeDetails = employeeService.getHrData(month,year);

       return CommonUtils.createSuccessResponse(200, "SUCCESS", "Fetched all employees", groupedEmployeeDetails);
    }
	@GetMapping("/employeeCanteenDetails")
    public ResponseMessageDto getHrByEmpData(@RequestParam(value = "emp_id", required = false) int emp_id,@RequestParam(value = "date", required = false) String date) {
	    log.info("EmployeeController: getCanteenEmployeeByEmployeeId Method Start");
	    String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);

        String searchDate = String.format("%d-%02d", year, month);

        List<EmployeeCanteenDetailsEntity> groupedEmployeeDetails = employeeService.getHrByEmpData(emp_id,month,year);

       return CommonUtils.createSuccessResponse(200, "SUCCESS", "Fetched all employees", groupedEmployeeDetails);
    }

	
	
	
	
//	
//	@PutMapping("/finance/{empId}")
//    public ResponseMessageDto financeDetails(@RequestBody EmployeeCanteenDetailsDto employee , @PathVariable("empId") int empId) {
//    	log.info("EmployeeController: FinanceDetails Method Start");
//    	List<EmployeeCanteenDetailsEntity> employees = employeeService.getCanteenFinance(employee,empId);
//		if (null != employees) {
//			log.info("EmployeeController: FinanceDetails Method End");
//			return CommonUtils.createSuccessResponse(200, "SUCCESS", "Updated",
//					employees);
//			}else {
//			log.info("EmployeeController: FinanceDetails Method End");
//			return CommonUtils.createErrorResponse(402, "ERROR",
//					"Unable to get your Data");
//		}
//    }
		
//		@PutMapping(value = "/{statusCode}")
//		public ResponseMessageDto updateCanteenEmployeeTotalAmount(@RequestBody EmployeeCanteenDetailsDto employee,@PathVariable("statusCode") int statusCode) {
//			log.info("EmployeeController: UpdateCanteenEmployee Method Start");
//			List<EmployeeCanteenDetailsEntity> employeeStatus = employeeService.updateEmployeeStatusCode(employee,statusCode);
//			if (null != employeeStatus) {
//				log.info("EmployeeController: UpdateCanteenEmployee Method End");
//				return CommonUtils.createSuccessResponse(200, "Updated", "Updated",
//						employeeStatus);
//			} else {
//				log.info("EmployeeController: UpdateCanteenEmployee Method End");
//				return CommonUtils.createErrorResponse(402, "ERROR",
//						"Unable to Save your Data");
//			}
//	}
		
//		@GetMapping("/finance")
//		public ResponseMessageDto getCanteenEmployeeByEmployeeId(@RequestParam(value = "date", required = false) String date) {
//   	log.info("EmployeeController: GetEmployeeStatusById Method Start");
//  	  if (date != null && !date.isEmpty()) {
//    	        String[] dateParts = date.split("-");
//	    	        int year = Integer.parseInt(dateParts[0]);
//    	        int month = Integer.parseInt(dateParts[1]);
//
//    	        String searchDate = String.format("%d-%02d", year, month);
//	    	        
//	    	        // Get all employees from the service layer
//	    	        List<EmployeeCanteenDetailsEntity> allEmployees = employeeService.getCanteenEmployeesbyStatusCode(1);
//
//	    	        // Filter employees based on the search date
//	    	        List<EmployeeCanteenDetailsEntity> filteredEmployees = allEmployees.stream()
//	    	                .filter(employee -> {
//	    	                    // Extract the month and year from the created date of the employee
//	    	                    Date createdDate = employee.getCreated_date(); // Assuming getCreatedDate() returns a Date object
//	    	                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
//	    	                    String dateString = dateFormat.format(createdDate);
//
//	    	                    // Check if the created date matches the search date
//	    	                    return dateString.equals(searchDate);
//	    	                })
//	    	                .collect(Collectors.toList());
//
//	    	        if (!filteredEmployees.isEmpty()) {
//	    	            log.info("EmployeeController: getCanteenEmployeeByEmployeeId Method End");
//	    	            return CommonUtils.createSuccessResponse(201, "SUCCESS", "Fetched", filteredEmployees);
//	    	        } else {
//	    	            log.info("EmployeeController: getCanteenEmployeeByEmployeeId Method End");
//	    	            return CommonUtils.createErrorResponse(402, "ERROR", "No data found for the specified month and year.");
//	    	        }
//	    	    } else {
//	    	        // If no date parameter is provided, return all data
//	    	        List<EmployeeCanteenDetailsEntity> allEmployees = employeeService.getCanteenEmployeesbyStatusCode(1);
//	    	        log.info("EmployeeController: GetEmployeeStatusById Method End");
//	    	        return CommonUtils.createSuccessResponse(201, "SUCCESS", "Fetched all employees", allEmployees);
//	    	    }
//	    	}
		
		@GetMapping("/finance")
		public ResponseMessageDto getCanteenEmployeeByEmployeeId(@RequestParam(value = "date", required = false) String date) {
		    log.info("EmployeeController: getCanteenEmployeeByEmployeeId Method Start");

		    String[] dateParts = date.split("-");
	        int year = Integer.parseInt(dateParts[0]);
	        int month = Integer.parseInt(dateParts[1]);

	        String searchDate = String.format("%d-%02d", year, month);

	        // Call the repository or service method to get grouped employee details
	        List<EmployeeDto> groupedEmployeeDetails = employeeService.getEmployeeCanteenDetailsGrouped(month,year);

	return CommonUtils.createSuccessResponse(200, "SUCCESS", "Fetched all employees", groupedEmployeeDetails);

		}
		
		@PutMapping(value = "/{empId}")
		public ResponseMessageDto UpdateCanteenEmployeeTotalAmount(@RequestBody EmpCanteenRequest employee,@PathVariable("empId") int empId) {
			log.info("EmployeeController: UpdateCanteenEmployee Method Start");
			List<EmployeeCanteenDetailsEntity> employeeStatus = employeeService.updateEmployeeStatusCode(employee,empId);
			if (null != employeeStatus) {
				log.info("EmployeeController: UpdateCanteenEmployee Method End");
				return CommonUtils.createSuccessResponse(201, "SUCCESS", "Updated",
						employeeStatus);
			} else {
				log.info("EmployeeController: UpdateCanteenEmployee Method End");
				return CommonUtils.createErrorResponse(402, "ERROR",
						"Unable to Save your Data");
			}
	}
	
//-------------------------------------------------------------------------------------------------------------------------------
//		@GetMapping("/excel")
//		public void exportToExcel (@RequestParam(value = "date", required = false) String date,HttpServletResponse response) throws IOException, NoClassDefFoundError {
//		    response.setContentType("application/octet-stream");
//		    String headerKey = "Content-Disposition";
//		    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		    String currentDateTime = dateFormatter.format(new Date());
//		    String fileName =  "employee_"+ currentDateTime + ".xlsx";
//		    String headerValue = "attachment; filename=" + fileName;
//		    response.setHeader(headerKey, headerValue);
//
//		    // Fetch all employees
//		    List<EmployeeCanteenDetailsEntity> listUsers = null;
//		    if (date != null && !date.isEmpty() && !date.equals("undefined")) {
//		        String[] dateParts = date.split("-");
//		        int year = Integer.parseInt(dateParts[0]);
//		        int month = Integer.parseInt(dateParts[1]);
//		        listUsers = employeeService.getCanteenEmployeesbyStatusCode(1);
//
//		        // Fetch employees by the specified month and year
//		        listUsers = employeeService.filterEmployeesByMonthAndYear(listUsers, month, year);
//		    } else {
//		        // Fetch all employees if date is not specified
//		        listUsers = employeeService.getCanteenEmployeesbyStatusCode(1);
//		    }
		

		@GetMapping("/excel")
		public void exportToExcel (@RequestParam(value = "date", required = false) String date,HttpServletResponse response) throws IOException, NoClassDefFoundError {
		    response.setContentType("application/octet-stream");
		    String headerKey = "Content-Disposition";
		    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		    String currentDateTime = dateFormatter.format(new Date());
		    String fileName =  "employee_"+ currentDateTime + ".xlsx";
		    String headerValue = "attachment; filename=" + fileName;
		    response.setHeader(headerKey, headerValue);
		    String[] dateParts = date.split("-");
	        int year = Integer.parseInt(dateParts[0]);
	        int month = Integer.parseInt(dateParts[1]);
		    
		    

		    // Filter only the approved employees (status code 1)
		    List<EmployeeDto> approvedEmployees =employeeService.getEmployeeCanteenDetailsGrouped(month,year);
		   

		    // Export only approved employees
		    EmployeeExcelExporter excelExporter = new EmployeeExcelExporter(approvedEmployees);
		    excelExporter.export(response);
		}
		}


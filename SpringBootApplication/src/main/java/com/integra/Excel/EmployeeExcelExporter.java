package com.integra.Excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.integra.dto.EmployeeDto;
import com.integra.entity.EmployeeCanteenDetailsEntity;
import com.integra.service.EmployeeServiceImpl;


import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
public class EmployeeExcelExporter {
	
	 private XSSFWorkbook workbook;
	    private XSSFSheet sheet;
	    private List<EmployeeDto> listUsers;
	     
	    public EmployeeExcelExporter(List<EmployeeDto> listUsers) {
	        this.listUsers = listUsers;
	        workbook = new XSSFWorkbook();
	        sheet = workbook.createSheet("Employees");
	    }
	 
	    private void writeHeaderLine() {
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	       Cell cell = row.createCell(0);
	       cell.setCellValue("EMPLOYEE ID");
	       cell.setCellStyle(style);
	       
	       cell = row.createCell(1);
	       cell.setCellValue("FIRST NAME");   
	       cell.setCellStyle(style);
	       
	       cell = row.createCell(2);
	       cell.setCellValue("LAST NAME");
	       cell.setCellStyle(style);
	       
	       cell = row.createCell(3);
	       cell.setCellValue("EMAIL");
	       cell.setCellStyle(style);
	       
	       cell = row.createCell(4);
	       cell.setCellValue("MAX COUNT");  
	       cell.setCellStyle(style);
	       
	       cell = row.createCell(5);
	       cell.setCellValue("TOTAL"); 
	       cell.setCellStyle(style);
	       
	       
	    }
	     
	    private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                 
	        for (EmployeeDto user : listUsers) {
	            Row row = sheet.createRow(rowCount++);
	             //mapping
	            Cell cell = row.createCell(0);
	            cell.setCellValue(user.getEmp_id());
	            sheet.autoSizeColumn(0);
	            cell.setCellStyle(style);
	            
	            cell = row.createCell(1);
	            cell.setCellValue(user.getFirst_name());
	            sheet.autoSizeColumn(1);
	            cell.setCellStyle(style);
	            
	            cell = row.createCell(2);
	            cell.setCellValue(user.getLast_name());
	            sheet.autoSizeColumn(2);
	            cell.setCellStyle(style);
	            
	            cell = row.createCell(3);
	            cell.setCellValue(user.getEmail());
	            sheet.autoSizeColumn(3);
	            cell.setCellStyle(style);
	            
	            cell = row.createCell(4);
	            cell.setCellValue(user.getMaxCount());
	            sheet.autoSizeColumn(4);
	            cell.setCellStyle(style);
	            
	            cell = row.createCell(5);
	            cell.setCellValue(user.getTotal());
	            sheet.autoSizeColumn(5);
	            cell.setCellStyle(style);
	            
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }
}
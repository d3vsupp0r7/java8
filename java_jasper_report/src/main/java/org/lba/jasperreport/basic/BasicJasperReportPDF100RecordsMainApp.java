package org.lba.jasperreport.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class BasicJasperReportPDF100RecordsMainApp {
	
	public static void main(String[] args) {
		
		String reportPath = "C:\\jasperReport\\";
		
		try {
			//Step 1. Prepare collection data
			List<EmployeeBasic> empList = new ArrayList<>();
			int num = 100;
			for(int i = 0; i < num; i++) {
				
				EmployeeBasic e = null;
				
				if(i%2 == 0) {
					 e = new EmployeeBasic(i, "EmployeeName"+i, "Organization"+i, "Front-end Developer", 20000);
				}else
				
				if(i%3 == 0) {
					 e = new EmployeeBasic(i, "EmployeeName"+i, "Organization"+i, "Consultant", 40000);
				}else
				
				if(i%5 == 0) {
					 e = new EmployeeBasic(i, "EmployeeName"+i, "Organization"+i, "Sr. Java Engineer", 47000);
				}
				else
				if(i%17 == 0) {
					 e = new EmployeeBasic(i, "EmployeeName"+i, "Organization"+i, "CTO", 700000);
				}else {
					e = new EmployeeBasic(i, "EmployeeName"+i, "Organization"+i, "Junior Dev.", 18000);
				}
				
				empList.add(e);
			}
		
			
			//Step 2. Compile the report(.jrxml to .jasper) that we have designed using Jaspersoft iReport Designer tool.
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath  + "\\employee-rpt.jrxml");
			//Step 3. Pass teh collection data
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(empList);
			//Step 4. Optionally add a parameter
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("createdBy", "ExampleParameterPasseToReport");
			//Step 5.Fill the list of employee and parameters into the report 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			//Step 6: Output
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-100-Rpt.pdf");
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}

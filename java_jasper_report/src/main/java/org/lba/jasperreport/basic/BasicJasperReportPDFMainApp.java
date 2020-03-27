package org.lba.jasperreport.basic;

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

public class BasicJasperReportPDFMainApp {
	
	public static void main(String[] args) {
		
		String reportPath = "C:\\jasperReport\\";
		
		try {
			//Step 1. Prepare collection data
			
			List<EmployeeBasic> empList = Arrays.asList(
					new EmployeeBasic(1, "EmployeeName1", "Organization1", "Front-end Developer", 20000),
					new EmployeeBasic(2, "EmployeeName2", "Organization2", "Consultant", 40000),
					new EmployeeBasic(3, "EmployeeName3", "Organization3", "Sr. Java Engineer", 47000),
					new EmployeeBasic(4, "EmployeeName4", "Organization4", "CTO", 700000));
			
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
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-Rpt.pdf");
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}

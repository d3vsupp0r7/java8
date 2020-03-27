package org.lba.jasperreport.subreport.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MyWorkingSubreportExample2{
	
	public static JasperPrint jasperPrint;
	public static JasperReport mainReport;

	final static String reportsDirName = "C://jasperReport";
	final static String  jasperDirName = "C://jasperReport";

	final static String [] jrxmlFiles = {"1_basic_subreport_main",
	"1_basic_subreport_subreport1"};

	public static String getJasperDir(String jrxmldir){
		/**
		 * Return directory for compiled report. Normally it jaspers directory
		 * into reports directory. If jasper directoty missing it will create.
		 */
		String result = "";
		File jrxmlDir = new File(jrxmldir);
		File jasperDir = new File(jrxmldir);

		if (jrxmlDir.exists() && jrxmlDir.isDirectory()){
			boolean cdres = true;
			if (!jasperDir.exists()) {
				cdres = false;
				try {
					jasperDir.mkdir();
					cdres = true;
				} catch(SecurityException se){}
			}
			if (cdres) result = jrxmldir;
		}
		return result;
	}

	public static boolean compileJRXML(){
		/**
		 *  Compile all jrxml from reports to jasper and pur it to getJasperDir result.
		 */
		boolean result = false;
		String jdn = getJasperDir(reportsDirName);
		String s, o;
		File outf;
		try{
			for (String rep: jrxmlFiles){
				s = reportsDirName+"/"+rep+".jrxml";
				System.out.println("Out JRXML: " + s);
				o = jdn+"/"+rep+".jasper";
				System.out.println("Out JASPER: " + o);
				JasperCompileManager.compileReportToFile(s, o);
				outf = new File(o);
				if (!outf.exists()) return false;
			}
		} catch (JRException e) {
			System.out.println("compileJRXML: " + e);
			return false;
		}
		result = true;
		return result;
	}
	
	public static void main( String[] args ){
		
		System.out.println("** MyWorkingSubreportExample2 **");

		try{
			//Parameters for pass to report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			//Organize datasource
			OrderFactory of = new OrderFactory();
			List<OrderBean> dataSource = of.create(); 
			JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(dataSource);
			//Compile jrxml to jasper-files.
			FileInputStream mainReportFile = null;
			if (compileJRXML()){
				try{
					String s = getJasperDir(reportsDirName)+"/"+jrxmlFiles[0]+".jasper";
					mainReportFile = new FileInputStream(s);
					//pass directory with jasper-files as parameters
					parameters.put("SUBREPORT_DIR", getJasperDir(reportsDirName)+"/");
					//Fill report and view report.
					jasperPrint = JasperFillManager.fillReport(mainReportFile, parameters, beanDataSource);
					JasperViewer.viewReport(jasperPrint);
					/*PDF out file*/
					JasperReport mainReportFileOut = JasperCompileManager.compileReport("C://jasperReport//1_basic_subreport_main.jrxml");	
					JasperExportManager.exportReportToPdfFile(jasperPrint, reportsDirName + "\\1_Basic_SubReport-Rpt.pdf");
					/**/
				} catch (Exception fise){fise.printStackTrace();}
				finally {
					if (mainReportFile != null) mainReportFile.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

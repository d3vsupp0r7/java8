package org.lba.jasperreport.subreport.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MyWorkingSubreportExample3
{
    public static JasperPrint jasperPrint;
    public static JasperReport mainReport;

    final static String reportsDirName = System.getProperty("user.dir")+"/reports";
    final static String jasperDirName = "/jaspers";
    final static String [] jrxmlFiles = {"1_basic_subreport_main",
			"1_basic_subreport_subreport1"};

    public static String getJasperDir(String jrxmldir){
        /**
         * Return directory for compiled report. Normally it jaspers directory
         * into reports directory. If jasper directoty missing it will create.
         */
        String result = System.getProperty("user.home");
        File jrxmlDir = new File(jrxmldir);
        File jasperDir = new File(jrxmldir + jasperDirName);
        
        if (jrxmlDir.exists() && jrxmlDir.isDirectory()){
        	
            boolean cdres = true;
            if (!jasperDir.exists()) {
                cdres = false;
                try {
                    jasperDir.mkdir();
                    cdres = true;
                } catch(SecurityException se){}
            }
            if (cdres) result = jrxmldir + jasperDirName;
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
                o = jdn+"/"+rep+".jasper";
                JasperCompileManager.compileReportToFile(s, o);
                outf = new File(o);
                if (!outf.exists()) return false;
            }
        } catch (JRException e) {return false;}
        
        result = true;
        return result;
    }
    
    public static void main( String[] args ){
    	
    	System.out.println("** MyWorkingSubreportExample3 **");
    	
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
            //If you haven't plans to compile jrxml scip this call. Alternate
            //way to create a mainReportFile
            //import net.sf.jasperreports.engine.design.JasperDesign mainDesign = JRXmlLoader.load("/path/to/jrxml");
            //JasperReport mainReportFile = JasperCompileManager.compileReport(mainDesign);
                try{
                    String s = getJasperDir(reportsDirName)+"/"+jrxmlFiles[0]+".jasper";
                    mainReportFile = new FileInputStream(s);
                    //pass directory with jasper-files as parameters
                    parameters.put("SUBREPORT_DIR", getJasperDir(reportsDirName)+"/");
                    //Fill report and view report.
                    jasperPrint = JasperFillManager.fillReport(mainReportFile, parameters, beanDataSource);
                    JasperViewer.viewReport(jasperPrint);
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
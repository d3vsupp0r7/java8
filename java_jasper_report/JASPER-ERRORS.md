# Report using field not mapped into java class/or report

net.sf.jasperreports.engine.JRException: Error retrieving field value from bean: oraganization.
	at net.sf.jasperreports.engine.data.JRAbstractBeanDataSource.getBeanProperty(JRAbstractBeanDataSource.java:193)
	at net.sf.jasperreports.engine.data.JRAbstractBeanDataSource.getFieldValue(JRAbstractBeanDataSource.java:158)
	at net.sf.jasperreports.engine.data.JRBeanCollectionDataSource.getFieldValue(JRBeanCollectionDataSource.java:104)
	at net.sf.jasperreports.engine.fill.JRFillDataset.setOldValues(JRFillDataset.java:1489)
	at net.sf.jasperreports.engine.fill.JRFillDataset.next(JRFillDataset.java:1390)
	at net.sf.jasperreports.engine.fill.JRFillDataset.next(JRFillDataset.java:1366)
	at net.sf.jasperreports.engine.fill.JRBaseFiller.next(JRBaseFiller.java:1085)
	at net.sf.jasperreports.engine.fill.JRVerticalFiller.fillReport(JRVerticalFiller.java:113)
	at net.sf.jasperreports.engine.fill.JRBaseFiller.fill(JRBaseFiller.java:582)
	at net.sf.jasperreports.engine.fill.BaseReportFiller.fill(BaseReportFiller.java:414)
	at net.sf.jasperreports.engine.fill.JRFiller.fill(JRFiller.java:121)
	at net.sf.jasperreports.engine.JasperFillManager.fill(JasperFillManager.java:667)
	at net.sf.jasperreports.engine.JasperFillManager.fillReport(JasperFillManager.java:983)
	at spring4_jasperreport.Sample.main(Sample.java:38)
Caused by: java.lang.NoSuchMethodException: Unknown property 'oraganization' on class 'class spring4_jasperreport.Employee'
	at org.apache.commons.beanutils.PropertyUtilsBean.getSimpleProperty(PropertyUtilsBean.java:1277)
	at org.apache.commons.beanutils.PropertyUtilsBean.getNestedProperty(PropertyUtilsBean.java:808)
	at org.apache.commons.beanutils.PropertyUtilsBean.getProperty(PropertyUtilsBean.java:884)
	at org.apache.commons.beanutils.PropertyUtils.getProperty(PropertyUtils.java:464)
	at net.sf.jasperreports.engine.data.JRAbstractBeanDataSource.getBeanProperty(JRAbstractBeanDataSource.java:173)
	... 13 more

package org.lba.jasperreport.subreport.basic;


import java.util.Date;
import java.util.List;

public class OrderBean{
    /**
     *This class describes master records.
     */
    private String nDoc; //Document number
    private Date date; //Document date
    private List<OrderDetailBean> orderDetails;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getNDoc() {
        return nDoc;
    }
    public void setNDoc(String nDoc) {
        this.nDoc = nDoc;
    }
    public List<OrderDetailBean> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetailBean> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

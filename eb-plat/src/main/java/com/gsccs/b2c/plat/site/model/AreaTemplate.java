package com.gsccs.b2c.plat.site.model;


/**
 * @说明     指定区域物流费用模板
 * @开发者 mahong
 * @年月日 2015年4月27日
 * @时分秒 下午2:58:48
 */
public class AreaTemplate {
	
    private Integer id;
    private String dispatchingaddress;		//指定区域地址
    private Double firstweightcost;			//首重费用
    private Double plusweightcost;			//续重费用
    private Integer becometemplateid;		//所属物流运费表单ID
    /*===================================================================================*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    /*===================================================================================*/
    public String getDispatchingaddress() {
        return dispatchingaddress;
    }
    public void setDispatchingaddress(String dispatchingaddress) {
        this.dispatchingaddress = dispatchingaddress == null ? null : dispatchingaddress.trim();
    }
    /*===================================================================================*/
    public Double getFirstweightcost() {
        return firstweightcost;
    }
    public void setFirstweightcost(Double firstweightcost) {
        this.firstweightcost = firstweightcost;
    }
    /*===================================================================================*/
    public Double getPlusweightcost() {
        return plusweightcost;
    }
    public void setPlusweightcost(Double plusweightcost) {
        this.plusweightcost = plusweightcost;
    }
    /*===================================================================================*/
    public Integer getBecometemplateid() {
        return becometemplateid;
    }
    public void setBecometemplateid(Integer becometemplateid) {
        this.becometemplateid = becometemplateid;
    }
    /*===================================================================================*/
}
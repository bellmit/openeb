package com.gsccs.b2c.plat.site.model;


/**
 * @说明     添加物流配送模板
 * @开发者 ma hong
 * @年月日 2015年4月27日
 * @时分秒 上午2:26:22
 */
public class DistriTemplate {
	
    private Integer id;						//表单编号
    private String dispatchingname;			//配送方式名称
    private String logisticscompany;		//物流公司名称
    private String type;					//类型-先收款后发货-货到付款
    private Double firstweight;			//首重重量-kg-公斤
    private Double plusweight;			//续重重量-kg-公斤
    private Double firstweightcost;		//首重费用
    private Double plusweightcost;		//续重费用
    private String isnotsupportpremium;		//是否支持物流保价
    private Double premiumrate;			//保价费率- 百分数
    private Double lowestrate;			//最低保价费
    private String allcityapply;			//所有地区适用=1                    当指定适用所有地区时，字段designatedregions保存为空
    private String designatedregions;		//指定部分地区城市设置运费=2  
    private String description;				//配送方式介绍
    private Integer sort;					//排序
    private String whetherenable;			//是否启用模板
    /*===================================================================================*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    /*===================================================================================*/
    public String getDispatchingname() {
        return dispatchingname;
    }
    public void setDispatchingname(String dispatchingname) {
        this.dispatchingname = dispatchingname == null ? null : dispatchingname.trim();
    }
    /*===================================================================================*/
    public String getLogisticscompany() {
        return logisticscompany;
    }
    public void setLogisticscompany(String logisticscompany) {
        this.logisticscompany = logisticscompany == null ? null : logisticscompany.trim();
    }
    /*===================================================================================*/
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    /*===================================================================================*/
    public Double getFirstweight() {
        return firstweight;
    }
    public void setFirstweight(Double firstweight) {
        this.firstweight = firstweight;
    }
    /*===================================================================================*/
    public Double getPlusweight() {
        return plusweight;
    }
    public void setPlusweight(Double plusweight) {
        this.plusweight = plusweight;
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
    public String getIsnotsupportpremium() {
        return isnotsupportpremium;
    }
    public void setIsnotsupportpremium(String isnotsupportpremium) {
        this.isnotsupportpremium = isnotsupportpremium == null ? null : isnotsupportpremium.trim();
    }
    /*===================================================================================*/
    public Double getPremiumrate() {
        return premiumrate;
    }
    public void setPremiumrate(Double premiumrate) {
        this.premiumrate = premiumrate;
    }
    /*===================================================================================*/
    public Double getLowestrate() {
        return lowestrate;
    }
    public void setLowestrate(Double lowestrate) {
        this.lowestrate = lowestrate;
    }
    /*===================================================================================*/
    public String getAllcityapply() {
        return allcityapply;
    }
    public void setAllcityapply(String allcityapply) {
        this.allcityapply = allcityapply == null ? null : allcityapply.trim();
    }
    /*===================================================================================*/
    public String getDesignatedregions() {
        return designatedregions;
    }
    public void setDesignatedregions(String designatedregions) {
        this.designatedregions = designatedregions == null ? null : designatedregions.trim();
    }
    /*===================================================================================*/
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    /*===================================================================================*/
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    /*===================================================================================*/
    public String getWhetherenable() {
        return whetherenable;
    }
    public void setWhetherenable(String whetherenable) {
        this.whetherenable = whetherenable == null ? null : whetherenable.trim();
    }
    /*===================================================================================*/
}
package com.gsccs.b2c.plat.site.model;

public class Banner {
    private Integer id;

    private String maingraph;

    private String maingraphline;

    private String subgraph1;

    private String subgraph2;

    private String subgraphline1;

    private String subgraphline2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaingraph() {
        return maingraph;
    }

    public void setMaingraph(String maingraph) {
        this.maingraph = maingraph == null ? null : maingraph.trim();
    }

    public String getMaingraphline() {
        return maingraphline;
    }

    public void setMaingraphline(String maingraphline) {
        this.maingraphline = maingraphline == null ? null : maingraphline.trim();
    }

    public String getSubgraph1() {
        return subgraph1;
    }

    public void setSubgraph1(String subgraph1) {
        this.subgraph1 = subgraph1 == null ? null : subgraph1.trim();
    }

    public String getSubgraph2() {
        return subgraph2;
    }

    public void setSubgraph2(String subgraph2) {
        this.subgraph2 = subgraph2 == null ? null : subgraph2.trim();
    }

    public String getSubgraphline1() {
        return subgraphline1;
    }

    public void setSubgraphline1(String subgraphline1) {
        this.subgraphline1 = subgraphline1 == null ? null : subgraphline1.trim();
    }

    public String getSubgraphline2() {
        return subgraphline2;
    }

    public void setSubgraphline2(String subgraphline2) {
        this.subgraphline2 = subgraphline2 == null ? null : subgraphline2.trim();
    }
}
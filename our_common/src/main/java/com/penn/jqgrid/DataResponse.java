package com.penn.jqgrid;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/14.
 */
public class DataResponse<T> {
    private String page;
    private String total;
    private String records;
    private List<T> rows;
    private Map<String, Object> userdata;

    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getRecords() {
        return records;
    }
    public void setRecords(String records) {
        this.records = records;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    public Map<String, Object> getUserdata() {
        return userdata;
    }
    public void setUserdata(Map<String, Object> userdata) {
        this.userdata = userdata;
    }

}

package com.evan.android.agenda;

/**
 * Created by laila-usr on 05/11/2016.
 */
public class ItemPeople {

    private String colId;
    private String colName;
    private String colTel;

    public ItemPeople(String colId, String colName, String colTel){

        this.colId = colId;
        this.colName = colName;
        this.colTel = colTel;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColTel() {
        return colTel;
    }

    public void setColTel(String colTel) {
        this.colTel = colTel;
    }

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }
}

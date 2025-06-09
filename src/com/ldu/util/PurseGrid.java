package com.ldu.util;

import javax.xml.bind.annotation.XmlRootElement;

import com.ldu.pojo.Purse;

import java.util.List;


@XmlRootElement
public class PurseGrid {
    private int current;
    private int rowCount;
    private int total;
    private List<Purse> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Purse> getRows() {
        return rows;
    }

    public void setRows(List<Purse> rows) {
        this.rows = rows;
    }
}

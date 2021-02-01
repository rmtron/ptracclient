/*
 * Copyright(c) 2019 RELapps
 * All rights reserved.
 */
package relapps.ptrac.client.gs;

/**
 *
 * @author RMT
 */
public class GsAdminSettings {

    public String getCompanyName() {
        return companyName;
    }

    public int getPeriodType() {
        return periodType;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }
    private String companyName;
    private int periodType;
}

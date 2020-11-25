/*
 * Copyright(c) 2020 RELapps
 * All rights reserved.
 */
package relapps.ptrac.client.gs;

/**
 * Serialization of accumulated time for a user and project.
 *
 * @author RMT
 */
public class GsTimeAccum {

    public String getProjectOid() {
        return projectOid;
    }

    public GsTime getTime() {
        return time;
    }

    public String getUserOid() {
        return userOid;
    }

    public void setProjectOid(String projectOid) {
        this.projectOid = projectOid;
    }

    public void setTime(GsTime time) {
        this.time = time;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }
    private String projectOid;
    private GsTime time;
    private String userOid;
}

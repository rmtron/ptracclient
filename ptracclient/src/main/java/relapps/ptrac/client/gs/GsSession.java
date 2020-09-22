/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package relapps.ptrac.client.gs;

/**
 *
 * @author RMT
 */
public class GsSession {

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserOid() {
        return userOid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public boolean isPermAdminProject() {
        return permAdminProject;
    }

    public boolean isPermAdminReport() {
        return permAdminReport;
    }

    public boolean isPermAdminUser() {
        return permAdminUser;
    }

    public boolean isPermSuperuser() {
        return permSuperuser;
    }

    public boolean isPermTimereg() {
        return permTimereg;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setPermAdminProject(boolean permAdminProject) {
        this.permAdminProject = permAdminProject;
    }

    public void setPermAdminReport(boolean permAdminReport) {
        this.permAdminReport = permAdminReport;
    }

    public void setPermAdminUser(boolean permAdminUser) {
        this.permAdminUser = permAdminUser;
    }

    public void setPermSuperuser(boolean permSuperuser) {
        this.permSuperuser = permSuperuser;
    }

    public void setPermTimereg(boolean permTimereg) {
        this.permTimereg = permTimereg;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }
    private boolean authenticated = false;
    private boolean permAdminProject = false;
    private boolean permAdminReport = false;
    private boolean permAdminUser = false;
    private boolean permSuperuser = false;
    private boolean permTimereg = false;
    private String token = null;
    private String userName = null;
    private String userOid = null;
}

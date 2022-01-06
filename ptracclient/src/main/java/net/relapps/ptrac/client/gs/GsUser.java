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
package net.relapps.ptrac.client.gs;

/**
 * serialization of user object.
 *
 * @author RMT
 */
public class GsUser extends GsObject {

    public GsUser() {
    }

    public int getAccesses() {
        return accesses;
    }

    public String getAuthType() {
        return authType;
    }

    public String getCalendarOid() {
        return calendarOid;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateDeleted() {
        return dateDeleted;
    }

    public String getDateLastAccess() {
        return dateLastAccess;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public int[] getRoles() {
        return roles;
    }

    public String getUserId() {
        return userId;
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

    public void setAccesses(int accesses) {
        this.accesses = accesses;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public void setCalendarOid(String calendarOid) {
        this.calendarOid = calendarOid;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateDeleted(String dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public void setDateLastAccess(String dateLastAccess) {
        this.dateLastAccess = dateLastAccess;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setRoles(int[] roles) {
        this.roles = roles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private int accesses;
    private String authType;
    private String calendarOid;
    private String dateCreation;
    private String dateDeleted;
    private String dateLastAccess;
    private String dateModified;
    private String displayName;
    private String email;
    private String employeeId;
    private String firstName;
    private String lastName;
    private boolean permAdminProject = false;
    private boolean permAdminReport = false;
    private boolean permAdminUser = false;
    private boolean permSuperuser = false;
    private boolean permTimereg = false;
    private int roles[];
    private String userId;
}

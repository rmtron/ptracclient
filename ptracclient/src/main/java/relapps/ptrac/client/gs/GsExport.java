/*
 * Copyright(c) 2021 RELapps (https://relapps.net)
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
 * Parameters for data export.
 *
 * @author RMT
 */
public class GsExport {

    public String getSocketId() {
        return socketId;
    }

    public boolean isExportCalendars() {
        return exportCalendars;
    }

    public boolean isExportGroups() {
        return exportGroups;
    }

    public boolean isExportProjects() {
        return exportProjects;
    }

    public boolean isExportUsers() {
        return exportUsers;
    }

    public void setExportCalendars(boolean exportCalendars) {
        this.exportCalendars = exportCalendars;
    }

    public void setExportGroups(boolean exportGroups) {
        this.exportGroups = exportGroups;
    }

    public void setExportProjects(boolean exportProjects) {
        this.exportProjects = exportProjects;
    }

    public void setExportUsers(boolean exportUsers) {
        this.exportUsers = exportUsers;
    }

    public void setSocketId(String socketId) {
        this.socketId = socketId;
    }
    private boolean exportCalendars;
    private boolean exportGroups;
    private boolean exportProjects;
    private boolean exportUsers;
    private String socketId;
}

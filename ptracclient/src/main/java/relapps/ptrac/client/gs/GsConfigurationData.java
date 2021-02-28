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
public class GsConfigurationData {

    public String getDbHost() {
        return dbHost;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbPasswd() {
        return dbPasswd;
    }

    public int getDbPort() {
        return dbPort;
    }

    public String getDbType() {
        return dbType;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getLogFolder() {
        return logFolder;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setLogFolder(String logFolder) {
        this.logFolder = logFolder;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }
    private String dbHost;
    private String dbName;
    private String dbPasswd;
    private int dbPort;
    private String dbType;
    private String dbUser;
    private String logFolder;
    private boolean useSSL;
}

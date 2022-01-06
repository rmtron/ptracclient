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
 * Version information stored on relapps.net.
 *
 * @author RMT
 */
public class GsAppVersion {

    public String getDate() {
        return date;
    }

    public int getMajor() {
        return major;
    }

    public int getMicro() {
        return micro;
    }

    public int getMinor() {
        return minor;
    }

    public int getVersion() {
        return version;
    }

    public String getVersionString() {
        return versionString;
    }

    public boolean isIsNewer() {
        return isNewer;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIsNewer(boolean isNewer) {
        this.isNewer = isNewer;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public void setMicro(int micro) {
        this.micro = micro;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    private String date;
    private boolean isNewer;
    private int major;
    private int micro;
    private int minor;
    private int version;
    private String versionString;
}

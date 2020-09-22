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
public class GsVersion {

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
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

    public String getVersion() {
        return version;
    }

    public String getVersionString() {
        return versionString;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
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

    public void setVersion(String version) {
        this.version = version;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }
    private String copyright;
    private String date;
    private String description;
    private String email;
    private String homepage;
    private int major;
    private int micro;
    private int minor;
    private String version;
    private String versionString;
}

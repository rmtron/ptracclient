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
 * Serialization of administration settings.
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

    public boolean isUseWebSockets() {
        return useWebSockets;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }

    public void setUseWebSockets(boolean useWebSockets) {
        this.useWebSockets = useWebSockets;
    }
    private String companyName;
    private int periodType;
    private boolean useWebSockets;
}

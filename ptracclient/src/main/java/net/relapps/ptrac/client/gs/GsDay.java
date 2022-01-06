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
 * Serialization of a day.
 *
 * @author RMT
 */
public class GsDay {

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getShortName() {
        return shortName;
    }

    public GsTime getWorkHours() {
        return workHours;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setWorkHours(GsTime workHours) {
        this.workHours = workHours;
    }
    private String comment;
    private String date;
    private boolean holiday;
    private String shortName;
    private GsTime workHours;
}

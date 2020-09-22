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
 * Serialization calender data.
 *
 * @author RMT
 */
public class GsCalendar extends GsObject {

    public String getDescription() {
        return description;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public GsDay[] getHolidays() {
        return holidays;
    }

    public String getName() {
        return name;
    }

    public GsTime getWhFri() {
        return whFri;
    }

    public GsTime getWhMon() {
        return whMon;
    }

    public GsTime getWhSat() {
        return whSat;
    }

    public GsTime getWhSun() {
        return whSun;
    }

    public GsTime getWhThu() {
        return whThu;
    }

    public GsTime getWhTue() {
        return whTue;
    }

    public GsTime getWhWed() {
        return whWed;
    }

    public int getYear() {
        return year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setHolidays(GsDay[] holidays) {
        this.holidays = holidays;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWhFri(GsTime whFri) {
        this.whFri = whFri;
    }

    public void setWhMon(GsTime whMon) {
        this.whMon = whMon;
    }

    public void setWhSat(GsTime whSat) {
        this.whSat = whSat;
    }

    public void setWhSun(GsTime whSun) {
        this.whSun = whSun;
    }

    public void setWhThu(GsTime whThu) {
        this.whThu = whThu;
    }

    public void setWhTue(GsTime whTue) {
        this.whTue = whTue;
    }

    public void setWhWed(GsTime whWed) {
        this.whWed = whWed;
    }

    public void setYear(int year) {
        this.year = year;
    }
    private String description;
    private GsDay holidays[];
    private String name;
    private GsTime whFri;
    private GsTime whMon;
    private GsTime whSat;
    private GsTime whSun;
    private GsTime whThu;
    private GsTime whTue;
    private GsTime whWed;
    private int year;
}

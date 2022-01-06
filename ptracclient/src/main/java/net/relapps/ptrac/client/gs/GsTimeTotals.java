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
 *
 * @author RMT
 */
public class GsTimeTotals {

    public GsTime getBalance() {
        return balance;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public GsTime[] getDaySum() {
        return daySum;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public String[] getDays() {
        return days;
    }

    public GsTime getDiffTime() {
        return diffTime;
    }

    public GsTime getSchTotal() {
        return schTotal;
    }

    public GsTime getTotal() {
        return total;
    }

    public GsTime getTotalClock() {
        return totalClock;
    }

    public void setBalance(GsTime balance) {
        this.balance = balance;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setDaySum(GsTime[] daySum) {
        this.daySum = daySum;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setDays(String[] days) {
        this.days = days;
    }

    public void setDiffTime(GsTime diffTime) {
        this.diffTime = diffTime;
    }

    public void setSchTotal(GsTime schTotal) {
        this.schTotal = schTotal;
    }

    public void setTotal(GsTime total) {
        this.total = total;
    }

    public void setTotalClock(GsTime totalClock) {
        this.totalClock = totalClock;
    }
    private GsTime balance;
    private GsTime daySum[];
    private String days[];
    private GsTime diffTime;
    private GsTime schTotal;
    private GsTime total;
    private GsTime totalClock;
}

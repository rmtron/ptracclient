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
package net.relapps.ptrac.client.core;

import java.time.LocalDate;
import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiTimeRec;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.gs.GsDateRange;
import net.relapps.ptrac.client.gs.GsDateRangeOids;
import net.relapps.ptrac.client.gs.GsDateRangeProject;
import net.relapps.ptrac.client.gs.GsDay;
import net.relapps.ptrac.client.gs.GsDayRecord;
import net.relapps.ptrac.client.gs.GsPeriod;
import net.relapps.ptrac.client.gs.GsProjectUserTime;
import net.relapps.ptrac.client.gs.GsTimeAccum;
import net.relapps.ptrac.client.gs.GsTimeRecord;

/**
 * API for time record operations.
 *
 * @author RMT
 */
public class ApiTimeRec implements IApiTimeRec {

    ApiTimeRec(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public void freezeDaysForAll(GsDateRange range)
            throws XHttpError, XApiError, XError, XAppError {
        _webClient.sendRequest(getService("/freezeDaysForAll"),
                EHttpMethod.POST, range);
    }

    @Override
    public GsPeriod getCurrentPeriod()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getCurrentPeriod"),
                EHttpMethod.POST, GsPeriod.class);
    }

    @Override
    public GsDayRecord[] getDayRecordsUser(String userOid, GsDateRange range)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getDayRecordsUser"),
                EHttpMethod.POST, getRangeOid(userOid, range),
                GsDayRecord[].class);
    }

    @Override
    public GsDay[] getDaysUser(String userOid, GsDateRange range)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getDaysUser"),
                EHttpMethod.POST, getRangeOid(userOid, range),
                GsDay[].class);
    }

    @Override
    public byte[] getExcelGroups(LocalDate dateFrom, LocalDate dateTo,
            String[] oidGroups)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        return _webClient.sendBlobRequest(getService("/getExcelGroups"),
                EHttpMethod.POST, inp);
    }

    @Override
    public byte[] getOdsGroups(LocalDate dateFrom, LocalDate dateTo,
            String[] oidGroups)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        return _webClient.sendBlobRequest(getService("/getOdsGroups"),
                EHttpMethod.POST, inp);
    }

    @Override
    public GsPeriod getPeriod(String periodId)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getPeriod"),
                EHttpMethod.POST, periodId, GsPeriod.class);
    }

    @Override
    public GsProjectUserTime[] getProjectUserTimeReportGroups(
            GsDateRangeOids dateRange)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService(
                "/getProjectUserTimeReportGroups"),
                EHttpMethod.POST, dateRange, GsProjectUserTime[].class);
    }

    @Override
    public GsPeriod[] getTimePeriods(int year)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getTimePeriods"),
                EHttpMethod.POST, year, GsPeriod[].class);
    }

    @Override
    public GsTimeRecord[] getTimeRecords(LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRange dateRange = new GsDateRange();
        dateRange.setFrom(dateFrom.toString());
        dateRange.setTo(dateTo.toString());
        return _webClient.sendRequest(getService("/getTimeRecordsDateRange"),
                EHttpMethod.POST, dateRange, GsTimeRecord[].class);
    }

    @Override
    public GsTimeRecord[] getTimeRecordsGroups(String[] oidGroups,
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        return _webClient.sendRequest(getService("/getTimeRecordsGroups"),
                EHttpMethod.POST, inp, GsTimeRecord[].class);
    }

    @Override
    public GsTimeAccum[] getTimeRecordsGroupsAcc(String[] oidGroups,
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        return _webClient.sendRequest(getService("/getTimeRecordsGroupsAcc"),
                EHttpMethod.POST, inp, GsTimeAccum[].class);
    }

    @Override
    public GsTimeRecord[] getTimeRecordsProject(String oidProject,
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeProject inp = new GsDateRangeProject();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setProjectOid(oidProject);
        GsTimeRecord records[]
                = _webClient.sendRequest(getService("/getTimeRecordsProject"),
                        EHttpMethod.POST, inp, GsTimeRecord[].class);
        return records;
    }

    private GsDateRangeOids getRangeOid(String oid, GsDateRange range) {
        GsDateRangeOids rangeOid = new GsDateRangeOids();
        rangeOid.setFrom(range.getFrom());
        rangeOid.setTo(range.getTo());
        String oids[] = {oid};
        rangeOid.setOids(oids);
        return rangeOid;
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/timerec";
    private final WebClient _webClient;
}

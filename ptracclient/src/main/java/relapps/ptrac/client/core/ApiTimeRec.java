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
package relapps.ptrac.client.core;

import java.time.LocalDate;
import relapps.ptrac.client.exif.EHttpMethod;
import relapps.ptrac.client.exif.IApiTimeRec;
import relapps.ptrac.client.exif.XApiError;
import relapps.ptrac.client.exif.XAppError;
import relapps.ptrac.client.exif.XError;
import relapps.ptrac.client.exif.XHttpError;
import relapps.ptrac.client.gs.GsDateRange;
import relapps.ptrac.client.gs.GsDateRangeOids;
import relapps.ptrac.client.gs.GsDateRangeProject;
import relapps.ptrac.client.gs.GsTimeRecord;

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

    @Override
    public byte[] getExcelGroups(LocalDate dateFrom, LocalDate dateTo,
            String[] oidGroups)
            throws XHttpError, XApiError, XError, XAppError {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        byte data[]
                = _webClient.sendBlobRequest(getService("/getExcelGroups"),
                        EHttpMethod.POST, inp);
        return data;
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/timerec";
    private final WebClient _webClient;
}

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

import relapps.ptrac.client.exif.IApiTimeRec;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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

    /**
     * Returns the time records for a list of groups in a time range.
     *
     * @param oidGroups A vector of the group OIDs.
     * @param dateFrom The from date.
     * @param dateTo The to date.
     * @return A vector of the time records.
     * @throws Exception
     */
    @Override
    public GsTimeRecord[] getTimeRecordsGroups(String[] oidGroups,
            LocalDate dateFrom, LocalDate dateTo)
            throws Exception {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setOids(oidGroups);
        return _webClient.sendRequest("GetTimeRecordsGroups",
                inp, GsTimeRecord[].class);
    }

    /**
     * Returns the time records for a project in a time range. Note: Returns
     * records for all days even when time is 0.
     *
     * @param oidProject The project OID.
     * @param dateFrom The from date.
     * @param dateTo The to date.
     * @return A vector of the time records.
     * @throws Exception
     */
    @Override
    public List<GsTimeRecord> getTimeRecordsProject(String oidProject,
            LocalDate dateFrom, LocalDate dateTo)
            throws Exception {
        GsDateRangeProject inp = new GsDateRangeProject();
        inp.setFrom(dateFrom.toString());
        inp.setTo(dateTo.toString());
        inp.setProjectOid(oidProject);
        GsTimeRecord records[] = _webClient.sendRequest("GetTimeRecordsProject",
                inp, GsTimeRecord[].class);
        return Arrays.asList(records);
    }
    private final WebClient _webClient;
}

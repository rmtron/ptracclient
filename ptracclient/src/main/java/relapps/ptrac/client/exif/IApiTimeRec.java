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
package relapps.ptrac.client.exif;

import java.time.LocalDate;
import relapps.ptrac.client.gs.GsPeriod;
import relapps.ptrac.client.gs.GsTimeAccum;
import relapps.ptrac.client.gs.GsTimeRecord;

/**
 * API functions related to time records.
 *
 * @author RMT
 */
public interface IApiTimeRec {

    /**
     * Returns an Excel report for the specified date range and groups.
     *
     * @param dateFrom The date from.
     * @param dateTo The date to.
     * @param oidGroups A list of the group OIDs.
     * @return An excel file.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    byte[] getExcelGroups(LocalDate dateFrom, LocalDate dateTo,
            String[] oidGroups)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Returns the periods for a given year.
     *
     * @param year The year.
     * @return A list of periods.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsPeriod[] getTimePeriods(int year)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Returns the time records in a time range.
     *
     * @param dateFrom The from date, use null to not specify a from date.
     * @param dateTo The to date, use null to not specify a to date.
     * @return A vector of the time records.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsTimeRecord[] getTimeRecords(
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Returns the time records for a list of groups in a time range.
     *
     * @param oidGroups A vector of the group OIDs.
     * @param dateFrom The from date.
     * @param dateTo The to date.
     * @return A vector of the time records.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsTimeRecord[] getTimeRecordsGroups(String[] oidGroups, LocalDate dateFrom,
            LocalDate dateTo) throws XHttpError, XApiError, XError, XAppError;
    /**
     * Get time records for groups and periods. Returns project time accumulated
     * for a list of groups in a time range with totals for periods.
     *
     * @param oidGroups A vector of the group OIDs.
     * @param dateFrom The from date.
     * @param dateTo The to date.
     * @return A vector of the accumulated times for users-projects.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsTimeAccum[] getTimeRecordsGroupsAcc(String[] oidGroups,
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Returns the time records for a project in a time range. Note: Returns
     * records for all days even when time is 0.
     *
     * @param oidProject The project OID.
     * @param dateFrom The from date.
     * @param dateTo The to date.
     * @return A vector of the time records.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsTimeRecord[] getTimeRecordsProject(String oidProject,
            LocalDate dateFrom, LocalDate dateTo)
            throws XHttpError, XApiError, XError, XAppError;
}

/*
 * Copyright(c) 2021 RELapps (https://relapps.net)
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
package net.relapps.ptrac.client.exif;

import net.relapps.ptrac.client.gs.GsCalendar;

/**
 * API for calendar management.
 *
 * @author RMT
 */
public interface IApiCalendar {

    /**
     * Create a new calendar.
     *
     * @param cal The calendar data.
     * @return The created calendar.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsCalendar createCalendar(GsCalendar cal)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Delete a calendar.
     *
     * @param calendarOid The calendar OID.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    void deleteCalendar(String calendarOid)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Export a calendar to JSON.
     *
     * @param calendarOid The calendar OID.
     * @return The exported JSON string.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    String exportCalendar(String calendarOid)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Get the defined calendars.
     *
     * @return A list of the calendars.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsCalendar[] getCalendars() throws XHttpError, XApiError, XError, XAppError;
    /**
     * Save a calendar to the database.
     *
     * @param calendar The calendar data to save.
     * @return The saved calendar.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsCalendar saveCalendar(GsCalendar calendar)
            throws XHttpError, XApiError, XError, XAppError;
}

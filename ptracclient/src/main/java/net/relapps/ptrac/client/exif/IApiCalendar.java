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
     * Get the defined calendars.
     *
     * @return A list of the calendars.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsCalendar[] getCalendars() throws XHttpError, XApiError, XError, XAppError;
}

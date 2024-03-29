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
package net.relapps.ptrac.client.exif;

/**
 * The interface to the web APIs.
 *
 * @author RMT
 */
public interface IWebApi {

    /**
     * Returns the calendar operations API.
     *
     * @return The API.
     */
    IApiCalendar getCalendarApi();

    /**
     * Returns the export/import operations API.
     *
     * @return The API.
     */
    IApiExportImport getExportImportApi();

    /**
     * Returns the miscellaneous operations API.
     *
     * @return The API.
     */
    IApiMisc getMiscApi();

    /**
     * Returns the project operations API.
     *
     * @return The API.
     */
    IApiProject getProjectApi();

    /**
     * Returns the session operations API.
     *
     * @return The API.
     */
    IApiSession getSessionApi();

    /**
     * Returns the time record operations API.
     *
     * @return The API.
     */
    IApiTimeRec getTimeRecApi();

    /**
     * Returns the user and groups operations API.
     *
     * @return The API.
     */
    IApiUser getUserApi();
}

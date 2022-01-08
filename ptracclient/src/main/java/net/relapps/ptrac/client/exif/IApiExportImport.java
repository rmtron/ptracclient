/*
 * Copyright(c) 2022 RELapps (https://relapps.net)
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

import net.relapps.ptrac.client.gs.GsExport;
import net.relapps.ptrac.client.gs.GsExportTimeRecords;
import net.relapps.ptrac.client.gs.GsImportData;
import net.relapps.ptrac.client.gs.GsText;

/**
 *
 * @author RMT
 */
public interface IApiExportImport {

    /**
     * Export data from the ptrac database to ptrac export format (zip).
     *
     * @param export Specifies what to export.
     * @return The exported data in ptrac export format (zip).
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    byte[] export(GsExport export)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Export time records from the ptrad database to ptrac export format (zip).
     *
     * @param export Specifies what to export.
     * @return The exported data in ptrac export format (zip).
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    byte[] exportTimerecords(GsExportTimeRecords export)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Import data from a file with ptrac export format.
     *
     * @param data The data to import.
     * @return The status description of the import.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsText importData(GsImportData data)
            throws XHttpError, XApiError, XError, XAppError;
}

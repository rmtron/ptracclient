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
package net.relapps.ptrac.client.core;

import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiExportImport;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.gs.GsExport;
import net.relapps.ptrac.client.gs.GsExportTimeRecords;
import net.relapps.ptrac.client.gs.GsImportData;
import net.relapps.ptrac.client.gs.GsText;

/**
 * Handles export/input.
 *
 * @author RMT
 */
public class ApiExportImport implements IApiExportImport {

    ApiExportImport(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public byte[] export(GsExport export)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendBlobRequest(getService("/export"),
                EHttpMethod.POST, export);
    }

    @Override
    public byte[] exportTimerecords(GsExportTimeRecords export) throws
            XHttpError, XApiError, XError, XAppError {
        return _webClient.sendBlobRequest(getService("/exportTimeRecords"),
                EHttpMethod.POST, export);
    }

    @Override
    public GsText importData(GsImportData data) throws XHttpError, XApiError,
            XError, XAppError {
        return _webClient.sendRequest(getService("/import"),
                EHttpMethod.POST, data, GsText.class);
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/expimp";
    private final WebClient _webClient;

}

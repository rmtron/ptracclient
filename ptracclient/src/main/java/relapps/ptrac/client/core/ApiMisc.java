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

import relapps.ptrac.client.exif.EHttpMethod;
import relapps.ptrac.client.exif.IApiMisc;
import relapps.ptrac.client.exif.XApiError;
import relapps.ptrac.client.exif.XAppError;
import relapps.ptrac.client.exif.XError;
import relapps.ptrac.client.exif.XHttpError;
import relapps.ptrac.client.gs.GsAppVersion;
import relapps.ptrac.client.gs.GsVersion;

/**
 *
 * @author RMT
 */
public class ApiMisc implements IApiMisc {

    ApiMisc(WebClient webClient) {
        _webClient = webClient;
    }

    public GsAppVersion getLatestVersion()
            throws XHttpError, XApiError, XError, XAppError {
        GsAppVersion project = _webClient.
                sendRequest("latestVersion", EHttpMethod.GET, GsAppVersion.class);
        return project;
    }

    @Override
    public GsVersion getVersion()
            throws XHttpError, XApiError, XError, XAppError {
        GsVersion project = _webClient.
                sendRequest("version", EHttpMethod.GET, GsVersion.class);
        return project;
    }
    private final WebClient _webClient;
}

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

import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiSession;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.gs.GsSession;
import net.relapps.ptrac.client.gs.GsSessionInfo;

/**
 * API for session related operations.
 *
 * @author RMT
 */
public class ApiSession implements IApiSession {

    ApiSession(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public void forgetSession()
            throws XHttpError, XApiError, XError, XAppError {
        _webClient.sendRequest(getService("/forgetSession"), EHttpMethod.POST);
    }

    @Override
    public GsSession getCurrentSession()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getSession"),
                EHttpMethod.POST, GsSession.class);
    }

    @Override
    public Integer getSessionDuration()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getSessionDuration"),
                EHttpMethod.POST, Integer.class);
    }

    @Override
    public GsSessionInfo[] getSessions()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getSessions"),
                EHttpMethod.POST, GsSessionInfo[].class);
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/session";
    private final WebClient _webClient;
}

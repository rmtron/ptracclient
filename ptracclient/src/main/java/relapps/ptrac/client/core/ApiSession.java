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

import relapps.ptrac.client.exif.IApiSession;
import relapps.ptrac.client.gs.GsSession;

/**
 * API for session related operations.
 *
 * @author RMT
 */
public class ApiSession implements IApiSession {
    ApiSession(WebClient webClient) {
        _webClient = webClient;
    }

    /**
     * Forget (dispose) the session.
     *
     * @throws Exception
     */
    @Override
    public void forgetSession() throws Exception {
        _webClient.sendRequest("ForgetSession");
    }

    @Override
    public GsSession getCurrentSession() throws Exception {
        return _webClient.sendRequest("GetSession", GsSession.class);
    }

    @Override
    public Integer getSessionDuration() throws Exception {
        return _webClient.sendRequest("GetSessionDuration", Integer.class);
    }

    private final WebClient _webClient;
}

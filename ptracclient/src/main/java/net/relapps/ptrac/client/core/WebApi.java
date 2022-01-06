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

import java.net.MalformedURLException;
import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiCalendar;
import net.relapps.ptrac.client.exif.IApiMisc;
import net.relapps.ptrac.client.exif.IWebApi;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.exif.XInvalidCredentials;
import net.relapps.ptrac.client.gs.GsCredentials;
import net.relapps.ptrac.client.gs.GsSession;

/**
 * The API handler.
 *
 * @author RMT
 */
public class WebApi implements IWebApi {

    /**
     * Create a new instance of WebApi.
     *
     * @param rootURL The web services root URL.
     * @param user The user (login).
     * @param passwd The password.
     * @throws MalformedURLException Thrown on invalid URL.
     * @throws XInvalidCredentials Thrown on invalid credentials.
     * @throws XApiError Thrown on error.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     * @throws XHttpError Error response from the backend.
     */
    public WebApi(String rootURL, String user, String passwd)
            throws MalformedURLException, XInvalidCredentials, XApiError,
            XHttpError, XError, XAppError {
        _webClient = new WebClient(rootURL);

        // Authenticate by creating a session.
        // Create credentials data
        GsCredentials cred = new GsCredentials();
        cred.setUser(user);
        cred.setPassword(passwd);

        // Send a create session request.
        GsSession session
                = _webClient.sendRequest("session/createSession",
                        EHttpMethod.POST, cred, GsSession.class);
        if (session == null) {
            throw new XInvalidCredentials("Invalid credentials.");
        }

        // Assign the autorization token (session).
        _webClient.setAutorization(session.getToken());
    }

    @Override
    public IApiCalendar getCalendarApi() {
        if (_apiCal == null) {
            _apiCal = new ApiCalendar(_webClient);
        }
        return _apiCal;
    }

    @Override
    public IApiMisc getMiscApi() {
        if (_apiMisc == null) {
            _apiMisc = new ApiMisc(_webClient);
        }
        return _apiMisc;
    }

    @Override
    public ApiProject getProjectApi() {
        if (_apiProject == null) {
            _apiProject = new ApiProject(_webClient);
        }
        return _apiProject;
    }

    @Override
    public ApiSession getSessionApi() {
        if (_apiSession == null) {
            _apiSession = new ApiSession(_webClient);
        }
        return _apiSession;
    }

    @Override
    public ApiTimeRec getTimeRecApi() {
        if (_apiTimeRec == null) {
            _apiTimeRec = new ApiTimeRec(_webClient);
        }
        return _apiTimeRec;
    }

    @Override
    public ApiUser getUserApi() {
        if (_apiUser == null) {
            _apiUser = new ApiUser(_webClient);
        }
        return _apiUser;
    }
    private ApiCalendar _apiCal;
    private ApiMisc _apiMisc;
    private ApiProject _apiProject;
    private ApiSession _apiSession;
    private ApiTimeRec _apiTimeRec;
    private ApiUser _apiUser;
    private final WebClient _webClient;
}

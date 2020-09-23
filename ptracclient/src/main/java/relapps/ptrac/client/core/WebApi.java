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

import java.net.MalformedURLException;
import relapps.ptrac.client.exif.IApiMisc;
import relapps.ptrac.client.exif.IWebApi;
import relapps.ptrac.client.exif.XInvalidCredentials;
import relapps.ptrac.client.gs.GsCredentials;
import relapps.ptrac.client.gs.GsSession;

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
     * @throws Exception Thrown on error.
     */
    public WebApi(String rootURL, String user, String passwd)
            throws MalformedURLException, XInvalidCredentials, Exception {
        _webClient = new WebClient(rootURL);

        // Authenticate by creating a session.
        // Create credentials data
        GsCredentials cred = new GsCredentials();
        cred.setUser(user);
        cred.setPassword(passwd);
        try {
            // Send a create session request.
            GsSession session = _webClient.sendRequest("CreateSession",
                    cred, GsSession.class);
            if (session == null) {
                throw XInvalidCredentials("Invalid credentials.");
            }

            // Assign the autorization token (session).
            _webClient.setAutorization(session.getToken());
        } catch (Exception ex) {
            throw ex;
        }
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

    private Exception XInvalidCredentials(String invalid_credentials) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ApiMisc _apiMisc;
    private ApiProject _apiProject;
    private ApiSession _apiSession;
    private ApiTimeRec _apiTimeRec;
    private ApiUser _apiUser;
    private final WebClient _webClient;
}

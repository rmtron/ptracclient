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

import java.net.MalformedURLException;
import net.relapps.ptrac.client.core.WebApi;

/**
 * Handles the creation of the connection to the ptrac web API.
 *
 * @author RMT
 */
public class FWebApi {

    private FWebApi() {
    }

    /**
     * Connect to the ptrac service and returns a new instance of IWebApi.
     *
     * @param url The ptrac URL.
     * @param user The ptrac user.
     * @param passwd The user password.
     * @return The web API object.
     * @throws MalformedURLException Thrown on invalid URL.
     * @throws XInvalidCredentials Thrown on invalid credentials.
     * @throws XApiError Thrown on error in API.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     * @throws XHttpError Error response from the back-end.
     *
     */
    public static IWebApi connect(String url, String user, String passwd)
            throws MalformedURLException, XInvalidCredentials, XApiError,
            XHttpError, XError, XAppError {
        return new WebApi(url, user, passwd);
    }
}

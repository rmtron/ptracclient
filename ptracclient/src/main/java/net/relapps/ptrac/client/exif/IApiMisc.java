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

import net.relapps.ptrac.client.gs.GsAppVersion;
import net.relapps.ptrac.client.gs.GsVersion;

/**
 * Miscellaneous operations.
 *
 * @author RMT
 */
public interface IApiMisc {

    /**
     * Returns information about the latest official release.
     *
     * @return The application information.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsAppVersion getLatestVersion()
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Returns the ptrac version information.
     *
     * @return The version information.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsVersion getVersion() throws XHttpError, XApiError, XError, XAppError;
}

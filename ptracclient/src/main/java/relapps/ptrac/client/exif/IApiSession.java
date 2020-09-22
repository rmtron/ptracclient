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
package relapps.ptrac.client.exif;

import relapps.ptrac.client.gs.GsSession;

/**
 *
 * @author RMT
 */
public interface IApiSession {

    /**
     * Forget (dispose) the session.
     *
     * @throws Exception
     */
    void forgetSession() throws Exception;

    /**
     * Get information about the current session.
     *
     * @return The session information.
     * @throws Exception
     */
    GsSession getCurrentSession() throws Exception;

    /**
     * Returns the maximum inactive session duration in seconds before closing
     * session.
     *
     * @return The time in seconds.
     * @throws Exception
     */
    Integer getSessionDuration() throws Exception;
}
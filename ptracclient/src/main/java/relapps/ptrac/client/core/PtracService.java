/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package relapps.ptrac.client.core;

import java.io.IOException;
import java.net.MalformedURLException;
import relapps.ptrac.client.gs.GsCredentials;
import relapps.ptrac.client.gs.GsSession;

/**
 * Represents the Web service interface for ptrac.
 *
 * @author RMT
 */
public class PtracService {

    private PtracService() {
    }

    /**
     * Connect to the ptrac service.
     *
     * @param url The ptrac URL.
     * @param user The ptrac user.
     * @param passwd The user password.
     * @return The connection created.
     * @throws MalformedURLException
     * @throws IOException
     * @throws Exception
     */
    public static PtracConnection connect(String url, String user, String passwd)
            throws MalformedURLException, IOException, Exception {
        WebClient webClient = new WebClient(url);

        // Authenticate by creating a session.
        // Create credentials data
        GsCredentials cred = new GsCredentials();
        cred.setUser(user);
        cred.setPassword(passwd);
        try {
            // Send a create session request.
            GsSession session = webClient.sendRequest("CreateSession",
                    cred, GsSession.class);

            // Assign the autorization token (session).
            webClient.setAutorization(session.getToken());
        } catch (Exception ex) {
            throw ex;
        }
        return new PtracConnection(webClient);
    }
}

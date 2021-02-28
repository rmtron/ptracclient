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
package relapps.ptracexample.client;

import relapps.ptrac.client.exif.FWebApi;
import relapps.ptrac.client.exif.IWebApi;
import relapps.ptrac.client.exif.XHttpError;
import relapps.ptrac.client.gs.GsProject;
import relapps.ptrac.client.gs.GsUser;
import relapps.ptrac.client.gs.GsVersion;

/**
 * Example accessing the ptrac Web Services.
 *
 * @author RMT
 */
public class Example {
    @SuppressWarnings({"CallToPrintStackTrace"})
    public static void main(String... args) {
        try {
            execute();
        } catch (XHttpError ex) {
            println("HTTP error code returned: " + ex.getResponseCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void execute() throws Exception {
        // The URL to the ptrac instance.
        final String rootURL = "http://localhost:9080";
        // The credentials for access to the web service.
        String apiUser = "admin";
        String apiPassword = "Omero2wer";

        IWebApi webapi = FWebApi.connect(rootURL, apiUser, apiPassword);

        // Get the ptrac version, no session is needed.
        GsVersion version = webapi.getMiscApi().getVersion();
        println(version.getVersionString());
        println("Build date: " + version.getDate());
        println("");
        println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
        println(" Projects");
        println("= = = = = = = = = = = = = = = = = = = = = = = = = =");

        // Get and print a list of the projects.
        GsProject projects[] = webapi.getProjectApi().getProjects();
        for (GsProject project : projects) {
            println(project.getName() + " - " + project.getDescription()
                    + ", " + project.getDateCreated());
        }

        println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
        println(" Users");
        println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
        GsUser users[] = webapi.getUserApi().getUsers();
        for (GsUser user : users) {
            println(user.getUserId() + " - " + user.getDisplayName());
        }

        // Forget the session (logout).
        webapi.getSessionApi().forgetSession();
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private static void println(String msg) {
        System.out.println(msg);
    }
}

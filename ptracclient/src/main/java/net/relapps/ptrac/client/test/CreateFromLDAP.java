/*
 * Copyright(c) 2021 RELapps (https://relapps.net)
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
package net.relapps.ptrac.client.test;

import net.relapps.ptrac.client.exif.FWebApi;
import net.relapps.ptrac.client.exif.IWebApi;
import net.relapps.ptrac.client.gs.GsUser;
import net.relapps.ptrac.client.gs.GsVersion;

/**
 *
 * @author RMT
 */
public class CreateFromLDAP {

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public static void main(String... args) {
        try {
            IWebApi api = FWebApi.connect("http://localhost:9080",
                    "admin", "secret");
            execute(api);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected static void execute(IWebApi api) throws Exception {
        GsVersion version = api.getMiscApi().getVersion();
        println(version.getVersionString());

        GsUser user = api.getUserApi().createUserFromLDAP("rmt");
        println("User: " + user.getDisplayName());
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private static void println(Object msg) {
        System.out.println(msg);
    }
}

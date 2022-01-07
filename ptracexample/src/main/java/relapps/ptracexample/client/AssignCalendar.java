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
package relapps.ptracexample.client;

import net.relapps.ptrac.client.exif.FWebApi;
import net.relapps.ptrac.client.exif.IWebApi;
import net.relapps.ptrac.client.gs.GsCalendar;
import net.relapps.ptrac.client.gs.GsVersion;

/**
 *
 * @author RMT
 */
public class AssignCalendar {

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

    private static void execute(IWebApi api) throws Exception {
        GsVersion version = api.getMiscApi().getVersion();
        println(version.getVersionString());

        // Lookup calendar
        GsCalendar calendar = getCalendar(api, "Calendarium");
        println("Calendar: " + calendar.getName()
                + " - " + calendar.getDescription());

        // Assign calendar to users.
        // Do not use this, due to some error in ptrac.
//        GsUser users[] = api.getUserApi().getUsers();
//        for (GsUser usr : users) {
//            println("User: " + usr.getUserId());
//            usr.setCalendarOid(calendar.getOid());
//            try {
//                api.getUserApi().saveUser(usr);
//            } catch (XApiError | XAppError | XError | XHttpError ex) {
//                println("Not able to save user: " + usr.getUserId());
//            }
//        }
    }

    private static GsCalendar getCalendar(IWebApi api, String name) throws
            Exception {
        GsCalendar[] calendars = api.getCalendarApi().getCalendars();
        for (var cal : calendars) {
            if (cal.getName().equals(name)) {
                return cal;
            }
        }
        return null;
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private static void println(Object msg) {
        System.out.println(msg);
    }
}

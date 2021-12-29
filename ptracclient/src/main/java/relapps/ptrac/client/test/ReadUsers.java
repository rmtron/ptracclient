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
package relapps.ptrac.client.test;

import relapps.ptrac.client.exif.FWebApi;
import relapps.ptrac.client.exif.IWebApi;
import relapps.ptrac.client.gs.GsDateRangeOids;
import relapps.ptrac.client.gs.GsProjectUserTime;
import relapps.ptrac.client.gs.GsUser;
import relapps.ptrac.client.gs.GsUserGroup;
import relapps.ptrac.client.gs.GsVersion;

/**
 *
 * @author RMT
 */
public class ReadUsers {

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
        GsUser[] users = api.getUserApi().getUsers();
        println("Users: " + users.length);
        GsUser[] usersAll = api.getUserApi().getUsersIncDeleted();
        println("Users all: " + usersAll.length);
        for (GsUser user : usersAll) {
            println(user.getUserId() + " " + user.getDisplayName()
                    + " (" + user.getEmployeeId()
                    + ") " + user.getAuthType() + " " + user.getDateDeleted());
        }
        //
        GsUserGroup group = api.getUserApi().getUserGroupByName("External");
        if (group != null) {
            GsDateRangeOids dateRange = new GsDateRangeOids();
            dateRange.setFrom("2018-01-01");
            dateRange.setTo("2021-07-01");
            String oids[] = {group.getOid()};
            dateRange.setOids(oids);

            GsProjectUserTime ut[] = api.getTimeRecApi().
                    getProjectUserTimeReportGroups(dateRange);
            for (var rec : ut) {
                println(rec.getName());
            }
        } else {
            println("Group not found.");
        }
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private static void println(Object msg) {
        System.out.println(msg);
    }
}

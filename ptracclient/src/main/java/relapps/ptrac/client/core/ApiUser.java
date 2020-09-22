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

import relapps.ptrac.client.exif.IApiUser;
import relapps.ptrac.client.gs.GsUser;
import relapps.ptrac.client.gs.GsUserGroup;

/**
 * API for user related operations.
 *
 * @author RMT
 */
public class ApiUser implements IApiUser {

    ApiUser(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public GsUser createUser(GsUser user) throws Exception {
        return _webClient.sendRequest("CreateUser",
                GsUser.class);
    }

    @Override
    public GsUserGroup createUserGroup(GsUserGroup user) throws Exception {
        return _webClient.sendRequest("CreateUserGroup",
                GsUserGroup.class);
    }

    @Override
    public GsUserGroup getUserGroupByName(String groupName) throws Exception {
        GsUserGroup groups[] = getUserGroups();
        // TODO implement a get group by name as a web service.
        for (GsUserGroup grp : groups) {
            if (grp.getName().equals(groupName)) {
                return grp;
            }
        }
        return null;
    }

    @Override
    public GsUserGroup[] getUserGroups() throws Exception {
        return _webClient.sendRequest("GetUserGroups",
                GsUserGroup[].class);
    }

    @Override
    public GsUser[] getUsers() throws Exception {
        return _webClient.sendRequest("GetUsers",
                GsUser[].class);
    }

    @Override
    public void saveUser(GsUser user) throws Exception {
        _webClient.sendRequest("SaveUser", user);
    }

    @Override
    public void saveUserGroup(GsUserGroup group) throws Exception {
        _webClient.sendRequest("SaveUserGroup", group);
    }
    private final WebClient _webClient;
}

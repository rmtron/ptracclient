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

import relapps.ptrac.client.exif.EHttpMethod;
import relapps.ptrac.client.exif.IApiUser;
import relapps.ptrac.client.exif.XApiError;
import relapps.ptrac.client.exif.XAppError;
import relapps.ptrac.client.exif.XError;
import relapps.ptrac.client.exif.XHttpError;
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
    public GsUser createUser(GsUser user)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/createUser"),
                EHttpMethod.POST, GsUser.class);
    }

    @Override
    public GsUserGroup createUserGroup(GsUserGroup user)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/createUserGroup"),
                EHttpMethod.POST, GsUserGroup.class);
    }

    @Override
    public GsUserGroup getUserGroupByName(String groupName)
            throws XHttpError, XApiError, XError, XAppError {
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
    public GsUserGroup[] getUserGroups()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getUserGroups"),
                EHttpMethod.POST, GsUserGroup[].class);
    }

    @Override
    public GsUser[] getUsers() throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getUsers"),
                EHttpMethod.POST, GsUser[].class);
    }

    @Override
    public GsUser[] getUsersIncDeleted()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getUsersIncDeleted"),
                EHttpMethod.POST, GsUser[].class);
    }

    @Override
    public void saveUser(GsUser user)
            throws XHttpError, XApiError, XError, XAppError {
        _webClient.sendRequest(getService("/saveUser"),
                EHttpMethod.POST, user);
    }

    @Override
    public void saveUserGroup(GsUserGroup group)
            throws XHttpError, XApiError, XError, XAppError {
        _webClient.sendRequest(getService("/saveUserGroup"),
                EHttpMethod.POST, group);
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/user";
    private final WebClient _webClient;
}

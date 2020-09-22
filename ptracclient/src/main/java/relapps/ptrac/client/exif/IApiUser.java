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

import relapps.ptrac.client.gs.GsUser;
import relapps.ptrac.client.gs.GsUserGroup;

/**
 *
 * @author RMT
 */
public interface IApiUser {

    /**
     * Create a new user.
     *
     * @param user The user information.
     * @return The user created with the assigned OID.
     * @throws Exception
     */
    GsUser createUser(GsUser user) throws Exception;

    /**
     * Create a new user group.
     *
     * @param user The user group information.
     * @return The user created created with the assigned OID.
     * @throws Exception
     */
    GsUserGroup createUserGroup(GsUserGroup user) throws Exception;

    /**
     * Lookup a user group by name.
     *
     * @param groupName The group name.
     * @return The group found or null if not found.
     * @throws Exception
     */
    GsUserGroup getUserGroupByName(String groupName) throws Exception;

    /**
     * Get the user groups.
     *
     * @return A list of the user groups.
     * @throws Exception
     */
    GsUserGroup[] getUserGroups() throws Exception;

    /**
     * Get the users.
     *
     * @return A list of the users.
     * @throws Exception
     */
    GsUser[] getUsers() throws Exception;

    /**
     * Save user information.
     *
     * @param user The user to save.
     * @throws Exception
     */
    void saveUser(GsUser user) throws Exception;

    /**
     * Save user group information.
     *
     * @param group The user group to save.
     * @throws Exception
     */
    void saveUserGroup(GsUserGroup group) throws Exception;
}

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
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    GsUser createUser(GsUser user) throws XHttpError, XApiError;

    /**
     * Create a new user group.
     *
     * @param user The user group information.
     * @return The user created created with the assigned OID.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    GsUserGroup createUserGroup(GsUserGroup user) throws XHttpError, XApiError;

    /**
     * Lookup a user group by name.
     *
     * @param groupName The group name.
     * @return The group found or null if not found.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    GsUserGroup getUserGroupByName(String groupName)
            throws XHttpError, XApiError;

    /**
     * Get the user groups.
     *
     * @return A list of the user groups.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    GsUserGroup[] getUserGroups() throws XHttpError, XApiError;

    /**
     * Get the users.
     *
     * @return A list of the users.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    GsUser[] getUsers() throws XHttpError, XApiError;

    /**
     * Save user information.
     *
     * @param user The user to save.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    void saveUser(GsUser user) throws XHttpError, XApiError;

    /**
     * Save user group information.
     *
     * @param group The user group to save.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the Api sending/recieving request.
     */
    void saveUserGroup(GsUserGroup group) throws XHttpError, XApiError;
}

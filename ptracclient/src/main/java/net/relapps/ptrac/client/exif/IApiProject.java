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
package net.relapps.ptrac.client.exif;

import net.relapps.ptrac.client.gs.GsProject;

/**
 * API for project management,
 *
 * @author RMT
 */
public interface IApiProject {

    /**
     * Create a project. It is not necessary to add information to the following
     * fields in GsProject:
     * <ul>
     * <li>children</li>
     * <li>dateCreated</li>
     * <li>dateModified</li>
     * <li>numChildren</li>
     * <li>numUsage</li>
     * <li>parentName</li>
     * </ul>
     *
     * @param project The data for the project to create.
     * @return The project created.
     * @throws XHttpError Error response from the back-end.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsProject createProject(GsProject project)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Check if a project exists.
     *
     * @param projectName The project name.
     * @return True if the project exists else false.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    Boolean existsProjectByName(String projectName)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Lookup a project.
     *
     * @param projectName The project name.
     * @return The project found or null if not found.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsProject getProjectByName(String projectName)
            throws XHttpError, XApiError, XError, XAppError;

    /**
     * Get the list of the defined projects.
     *
     * @return The list of projects.
     * @throws XHttpError Error response from the backend.
     * @throws XApiError Error in the API sending/receiving request.
     * @throws XAppError Thrown on error in the back-end application.
     * @throws XError Thrown on error.
     */
    GsProject[] getProjects()
            throws XHttpError, XApiError, XError, XAppError;
}

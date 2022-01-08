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
package net.relapps.ptrac.client.core;

import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiProject;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.gs.GsProject;

/**
 * API for project related operations.
 *
 * @author RMT
 */
public class ApiProject implements IApiProject {

    ApiProject(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public GsProject createProject(GsProject project)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.
                sendRequest(getService("/createProject"), EHttpMethod.POST,
                        project, GsProject.class);
    }

    @Override
    public void deleteProject(String projectOid) throws XHttpError, XApiError,
            XError, XAppError {
        _webClient.sendRequest(getService("/deleteProject"),
                EHttpMethod.POST, projectOid);
    }

    @Override
    public Boolean existsProjectByName(String projectName) throws XHttpError,
            XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/existsProjectByName"),
                EHttpMethod.POST, projectName, Boolean.class);
    }

    @Override
    public GsProject getProject(String projectOid) throws XHttpError, XApiError,
            XError, XAppError {
        return _webClient.sendRequest(getService("/getProject"),
                EHttpMethod.POST, projectOid, GsProject.class);
    }

    @Override
    public GsProject getProjectByName(String projectName)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getProjectByName"),
                EHttpMethod.POST, projectName, GsProject.class);
    }

    @Override
    public GsProject[] getProjects()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getProjects"),
                EHttpMethod.POST, GsProject[].class);
    }

    @Override
    public GsProject saveProject(GsProject project)
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/saveProject"),
                EHttpMethod.POST, project, GsProject.class);
        }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/project";
    private final WebClient _webClient;
}

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
import relapps.ptrac.client.exif.IApiProject;
import relapps.ptrac.client.exif.XApiError;
import relapps.ptrac.client.exif.XAppError;
import relapps.ptrac.client.exif.XError;
import relapps.ptrac.client.exif.XHttpError;
import relapps.ptrac.client.gs.GsProject;

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
        GsProject newProject = _webClient.
                sendRequest(getService("/createProject"), EHttpMethod.POST,
                        project, GsProject.class);
        return newProject;
    }

    @Override
    public Boolean existsProjectByName(String projectName) throws XHttpError,
            XApiError, XError, XAppError {
        Boolean exists = _webClient.
                sendRequest(getService("/existsProjectByName"), EHttpMethod.POST,
                        projectName, Boolean.class);
        return exists;
    }

    @Override
    public GsProject getProjectByName(String projectName)
            throws XHttpError, XApiError, XError, XAppError {
        GsProject project = _webClient.
                sendRequest(getService("/getProjectByName"), EHttpMethod.POST,
                        projectName, GsProject.class);
        return project;
    }

    @Override
    public GsProject[] getProjects()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getProjects"),
                EHttpMethod.POST, GsProject[].class);
    }
    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/project";
    private final WebClient _webClient;
}

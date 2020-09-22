/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package relapps.ptrac.client.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import relapps.ptrac.client.gs.GsDateRangeOids;
import relapps.ptrac.client.gs.GsDateRangeProject;
import relapps.ptrac.client.gs.GsProject;
import relapps.ptrac.client.gs.GsTimeRecord;
import relapps.ptrac.client.gs.GsUser;
import relapps.ptrac.client.gs.GsUserGroup;
import relapps.ptrac.client.gs.GsUserGroupSelection;
import relapps.ptrac.client.gs.GsVersion;

/**
 * Represents a connection to the ptrac server. This class is far from complete,
 * there are a lot of API functions that are still not implemented.
 *
 * @author RMT
 */
public class PtracConnection {

    PtracConnection(WebClient client) {
        _webClient = client;
    }

    /**
     * Create a project.
     *
     * @param project The data for the project to create.
     * @return The project created.
     * @throws Exception
     */
    public GsProject createProject(GsProject project) throws Exception {
        GsProject newProject = _webClient.
                sendRequest("CreateProject", project, GsProject.class);
        if (newProject != null) {
            _projects.put(newProject.getName().trim(), newProject);
        }
        return newProject;
    }

    /**
     * Forget (dispose) the session.
     *
     * @throws Exception
     */
    public void forgetSession() throws Exception {
        _webClient.sendRequest("ForgetSession");
    }

    /**
     * Lookup a project.
     *
     * @param projectName The project name.
     * @return The project found or null if not found.
     * @throws Exception
     */
    public GsProject getProject(String projectName) throws Exception {
        // Note: Replace the code when a getProjectByName is implemented as
        // a Web service
        initializeProjects();
        GsProject project = _projects.get(projectName.trim());
        return project;
    }

    /**
     * Get the list of projects.
     *
     * @return The list of projects.
     * @throws Exception
     */
    public List<GsProject> getProjects() throws Exception {
        // Get a list of the projects.
        initializeProjects();
        return new ArrayList<>(_projects.values());
    }

    public List<GsTimeRecord> getTimeRecordsGroups(String[] oidGroups)
            throws Exception {
        GsDateRangeOids inp = new GsDateRangeOids();
        inp.setFrom("2020-01-01");
        inp.setTo("2020-12-31");
        inp.setOids(oidGroups);
        GsTimeRecord records[] = _webClient.sendRequest("GetTimeRecordsGroups",
                inp, GsTimeRecord[].class);
        return Arrays.asList(records);
    }

    public List<GsTimeRecord> getTimeRecordsProject(String oidProject)
            throws Exception {
        GsDateRangeProject inp = new GsDateRangeProject();
        inp.setFrom("2020-01-01");
        inp.setTo("2020-12-31");
        inp.setProjectOid(oidProject);
        GsTimeRecord records[] = _webClient.sendRequest("GetTimeRecordsProject",
                inp, GsTimeRecord[].class);
        return Arrays.asList(records);
    }

    public GsUserGroup getUserGroup(String groupName) throws Exception {
        initializeGroups();
        GsUserGroup group = _groups.get(groupName.trim());
        return group;
    }

    public List<GsUserGroup> getUserGroups() throws Exception {
        initializeGroups();
        return new ArrayList<>(_groups.values());
    }

    public List<GsUser> getUsers() throws Exception {
        // Get a list of the projects.
        initializeUsers();
        return new ArrayList<>(_users.values());
    }

    public GsVersion getVersion() throws IOException, Exception {
        // Get the ptrac version, no session is needed.
        GsVersion version = _webClient.
                sendRequest("GetVersion", GsVersion.class);
        return version;
    }

    public GsProject saveProject(GsProject project) throws Exception {
        GsProject ret = _webClient.
                sendRequest("SaveProject", project, GsProject.class);
        if (ret != null) {
            // Replace the existing value in map.
            _projects.put(ret.getName().trim(), ret);
        }
        return ret;
    }

    public void setProjectGroupSelection(GsUserGroupSelection selection)
            throws Exception {
        _webClient.sendRequest("SetProjectGroupSelection", selection);
    }

    public void setUserGroupSelection(GsUserGroupSelection selection)
            throws Exception {
        _webClient.sendRequest("SetUserGroupSelection", selection);
    }

    private void initializeGroups() throws Exception {
        if (_groups == null) {
            GsUserGroup groups[] = _webClient.sendRequest("GetUserGroups",
                    GsUserGroup[].class);
            _groups = new TreeMap<>();
            for (var grp : groups) {
                _groups.put(grp.getName().trim(), grp);
            }
        }
    }

    private void initializeProjects() throws Exception {
        if (_projects == null) {
            GsProject projects[] = _webClient.sendRequest("GetProjects",
                    GsProject[].class);
            _projects = new TreeMap<>();
            for (var proj : projects) {
                _projects.put(proj.getName().trim(), proj);
            }
        }
    }

    private void initializeUsers() throws Exception {
        if (_users == null) {
            GsUser users[] = _webClient.sendRequest("GetUsers",
                    GsUser[].class);
            _users = new TreeMap<>();
            for (var user : users) {
                _users.put(user.getUserId().trim(), user);
            }
        }
    }
    private Map<String, GsUserGroup> _groups = null;
    private Map<String, GsProject> _projects = null;
    private Map<String, GsUser> _users;
    private final WebClient _webClient;
}

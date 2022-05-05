#
# Copyright(c) 2021 RELapps (https://relapps.net)
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
#
##############################################################################
#
# Represents the ptrac REST API for access to the web services.
#
##############################################################################
#
from .httpclient import HttpClient
from .credentials import Credentials
import json

def get_api():
    # Get the user credentials for the connection to ptrac.
    creds = Credentials()
    inp_user = creds.get_user()
    inp_password = creds.get_password()
    # The ptrac URL
    inp_url = creds.get_url()

    # Open the connection to ptrac.
    api = PtracApi(inp_url)
    version = api.get_version()
    print('Connected to', version['versionString'])
    session = api.authenticate(inp_user, inp_password)
    if session is None:
        print('Error: Invalid credentials?')
        quit()
    else:
        print('Authenticated OK')
    return api


class PtracApi:
    def __init__(self, url):
        self.__httpClient = HttpClient(url)

    # Authenticate and store session token
    def authenticate(self, user, password):
        args = {'user': user, 'password': password}
        session = self.__httpClient.post('/session/createSession', args)
        string = session.decode('UTF-8', 'ignore')
        if session is not None and len(string) > 0:
            resp = json.loads(session)
            token = resp["token"]
            self.__httpClient.set_token(token)
            return resp
        else:
            return None

    # Dispose session
    def dispose(self):
        self.__check()
        self.__httpClient.post('/session/forgetSession', {})
        self.__httpClient = None

    # Returns the user groups
    def get_user_groups(self):
        self.__check()
        groups = self.__httpClient.post('/user/getUserGroups', {})
        if groups is not None:
            return json.loads(groups)
        else:
            return None

    # Returns the members of a group
    def get_user_group_user_memb(self, group_oid):
        self.__check()
        users = self.__httpClient.post('/user/getUserGroupUserMemb', group_oid)
        if users is not None:
            return json.loads(users)
        else:
            return None

    # Lookup a user by OID.
    def get_user(self, user_oid):
        self.__check()
        user = self.__httpClient.post('/user/getUser', user_oid)
        if user is not None:
            return json.loads(user)
        else:
            return None

    # Fetch time records for a group in a date range
    def get_time_records_groups(self, date_from, date_to, user_group):
        self.__check()
        args = {
            "from": date_from,
            "to": date_to,
            "oids": [user_group]
        }
        time_records = self.__httpClient.post('/timerec/getTimeRecordsGroups', args)
        if time_records is not None:
            return json.loads(time_records)
        else:
            return None

    # Lookup a project by the project name/identifier
    def get_project_by_name(self, project_name):
        self.__check()
        project = self.__httpClient.post('/project/getProjectByName', project_name)
        if project is not None:
            return json.loads(project)
        else:
            return None

    # Lookup a project by the project OID
    def get_project(self, project_oid):
        self.__check()
        project = self.__httpClient.post('/project/getProject', project_oid)
        if project is not None:
            return json.loads(project)
        else:
            return None

    # Returns the defined projects
    def get_projects(self):
        self.__check()
        project = self.__httpClient.post('/project/getProjects', {})
        if project is not None:
            return json.loads(project)
        else:
            return None

    # Get group selection for a project.
    def get_project_group_selection(self,project_oid):
        self.__check()
        selection = self.__httpClient.post('/project/getProjectGroupSelection', project_oid)
        if selection is not None:
            return json.loads(selection)
        else:
            return None

    # Set group selection for a project.
    def set_project_group_selection(self,project_oid,selection):
        self.__check()
        args = {
            "objectOid": project_oid,
            "selection": selection
        }
        self.__httpClient.post('/project/setProjectGroupSelection', args)

    # Returns the defined projects
    def get_day_records(self, date_from, date_to):
        self.__check()
        args = {
            "from": date_from,
            "to": date_to
        }
        records = self.__httpClient.post('/timerec/getDayRecords', args)
        if records is not None:
            return json.loads(records)
        else:
            return None

    # Returns the defined projects
    def get_time_object(self, time):
        self.__check()
        tobj = self.__httpClient.post('/timerec/getTimeObject', time)
        if tobj is not None:
            return json.loads(tobj)
        else:
            return None

    # Returns the ptrac version information
    def get_version(self):
        self.__check()
        version = self.__httpClient.get('/version', {})
        if len(version) > 0:
            return json.loads(version)
        else:
            return None

    # Exports the project definitions and return the result as a binary file
    def export_projects(self):
        self.__check()
        args = {
            "exportCalendars": False,
            "exportGroups": False,
            "exportProjects": True,
            "exportUsers": False,
            "socketId": None
        }
        data = self.__httpClient.post('/expimp/export', args)
        return data

    def create_project(self,parentoid,projid,description,active):
        self.__check()
        args = {
            "active": active,
            "description": description,
            "name": projid,
            "note": '',
            "parentOid": parentoid,
            "pto": False
        }
        proj_created = self.__httpClient.post('/project/createProject', args)
        if len(proj_created) > 0:
            return json.loads(proj_created)
        else:
            return None

    # Returns the events in the action log.
    def get_action_log(self):
        self.__check()
        args = {
            "from": None,
            "to": None
        }
        data = self.__httpClient.post('/log/getEvents', args)
        if data is not None:
            return json.loads(data)
        else:
            return None
    
    # Check if connection is valid.
    def __check(self):
        if self.__httpClient == None:
            raise Exception('Connection is not valid')
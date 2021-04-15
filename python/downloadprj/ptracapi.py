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
# Represents the ptrac REST API
#
from httpclient import HttpClient
import json
import sys


class PtracApi:
    def __init__(self, url):
        self.__httpClient = HttpClient(url)

    # Authenticate and store session token
    def authenticate(self, user, password):
        args = {'user': user, 'password': password}
        session = self.__httpClient.post('/session/createSession', args)
        size = sys.getsizeof(session)
        string = session.decode('UTF-8', 'ignore')
        if session is not None and len(string) > 0:
            resp = json.loads(session)
            token = resp["token"]
            self.__httpClient.set_token(token)
            return resp
        else:
            return None

    # Returns the user groups
    def get_user_groups(self):
        groups = self.__httpClient.post('/user/getUserGroups', {})
        if groups is not None:
            return json.loads(groups)
        else:
            return None

    # Returns the members of a group
    def get_user_group_user_memb(self, group_oid):
        users = self.__httpClient.post('/user/getUserGroupUserMemb', group_oid)
        if users is not None:
            return json.loads(users)
        else:
            return None

    # Fetch time records for a group in a date range
    def get_time_records_groups(self, date_from, date_to, user_group):
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

    # Lookup a project by the project OID
    def get_project(self, project_oid):
        project = self.__httpClient.post('/project/getProject', project_oid)
        if project is not None:
            return json.loads(project)
        else:
            return None

    # Returns the ptrac version information
    def get_version(self):
        version = self.__httpClient.get('/version', {})
        if len(version) > 0:
            return json.loads(version)
        else:
            return None

    # Exports the project definitions and return the result as a binary file
    def export_projects(self):
        args = {
            "exportCalendars": False,
            "exportGroups": False,
            "exportProjects": True,
            "exportUsers": False,
            "socketId": None
        }
        data = self.__httpClient.post('/expimp/export', args)
        return data

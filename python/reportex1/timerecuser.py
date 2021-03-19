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
# Utility class for handling of time records.
#
class TimeRecUser:
    def __init__(self, user):
        self.__timerecs = []
        self.__user = user
        self.__project_map = {}

    def add_timerec(self, tr):
        self.__timerecs.append(tr)
        project_oid = tr['projectOid']
        # Store a dictionary with the project OID and list of time records
        project_list = None
        if project_oid not in self.__project_map:
            project_list = []
            self.__project_map[project_oid] = project_list
        else:
            project_list = self.__project_map[project_oid]
        project_list.append(tr)

    def get_timerecs(self):
        return self.__timerecs

    def get_project_oids(self):
        return self.__project_map.keys()

    def get_timerecs_project(self, project_oid):
        if project_oid in self.__project_map:
            ret = self.__project_map[project_oid]
        else:
            ret = []
        return ret

    def get_user(self):
        return self.__user

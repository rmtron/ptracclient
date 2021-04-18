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
# This is a Python example using the ptrac REST API for the generation of
# a report for a user group in a date range.
# Please feel free to use and modify the example as you wish.
#
# The python requests module is required for this example.
#
# You can install the requests module using the Python pip command:
# pip install requests
#

# Use implementation from ptraclib
import sys

sys.path.append('../ptraclib')

from ptracapi import PtracApi
from timerecuser import TimeRecUser

def main():
    #################################################################
    # Input parameters

    # The ptrac URL
    inp_url = 'http://localhost:9080/'

    # The user name and password for the access to ptrac
    inp_user = 'admin'
    inp_password = 'secret'

    # The user group for the report
    inp_group = 'GroupName'

    # The date range
    inp_date_from = '2021-01-01'
    inp_date_to = '2021-01-31'

    #################################################################

    api = PtracApi(inp_url)
    version = api.get_version()
    print(version['versionString'])
    print('Date range ', inp_date_from, '-', inp_date_to)
    print('user group: ', inp_group)

    session = api.authenticate(inp_user, inp_password)
    if session is None:
        print('Error: Invalid credentials?')
        quit()

    groups = api.get_user_groups();
    group_oid = None
    for grp in groups:
        if grp["name"] == inp_group:
            group_oid = grp["oid"]

    if group_oid is None:
        print('Error: Group ', inp_group, ' not found')
        quit()

    user_map = {}
    users = api.get_user_group_user_memb(group_oid)
    for usr in users:
        user_map[usr['oid']] = usr

    # Fetch the time records for the group and date range
    time_records = api.get_time_records_groups(inp_date_from,
                                               inp_date_to,
                                               group_oid)

    # Iterate the time records and store as TimeRecUser
    total = 0
    tr_user = {}
    for tr in time_records:
        dec_hours = tr["time"]["decimalHours"]
        total += float(dec_hours)
        user_oid = tr['userOid']
        # Check if user is stored i dictionary
        if user_oid in tr_user:
            truser = tr_user[user_oid]
        else:
            # Create a new TimeRecUser and store in dictionary
            userobj = user_map[user_oid]
            truser = TimeRecUser(userobj)
            tr_user[user_oid] = truser

        # Add time record to the TimeRecUser
        truser.add_timerec(tr)

    # Iterate the dictionary of TimeRecUser
    project_map = {}
    for user_oid in tr_user:
        print('')
        truser = tr_user[user_oid]
        print(truser.get_user()['displayName'])
        user_sum = 0.0
        for project_oid in truser.get_project_oids():
            # Lookup project
            if project_oid not in project_map:
                project = api.get_project(project_oid)
            else:
                project = project_map[project_oid]
            time_records = truser.get_timerecs_project(project_oid)
            # Sum the time
            project_sum = 0.0
            for tr in time_records:
                project_sum += float(tr["time"]["decimalHours"])
            print('   ', project['name'], ' ', project_sum)
            user_sum += project_sum
        print('Total user:', user_sum)

    print('')
    print('Total all users: ', total)
    print('')


# Call the main function
if __name__ == '__main__':
    main()

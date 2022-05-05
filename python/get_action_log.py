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
# This is a Python example using the ptrac REST API for extraction of the
# action/event log to CSV file.
#
# Please feel free to use and modify the example as you wish.
#
# The python requests module is required for this example.
#
# You can install the requests module using the Python pip command:
# pip install requests
#

# Use implementation from ptraclib
import sys

from lib.ptracapi import PtracApi,get_api
import datetime

#################################################################


# The output folder
# out_folder = '/home/user/projects'
out_folder = './output'

# Open the connection to ptrac.
api = get_api()

#################################################################


def get_filename():
    now = datetime.datetime.now()
    date_string = now.strftime('%Y-%m-%d-%H%M')
    return out_folder + '/action_log_' + date_string + '.csv'


def main():
    events = api.get_action_log()
    user_map = {}
    file_name = get_filename()
    f = open(file_name, "a")
    for event in events:
        action = event['action']
        user_oid = event['user']
        message = event['message']
        timestamp = event['timestamp']
        if user_oid not in user_map:
            user = api.get_user(user_oid)
            user_map[user_oid] = user
        else:
            user = user_map[user_oid]
        user_name = user['displayName']
        # print(timestamp, ',', action, ',', user_name, ',', message)
        line = ''
        line += timestamp + ','
        line += action + ','
        line += user_name + ','
        line += message + '\n'
        f.write(line)

    f.close()
    print('Generated file: ' + file_name)


# Call the main function
if __name__ == '__main__':
    try:
        main()
    except Exception as ex:
        print('ERROR: ', ex)
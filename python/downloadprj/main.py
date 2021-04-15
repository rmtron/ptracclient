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
# This is a Python example using the ptrac REST API for exporting projects
# to a file which can be imported in ptrac.
#
# Please feel free to use and modify the example as you wish.
#
# The python requests module is required for this example.
#
# You can install the requests module using the Python pip command:
# pip install requests
#

from ptracapi import PtracApi
import datetime

#################################################################
# Input parameters

# The ptrac URL
inp_url = 'https://localhost/ptrac'

# The output folder
out_folder = '/home/user/projects'

# The user name and password for the access to ptrac
inp_user = 'admin'
inp_password = 'secret'


#################################################################


def get_filename():
    now = datetime.datetime.now()
    date_string = now.strftime('%Y-%m-%d-%H%M')
    return out_folder + '/projects_' + date_string + '.ptrac'


def main():
    api = PtracApi(inp_url)
    version = api.get_version()
    print(version['versionString'])

    session = api.authenticate(inp_user, inp_password)
    if session is None:
        print('Error: Invalid credentials?')
        quit()
    data = api.export_projects()

    print('Finished')
    file_name = get_filename()
    f = open(file_name, "ab")
    f.write(data)
    f.close()
    print('Generated file: ' + file_name)


# Call the main function
if __name__ == '__main__':
    main()

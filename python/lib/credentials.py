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
# Read credentials from enviroment variables.
# PT_USER store the user identifier
# PT_PASSWORD store the password
#
##############################################################################
#
#

import os
import getpass

class Credentials:
    def __init__(self):
        # Read the information from environment variables.
        self.__user = os.getenv('PT_USER')
        self.__password = os.getenv('PT_PASSWORD')
        self.__url = 'http://localhost:9080/ptracweb'

    def get_user(self):
        # If not set ask the user.
        if self.__user is None:
            self.__user = inp_user = input('User: ')
        return self.__user

    def get_password(self):
        # If not set ask the user.
        if self.__password is None:
            self.__password = getpass.getpass('Password: ')
        return self.__password

    def get_url(self):
        return self.__url

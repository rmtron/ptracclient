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
#
# HTTP client handling calls to the REST API.
# Install requests package
# pip install requests
#
import requests
import json

class HttpClient:
    def __init__(self, base_url):
        self.__base_url = base_url
        self.__token = None

    # Assign the authentication token for the session
    def set_token(self, token):
        self.__token = token

    # Call a get rest function
    def get(self, action, arg):
        url = self.__base_url + action
        headers = self.__get_headers()
        response = requests.get(url, json=arg, headers=headers)
        if response.status_code == 200:
            return response.content
        else:
            # Primitive solution, just print the error message and return None.
            obj = json.loads(response.content)
            print(obj['message'])
            return None

    # Call a post rest function
    def post(self, action, arg):
        url = self.__base_url + action
        headers = self.__get_headers()
        response = requests.post(url, json=arg, headers=headers)
        if response.status_code == 200:
            return response.content
        else:
            # Primitive solution, just print the error message and return None.
            obj = json.loads(response.content)
            print(obj['message'])
            return None

    # Returns the request header
    def __get_headers(self):
        if self.__token is not None:
            headers = {'Authorization': self.__token,
                       'Content-type': 'application/json'}
        else:
            headers = {'Content-type': 'application/json'}
        return headers

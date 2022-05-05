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
#
#
# Fetch a list of the worked time for the user.
#
##############################################################################
#

from lib.ptracapi import PtracApi, get_api
import datetime

#################################################################

def main():
    # Open the connection to ptrac.
    api = get_api()

    # Ask for the project/activity data.
    date_start = input('Start date (YYYY-MM-DD): ')
    date_end = input('End date (YYYY-MM-DD): ')
    data = api.get_day_records( date_start, date_end)
    for day in data:
        print('')
        print(day['date'])
        for rec in day['timeCalcRec']:
            time = ''
            minutes = rec['end']['minutes'] - rec['start']['minutes']
            if ( minutes > 0):
                tobj = api.get_time_object( 'm' + str(minutes));
                time = tobj['time']
            print( rec['start']['time'], '-', rec['end']['time'], ' = ', time)
    api.dispose()

# Call the main function
if __name__ == '__main__':
    try:
        main()
    except Exception as ex:
        print('ERROR: ', ex)
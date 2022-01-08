/*
 * Copyright(c) 2021 RELapps (https://relapps.net)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.relapps.ptrac.client.core;

import net.relapps.ptrac.client.exif.EHttpMethod;
import net.relapps.ptrac.client.exif.IApiCalendar;
import net.relapps.ptrac.client.exif.XApiError;
import net.relapps.ptrac.client.exif.XAppError;
import net.relapps.ptrac.client.exif.XError;
import net.relapps.ptrac.client.exif.XHttpError;
import net.relapps.ptrac.client.gs.GsCalendar;

/**
 * Calendar operations.
 *
 * @author RMT
 */
public class ApiCalendar implements IApiCalendar {

    ApiCalendar(WebClient webClient) {
        _webClient = webClient;
    }

    @Override
    public GsCalendar createCalendar(GsCalendar cal) throws XHttpError,
            XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/createCalendar"),
                EHttpMethod.POST, cal, GsCalendar.class);
    }

    @Override
    public void deleteCalendar(String calendarOid) throws XHttpError, XApiError,
            XError, XAppError {
        _webClient.sendRequest(getService("/deleteCalendar"),
                EHttpMethod.POST, calendarOid);
    }

    @Override
    public String exportCalendar(String calendarOid) throws XHttpError,
            XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/exportCalendar"),
                EHttpMethod.POST, calendarOid, String.class);
    }

    @Override
    public GsCalendar[] getCalendars()
            throws XHttpError, XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/getCalendars"),
                EHttpMethod.POST, 0, GsCalendar[].class);
    }

    @Override
    public GsCalendar saveCalendar(GsCalendar calendar) throws XHttpError,
            XApiError, XError, XAppError {
        return _webClient.sendRequest(getService("/saveCalendar"),
                EHttpMethod.POST, calendar, GsCalendar.class);
    }

    private String getService(String name) {
        return _prefix + name;
    }
    private final String _prefix = "/calendar";
    private final WebClient _webClient;
}

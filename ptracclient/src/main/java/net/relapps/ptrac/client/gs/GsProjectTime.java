/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
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
package net.relapps.ptrac.client.gs;

/**
 * Serialization.
 *
 * @author RMT
 */
public class GsProjectTime extends GsProject {

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public GsProjectTime[] getChildTimes() {
        return childTimes;
    }

    public GsTime getTime() {
        return time;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setChildTimes(GsProjectTime[] childTimes) {
        this.childTimes = childTimes;
    }

    public void setTime(GsTime time) {
        this.time = time;
    }
    private GsProjectTime childTimes[];
    private GsTime time;
}

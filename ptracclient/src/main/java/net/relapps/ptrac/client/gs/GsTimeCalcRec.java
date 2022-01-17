/*
 * Copyright(c) 2022 RELapps (https://relapps.net)
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
 * Represents a time calculator record.
 *
 * @author RMT
 */
public class GsTimeCalcRec {

    /**
     * The end time.
     *
     * @return Time
     */
    public GsTime getEnd() {
        return end;
    }

    /**
     * The start time.
     *
     * @return Time
     */
    public GsTime getStart() {
        return start;
    }

    public void setEnd(GsTime end) {
        this.end = end;
    }

    public void setStart(GsTime start) {
        this.start = start;
    }
    private GsTime end;
    private GsTime start;
}

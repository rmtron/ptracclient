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
package relapps.ptrac.client.gs;

/**
 *
 * @author RMT
 */
public class GsUserRole {

    public String getDescription() {
        return description;
    }

    public int getMask() {
        return mask;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }
    private String description;
    private int mask;
}

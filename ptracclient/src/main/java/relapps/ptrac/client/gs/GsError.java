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
 * Handles serialization of an error message.
 *
 * @author RMT
 */
public class GsError {

    public GsError(String status, String message) {
        this.exception = status;
        this.message = message;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public String[] getCallstack() {
        return callstack;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setCallstack(String callstack[]) {
        this.callstack = callstack;
    }

    private String[] callstack;
    private final String exception;
    private final String message;
}

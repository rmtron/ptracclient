/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package relapps.ptrac.client.core;

/**
 * Handles serialization of data for ptrac WEB services.
 *
 * @author RMT
 */
class GsWrapper {

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (data != null) {
            ret.append("Data: ");
            ret.append(data);
            ret.append('\n');
            ret.append("Type: ");
            ret.append(data.getClass().toString());
        } else {
            ret.append("Data: null");
        }
        ret.append('\n');
        ret.append("Exception: ");
        ret.append(exception);
        ret.append('\n');
        ret.append("Ex msg: ");
        ret.append(exMessage);
        return ret.toString();
    }

    /**
     * The serialization data (JSON) for the returned object.
     *
     * @return The serialization code.
     */
    String getData() {
        return data;
    }

    /**
     * Exception message.
     *
     * @return Exception message or null if no exception.
     */
    String getExMessage() {
        return exMessage;
    }

    /**
     * Exception class.
     *
     * @return The exception class name or null if no exception.
     */
    String getException() {
        return exception;
    }

    /**
     * Check if the serialization contains an exception.
     *
     * @return True if it contains an exception.
     */
    boolean hasException() {
        return exception != null;
    }

    void setData(String data) {
        this.data = data;
    }

    void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    void setException(String exception) {
        this.exception = exception;
    }

    private String data;
    private String exMessage;
    private String exception;
}

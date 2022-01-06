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
package net.relapps.ptrac.client.exif;

/**
 * Exception thrown on HTTP error.
 *
 * @author RMT
 */
@SuppressWarnings("serial")
public class XHttpError extends Exception {

    /**
     * Creates a new instance of <code>XHttpError</code> without detail message.
     */
    public XHttpError() {
    }

    /**
     * Constructs an instance of <code>XHttpError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public XHttpError(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>XHttpError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     * @param responseCode The HTTP response code.
     */
    public XHttpError(String msg, int responseCode) {
        super(msg);
        _responseCode = responseCode;
    }

    /**
     * Constructs an instance of <code>XHttpError</code> with the specified
     * detail message.
     *
     * @param msg The detail message.
     * @param cause The cause (which is saved for later retrieval by the
     * Exception.getCause() method). (A null value is permitted, and indicates
     * that the cause is nonexistent or unknown.)
     * @param responseCode The HTTP response code.
     */
    public XHttpError(String msg, Throwable cause, int responseCode) {
        super(msg, cause);
        _responseCode = responseCode;
    }

    /**
     * Returns the response code.
     *
     * @return The status code.
     */
    public int getResponseCode() {
        return _responseCode;
    }
    private int _responseCode = 0;
}

/*
 * Copyright(c) 2020 SENER Ingenieria y Sistemas
 * All rights reserved.
 */
package net.relapps.ptrac.client.exif;

import net.relapps.ptrac.client.gs.GsError;

/**
 * Thrown when exception is thrown in the remote application.
 *
 * @author RMT
 */
@SuppressWarnings("serial")
public class XAppError extends Exception {

    /**
     * Creates a new instance of <code>XAppError</code> without detail message.
     */
    public XAppError() {
    }

    /**
     * Creates a new instance of <code>XAppError</code> without detail message.
     *
     * @param error The error information.
     */
    public XAppError(GsError error) {
        _error = error;
    }

    /**
     * Creates a new instance of <code>XAppError</code> without detail message.
     *
     * @param error The error information.
     * @param msg the detail message.
     */
    public XAppError(GsError error, String msg) {
        super(msg);
        _error = error;
    }

    /**
     * Constructs an instance of <code>XAppError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public XAppError(String msg) {
        super(msg);
    }

    /**
     * Returns the causing exception.
     *
     * @return The exception name.
     */
    public String getException() {
        return _error.getException();
    }

    /**
     * Returns the remote error object which may be null if it's not available.
     *
     * @return Remote error information.
     */
    public GsError getRemoteError() {
        return _error;
    }
    private GsError _error;
}

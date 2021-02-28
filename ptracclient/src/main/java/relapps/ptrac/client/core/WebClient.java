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

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import relapps.ptrac.client.exif.EHttpMethod;
import relapps.ptrac.client.exif.XApiError;
import relapps.ptrac.client.exif.XAppError;
import relapps.ptrac.client.exif.XError;
import relapps.ptrac.client.exif.XHttpError;
import relapps.ptrac.client.gs.GsError;

/**
 * A WEB client for sending and receiving JSON serialized object from server.
 *
 * @author RMT
 */
public class WebClient {

    /**
     * Create a new instance of WebClient.
     *
     * @param rootURL The root URL.
     * @throws MalformedURLException
     */
    public WebClient(String rootURL) throws MalformedURLException {
        this(new URL(rootURL));
    }

    /**
     * Create a new instance of WebClient.
     *
     * @param rootURL The root URL.
     * @throws MalformedURLException
     */
    public WebClient(URL rootURL) throws MalformedURLException {
        if (rootURL.toExternalForm().endsWith("/")) {
            _rootURL = rootURL;
        } else {
            _rootURL = new URL(rootURL.toExternalForm() + "/");
        }
    }

    /**
     * Send a http request to the server. This method is synchronized to avoid
     * concurrent calls from different threads. Must handle a pool of
     * HttpClient's to make it thread safe.
     *
     * @param method The HTTP method to use.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @return The binary data received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    synchronized public byte[] sendBlobRequest(String url,
            EHttpMethod method) throws XError, XHttpError, XAppError {
        return sendBlobRequest(url, method, null);
    }

    /**
     * Send a http request to the server. This method is synchronized to avoid
     * concurrent calls from different threads. Must handle a pool of
     * HttpClient's to make it thread safe.
     *
     * @param <I> The input object type.
     * @param input The input object (send to server).
     * @param method The HTTP method to use.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @return The binary data received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    synchronized public <I> byte[] sendBlobRequest(String url,
            EHttpMethod method, I input) throws XError, XHttpError, XAppError {
        String inputJson = toString(input);
        URL serviceURL;
        try {
            serviceURL = getServiceUrl(url);
        } catch (MalformedURLException ex) {
            throw new XError("Error fetching URL", ex);
        }
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        try {
            builder = builder.uri(serviceURL.toURI());
        } catch (URISyntaxException ex) {
            throw new XError("HttpRequest.Builder", ex);
        }
        switch (method) {
            case DELETE:
                builder = builder.DELETE();
                break;
            case GET:
                builder = builder.GET();
                break;
            case POST:
                builder = builder.POST(HttpRequest.BodyPublishers.ofString(
                        inputJson));
                break;
            case PUT:
                builder = builder.PUT(HttpRequest.BodyPublishers.ofString(
                        inputJson));
                break;
        }
        if (_authToken != null) {
            builder = builder.setHeader("Authorization", _authToken);
        }
        builder = builder.setHeader("Content-Type", "application/json");

        HttpRequest request = builder.build();
        // HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<byte[]> response;
        try {
            response = _httpClient.send(request,
                    HttpResponse.BodyHandlers.ofByteArray());
        } catch (IOException | InterruptedException ex) {
            throw new XError("HttpClient send", ex);
        }
        int statusCode = response.statusCode();
        byte[] output;
        switch (statusCode) {
            case 200: {
                output = response.body();
                // Gson gson = GsonFactory.getGson();
                // output = gson.fromJson(body, outputClass);
                break;
            }
            case 400: {
                output = null;
                byte[] body = response.body();
                throwXAppError(url, method, "");
                break;
            }
            default: {
                throw new XHttpError("Error conecting to server: "
                        + serviceURL
                        + "\n",
                        statusCode);
            }
        }
        return output;
    }

    /**
     * Make a request without input and output parameters to the server.
     *
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param method The HTTP method to use.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XApiError Thrown on error in sending/receiving request.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    void sendRequest(String url, EHttpMethod method)
            throws XHttpError, XApiError, XError, XAppError {
        sendRequest(url, method, (Class<?>) null);
    }

    /**
     * Make a request without input to the server.
     *
     * @param <O> The output object type.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param method The HTTP method to use.
     * @param outputClass The output class.
     * @return The object received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XApiError Thrown on error in sending/receiving request.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    <O> O sendRequest(String url, EHttpMethod method, Class<O> outputClass)
            throws XHttpError, XApiError, XError, XAppError {
        return sendRequest(url, method, (Void) null, outputClass);
    }

    /**
     * Make a request to the server.
     *
     * @param <I> The input object type.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param input The input object (send to server).
     * @param method The HTTP method to use.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XApiError Thrown on error in sending/receiving request.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    <I> void sendRequest(String url, EHttpMethod method, I input)
            throws XHttpError, XApiError, XError, XAppError {
        sendRequest(url, method, input, Void.class);
    }

    /**
     * Make a request to the server.
     *
     * @param <I> The input object type.
     * @param <O> The output object type.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param method The HTTP method to use.
     * @param input The input object (send to server).
     * @param outputClass The output class.
     * @return The object received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws XApiError Thrown on error in sending/receiving request.
     * @throws XAppError Thrown on error from application.
     * @throws XError Thrown on error.
     */
    <I, O> O sendRequest(String url, EHttpMethod method,
            I input, Class<O> outputClass)
            throws XHttpError, XApiError, XError, XAppError {
        String inputJson = toString(input);

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        URL serviceURL;
        try {
            serviceURL = getServiceUrl(url);
            builder = builder.uri(serviceURL.toURI());
        } catch (MalformedURLException | URISyntaxException ex) {
            throw new XError("Service URI error", ex);
        }
        switch (method) {
            case DELETE:
                builder = builder.DELETE();
                break;
            case GET:
                builder = builder.GET();
                break;
            case POST:
                builder = builder.POST(HttpRequest.BodyPublishers.ofString(
                        inputJson));
                break;
            case PUT:
                builder = builder.PUT(HttpRequest.BodyPublishers.ofString(
                        inputJson));
                break;
        }
        if (_authToken != null) {
            builder = builder.setHeader("Authorization", _authToken);
        }
        builder = builder.setHeader("Content-Type", "application/json");

        HttpRequest request = builder.build();

        HttpResponse<String> response;
        try {
            response = _httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            throw new XApiError("Error in sending request.", ex);
        }
        int statusCode = response.statusCode();

        O output;
        switch (statusCode) {
            case 200: {
                if (outputClass != null) {
                    String body = response.body();
                    Gson gson = GsonFactory.getGson();
                    output = gson.fromJson(body, outputClass);
                } else {
                    output = null;
                }
                break;
            }
            case 400: {
                output = null;
                String body = response.body();
                throwXAppError(url, method, body);
                break;
            }
            default:
                String body = response.body();
                throw new XHttpError("Error connecting to server: "
                        + serviceURL
                        + "\n" + body,
                        statusCode);
        }
        return output;
    }

    /**
     * Assign the authorization token (session token).
     *
     * @param authToken The token, null to skip authorization.
     */
    void setAutorization(String authToken) {
        _authToken = authToken;
    }

    private URL getServiceUrl(String service) throws MalformedURLException {
        return new URL(_rootURL + service);
    }

    private void throwXAppError(String url, EHttpMethod method, String body)
            throws XAppError {
        Gson gson = GsonFactory.getGson();
        GsError error = gson.fromJson(body, GsError.class);
        StringBuilder msg = new StringBuilder();
        msg.append("Error accessing: ");
        msg.append(method.toString());
        msg.append(" ");
        msg.append(url);
        throw new XAppError(error, msg.toString());
    }

    /**
     * Convert to JSON string.
     *
     * @param input The object to convert.
     * @return A JSON string representation.
     */
    private String toString(Object input) {
        Gson gson = GsonFactory.getGson();
        String inputJson;
        if (input instanceof String) {
            inputJson = input.toString();
        } else {
            inputJson = gson.toJson(input);
        }
        return inputJson;
    }
    private String _authToken;
    private final HttpClient _httpClient = HttpClient.newBuilder().build();
    private final URL _rootURL;
}

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
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import relapps.ptrac.client.exif.XHttpError;

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
     * Make a request without input and output parameters to the server.
     *
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @throws XHttpError Thrown on a HTTP error.
     * @throws IOException Thrown IO error.
     * @throws Exception Thrown on error.
     */
    void sendRequest(String url)
            throws XHttpError, IOException, Exception {
        sendRequest(url, (Class<?>) null);
    }

    /**
     * Make a request without input to the server.
     *
     * @param <O> The output object type.
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param outputClass The output class.
     * @return The object received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws IOException Thrown IO error.
     * @throws Exception Thrown on error.
     */
    <O> O sendRequest(String url, Class<O> outputClass)
            throws XHttpError, IOException, Exception {
        return sendRequest(url, (Void) null, outputClass);
    }

    /**
     * Make a request to the server.
     *
     * @param <I> The input object type.
     * @param input The input object (send to server).
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @throws XHttpError Thrown on a HTTP error.
     * @throws IOException Thrown IO error.
     * @throws Exception Thrown on error.
     */
    <I> void sendRequest(String url, I input)
            throws XHttpError, IOException, Exception {
        sendRequest(url, input, Void.class);
    }

    /**
     * Make a request to the server.
     *
     * @param <I> The input object type.
     * @param <O> The output object type.
     * @param input The input object (send to server).
     * @param url The relative URL for the service (relative to the root given
     * in the constructor).
     * @param outputClass The output class.
     * @return The object received from the server.
     * @throws XHttpError Thrown on a HTTP error.
     * @throws IOException Thrown IO error.
     * @throws Exception Thrown on error.
     */
    @SuppressWarnings({"unchecked", "UseSpecificCatch"})
    <I, O> O sendRequest(String url, I input, Class<O> outputClass)
            throws XHttpError, IOException, Exception {
        Gson gson = new Gson();
        String inputJson = gson.toJson(input);

        URL servletURL = getServiceUrl(url);
        HttpRequest request;
        if (_authToken != null) {
            request = HttpRequest.newBuilder()
                    .uri(servletURL.toURI())
                    .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                    .setHeader("Authorization", _authToken)
                    .build();
        } else {
            request = HttpRequest.newBuilder()
                    .uri(servletURL.toURI())
                    .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
        }

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> response
                = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new XHttpError("Error status code returned", statusCode);
        }
        String body = response.body();
        GsWrapper wrapper = gson.fromJson(body, GsWrapper.class);
        if (wrapper.hasException()) {
            throw new XHttpError(wrapper.getExMessage(), statusCode);
        }
        String outputJson = wrapper.getData();
        O output;

        boolean isVoid = false;
        if (outputClass != null) {
            // Do not read output if void type.
            String vclass = outputClass.getName();
            isVoid = vclass.equals("java.lang.Void");
        }
        Void v;
        if (outputClass != null && !isVoid) {
            output = gson.fromJson(outputJson, outputClass);
        } else {
            output = null;
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

    private URL getServiceUrl(String service) throws Exception {
        URL serviceURL = new URL(_rootURL, service);
        return serviceURL;
    }
    private String _authToken;
    private final URL _rootURL;
}

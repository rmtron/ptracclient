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
package net.relapps.ptrac.client.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Factory for creation of GsonBuilder.
 *
 * @author RMT
 */
public class GsonFactory {

    private GsonFactory() {
    }

    /**
     * Returns a GSON serializer.
     *
     * @return The GSON serializer.
     */
    public static Gson getGson() {
        return getGsonBuilder().create();
    }

    /**
     * Returns the GSON builder.
     *
     * @return The GSON builder.
     */
    public static GsonBuilder getGsonBuilder() {
        if (_gsonBuilder == null) {
            _gsonBuilder = new GsonBuilder();
        }
        return _gsonBuilder;
    }

    /**
     * Returns a GSON serializer with pretty printing activated..
     *
     * @return The GSON serializer.
     */
    public static Gson getGsonPrettyPrint() {
        return getGsonBuilder().setPrettyPrinting().create();
    }
    private static GsonBuilder _gsonBuilder = null;
}

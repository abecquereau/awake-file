/*
 * This file is part of Awake FILE. 
 * Awake file: Easy file upload & download over HTTP with Java.                                    
 * Copyright (C) 2015,  KawanSoft SAS
 * (http://www.kawansoft.com). All rights reserved.                                
 *                                                                               
 * Awake FILE is free software; you can redistribute it and/or                 
 * modify it under the terms of the GNU Lesser General Public                    
 * License as published by the Free Software Foundation; either                  
 * version 2.1 of the License, or (at your option) any later version.            
 *                                                                               
 * Awake FILE is distributed in the hope that it will be useful,               
 * but WITHOUT ANY WARRANTY; without even the implied warranty of                
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU             
 * Lesser General Public License for more details.                               
 *                                                                               
 * You should have received a copy of the GNU Lesser General Public              
 * License along with this library; if not, write to the Free Software           
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  
 * 02110-1301  USA
 *
 * Any modifications to this file must keep this entire header
 * intact.
 */
package org.kawanfw.commons.json;

import java.lang.reflect.Type;

import org.kawanfw.commons.api.client.HttpProtocolParameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * Class to format a HttpProtocolParameters to a JSON String and vice versa using
 * Gson.
 * 
 * @author Nicolas de Pomereu
 */

public class HttpProtocolParametersGson {

    /**
     * Protected
     */
    protected HttpProtocolParametersGson() {

    }

    /**
     * Format a HttpProtocolParameters instance into a JSON String
     * 
     * @param httpProtocolParameters
     *            a HttpProtocolParameters instance
     * @return the JSON string
     */
    public static String toJson(HttpProtocolParameters httpProtocolParameters) {

	Gson gson = new Gson();
	Type type = new TypeToken<HttpProtocolParameters>() {
	}.getType();
	String jsonString = gson.toJson(httpProtocolParameters, type);

	return jsonString;
    }

    /**
     * Format a JSON String back to a HttpProtocolParameters instance
     * 
     * @param jsonString
     *            The JSON string containing the HttpProxy
     * @return the HttpProtocolParameters instance
     */
    public static HttpProtocolParameters fromJson(String jsonString) {
	Gson gson = new Gson();
	Type type = new TypeToken<HttpProtocolParameters>() {
	}.getType();

	HttpProtocolParameters httpProtocolParameters = gson.fromJson(
		jsonString, type);
	return httpProtocolParameters;
    }

}

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
package org.kawanfw.file.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.kawanfw.file.api.client.RemoteFile;
import org.kawanfw.file.api.client.RemoteSession;
import org.kawanfw.file.api.util.client.JarReader;
import org.kawanfw.file.reflection.ClassFileLocatorNew;
import org.kawanfw.file.test.parms.TestParms;

/**
 * @author Nicolas de Pomereu
 *
 */
public class Test {

    String title = null;
    String url = null;
    String cover = null;
    
    @Override
    public String toString() {
	return "Test [title=" + title + ", url=" + url + ", cover=" + cover
		+ "]";
    }

    /**
     * 
     */
    public Test() {
	
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

	File file = new File("c:\\test\\class.txt");
	File file2 = new File("c:\\test\\class.txt");
	System.out.println(file.compareTo(file2));
	
	RemoteSession remoteSession = new RemoteSession(
		    TestParms.AWAKE_URL, TestParms.REMOTE_USER,
		    TestParms.REMOTE_PASSWORD.toCharArray());
	
	RemoteFile remoteFile = new RemoteFile(remoteSession, "/class.txt");
	RemoteFile remoteFile2 = new RemoteFile(remoteSession, "/class.txt");	    
	System.out.println(remoteFile.compareTo(remoteFile2));	    
    }

    /**
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void ClassFileLocatorNewTest() throws ClassNotFoundException,
	    IOException, FileNotFoundException {
	String classname = "org.kawanfw.file.test.run.filter.StaticFilterTest$ThePublicStaticFileFilter";
	Class<?> clazz = Class.forName(classname);
	ClassFileLocatorNew classFileLocatorNew = new ClassFileLocatorNew(clazz, null);
	byte [] byteArray = classFileLocatorNew.extractClassFileBytecode();
	System.out.println("byteArray.length: " + byteArray.length);
	
	File file = new File("I:\\_dev_awake\\awake-file-3.0\\lib\\kawanfw-filters.jar");
	byte [] b = JarReader.extractClassFileBytecode(new FileInputStream(file), classname);
	System.out.println("b.length: " + b.length);
	
	file = new File("I:\\_dev_awake\\awake-file-android-test\\assets\\kawansoft\\kawanfw-filters.jar");
	b = JarReader.extractClassFileBytecode(new FileInputStream(file), classname);
	System.out.println("b.length: " + b.length);
    }

}

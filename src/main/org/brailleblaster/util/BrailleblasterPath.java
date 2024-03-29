/* BrailleBlaster Braille Transcription Application
  *
  * Copyright (C) 2010, 2012
  * ViewPlus Technologies, Inc. www.viewplus.com
  * and
  * Abilitiessoft, Inc. www.abilitiessoft.com
  * All rights reserved
  *
  * This file may contain code borrowed from files produced by various 
  * Java development teams. These are gratefully acknoledged.
  *
  * This file is free software; you can redistribute it and/or modify it
  * under the terms of the Apache 2.0 License, as given at
  * http://www.apache.org/licenses/
  *
  * This file is distributed in the hope that it will be useful, but
  * WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE
  * See the Apache 2.0 License for more details.
  *
  * You should have received a copy of the Apache 2.0 License along with 
  * this program; see the file LICENSE.
  * If not, see
  * http://www.apache.org/licenses/
  *
  * Maintained by John J. Boyer john.boyer@abilitiessoft.com
*/

package org.brailleblaster.util;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BrailleblasterPath
{
   public static String getPath (Object classToUse) 
{
	   
    /*  Option to use an environment variable (mostly for testing with 
    * Eclipse) */
    String url = System.getenv("BBLASTER_WORK");
    if (url != null) {
    	     url = "file:/" + url ;
    } 
    else {  
    	url = classToUse.getClass().getResource("/" 
+ classToUse.getClass().getName().replaceAll("\\.", "/")
 + ".class").toString();

     url = url.substring(url.indexOf("file")).replaceFirst("/[^/]+\\.jar!.*$", "/");
    }
     
     try {
         File dir = new File(new URL(url).toURI());
         url = dir.getAbsolutePath();

     
     } catch (MalformedURLException mue) {
         url = null;
     } catch (URISyntaxException ue) {
         url = null;
     }
     return url;
   } 
}

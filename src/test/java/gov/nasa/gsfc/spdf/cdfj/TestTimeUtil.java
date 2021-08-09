/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nasa.gsfc.spdf.cdfj;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author smf
 */
public class TestTimeUtil {
    
    
    // folder for tests - gets deleted after each test
    @ClassRule
    public static TemporaryFolder temp_folder = new TemporaryFolder ();
    
    @BeforeClass
    public static void setupTimeUtil () throws Exception, Throwable
    {
//        Properties props = System.getProperties();
//        File ls_file = temp_folder.newFile("CDFLeapSeconds.txt");
//        props.setProperty("CDF_LEAPSECONDSTABLE", ls_file.getAbsolutePath());
    }
    
    // test the leap second reading static routine in TestTimeUtils
    @Test
    public void testTimeUtil () throws Exception, Throwable
    {
        System.out.println("TimeUtil");
        
        Map<String, Long> tt2000_map = new HashMap<> ();
        // the following map contents relate date/times in ISO8601 format
        // to TT2000 values - they were generated using the CDF C interface
        tt2000_map.put ("1972-01-01T00:00:00.000", -883655957816000000l);
        tt2000_map.put ("1972-07-01T00:00:00.000", -867931156816000000l);
        tt2000_map.put ("1973-01-01T00:00:00.000", -852033555816000000l);
        tt2000_map.put ("1973-07-01T00:00:00.000", -836395155816000000l);
        tt2000_map.put ("1974-01-01T00:00:00.000", -820497554816000000l);
        tt2000_map.put ("1974-07-01T00:00:00.000", -804859154816000000l);
        tt2000_map.put ("1975-01-01T00:00:00.000", -788961553816000000l);
        tt2000_map.put ("1975-07-01T00:00:00.000", -773323153816000000l);
        tt2000_map.put ("1976-01-01T00:00:00.000", -757425552816000000l);
        tt2000_map.put ("1976-07-01T00:00:00.000", -741700752816000000l);
        tt2000_map.put ("1977-01-01T00:00:00.000", -725803151816000000l);
        tt2000_map.put ("1977-07-01T00:00:00.000", -710164751816000000l);
        tt2000_map.put ("1978-01-01T00:00:00.000", -694267150816000000l);
        tt2000_map.put ("1978-07-01T00:00:00.000", -678628750816000000l);
        tt2000_map.put ("1979-01-01T00:00:00.000", -662731149816000000l);
        tt2000_map.put ("1979-07-01T00:00:00.000", -647092749816000000l);
        tt2000_map.put ("1980-01-01T00:00:00.000", -631195148816000000l);
        tt2000_map.put ("1980-07-01T00:00:00.000", -615470348816000000l);
        tt2000_map.put ("1981-01-01T00:00:00.000", -599572748816000000l);
        tt2000_map.put ("1981-07-01T00:00:00.000", -583934347816000000l);
        tt2000_map.put ("1982-01-01T00:00:00.000", -568036747816000000l);
        tt2000_map.put ("1982-07-01T00:00:00.000", -552398346816000000l);
        tt2000_map.put ("1983-01-01T00:00:00.000", -536500746816000000l);
        tt2000_map.put ("1983-07-01T00:00:00.000", -520862345816000000l);
        tt2000_map.put ("1984-01-01T00:00:00.000", -504964745816000000l);
        tt2000_map.put ("1984-07-01T00:00:00.000", -489239945816000000l);
        tt2000_map.put ("1985-01-01T00:00:00.000", -473342345816000000l);
        tt2000_map.put ("1985-07-01T00:00:00.000", -457703944816000000l);
        tt2000_map.put ("1986-01-01T00:00:00.000", -441806344816000000l);
        tt2000_map.put ("1986-07-01T00:00:00.000", -426167944816000000l);
        tt2000_map.put ("1987-01-01T00:00:00.000", -410270344816000000l);
        tt2000_map.put ("1987-07-01T00:00:00.000", -394631944816000000l);
        tt2000_map.put ("1988-01-01T00:00:00.000", -378734343816000000l);
        tt2000_map.put ("1988-07-01T00:00:00.000", -363009543816000000l);
        tt2000_map.put ("1989-01-01T00:00:00.000", -347111943816000000l);
        tt2000_map.put ("1989-07-01T00:00:00.000", -331473543816000000l);
        tt2000_map.put ("1990-01-01T00:00:00.000", -315575942816000000l);
        tt2000_map.put ("1990-07-01T00:00:00.000", -299937542816000000l);
        tt2000_map.put ("1991-01-01T00:00:00.000", -284039941816000000l);
        tt2000_map.put ("1991-07-01T00:00:00.000", -268401541816000000l);
        tt2000_map.put ("1992-01-01T00:00:00.000", -252503941816000000l);
        tt2000_map.put ("1992-07-01T00:00:00.000", -236779140816000000l);
        tt2000_map.put ("1993-01-01T00:00:00.000", -220881540816000000l);
        tt2000_map.put ("1993-07-01T00:00:00.000", -205243139816000000l);
        tt2000_map.put ("1994-01-01T00:00:00.000", -189345539816000000l);
        tt2000_map.put ("1994-07-01T00:00:00.000", -173707138816000000l);
        tt2000_map.put ("1995-01-01T00:00:00.000", -157809538816000000l);
        tt2000_map.put ("1995-07-01T00:00:00.000", -142171138816000000l);
        tt2000_map.put ("1996-01-01T00:00:00.000", -126273537816000000l);
        tt2000_map.put ("1996-07-01T00:00:00.000", -110548737816000000l);
        tt2000_map.put ("1997-01-01T00:00:00.000", -94651137816000000l);
        tt2000_map.put ("1997-07-01T00:00:00.000", -79012736816000000l);
        tt2000_map.put ("1998-01-01T00:00:00.000", -63115136816000000l);
        tt2000_map.put ("1998-07-01T00:00:00.000", -47476736816000000l);
        tt2000_map.put ("1999-01-01T00:00:00.000", -31579135816000000l);
        tt2000_map.put ("1999-07-01T00:00:00.000", -15940735816000000l);
        tt2000_map.put ("2000-01-01T00:00:00.000", -43135816000000l);
        tt2000_map.put ("2000-07-01T00:00:00.000", 15681664184000000l);
        tt2000_map.put ("2001-01-01T00:00:00.000", 31579264184000000l);
        tt2000_map.put ("2001-07-01T00:00:00.000", 47217664184000000l);
        tt2000_map.put ("2002-01-01T00:00:00.000", 63115264184000000l);
        tt2000_map.put ("2002-07-01T00:00:00.000", 78753664184000000l);
        tt2000_map.put ("2003-01-01T00:00:00.000", 94651264184000000l);
        tt2000_map.put ("2003-07-01T00:00:00.000", 110289664184000000l);
        tt2000_map.put ("2004-01-01T00:00:00.000", 126187264184000000l);
        tt2000_map.put ("2004-07-01T00:00:00.000", 141912064184000000l);
        tt2000_map.put ("2005-01-01T00:00:00.000", 157809664184000000l);
        tt2000_map.put ("2005-07-01T00:00:00.000", 173448064184000000l);
        tt2000_map.put ("2006-01-01T00:00:00.000", 189345665184000000l);
        tt2000_map.put ("2006-07-01T00:00:00.000", 204984065184000000l);
        tt2000_map.put ("2007-01-01T00:00:00.000", 220881665184000000l);
        tt2000_map.put ("2007-07-01T00:00:00.000", 236520065184000000l);
        tt2000_map.put ("2008-01-01T00:00:00.000", 252417665184000000l);
        tt2000_map.put ("2008-07-01T00:00:00.000", 268142465184000000l);
        tt2000_map.put ("2009-01-01T00:00:00.000", 284040066184000000l);
        tt2000_map.put ("2009-07-01T00:00:00.000", 299678466184000000l);
        tt2000_map.put ("2010-01-01T00:00:00.000", 315576066184000000l);
        tt2000_map.put ("2010-07-01T00:00:00.000", 331214466184000000l);
        tt2000_map.put ("2011-01-01T00:00:00.000", 347112066184000000l);
        tt2000_map.put ("2011-07-01T00:00:00.000", 362750466184000000l);
        tt2000_map.put ("2012-01-01T00:00:00.000", 378648066184000000l);
        tt2000_map.put ("2012-07-01T00:00:00.000", 394372867184000000l);
        tt2000_map.put ("2013-01-01T00:00:00.000", 410270467184000000l);
        tt2000_map.put ("2013-07-01T00:00:00.000", 425908867184000000l);
        tt2000_map.put ("2014-01-01T00:00:00.000", 441806467184000000l);
        tt2000_map.put ("2014-07-01T00:00:00.000", 457444867184000000l);
        tt2000_map.put ("2015-01-01T00:00:00.000", 473342467184000000l);
        tt2000_map.put ("2015-07-01T00:00:00.000", 488980868184000000l);
        tt2000_map.put ("2016-01-01T00:00:00.000", 504878468184000000l);
        tt2000_map.put ("2016-07-01T00:00:00.000", 520603268184000000l);
        tt2000_map.put ("2017-01-01T00:00:00.000", 536500869184000000l);
        tt2000_map.put ("2017-07-01T00:00:00.000", 552139269184000000l);
        tt2000_map.put ("2018-01-01T00:00:00.000", 568036869184000000l);
        tt2000_map.put ("2018-07-01T00:00:00.000", 583675269184000000l);
        tt2000_map.put ("2019-01-01T00:00:00.000", 599572869184000000l);
        tt2000_map.put ("2019-07-01T00:00:00.000", 615211269184000000l);

        // iterate over the dictionary of ISO8601 / TT2000 date/times,
        // checking that the Java constructed TT2000 value is the same
        // as the equivalent value from the C interface
        SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.SSS");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        TreeMap<String, Long> tt2000_map_sorted = new TreeMap<>(tt2000_map);
        for (Map.Entry pair : tt2000_map_sorted.entrySet()) {
            String date_string = (String) pair.getKey();
            double tt2000_given = ((double) ((Long) pair.getValue())) / 1000000000.0;
            Date date = df.parse (date_string);
            double tt2000_calc = TimeUtil.tt2000(date) / 1000000000.0;
            System.out.printf ("%s %s %.9f %.9f\n", date_string, df.format (date), tt2000_given, tt2000_calc);
            assertEquals (tt2000_given, tt2000_calc, 0.0000000001);
        }
    }
    
}

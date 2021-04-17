/* This code was written to investigate how the pure Java CDF library works,
 * since no example code is provided with the library. The functions used
 * in the test make use of all aspects of the CDF library needed for the
 * BGS Intermagnet CDF library code */

package gov.nasa.gsfc.spdf.cdfj;

import org.junit.Test;
import static org.junit.Assert.*;

import gov.nasa.gsfc.spdf.cdfj.TestCDFReadAndWrite;
import gov.nasa.gsfc.spdf.cdfj.CDFReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Vector;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;



public class TestCDFReadAndWrite
{
    private static final int TEST_DATA_LENGTH = 100;
    
    // folder for tests - gets deleted after each test
    @Rule
    public TemporaryFolder temp_folder = new TemporaryFolder ();
    
    @Test
    public void testWriteAndReadCDF () throws Exception, Throwable
    {
        System.out.println("WriteAndReadCDF: temp folder = " + temp_folder.getRoot().getAbsolutePath());
        
        // create data for tests
        File cdf_file = temp_folder.newFile ("test.cdf");
        String glob_attr_name = "MyGlobalAttr";
        String glob_attr_value = "Attribute contents";
        String data_var_name = "GeomagneticFieldX";
        String times_var_name = "GeomagneticTimes";
        String var_attr_name = "DEPEND_0";
        double data [] = new double [TEST_DATA_LENGTH];
        long times [] = new long [TEST_DATA_LENGTH];
        double missing_val = 99999.0;
        long missing_time = - Long.MAX_VALUE;
        Date date = new Date (1609459200000l);  // 2021-01-01T00:00:00.0000Z
        for (int count=0; count<data.length; count ++) {
            data[count] = Math.sin ((double) count * 2.0 * Math.PI / (double) data.length) * 100.0;
            times[count] = TimeUtil.tt2000(date);
            date = new Date (date.getTime() + 1000);
        }
        
        // write the CDF
        CDFWriter cdf_writer = new CDFWriter(false);
        cdf_writer.addGlobalAttributeEntry (glob_attr_name, CDFDataType.CHAR, glob_attr_value);
        cdf_writer.defineVariable (data_var_name, CDFDataType.DOUBLE, new int [] {}, new boolean [] {}, true, true, new double [] {missing_val});
        cdf_writer.defineVariable (times_var_name, CDFDataType.TT2000, new int [] {}, new boolean [] {}, true, true, new long [] {missing_time});
        int record_limits [] = new int [] {0, data.length -1};
        cdf_writer.addData (data_var_name, data, record_limits);
        cdf_writer.addData (times_var_name, times, record_limits);
        cdf_writer.addVariableAttributeEntry(data_var_name, var_attr_name, CDFDataType.CHAR, times_var_name);
        cdf_writer.write (cdf_file.getAbsolutePath(), true);
        
        // take a copy (uncomment to allow you to view the CDF file, which otherwise gets deleted)
//        Path target = Paths.get ("c:\\software\\cdfj\\test.cdf");
//        Files.copy(Paths.get(cdf_file.getAbsolutePath()), target, StandardCopyOption.REPLACE_EXISTING);
        
        // read and test the CDF
        CDFReader cdf_reader = new CDFReader (cdf_file.getAbsolutePath());
        Vector<AttributeEntry> glob_entries = cdf_reader.getAttributeEntries (glob_attr_name);
        AttributeEntry glob_entry = glob_entries.get(0);
        assertEquals (glob_attr_name, glob_entry.getAttributeName());
        assertEquals (glob_attr_value, glob_entry.getValue());
        double data_from_cdf [] = (double []) cdf_reader.get(data_var_name);
        long times_from_cdf [] = (long []) cdf_reader.get(times_var_name);
        assertEquals (TEST_DATA_LENGTH, data_from_cdf.length);
        assertEquals (TEST_DATA_LENGTH, times_from_cdf.length);
        for (int count=0; count<data.length; count ++) {
            assertEquals (data[count], data_from_cdf[count], 0.0001);
            assertEquals (times[count], times_from_cdf[count]);
        }        
        Vector<AttributeEntry> var_entries = cdf_reader.getAttributeEntries(data_var_name, var_attr_name);
        AttributeEntry var_entry = var_entries.get(0);
        assertEquals (var_attr_name, var_entry.getAttributeName());
        assertEquals (times_var_name, var_entry.getValue());
    }
}

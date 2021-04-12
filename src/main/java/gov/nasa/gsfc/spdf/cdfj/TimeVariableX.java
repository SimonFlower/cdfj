package gov.nasa.gsfc.spdf.cdfj;
import java.nio.ByteBuffer;
/**
 * Time Variable.
 */
public interface TimeVariableX extends TimeVariable {
    /**
     * Returns relative times for the specified time range using the given
     * {@link TimeInstantModel time instant model}.
     * <p>
     * @param    timeRange  relative time range 
     * @param    tspec  a time instant model
     * @return   a double array of times
     * @throws Throwable if an error occurs
     */
    public double[] getTimes(double[] timeRange, TimeInstantModel tspec) throws
        Throwable;
    /**
     * Returns the record range corresponding to the time range
     * <p>
     * @param    timeRange  time range 
     * @return   an int array of record range
     * @throws Throwable if an error occurs
     */

    public int[] getRecordRange(double[] timeRange) throws Throwable;
    /**
     * Returns the record range corresponding to the start/stop time range of given
     * time instant model
     * <p>
     * @param    startTime  relative start time
     * @param    stopTime  relative stop time
     * @param    ts  a time instant model
     * @return   an int array of record range
     * @throws Throwable if an error occurs
     */
    public int [] getRecordRange(int[] startTime, int[] stopTime,
            TimeInstantModel ts) throws Throwable;
    /**
     * Returns the raw buffer 
     * @return   a byte buffer object
     */
    public ByteBuffer getRawBuffer();
    /**
     * Returns the time precisio
     * @return   a time precision object
     */
    public TimePrecision getPrecision();
}

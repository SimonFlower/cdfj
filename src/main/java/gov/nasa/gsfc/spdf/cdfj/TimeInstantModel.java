package gov.nasa.gsfc.spdf.cdfj;
/**
 * An instant of time in timeseries methods of cdfj is defined by a base
 * time which is the
 * offset in milliseconds since Epoch 0, and an offset relative to the base 
 * time specified in one of the following time units: milliseconds, 
 * microseconds, nanoseconds or pico seconds.
 * The default Time Instant Model sets the offset unit be millisecond.
 * 
 */
public interface TimeInstantModel extends java.lang.Cloneable {
    /**
     * Returns base time in base time units since Epoch 0.
     * @see #getBaseTimeUnits()
     * @return a time in double value
     */
    public double getBaseTime();

    /**
     * Returns base time units.
     * <p>Currently fixed as TimePrecision.MILLISECOND</p>
     * @return a TimePrecision object
     */
    public TimePrecision getBaseTimeUnits();

    /**
     * Returns time offset units.
     * @return a TimePrecision object
     */
    public TimePrecision getOffsetUnits();

    /**
     * Sets time offset units.
     * <p>Units must be compatible with the underlying data resolution.</p>
     * <ul>
     * <li>If the time variable is type Epoch - units can only be millisecond
     * (TimePrecision.MILLISECOND).</li>
     * <li>For EPOCH16 time variable, acceptable units are: millisecond,
     * microsecond (TimePrecision.MICROSECOND),
     * nanosecond (TimePrecision.NANOSECOND), or
     * or picosecond(TimePrecision.PICOSECOND).</li>
     * <li>For Themis like time variable, acceptable units are: millisecond,
     * or microsecond.</li>
     * <li>For TT2000 time variable, acceptable units are: millisecond,
     * microsecond, or nanosecond.</li>
     * </ul>
     * @param precision a TimePrecision object
     */
    public void setOffsetUnits(TimePrecision precision);

    public Object clone();
}

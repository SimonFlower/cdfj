package gov.nasa.gsfc.spdf.cdfj;
import java.util.*;
public interface VariableAttribute extends Attribute {
    /**
     * returns count of entries for this variable attribute. 
     * @return the number of entries
     */
    public int getEntryCount();

    /**
     * returns nth entry for this variable attribute. 
     * if entry type is string, a String or String[] is returned.
     * if entry type is long, a long[] is returned.
     * In other cases  a double[] is returned
     * @param n the entry number
     * @return the entry in object
     */
    public Object getEntry(int n);

    /**
     * returns whether nth entry is of type long.
     * @param n the entry number
     * @return a flag indicating whether the entry is of long type
     * @throws Throwable is thrown for invalid entry number
     */
    public boolean isLongType(int n) throws Throwable;

    /**
     * returns whether nth entry is of type string.
     * @param n the entry number
     * @return a flag indicating whether the entry is of string type
     * @throws Throwable is thrown for invalid entry number
     */
    public boolean isStringType(int n) throws Throwable;
}

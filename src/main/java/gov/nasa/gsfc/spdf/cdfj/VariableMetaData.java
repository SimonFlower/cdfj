package gov.nasa.gsfc.spdf.cdfj;
import java.util.*;
import java.nio.*;
/**
 * Interface that defines methods for getting  properties of
 * a CDF variable.
 */
public interface VariableMetaData {
    /**
     * Determines whether the value of this variable is the same at
     * all time points. 
     * returns true if value may change, false otherwise
     * @return the variable's record variance
     */
    public boolean recordVariance();

    /**
     * Determines whether the value of this variable is represented as
     * a compressed byte sequence in the CDF.
     * @return a flag indicating whether the variable is compressed
     */
    public boolean isCompressed();

    /**
     * Determines whether the value of this variable is presented in
     * a row-major order in the CDF.
     * @return a flag indicating whether the variable is a row major
     */
    public boolean rowMajority();

    /**
     * Gets the name of this of this variable
     * @return the variable name
     */
    public String getName();

    /**
     * Gets the type of values of the variable.
     * Supported types are defined in the CDF Internal Format Description
     * @return the variable's data type
     */
    public int getType();

    /**
     * Gets the size of an item (defined as number of bytes needed to
     * represent the value of this variable at a point).
     * @return the variable's byte size for each data item
     */
    public int getDataItemSize();

    /**
     * Gets the sequence number of the variable inside the CDF. 
     * @return the variable number
     */
    public int getNumber();

    /**
     * Gets the number of elements (of type returned by getType()).
     * @return the variable's number of elements
     */
    public int getNumberOfElements();

    /**
     * Gets the number of values (size of time series)
     * @return the variable's number of data values 
     */
    public int getNumberOfValues();

    /**
     * Gets an object that represents a padded instance.
     * For variable of type 'string', a String is returned;
     * For numeric data, a double[] is returned. If the variable type is
     * long, a loss of precision may occur. 
     * @return the variable's pad value in object
     */
    public Object getPadValue();

    /**
     * Gets an object that represents a padded instance for a variable of
     * numeric type.
     * A double[] is returned, unless the variable type is long and
     * preservePrecision is set to true;
     * @param preservePrecision a flag indicating whether to preserve the
     *                          precision
     * @return the variable's pad value in object
     */
    public Object getPadValue(boolean preservePrecision);

    /**
     * Gets the dimensions.
     * @return the variable's dimensional sizes
     */
    public int[] getDimensions();

    /**
     * Gets the dimensional variance. This determines the effective
      record variance dimensionality of values of the variable.
     * @return the variable's dimensional variances 
     */
    public boolean[] getVarys();

    /**
     * Gets a list of regions that contain data for the variable.
     * Each element of the vector describes a region as an int[3] array.
     * Array elements are: record number of first point
     * in the region, record number of last point in the
     * region, and offset of the start of region.
     * @return the variable's list of regions that contain data
     */
    public VariableDataLocator getLocator();

    /**
     * Gets an array of VariableDataBuffer objects that provide location of
     * data for this variable if this variable is not compressed. This method
     * throws a Throwable if invoked for a compressed variable.
     * getBuffer method of VariableDataBuffer object returns a read only 
     * ByteBuffer that contains data for this variable for a range of
     * records. getFirstRecord() and getLastRecord() define the
     * range of records.
     * @return the variable data buffer
     * @throws Throwable if the variable is compressed
     */
    public VariableDataBuffer[] getDataBuffers() throws Throwable;
    /**
     * Gets an array of VariableDataBuffer objects that provide location of
     * data for this variable if this variable is not compressed. This method
     * throws a Throwable if invoked for a compressed variable.
     * getBuffer method of VariableDataBuffer object returns a read only 
     * ByteBuffer that contains data for this variable for a range of
     * records. getFirstRecord() and getLastRecord() define the
     * range of records.
     * @param raw a flag indicating whether 
     * @return the variable data buffer
     * @throws Throwable if the variable is compressed
     */
    public VariableDataBuffer[] getDataBuffers(boolean raw) throws Throwable;

    /**
     * Returns effective rank of this variable.
     * Dimensions for which dimVarys is false do not count.
     * @return the variable's effiective rank
     */
    public int getEffectiveRank();

    /**
     * Returns ByteBuffer containing uncompressed values converted to
     * a stream of numbers of the type specified by 'type' using the
     * specified byte ordering (specified by bo) for the specified range
     * of records. Original  ordering of values (row majority) is preserved.
     * recordRange[0] specifies the first record, and recordRange[1] the last
     * record. If 'preserve' is true, a Throwable is thrown if the conversion
     * to specified type will result in loss of precision. If 'preserve' is
     * false, compatible conversions will be made even if it results in loss
     * of precision. 
     * @param type the returned data tyle class
     * @param recordRange  a range of data points
     * @param preserve a flag indicating whether to preserve the precision 
     * @param bo the byte ordering object
     * @return the byte buffer object
     * @throws Throwable if an error occurs
     */
    public ByteBuffer getBuffer(Class type, int[] recordRange, boolean preserve,
        ByteOrder bo) throws Throwable;

    /**
     * Shows whether one or more records (in the range returned by
     * getRecordRange()) are missing. 
     * @return a flag indicating whether the returned record(s) contains
     * missing record(s).
     */
    public boolean isMissingRecords();

    /**
     * Returns record range for this variable
     * @return the variable's dimensions
     */
    public int[] getRecordRange();

    /**
     * returns whether conversion of this variable to type specified by
     * cl is supported while preserving precision.
     * equivalent to isCompatible(Class cl, true)
     * @param cl a given class
     * @return a flag indicating whether the variable can be converted
     * compatibly to the given class
     */
    public boolean isCompatible(Class cl);

    /**
     * returns whether conversion of this variable to type specified by
     * cl is supported under the given precision preserving constraint.
     * @param cl a given class
     * @param preserve the given precision preserving
     * @return a flag indicating whether the variable can be converted
     * compatibly to the given class
     */
    public boolean isCompatible(Class cl, boolean preserve);

    /**
     * Return whether the missing record should be assigned the last 
     * seen value. If none has been seen, pad value is assigned.
     * @return a flag indicating if missing record value is filled with the
     * last written value
     */
    public boolean missingRecordValueIsPrevious();

    /**
     * Return whether the missing record should be assigned the pad 
     * value.
     * @return a flag indicating if missing record value is filled with the
     * pad value
     */
    public boolean missingRecordValueIsPad();

    /**
     * Return element count for this variable's dimensions.
     * @return the variable's dimension sizes
     */
    public Vector getElementCount();

    /**
     * Returns the variable's effective dimensions
     * @return an int array of the effiective dimensions
     */
    public int[] getEffectiveDimensions();
    /**
     * Returns the variable's blocking factor
     * @return the blocking factor
     */
    public int getBlockingFactor();
    /**
     * Returns the variable's r/z type
     * @return a flag indicating whether the variable is a rVariable
     */
    public boolean isTypeR();
}

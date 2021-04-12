package gov.nasa.gsfc.spdf.cdfj;
import java.util.*;
import java.nio.*;
/**
 * Interface that defines methods for getting  properties of
 * a CDF variable.
 */
public interface Variable extends VariableMetaData {
    /**
     * Returns this variable's values as byte[] if variable type is byte,
     * unsigned byte or char. Otherwise, throws Throwable
     * @return an array of byte values
     * @throws Throwable for variables of other types.
     */
    public byte[] asByteArray() throws Throwable;

    /**
     * Returns this variable's values for a range of records as byte[] if
     * variable type is byte,  unsigned byte or char. Otherwise, throws
     * Throwable
     * @param pt the point range
     * @return an array of byte values
     * @throws Throwable for variables of other types.
     */
    public byte[] asByteArray(int[] pt) throws Throwable;

    /**
     * Returns this variable's values as float[].
     * If variable type cannot be cast to float, a Throwable is thrown.
     * @return an array of float values
     * @throws Throwable for variables of other types.
     */
    public float[] asFloatArray() throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * float[].
     * If variable type cannot be cast to float, a Throwable is thrown.
     * If preserve is true, a Throwable is thrown for variables of type double,
     * long or int to signal possible loss of precision.
     * @param preserve a flag indicating whether to preserve the precision
     * @param pt the point range
     * @return an array of float values
     * @throws Throwable for variables of other types.
     */
    public float[] asFloatArray(boolean preserve, int[] pt) throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * float[].
     * If variable type cannot be cast to float, a Throwable is thrown.
     * @param pt the point range
     * @return an array of float values
     * @throws Throwable for variables of other types.
     */
    public float[] asFloatArray(int[] pt) throws Throwable;

    /**
     * Returns this variable's values as double[].
     * If variable type cannot be cast to double, a Throwable is thrown.
     * @return an array of double values
     * @throws Throwable for variables of other types.
     */
    public double[] asDoubleArray() throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * double[].
     * If variable type cannot be cast to double, a Throwable is thrown.
     * If preserve is true, a Throwable is thrown for variables of type long
     * to signal possible loss of precision.
     * @param preserve a flag indicating whether to preserve the precision
     * @param pt the point range
     * @return an array of double values
     * @throws Throwable for variables of other types.
     */
    public double[] asDoubleArray(boolean preserve, int[] pt) throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * double[].
     * If variable type cannot be cast to double, a Throwable is thrown.
     * @param pt the point range
     * @return an array of double values
     * @throws Throwable for variables of other types.
     */
    public double[] asDoubleArray(int[] pt) throws Throwable;

    /**
     * Returns this variable's values as int[] for variables of type
     * int, short or unsigned short, byte or unsigned byte.
     * @return an array of int values
     * @throws Throwable for variables of other types.
     */
    public int[] asIntArray() throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * int[] for variables of type int, short or unsigned short, byte or
     * unsigned byte, or unsigned int (only if preserve is false).
     * @param preserve a flag indicating whether to preserve the signed 
     * @param pt the point range
     * @return an array of int values
     * @throws Throwable for variables of other types.
     */
    public int[] asIntArray(boolean preserve, int[] pt) throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * int[] for variables of type int, short or unsigned short, byte or
     * unsigned byte.
     * @param pt the point range
     * @return an array of int values
     * @throws Throwable for variables of other types.
     */
    public int[] asIntArray(int[] pt) throws Throwable;

    /**
     * Returns this variable's values as short[] for variables of type
     * short, byte or unsigned byte
     * @return an array of short values
     * @throws Throwable for variables of other types.
     */
    public short[] asShortArray() throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * short[] for variables of type short, byte or unsigned byte, or
     * unsigned short (only if preserve is false).
     * @param preserve a flag indicating whether to preserve its signed
     * @param pt the point range
     * @return an array of short values
     * @throws Throwable for variables of other types.
     */
    public short[] asShortArray(boolean preserve, int[] pt) throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * short[] for variables of type short, byte or unsigned byte.
     * @param pt the point range
     * @return an array of short values
     * @throws Throwable for variables of other types.
     */
    public short[] asShortArray(int[] pt) throws Throwable;

    /**
     * Returns this variable's values as long[] for variables of type long.
     * @return an array of long values
     * @throws Throwable for variables of other types.
     */
    public long[] asLongArray() throws Throwable;

    /**
     * Returns this variable's values for the specified range of records as
     * long[] for variables of type long.
     * @param pt the point range
     * @return an array of long values
     * @throws Throwable for variables of other types.
     */
    public long[] asLongArray(int[] pt) throws Throwable;

    /**
     * Return whether the missing record should be assigned the last 
     * seen value. If none has been seen, pad value is assigned.
     * @return a flag indicating whether missing data is filled with the last
     *         written value
     */
    public boolean missingRecordValueIsPrevious();

    /**
     * Return whether the missing record should be assigned the pad 
     * value.
     * @return a flag indicating whether missing data is filled with pad value
     */
    public boolean missingRecordValueIsPad();

    /**
     * Return element count for this variable's dimensions.
     * @return a vector for dimensional sizes
     */
    public Vector getElementCount();

    /**
     * Returns byte {@link VDataContainer.CByte DataContainer} for a
     * range of points.
     * @param pt the point range
     * @return a data container of Byte object
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CByte getByteContainer(int[] pt) throws Throwable;

    /**
     * Returns String {@link VDataContainer.CString DataContainer} for a
     * range of points.
     * @param pt the point range
     * @return a data container of String object
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CString getStringContainer(int[] pt) throws Throwable;

    /**
     * Returns float {@link VDataContainer.CFloat DataContainer} for a
     * range of points, optionally accepting possible loss of precision.
     * @param pt the point range 
     * @param preserve the flag indicating whether the precision is to be
     *         preserved
     * @param bo  the byte ordering
     * @return a data container of Float object
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CFloat getFloatContainer(int[] pt, boolean preserve,
        ByteOrder bo) throws Throwable;

    /**
     * Returns float {@link VDataContainer.CFloat DataContainer} for a
     * range of points using native ByteOrder, optionally accepting possible
     * loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @return the data container of Float type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CFloat getFloatContainer(int[] pt, boolean preserve)
        throws Throwable;

    /**
     * Returns double {@link VDataContainer.CDouble DataContainer} for a
     * range of points, optionally accepting possible loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @param bo the byte ordering object
     * @return the data container of Double type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CDouble getDoubleContainer(int[] pt, boolean preserve,
        ByteOrder bo) throws Throwable;

    /**
     * Returns double {@link VDataContainer.CDouble DataContainer} for a
     * range of points using native ByteOrder, optionally accepting possible
     * loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @return the data container of Double type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CDouble getDoubleContainer(int[] pt, boolean preserve)
        throws Throwable;

    /**
     * Returns int {@link VDataContainer.CInt DataContainer} for a
     * range of points, optionally accepting possible loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @param bo the byte ordering object
     * @return the data container of Long type

     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CInt getIntContainer(int[] pt, boolean preserve,
        ByteOrder bo) throws Throwable;

    /**
     * Returns int {@link VDataContainer.CInt DataContainer} for a
     * range of points using native ByteOrder, optionally accepting possible
     * loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @return the data container of Integer type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CInt getIntContainer(int[] pt, boolean preserve)
        throws Throwable;

    /**
     * Returns short {@link VDataContainer.CShort DataContainer} for a
     * range of points, optionally accepting possible loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @param bo the byte ordering object
     * @return the data container of Long type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CShort getShortContainer(int[] pt, boolean preserve,
        ByteOrder bo) throws Throwable;

    /**
     * Returns short {@link VDataContainer.CShort DataContainer} for a
     * range of points using native ByteOrder, optionally accepting possible
     * loss of precision.
     * @param pt the data points
     * @param preserve a flag indicating whether to preserve precision
     * @return the data container of Short type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CShort getShortContainer(int[] pt, boolean preserve)
        throws Throwable;

    /**
     * Returns long {@link VDataContainer.CLong DataContainer} for a
     * range of points.
     * @param pt the data points
     * @param bo the byte ordering object
     * @return the data container of Long type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CLong getLongContainer(int[] pt, ByteOrder bo) throws
        Throwable;

    /**
     * Returns short {@link VDataContainer.CLong DataContainer} for a
     * range of points using native ByteOrder.
     * @param pt the data points
     * @return the data container of Long type
     * @throws  Throwable if variable type is not compatible
     */
    public VDataContainer.CLong getLongContainer(int[] pt) throws Throwable;

    /**
     * Returns {@link CDFImpl CDFImpl} object containing this variable.
     * @return the source CDF object
     */
    public CDFImpl getCDF();

    /**
     * Returns effective dimensions
     */
    public int[] getEffectiveDimensions();
}

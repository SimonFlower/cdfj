package gov.nasa.gsfc.spdf.cdfj;
import java.nio.*;
import java.util.*;
/**
 * Interface that defines methods for getting attributes, variable
 * characteristics
 */
public interface CDFMeta {
    /**
     * Returns ByteOrder.LITTLE_ENDIAN, or ByteOrder.BIG_ENDIAN depending
     * the CDF encoding
     * @return The byte ordering
     */
    public ByteOrder getByteOrder();

    /**
     * Returns whether the arrays are stored in row major order in the source
     * @return The flag if this is a row major
     */
    public boolean rowMajority();

    /**
     * Returns names of variables in the CDF
     * @return An array of variable names
     */
    public String [] getVariableNames();

    /**
     * Returns the object that implements the {@link Variable} interface for
     * the named variable
     * @param name   name of the variable
     * @return The given variable's meta object
     */
    public VariableMetaData getVariable(String name);

    /**
     * Returns names of variables of given VAR_TYPE in the CDF
     * @param type   The VAR_TYPE value
     * @return An array of variables with the given VAR_TYPE
     */
    public String [] getVariableNames(String type);

    /**
     * Returns names of global attributes.
     * @return An array of global attribute names
     */
    public String [] globalAttributeNames();

    /**
     * Returns names of attributes of the given variable. 
     * @param name   name of the variable
     * @return An array of attribute names defined for the given variable
     */
    public String [] variableAttributeNames(String name);

    /**
     * Returns value of the named global attribute.
     * <p>
     * For a  character string attribute, a Vector of String is returned
     * For a  numeric attribute, a long[] is returned for long type;
     * double[] is returned for all other numeric types.
     * @param atr   name of the global attribute
     * @return An object for the attribute value(s)
     */
    public Object getAttribute(String atr);

    /**
     * Returns the {@link GlobalAttribute} object for the named global
     * attribute.
     * @param atr   name of the global attribute
     * @return An object for the given global attribute value
     * @exception Throwable If there was a problem getting the data
     */
    public GlobalAttribute getGlobalAttribute(String atr) throws Throwable;

    /**
     * Returns value of the named attribute for specified variable.
     * <p>
     * For a  character string attribute, a String[] is returned
     * For a  numeric attribute, a long[] is returned for long type;
     * double[] is returned for all other numeric types.
     * @param vname   name of the variable
     * @param aname   name of the attribute
     * @return An object for the variable attribute entry
     */
    public Object getAttribute(String vname, String aname);

    /**
     * Returns whether value of the given variable can be cast to the
     * specified type without loss of precision
     * @param vname   name of the variable
     * @param cl      An object class
     * @return A flag
     * @exception Throwable If there was a problem checking the variable
     */
    public boolean isCompatible(String vname, Class cl) throws Throwable;

    /**
     * Returns values of a numeric variable whose values can be converted
     * to double without loss of precision as double[].
     * If variable is non-numeric, or of type long a Throwable is thrown.
     * @param varName   name of the variable
     * @return An array of double values for a numeric variable
     * @exception Throwable If there was a problem getting the data
     */
    public double[] get1D(String varName) throws Throwable;

    /**
     * Returns values of a string variable as byte[].
     * If variable is numeric, a Throwable is thrown.
     * @param varName   name of the variable
     * @param stringType  A flag if the variable is a string type
     * @return An array of byte data for the variable
     * @exception Throwable If there was a problem getting the data
     */
    public byte[] get1D(String varName, Boolean stringType) throws Throwable;

    /**
     * Returns value of a variable as a one dimensional array.
     * returns, as double[], values of a numeric variable whose values can be
     * converted  to double without loss of precision;
     * returns, as byte[], values of a string variable;
     * returns, as long[], values of a long variable for preserve = true,
     * and as double[] otherwise.
     * @param varName   name of the variable
     * @param preserve  Whether to preserve the precision
     * @return A 1D object
     * @exception Throwable If there was a problem getting the data
     */
    public Object get1D(String varName, boolean preserve) throws Throwable;

    /**
     * Returns value of 1 dimensional variable at the specified point.
     * @param varName   name of the variable
     * @param point     The point number of the variable
     * @return A 1D object
     * @exception Throwable If there was a problem getting the data
     */
    public Object get1D(String varName, int point) throws Throwable;

    /**
     * Returns values of 1 dimensional variable for the specified 
     * range of points.
     * @param varName   name of the variable
     * @param first     record number of first point of range
     * @param last      record number of first point of range
     * @return A 1D object
     * @exception Throwable If there was a problem getting the data
     */
    public Object get1D(String varName, int first, int last) throws Throwable;

    public Vector getAttributeEntries(String attribute) throws Throwable;
    public Vector getAttributeEntries(String vname, String attribute);
}

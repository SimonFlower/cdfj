package gov.nasa.gsfc.spdf.cdfj;
//import gov.nasa.gsfc.spdf.common.*;
import java.nio.*;
/**
 * Data Container for a variable
 */
public interface VDataContainer extends Runnable {
    /**
     * Returns ByteBuffer for this container.
     * @return byte buffer
     */
    public ByteBuffer getBuffer();

    /**
     * Returns range of records in this container.
     * @return A range of data records
     */
    public int[] getRecordRange();

    /**
     * Returns the one dimensional array representation.
     * @return A 1-D array object
     */
    public Object as1DArray();
    /**
     * Returns the one dimensional array representation.
     * @param cmtarget A flag indicating whether to column major target
     * @return An 1-D array object
     */
    public Object asOneDArray(boolean cmtarget);
    /**
     * Returns the one dimensional array representation.
     * @return An array object
     * @throws Throwable if an error occurs
     */
    public AArray asArray() throws Throwable ;
    /**
     * @param direct as true or false
     */
    public void setDirect(boolean direct);

    /**
     * Returns the {@link Variable Variable} for this container.
     * @return An Variable object
     */
    public Variable getVariable();

    /**
     * Double Data Container.
     */
    public static interface CDouble extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public double[] as1DArray();
        public double[] asOneDArray();
        public double[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        public DoubleArray asArray() throws Throwable ;
    }

    /**
     * Float Data Container.
     */
    public static interface CFloat extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public float[] as1DArray();
        public float[] asOneDArray();
        public float[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        public FloatArray asArray() throws Throwable ;
    }

    /**
     * Int Data Container.
     */
    public static interface CInt extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public int[] as1DArray();
        public int[] asOneDArray();
        public int[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        public IntArray asArray() throws Throwable ;
    }

    /**
     * Short Data Container.
     */
    public static interface CShort extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public short[] as1DArray();
        public short[] asOneDArray();
        public short[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        public ShortArray asArray() throws Throwable ;
    }

    /**
     * Long Data Container.
     */
    public static interface CLong extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public long[] as1DArray();
        public long[] asOneDArray();
        public long[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        public LongArray asArray() throws Throwable ;
    }

    /**
     * Byte Data Container.
     */
    public static interface CByte extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public byte[] as1DArray();
        public byte[] asOneDArray();
        public byte[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        //public ByteArray asArray() throws Throwable ;
    }

    /**
     * String Data Container.
     */
    public static interface CString extends VDataContainer {
        /**
         * Returns the one dimensional array representation.
         */
        public byte[] as1DArray();
        public byte[] asOneDArray();
        public byte[] asOneDArray(boolean cmtarget);

        /**
         * Returns the multi dimensional array representation.
         */
        //public StringArray asArray() throws Throwable ;
    }
    public boolean setUserBuffer(ByteBuffer buffer);
    public int getCapacity();
}

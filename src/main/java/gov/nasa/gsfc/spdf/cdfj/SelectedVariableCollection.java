package gov.nasa.gsfc.spdf.cdfj;
/**
 * Specifies the selection and options for the aggregated CDF.
 */
public interface SelectedVariableCollection {
    /**
     * Add a variable to the output with specified compression and
     * default specification for {@link SparseRecordOption SparseRecordOption},
     * (PAD).
     * @param name sparse record in string representation
     * @param compression A flag indicating whether the variable is to compressed
     */
    public void add(String name, boolean compression);

    /**
     * Add a variable to the output with specified compression and
     * specified setting for {@link SparseRecordOption SparseRecordOption}.
     * @param name sparse record in string representation
     * @param compression A flag indicating whether the variable is to compressed
     * @param opt a SparseRecordOption object
     */
    public void add(String name, boolean compression, SparseRecordOption opt);

    /**
     * Returns whether compression was chosen for the variable.
     * @param name a variable name
     * @return A flag indicating whether the variable is compressed
     */
    public boolean isCompressed(String name);

    /**
     * Returns a list of variable selected.
     * @return a array of selected variable names
     */
    public String[] getNames();

    /**
     * Returns whather a given variable is in the list of variable selected.
     * @param name a variable name
     * @return a flag indicating whether the variable is in the list of variable selected
     */
    public boolean hasVariable(String name);

    /**
     * Returns {@link SparseRecordOption SparseRecordOption} chosen for
     * the given variable.
     * @param name sparse record in string representation
     * @return a SparseRecordOption object
     */
    public SparseRecordOption getSparseRecordOption(String name);
}

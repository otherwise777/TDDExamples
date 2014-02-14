//# BEGIN SKELETON

/**
 * Concrete class for graded homework assignment in Series 1 of 2IPC0, where you
 * provide a functional decomposition of {@code isSecure()}.
 * <p>
 * Write your code in this file between the lines marked by //# BEGIN TODO ...
 * and //# END TODO (do NOT remove these markers).
 * <p>
 * <!--//# BEGIN TODO: Name, id, and date-->
 * <p>
 * <font color="red"><b>Ligtenberg Wouter <br />0864271 <br
 * />07-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposed extends AbstractKeyCollection {

    @Override
    public boolean isSecure(int[][][] keys) {
//# BEGIN TODO: Functional decomposition; the top-level method
        //iterates through all the keys that get checked with other keys
        for (int key1 = 0; key1 != keys.length; key1++) {
            if (!isKey(keys[key1])) { //checks if key1 is a valid key
                return false;
            }
            //for every key1 it iterates through all keys to check if it is 
            //secure
            for (int key2 = 0; key2 != keys.length; key2++) {
                //does nothing if keys are the same
                if (key1 == key2) {
                } else if (isKeyConvertable(keys[key1], keys[key2])) {
                    //if keys are convertable returns false
                    return false;
                }
            } //end of key2
        } //end of key1
        return true;
//# END TODO
    }

//# BEGIN TODO: Functional decomposition; auxiliary method(s) with contracts 
    /**
     * Checks if {@code key1} is convertible into {@code key2} 
     *
     * @param key1 the first key that will be checked with {@code key2}
     * @param key2 the second key that is checked with {@code key1}
     * @return whether {@code key1} can be converted into {@code key2}
     * @pre {@code key1 != null && key2 != null && iskey(key1) && iskey(key2) }
     * @modifies none
     * @post {@code \result == (!(length(key1) == length(key2) ||
     * \forall r; !isRowKeyConvertable(key1[r], key2[r])))}
     */
    public boolean isKeyConvertable(int[][] key1, int[][] key2) {
        if (key1.length != key2.length) {
            return false;
            //returns false because the keys are not the same size thus not convertible
        }
        //iterates through the 2 rows
        for (int r = 0; r != N_ROWS; r++) {
            if (!isRowKeyConvertable(key1[r], key2[r])) {
                //returns false if row r of key1 can be converted into row r of key2
                return false;
            }
        } //end of r
        return true; //returns true if key is  convertable
    }

    /**
     * checks if the row is convertible.
     *
     * @param row1 the first row to be checked
     * @param row2 the the second row to be checked
     * @return whether {@code row1} can be converted into {@code row2}
     * @pre {@code row1 != null && row2 != null}
     * @modifies none
     * @post {@code \result == !(length(row1) == length(row2) &&
     * (\forall i; row1[i] < row2[i]))}
     */
    public boolean isRowKeyConvertable(int[] row1, int[] row2) {
        if (row1.length != row2.length) {
            //returns false because the rows are not the same size thus not convertable
            return false;
        }
        for (int i = 0; i != row1.length; i++) { //iterates through the cuts of the row
            if (row1[i] < row2[i]) {
                //returns false when one of the cuts of row1 is smaller 
                //then the same cut in row2
                return false;
            }
        } //end of i
        return true;
    }
}
//# END TODO
//# END SKELETON

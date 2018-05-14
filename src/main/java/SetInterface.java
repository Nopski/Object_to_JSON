public interface SetInterface {
    /**
     * create Set
     */
    public void create();

    /**
     * create Set by Object
     * @param obj
     */
    public void create(Object[] obj);

    /**
     * create Set by int
     * @param array
     */
    public void create(int[] array);

    /**
     * show
     */
    public void show();

    /**
     * show with object
     * @param obj
     */
    public void show_obj(Object[] obj);

    /**
     * add element
     * @param elemnt
     */
    public void add(int elemnt);

    /**
     * check on empty
     * @return
     */
    public boolean isEmpty();

    /**
     * check on empty object
     * @return true or false
     */
    public boolean isEmptyObj();

    /**
     * clear all elements
     */
    public void clear();

    /**
     * clear all objects array
     */
    public void clearObj();

    /**
     * remove index in array
     * @param index
     */
    public void remove(int index);

    /**
     * return size of array
     * @return int of size
     */
    public int size();

    /**
     * return size of array object
     * @return int of size
     */
    public int sizeObj();
}

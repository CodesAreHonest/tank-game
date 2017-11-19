/**
 * @author (Chai Ying Hua)
 * <p>
 * This is the iterator's interface of the ITERATOR design patterns
 * -----------------------------------------------------------------
 * 1. This class is an interface that represents aggregation and create iterator for the containers.
 * 2. The iterator is create in the ArrayList to access the elements contain in the container without exposing its internal structure.
 */


import java.util.Iterator;

public interface MoveIterator {
    public Iterator createIterator();
}
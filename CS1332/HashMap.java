import java.util.List;
import java.util.Set;

/**
 * Your implementation of HashMap.
 *
 * @author Hardik Sangwan
 * @version 1.0
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

    // Do not make any new instance variables.
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code INITIAL_CAPACITY}.
     *
     * Do not use magic numbers!
     *
     * Use constructor chaining.
     */
    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code initialCapacity}.
     *
     * You may assume {@code initialCapacity} will always be positive.
     *
     * @param initialCapacity initial capacity of the backing array
     */
    public HashMap(int initialCapacity) {
        table = (MapEntry<K, V>[]) new MapEntry[initialCapacity];
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key/Value provided is null");
        }
        if (((double) (size + 1) / (double) table.length) > MAX_LOAD_FACTOR) {
            resizeBackingTable((table.length * 2) + 1);
        }
        return putHelper(key, value);
    }

    /**
    * Helper method for the add and resize method
    * @param key the key of the new entry to be added
    * @param value the value associated with the key
    * @throws IllegalArgumentException if key or value is null
    * @return null if the key was not already in the map.  If it was in the
    * map, return the old value associated with it
    */
    private V putHelper(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key/Value provided is null");
        }
        int hashval = (Math.abs(key.hashCode()) % table.length);
        int index = 1;
        MapEntry<K, V> temporary;
        int[] tempInd = new int[table.length];
        int tempI = 0;
        if (table[hashval] == null) {
            table[hashval] = new MapEntry<K, V>(key, value);
            size++;
            return null;
        } else {
            for (int i = 0; i < table.length; i++) {
                if (table[hashval] != null && !table[hashval].isRemoved()
                    && table[hashval].getKey().equals(key)) {
                    temporary = table[hashval];
                    V temp = table[hashval].getValue();
                    table[hashval].setValue(value);
                    table[hashval].setKey(key);
                    return temp;
                }
                if (table[hashval] == null || table[hashval].isRemoved()) {
                    tempInd[tempI] = hashval;
                    tempI++;
                }
                hashval = ((Math.abs(key.hashCode()) + index) % table.length);
                index++;
            }
        }
        table[tempInd[0]] = new MapEntry<K, V>(key, value);
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key provided is null");
        }
        for (int i = 0; i < table.length; i++) {
            int hashval = ((Math.abs(key.hashCode()) + i) % table.length);
            if (table[hashval] != null && table[hashval].getKey().equals(key)) {
                if (!table[hashval].isRemoved()) {
                    table[hashval].setRemoved(true);
                    size--;
                    return table[hashval].getValue();
                }
            } else if (table[hashval] == null) {
                throw new java.util.NoSuchElementException("The key is not"
                + " in the map");
            }
        }
        throw new java.util.NoSuchElementException("The key is not in the map");
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key provided is null");
        }
        for (int i = 0; i < table.length; i++) {
            int hashval = ((Math.abs(key.hashCode()) + i) % table.length);
            if (table[hashval] != null && table[hashval].getKey().equals(key)) {
                if (!table[hashval].isRemoved()) {
                    return table[hashval].getValue();
                }
            } else if (table[hashval] == null) {
                throw new java.util.NoSuchElementException("The key is not"
                + " in the map");
            }
        }
        throw new java.util.NoSuchElementException("The key is not in the map");
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key provided is null");
        }
        for (int i = 0; i < table.length; i++) {
            int hashval = ((Math.abs(key.hashCode()) + i) % table.length);
            if (table[hashval] != null && table[hashval].getKey().equals(key)) {
                if (table[hashval].isRemoved()) {
                    return false;
                }
                return true;
            } else if (table[hashval] == null) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        table = (MapEntry<K, V>[]) new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new java.util.HashSet<K>();
        int ind = 0;
        for (int i = 0; i < table.length && ind < size; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                set.add(table[i].getKey());
                ind++;
            }
        }
        return set;
    }

    @Override
    public List<V> values() {
        List<V> list = new java.util.ArrayList<V>();
        int ind = 0;
        for (int i = 0; i < table.length && ind < size; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                list.add(table[i].getValue());
                ind++;
            }
        }
        return list;
    }

    @Override
    public void resizeBackingTable(int length) {
        if (length <= 0 || length < size) {
            throw new IllegalArgumentException("length is non positive or less"
            + " than the size of the backing array");
        }
        MapEntry<K, V>[] oldTable = table;
        table = (MapEntry<K, V>[]) new MapEntry[length];
        int index = 1;
        size = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && !oldTable[i].isRemoved()) {
                putHelper(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    @Override
    public MapEntry<K, V>[] getTable() {
        // DO NOT EDIT THIS METHOD!
        return table;
    }

}
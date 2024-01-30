// --== CS400 Project One File Header ==--
// Name: August Bambenek
// CSL Username: bambenek
// Email: abambenek@wisc.edu
// Lecture #: <001 @11:00am, 002 @1:00pm, 003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Implementation of a hashtable using chaining to handle collisions
 * 
 * @author Study
 * @param <KeyType> - generic data type of the key 
 * @param <ValueType> - generic data type of the value
 */
public class HashtableMap <KeyType, ValueType> implements MapADT <KeyType, ValueType> {
	
	protected LinkedList[] hashTable; // hashtable implemented with an array of Linked Lists
	
	/**
	 * creates and initializes the hashtable with a specified capacity
	 * 
	 * @param capacity - capacity of the hashtable being initialized
	 */
	public HashtableMap (int capacity) {
		hashTable = new LinkedList[capacity];
		initializeHashtable(hashTable);
	}
	
	/**
	 * creates and initializes the hashtable with a default capacity of 15
	 */
	public HashtableMap() {
		hashTable = new LinkedList[15];
		initializeHashtable(hashTable);
	}

	/**
	 * Places an input key/value pair into the hashtable.  Also doubles the capacity of the hashtable when
	 * the load factor is > 70%
	 * 
	 * @param key - key to insert into hashtable
	 * @param value - value to insert into hashtable
	 * @return true if element was successfully inserted, false if element wasn't successfully inserted
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean put(KeyType key, ValueType value) {
		if (key == null) {
			return false;
		}
		if ((double) (size() + 1.0)/ hashTable.length >= 0.7) {
			hashTable = rehash();
		}
		if (hashTable[key.hashCode() % hashTable.length].size() == 0) {
			hashTable[key.hashCode() % hashTable.length].add(putHelper(key, value));
			return true;
		}
		for (int i = 0; i < hashTable[key.hashCode() % hashTable.length].size(); i++) {
			if (hashTable[key.hashCode() % hashTable.length].get(i) instanceof LinkedList) {
				if (key.equals(((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getFirst())) {
					return false;
				}
				if (i == hashTable[key.hashCode() % hashTable.length].size() - 1) {
					hashTable[key.hashCode() % hashTable.length].add(putHelper(key, value));
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * private helper version of the put method with a specified list to insert elements into 
	 * rather than the default hashTable.
	 * 
	 * @param key - key to insert into hashtable
	 * @param value - value to insert into hashtable
	 * @param list - hashtable that key/value pair is being inserted into
	 * @return true if element was successfully inserted, false if element wasn't successfully inserted
	 */
	private boolean put(KeyType key, ValueType value, LinkedList[] list) {
		if (key == null) {
			return false;
		}
		if (list[key.hashCode() % list.length].size() == 0) {
			list[key.hashCode() % list.length].add(putHelper(key, value));
			return true;
		}
		for (int i = 0; i < list[key.hashCode() % list.length].size(); i++) {
			if (list[key.hashCode() % list.length].get(i) instanceof LinkedList) {
				if (key.equals(((LinkedList) list[key.hashCode() % list.length].get(i)).getFirst())) {
					return false;
				}
				if (i == list[key.hashCode() % list.length].size() - 1) {
					list[key.hashCode() % hashTable.length].add(putHelper(key, value));
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * private helper method, helps put key/value pairs into the LinkedLists to implement chaining.
	 * Key is the first element, value is the second element.
	 * 
	 * @param key - key to go in key/value pair
	 * @param value - value to go in key/value pair
	 * @return the key/value pair
	 */
	private LinkedList putHelper(KeyType key, ValueType value) {
		LinkedList list = new LinkedList();
		list.add(key);
		list.add(value);
		return list;
	}

	/**
	 * private helper method; returns a new hashtable with the exact same key/value pairs 
	 * but double the capacity
	 * 
	 * @return a new hashtable with the exact same key/value pairs but double the capacity
	 */
	private LinkedList[] rehash() {
		KeyType tempKey;
		ValueType tempValue;
		LinkedList[] newHash = new LinkedList[hashTable.length * 2];
		initializeHashtable(newHash);
		for (int i = 0; i < hashTable.length; i++) {
			for (int j = 0; j < hashTable[i].size(); j++) {
				if (hashTable[i].get(j) instanceof LinkedList) {
					tempKey = (KeyType)((LinkedList) hashTable[i].get(j)).getFirst();
					tempValue = (ValueType)((LinkedList) hashTable[i].get(j)).getLast();
					put(tempKey, tempValue, newHash);
				}
			}
		}
		return newHash;
	}
	
	/**
	 * helper method to initialize the hashtable array with LinkedLists in each spot
	 * 
	 * @param list - new array of LinkedLists that needs to be initialized to become a hashtable
	 */
	private void initializeHashtable(LinkedList[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList();
		}
	}
	
	/**
	 * Searches for a key in the hashtable and returns its corresponding value
	 * 
	 * @param key - key to look for in the hashtable
	 * @return the value corresponding with the key passed as input
	 * @throws NoSuchElementException if the key passed as input can not be found in the hashtable
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		for (int i = 0; i < hashTable[key.hashCode() % hashTable.length].size(); i++) {
			if (hashTable[key.hashCode() % hashTable.length].get(i) instanceof LinkedList) {
				if (key.equals(((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getFirst())) {
					return (ValueType) (((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getLast());
				}
			}
		}
		throw new NoSuchElementException("element not found");
	}

	/**
	 * removes a key/value pair from the hashtable
	 * 
	 * @param key - key to look for and remove from the hashtable
	 * @return the removed value that corresponds with the removed key
	 */
	@Override
	public ValueType remove(KeyType key) {
		for (int i = 0; i < hashTable[key.hashCode() % hashTable.length].size(); i++) {
			if (hashTable[key.hashCode() % hashTable.length].get(i) instanceof LinkedList) {
				if (key.equals(((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getFirst())) {
					ValueType removedVal = (ValueType) (((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getLast());
					hashTable[key.hashCode() % hashTable.length].remove(i);
					return removedVal;
				}
			}
		}
		return null;
	}

	/**
	 * checks if a key passed as input matches a key that is currently in the hashtable
	 * 
	 * @param key - key to look for in the hashtable
	 * @return true if key is in the hashtable, returns false if the key is not in the hashtable
	 */
	@Override
	public boolean containsKey(KeyType key) {
		for (int i = 0; i < hashTable[key.hashCode() % hashTable.length].size(); i++) {
			if (hashTable[key.hashCode() % hashTable.length].get(i) instanceof LinkedList) {
				if (key.equals(((LinkedList) hashTable[key.hashCode() % hashTable.length].get(i)).getFirst())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * returns the current number of key/value pairs in the hashtable
	 * 
	 * @return number of key/value pairs in the hashtable
	 */
	@Override
	public int size() {
		int count = 0;
		for (int i = 0; i < hashTable.length; i++) {
			count += hashTable[i].size();
		}
		return count;
	}

	/**
	 * clears all elements in the hashtable
	 */
	@Override
	public void clear() {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i].clear();
		}
	}

}

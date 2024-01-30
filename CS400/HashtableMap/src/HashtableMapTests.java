// --== CS400 Project One File Header ==--
// Name: August Bambenek
// CSL Username: bambenek
// Email: abambenek@wisc.edu
// Lecture #: <001 @11:00am, 002 @1:00pm, 003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

public class HashtableMapTests {
	
	/**
	 * tests functionality of put and get on elements using chaining and elements not using chaining
	 * 
	 * @return true if tests pass, false if tests fail
	 */
	public static boolean test1() {
		try {
			HashtableMap<Integer, String> hash = new HashtableMap<Integer, String>(10);
			if (!hash.put(12, "twelve")) {
				return false;
			}
			if (!hash.put(13, "thirteen")) {
				return false;
			}
			if (!hash.put(23, "twenty-three")) {
				return false;
			}
			if (!hash.put(3, "three")) {
				return false;
			}
			if (!hash.get(3).equals("three")) {
				return false;
			}
			if (!hash.get(13).equals("thirteen")) {
				return false;
			}
			if (!hash.get(23).equals("twenty-three")) {
				return false;
			}
			if (!hash.get(12).equals("twelve")) {
				return false;
			}
			if (hash.put(3, "not three")) {
				return false;
			}
			if (!hash.get(3).equals("three")) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * tests remove and clear methods
	 * 
	 * @return true if tests pass, false if tests fail
	 */
	public static boolean test2() { 
		try {
			HashtableMap<Character, Double> hash = new HashtableMap<Character, Double>();
			hash.put('A', 1.23);
			hash.put('B', 2.34);
			hash.put('Q', 17.18);
			hash.put('C', 3.45);
			if (hash.remove('D') != null) {
				return false;
			}
			if (hash.size() != 4) {
				return false;
			}
			if (hash.remove('Q') - 17.18 > 0.00001) {
				return false;
			}
			if (hash.size() != 3) {
				return false;
			}
			hash.clear();
			if (hash.size() != 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * tests thrown exception on get method
	 * 
	 * @return true if tests pass, false if tests fail
	 */
	public static boolean test3() { 
		try {
			HashtableMap<String, Integer> hash = new HashtableMap<String, Integer>();
			hash.get("ZZZZZ");
			return false;
		} catch (NoSuchElementException e) {
			if (e.getMessage().equals("element not found")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		} 
	}
	
	/**
	 * tests containsKey and size methods
	 * 
	 * @return true if tests pass, false if tests fail
	 */
	public static boolean test4() {
		try {
			HashtableMap<Integer, Character> hash = new HashtableMap<Integer, Character>();
			if (hash.size() != 0) {
				return false;
			}
			hash.put(3, '@');
			if (!hash.containsKey(3)) {
				return false;
			}
			if (hash.size() != 1) {
				return false;
			}
			hash.put(8, 'm');
			if (!hash.containsKey(8)) {
				return false;
			}
			if (hash.size() != 2) {
				return false;
			}
			hash.put(6, '!');
			if (!hash.containsKey(6)) {
				return false;
			}
			if (hash.size() != 3) {
				return false;
			}
			hash.remove(6);
			if (hash.containsKey(6)) {
				return false;
			}
			if (hash.size() != 2) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * tests functionality of resizing and rehashing hashtables when capacity > 70%
	 * 
	 * @return true if tests pass, false if tests fail
	 */
	public static boolean test5() { 
		try {
			HashtableMap<Integer, String> hash = new HashtableMap<Integer, String>(2);
			hash.put(1, "one");
			if (!hash.put(2, "two")) {
				return false;
			}
			if (!hash.get(2).equals("two")) {
				return false;
			}
			if (!hash.put(3, "three")) {
				return false;
			}
			if (!hash.get(2).equals("two") || !hash.get(3).equals("three")) {
				return false;
			}
			if (!hash.put(4, "four")) {
				return false;
			}
			if (!hash.put(5, "five")) {
				return false;
			}
			if (!hash.put(6, "six")) {
				return false;
			}
			if (!hash.get(1).equals("one") || !hash.get(5).equals("five")) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test1());
		System.out.println(test2());
		System.out.println(test3());
		System.out.println(test4());
		System.out.println(test5());
	}
}

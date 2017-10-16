/**
 * Consistent Hashing Implementation
 */
package edu.mandeep.practice;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author mandeep
 *
 */
public class ConsistentHashing {
	private static int MAX_REPLICA = 10;
	private SortedMap<BigInteger, String> hash = new TreeMap<>();
	
	public void put(String node) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		BigInteger key = hash(node);
		hash.put(key, node);
		
		for(int i = 0; i < MAX_REPLICA; i++){
			key = hash(node+":"+i);
			hash.put(key, node);
		}
	}
	
	private String get(String entry) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		assert !hash.isEmpty() : "Handle the error properly";
		
		BigInteger key = hash(entry);
		if(!hash.containsKey(key)){
			SortedMap<BigInteger, String> tailMap = hash.tailMap(key);
			key = tailMap.isEmpty() ? hash.firstKey() : tailMap.firstKey();
		}
		
		return hash.get(key);
	}

	/**
	 * @param node
	 * @return
	 */
	private BigInteger hash(String node) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] checksum = md5.digest(node.getBytes("UTF-8"));
		return new BigInteger(1, checksum);
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ConsistentHashing ch = new ConsistentHashing();
		
		for(char c = 'A'; c <= 'Z'; c++)
			ch.put(String.valueOf(c));
		
		for(int i = 0; i < 100; i++)
			System.out.println(ch.get("user-id-" + i + "-data"));
	}

}
/**
 * Calculate cosine similarity of documents
 */
package edu.mandeep.practice.tfidf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author mandeep
 *
 */
public class CosSimilarity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String t1 = "He is the hero Gotham deserves";
		String t2 = "but not the one it needs right now";
		
		System.out.println(cosineSimilarity(t1, t2));
	}

	public static Map<String, Integer> getTermFrequency(String[] terms){
		Map<String, Integer> termFrequencyMap = new HashMap<>();
		
		for(String term : terms){
			Integer n = termFrequencyMap.get(term);
			n = (n == null) ? 1 : ++n;
			termFrequencyMap.put(term, n);
		}
		
		return termFrequencyMap;
	}

	public static double cosineSimilarity(String t1, String t2){
		Map<String, Integer> a = getTermFrequency(t1.split("\\W+"));
		Map<String, Integer> b = getTermFrequency(t2.split("\\W+"));
		
		HashSet<String> intersection = new HashSet<>(a.keySet());
		intersection.retainAll(b.keySet());
		
		double dotProduct = 0, magA = 0, magB = 0;
		
		for(String item: intersection){
			dotProduct += a.get(item) * b.get(item);
		}
		
		for(String k : a.keySet())
			magA += Math.pow(a.get(k), 2);
		
		for(String k : b.keySet())
			magB += Math.pow(b.get(k), 2);
		
		return dotProduct/ Math.sqrt(magA * magB);
		
	}
}
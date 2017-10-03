/**
 * 
 */
package edu.mandeep.interviewprep.tfidf;

import java.util.List;

/**
 * @author mandeep
 *
 */
public class TfIdf {

	/**
	 * @param totalterms
	 * @param terms
	 * @return
	 */
	public double tfCalculator(String[] totalterms, String termToCheck) {
        double count = 0;  //to count the overall occurrence of the term termToCheck
        for (String s : totalterms) {
            if (s.equalsIgnoreCase(termToCheck)) {
                count++;
            }
        }
       // System.out.println(count / totalterms.length);
        return count / totalterms.length ;
    }

	/**
	 * @param termsArray
	 * @param terms
	 * @return
	 */
	public double idfCalculator(List<String[]> allTerms, String termToCheck) {
        double count = 0;
        for (String[] ss : allTerms) {
            for (String s : ss) {
                if (s.equalsIgnoreCase(termToCheck)) {
                    count++;
                    break;
                }
            }
        }
        return 1 + Math.log(allTerms.size() / count);
    }

}
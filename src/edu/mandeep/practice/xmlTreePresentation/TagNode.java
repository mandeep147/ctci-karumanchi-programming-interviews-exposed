/**
 * 
 */
package edu.mandeep.practice.xmlTreePresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class TagNode extends DomTree {
	List<DomTree> children = new ArrayList<>();
	String start, end;
	
	public List<DomTree> getChildren() {
		return children;
	}
	
	public void setChildren(List<DomTree> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return start + children.toString() + end;
	}
	
}
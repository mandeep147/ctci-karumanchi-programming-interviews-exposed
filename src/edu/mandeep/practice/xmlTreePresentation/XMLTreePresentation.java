/**
 * https://discuss.leetcode.com/topic/52519/xml-tree-presentation
 */
package edu.mandeep.practice.xmlTreePresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.mandeep.ctci.stacksAndQueues.Stack;

/**
 * @author mandeep
 *
 */
public class XMLTreePresentation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> input = new ArrayList<>(Arrays.asList("open,story", "open,id", "inner,1234", "close,id",
				"open,snaps", "open,snap", "close,snap", "open,snap", "close,snap", "open,snap", "close,snap",
				"open,snap", "close,snap", "close,snaps", "close,story"));
		
		DomTree dom = parse(input);
		print(dom);
	}
	
	public static DomTree parse(List<String> input){
		Stack<TagNode> stack = new Stack<>();
		DomTree last = null;
		
		for(String parts: input){
			String[] part = parts.split(",");
			if(part[0].equals("open")){
				TagNode tag = new TagNode();
				tag.start = "<" + part[1] + ">";
				if(!stack.isEmpty())
					stack.peek().children.add(tag);
				stack.push(tag);
			}else if(part[0].equals("close")){
				if(!stack.isEmpty()){
					TagNode tag = stack.pop();
					tag.end = "</" + part[1] +">";
					last = tag;
				}
			}else{
				ContentNode content = new ContentNode();
				content.content = part[1];
				stack.peek().children.add(content);
			}
		}
		
		return last;
	}
	
	private static void print(DomTree dom){
		if(dom instanceof TagNode){
			System.out.println(((TagNode) dom).start);
			for(DomTree tag : ((TagNode) dom).children)
				print(tag);
			System.out.println(((TagNode) dom).end);
		}else
			System.out.println(((ContentNode) dom).content);
	}

}
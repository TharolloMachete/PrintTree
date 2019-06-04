package PrintTree;

import java.util.ArrayList;

class Node {
	int id;
	int parentID;
	String label;
	Node(int _id ,String _label ,int _parentID){
		this.id = _id;
		this.parentID = _parentID;
		this.label = _label;
	}
}

public class PrintTree {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ArrayList<Node> nodes = new ArrayList<Node>();
	        
	        Node nodeB = new Node(123, "NodeB", 7000);
	        Node nodeH = new Node(124, "NodeH", 9);
	        Node nodeA = new Node(7000,"NodeA", 0);
	        Node nodeC = new Node(9,   "NodeC", 123);
	        Node nodeF = new Node(3,   "NodeF",  0);
	        Node nodeE = new Node(25,  "NodeE", 7000);
	        Node nodeD = new Node(2,   "NodeD", 7000);
	        Node nodeG = new Node(10,  "NodeG",  3);

		    nodes.add(nodeB);
	        nodes.add(nodeH);
		    nodes.add(nodeA);
		    nodes.add(nodeC);
		    nodes.add(nodeF);
		    nodes.add(nodeE);
		    nodes.add(nodeD);
		    nodes.add(nodeG);
	        
		    printTree(nodes);
		}

		 static void printTree(ArrayList< Node > nodes) {
			    //loop through the list of nodes
			    for (int i = 0;i < nodes.size(); i++) {
			      //check if the Node is the parent
			      if (nodes.get(i).parentID == 0) {
			        //call a method to print trees
			        printATree(nodes, nodes.get(i), 0);
			      }//end if condition
			    }//end for loop
			  }

			  private static void printATree(ArrayList<Node> nodes , Node node, int level){
			    //childs to hold  List of Childrens
			    ArrayList<Node> childs = nodeHasChildren(nodes, node.id);
			    String tab = "";
			    //loop through levels to determine what position to print a Node
			    for (int i =0;i < level; i++) {
			      tab += "\t";
			    }//end for loop
			    //print a Node label
			    System.out.println(tab + node.label);
			    //check what level we should be
			    if (nodes.size() > 0) {
			      level++;
			    }//end if condition
			    //loop through the list of childs
			    for (Node child :  childs) {
			      //perform recursion to detemine if Node has childrens
			      printATree(nodes, child, level);
			    }//end for loop
			  }
			  private static ArrayList<Node> nodeHasChildren(ArrayList<Node> nodes, int nodeId) {
			    //results to hold  List of Childrens
			    ArrayList<Node> results = new ArrayList<Node>();
			    //loop through the nodes to identify the child
			    for (Node node : nodes) {
			      //check if the child belongs to this Node
			      if (node.parentID == nodeId) {
			        results.add(node);
			      }//end if condition
			    }//end for loop
			    //returns ArrayList of child Nodes
			    return results;
			  }
	}
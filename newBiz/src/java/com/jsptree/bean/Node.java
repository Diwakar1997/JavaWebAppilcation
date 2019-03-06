
package com.jsptree.bean;

import java.util.List;
public class Node {
	// Current node id
	private String nodeId;
	// Current node name
	private String nodefName;
        private String nodemName;
        private String nodelName;
	// Status of node ( checked or not checked )
	private int isSelected;
	// Each node has list of children
	private List<Node> children;	
	// This will hold exceptions if occurred.
	private String errorDescription;
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodefName() {
		return nodefName;
	}

	public void setNodefName(String nodefName) {
		this.nodefName = nodefName;
	}
        
        public String getNodelName() {
		return nodelName;
	}

	public void setNodelName(String nodelName) {
		this.nodelName = nodelName;
	}
        
        public String getNodemName() {
		return nodemName;
	}

	public void setNodemName(String nodemName) {
		this.nodemName = nodemName;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}



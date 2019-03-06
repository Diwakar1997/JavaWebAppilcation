/*
    Copyright (C) 2012  saminda konkaduwa

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

	Also add information on how to contact you by electronic and paper mail.
 */

package com.jsptree.tags;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import com.jsptree.bean.Node;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.exception.ParseErrorException;

import com.javawebtutor.model.User;

/**
 * @author Saminda Konkaduwa, skonkaduwa@gmail.com
 * @version 1.0
 * @since 10/April/2012
 * 
 *        This Tag class will read parent child relationships from database and
 *        build tree structure. This Tag class will push the tree structure to
 *        an Apache velocity template.
 */
public class TreeTag extends SimpleTagSupport{
	// Root node. This can contain list of children
	private Node root = new Node();
        User user=new User();
	// List of children of root node
	private List<Node> jspTree = new ArrayList<Node>();
        String name;

     public void setName(String name) {
        this.name = name;
     }
        
        
        
        
	// This method will invoke when tree structure called from JSP page
	public void doTag() throws IOException, JspException {
		Properties properties = new Properties();
		try {
			// Loading properties.

			InputStream propertyInputStream = getClass().getResourceAsStream("config.properties");
			properties.load(propertyInputStream);
			// Properties to load Apache Velocity Template
			properties.setProperty(properties.getProperty("key.resource.loader"), properties.getProperty("value.resource.loader.location"));
			properties.setProperty(properties.getProperty("key.class.resource.loader"), properties.getProperty("value.class.resource.loader"));
			propertyInputStream.close();

			// Getting the JDBC connectivity
			Class.forName(properties.getProperty("jdbc.driver"));
			Connection conn = DriverManager.getConnection(properties.getProperty("jdbc.connection.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));

			// Initializing the Apache Velocity engine
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.init(properties);
			// Loading the Apache Velocity template
			Template velocityTemplate = velocityEngine.getTemplate(properties.getProperty("apache.velocity.template.name"));
			VelocityContext context = new VelocityContext();

			if (conn != null) {
				List<String> parentLevel = new ArrayList<String>();
				PreparedStatement pstmtUpperLevel = conn.prepareStatement("SELECT userId,firstName,middleName,lastName FROM USER_TABLE WHERE sponseId='" + name + "'");
				ResultSet rsUpperLevel = pstmtUpperLevel.executeQuery();
				Node parentNode = new Node();
				// Read top most parent list
				while (rsUpperLevel.next()) {
					parentLevel.add(rsUpperLevel.getString("userId"));
					
                                        parentNode.setNodefName(rsUpperLevel.getString("firstName"));
                                        parentNode.setNodemName(rsUpperLevel.getString("middleName"));
                                        parentNode.setNodelName(rsUpperLevel.getString("lastName"));
					
				}
				rsUpperLevel.close();
				pstmtUpperLevel.close();
				
				if (parentLevel.isEmpty()) {
					System.out.println("\n]\n\nERROR :Empty database table found OR invalid root node configuration found. There should be one root node in databsae table. Please run given SQL file.");
					throw new Exception(":Empty database table found OR invalid root node configuration found. There should be one root node in databsae table. Please run given SQL file.");
				}

				// Recursive call of child node of current parent node
				readNextGroundLevel(parentLevel, parentNode, conn);
				conn.close();
			}
			root.setChildren(jspTree);
			root.setErrorDescription("");
			context.put("node", root);
			StringWriter writer = new StringWriter();
			velocityTemplate.merge(context, writer);
			JspWriter out = getJspContext().getOut();
			System.out.println(writer.toString());
			out.print(writer.toString());
		} catch (Exception e) {
                    try {
                        // Initializing the Apache Velocity engine
                        VelocityEngine velocityEngine = new VelocityEngine();
                        try {
                            velocityEngine.init(properties);
                        } catch (Exception ex) {
                            Logger.getLogger(TreeTag.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        // Loading the Apache Velocity template
                        Template velocityTemplate = velocityEngine.getTemplate(properties.getProperty("apache.velocity.template.name"));
                        VelocityContext context = new VelocityContext();
                        root.setChildren(jspTree);
                        root.setErrorDescription(e.getMessage());
                        context.put("node", root);
                        StringWriter writer = new StringWriter();
                        velocityTemplate.merge(context, writer);
                        JspWriter out = getJspContext().getOut();
                        System.out.println(writer.toString());
                        out.print(writer.toString());
                        e.printStackTrace();
                    } catch (ParseErrorException ex) {
                        Logger.getLogger(TreeTag.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(TreeTag.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}

	}

	// This method reads children of current node.
	private void readNextGroundLevel(List<String> parentList, Node parent, final Connection conn) throws SQLException {

		for (String upperLevel : parentList) {
			// Connection will not close this level as it passed from caller of
			// this method.
			if (conn != null) {
				PreparedStatement pstmtUpperLevel = conn.prepareStatement("SELECT userId,firstName,middleName,lastName FROM USER_TABLE WHERE sponseId='" + upperLevel + "'");
				ResultSet rsUpperLevel = pstmtUpperLevel.executeQuery();
				while (rsUpperLevel.next()) {
					String childId = rsUpperLevel.getString("userId");
					// This node name will be used as checked box name in the
					// HTML page
					String nodefName = rsUpperLevel.getString("firstName");
                                        String nodemName = rsUpperLevel.getString("middleName");
                                        String nodelName = rsUpperLevel.getString("lastName");
					// Reading status of node
				
					// Set the top most root element of the tree. Only single
					// time happened.
					if (jspTree.isEmpty()) {
						Node root = new Node();
						root.setNodeId(upperLevel);
						root.setNodefName(parent.getNodefName());
                                                root.setNodemName(parent.getNodemName());
                                                root.setNodelName(parent.getNodelName());
						root.setIsSelected(parent.getIsSelected());
						jspTree.add(root);
						parent = root;
					}
					// Create node for current level
					Node node = new Node();
					node.setNodefName(nodefName);
                                        node.setNodemName(nodemName);
                                        node.setNodelName(nodelName);
					node.setNodeId(childId);
					// Current node will add to its parent node if it's parent
					// already has children
					if (parent.getChildren() != null) {
						parent.getChildren().add(node);
					} else {
						// Current node will add to its parent node if it's
						// parent already has no children
						List<Node> childList = new ArrayList<Node>();
						childList.add(node);
						parent.setChildren(childList);
					}

					// Add current child to next iteration
					List<String> parentLevel = new ArrayList<String>();
					parentLevel.add(childId);

					// Recursive call read children list until leaf nodes found.
					// Leaf nodes will not contains children.
					if (!parentLevel.isEmpty()) {
						readNextGroundLevel(parentLevel, node, conn);
					}
				}
				// Only close ResultSet and PreparedStatement. Connection is
				// passed from doTag method.
				rsUpperLevel.close();
				pstmtUpperLevel.close();
			}
		}
	}

}
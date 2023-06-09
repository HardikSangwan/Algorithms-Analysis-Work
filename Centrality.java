package org.gephi.toolkit.demos;

import java.io.*;
import java.util.*;
import java.lang.*;



import org.gephi.graph.api.*;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.openide.util.Lookup;

import org.gephi.io.importer.api.*;
import org.gephi.io.processor.plugin.DefaultProcessor;
import org.gephi.io.importer.spi .*;

import org.gephi.statistics.plugin.*;
import org.gephi.data.attributes.api.*;
import org.gephi.io.exporter.api.*;
import org.gephi.statistics.plugin.GraphDistance;

import org.gephi.statistics.plugin.EigenvectorCentrality;

public class Centrality{
	
	public Centrality(){
		
	}
	
	public static void main(String args[]){
		   	
    	//Gephi initialization
        ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
        pc.newProject();
        Workspace workspace = pc.getCurrentWorkspace();
        
        GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();
		AttributeModel attributeModel = Lookup.getDefault().lookup(AttributeController.class).getModel();
		
		//Get controllers and models
        ImportController importController = Lookup.getDefault().lookup(ImportController.class);
      
      	//adding a new attribute - criticality = betweenness/degree
		AttributeTable nodeTable = attributeModel.getNodeTable();
		
		AttributeColumn criticality = nodeTable.addColumn("Criticality",AttributeType.DOUBLE);      

        //Import file
        Container container;
        try {
            File file = new File("centrality_example.gml");
            container = importController.importFile(file);
            container.getLoader().setEdgeDefault(EdgeDefault.UNDIRECTED);   //Force UNDIRECTED
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        //Append imported data to GraphAPI
        importController.process(container, new DefaultProcessor(), workspace);

 
		//See if graph is well imported
		UndirectedGraph graph = graphModel.getUndirectedGraph();
		System.out.println("Nodes: " + graph.getNodeCount());
		System.out.println("Edges: " + graph.getEdgeCount());
		
		//Create an object to calculate the EigenvectorCentrality
		EigenvectorCentrality eigenvectorCentrality = new EigenvectorCentrality();
		
		//calculate the eigenvector centrality
		eigenvectorCentrality.execute(graphModel,attributeModel);
		
		//calculate the betweeness and closeness centrality
		GraphDistance graphDistance = new GraphDistance();
		
		graphDistance.execute(graphModel,attributeModel);
		
		for (Node node : graph.getNodes()){
			
			double betweenness = (Double)node.getAttributes().getValue("Betweenness Centrality");
			
			double degree = graph.getDegree(node);
			
			node.getAttributes().setValue("Criticality", betweenness/degree);	
					
		}
		
		for (Node node : graph.getNodes()){
			
			System.out.println("Node "+node.getNodeData().getLabel());    		
			
			System.out.println("Betweennes centrality: "+ (Double)node.getAttributes().getValue("Betweenness Centrality"));
			
			System.out.println("Degree centrality: "+ graph.getDegree(node));
			
			System.out.println("Criticality: "+ (Double)node.getAttributes().getValue("Criticality"));
			
			System.out.println("Closeness centrality: "+ (Double)node.getAttributes().getValue("Closeness Centrality"));
			
			System.out.println("Eigenvector centrality: "+ (Double)node.getAttributes().getValue("Eigenvector Centrality")+"\n");
			
				
		
		}
		
		//export the graph
		exportGraph(graph, "graph");
			
		exportPDF("graph");
			
		    
	}
	
	 static void exportPDF(String fileName){
    	
    	ExportController ec = Lookup.getDefault().lookup(ExportController.class);
		
		try {
			
		   			
		   ec.exportFile(new File(fileName+".pdf"));
		} catch (IOException ex) {
		   ex.printStackTrace();
		   return;
		}
	
	}
	
	 
	static void exportGraph(Graph graph, String filename){
    	
    	 try{
        
        	ExportController ec = Lookup.getDefault().lookup(ExportController.class);
			ec.exportFile(new File(filename+".gexf"));
			
        }catch(IOException ex){
        	
        }
    }
	
	

	
	

	
	
	
	
}
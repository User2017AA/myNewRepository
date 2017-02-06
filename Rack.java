public class Rack{

	
	/*

		Stores the Node objects into an array
	*/

	//fixed set of size on the rack sizes is assumed to be the capacity of max 8 Nodes
	private Node [] arrayOfNodes;
	private int nrNodesPerRack; // 
	private int index; // teller hvor i array du har neste ledig plass


	
	Rack(int nrNodesPerRack){
		this.nrNodesPerRack=nrNodesPerRack;
		arrayOfNodes = new Node[nrNodesPerRack];
		index=0;
		

	}
	



	public boolean erListenFull(){
		
		if(index<nrNodesPerRack){
			return false; // list has still room for another node

		}

		return true; //list is full

		

	}

	public void settNode(Node node){
		arrayOfNodes[index]= node;
		index++;

	}


	public double getMaxYtelseAvRack(){
		double totalMaxYtelse=0;

		for(int i =0; i<index; i++){
			totalMaxYtelse = totalMaxYtelse + arrayOfNodes[i].getTotalFlops();
		}
		return totalMaxYtelse;

	}	


	public int getMinMinne(int minMinne){
		int counter=0;

		for(int i =0; i<index; i++){
			if(arrayOfNodes[i].getMinne()>=minMinne){
				counter++;
			}
		}
		return counter;

	}	
	
}
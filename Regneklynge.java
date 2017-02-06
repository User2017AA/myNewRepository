import java.util.ArrayList; 



public class Regneklynge{
	private ArrayList<Rack> listOfRacks;  //newer version of java do not have to say rack in last brackets
	private Node node; 
	private int nrNodesPerRack;
	
	

	Regneklynge(int nrNodesPerRack){
		
		this.nrNodesPerRack = nrNodesPerRack;
		listOfRacks = new ArrayList<>();
		Rack rack = new Rack(nrNodesPerRack);
		listOfRacks.add(rack);
	}

	public static void main(String [] args){

		
			//start  with initial size of each rack
		Regneklynge abel = new Regneklynge(12);

			//1st batch of racks
		for(int y = 0; y<650; y++){
			Node node= new Node(64, 2, 2.6e9, 8, 8);
			abel.settInNode(node);
		}

			//2nd batch of racks
		for(int z=0; z<16; z++){
			Node node= new Node(1024, 2, 2.3e9, 8, 8);
			abel.settInNode(node);

		}

		double maxytelse= abel.totalFlopsIRegneklynge();

		System.out.println(" Samlet FLOPS : "+ maxytelse);

		abel.noderLikOgOverMinne(32);
		
		abel.noderLikOgOverMinne(64);
		
		abel.noderLikOgOverMinne(128);

		System.out.println("Antall rack : "+ abel.listOfRacks.size());


	}


		/*iterates through  list of racks to fin all nodes that are equal or above minimum
		takes a memory size and returns how many nodes are equal or above this size
		*/	
	public void noderLikOgOverMinne(int minne){
		int totalNoderAvStorrelse= 0;
		for(int i =0; i<listOfRacks.size();i++){
			totalNoderAvStorrelse += listOfRacks.get(i).getMinMinne(minne);

		}
		
		System.out.printf(" Noder med %d GB : " + totalNoderAvStorrelse + "%n", minne);

	}

		//places nodes in existing rack until full and if full it creates new racks
	public void settInNode(Node node){
		boolean needNewRack =false;

		//if the rack has available space place the node
		//could have just checked the last element in the rack to save itterations
		for(int i =0; i<listOfRacks.size(); i++){

			if(listOfRacks.get(i).erListenFull()==false){

				listOfRacks.get(i).settNode(node);
				return;

			}else{
				needNewRack=true; 
			}

		}

		if(needNewRack==true){
			Rack rack = new Rack(nrNodesPerRack);
			
			int rackNr= listOfRacks.size();
			//legger til listen av racks
			listOfRacks.add(rack);
			//int rackNr= listOfRacks.size()-1;
			listOfRacks.get(rackNr).settNode(node);
		}
		

	}
	
	//calculates the maximum capacity
	public double totalFlopsIRegneklynge(){
		double maxkapasitetAvRack=0.0;
		
		for(int i =0; i<listOfRacks.size(); i++){
			maxkapasitetAvRack += listOfRacks.get(i).getMaxYtelseAvRack();
			
		}
		return maxkapasitetAvRack;

	}


	

	
}
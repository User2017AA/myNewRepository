
import java.util.ArrayList; 
//code comment to repository
public class Node{

	private int minne;
	private double totalFlops;
	private int nrKjerner;
	private ArrayList<Prosessor> listOfProsessor;




	Node(int minne, int nrKjerner, double klHastighet, int pros_1, int pros_2){
		this.minne = minne;
		this.nrKjerner=nrKjerner;

		listOfProsessor = new ArrayList<>();

		Prosessor prosessor1 = new Prosessor(pros_1, klHastighet);
		listOfProsessor.add(prosessor1);

		Prosessor prosessor2 = new Prosessor(pros_2, klHastighet);
		listOfProsessor.add(prosessor2);


	}

	Node(int minne, int nrKjerner, double klHastighet, int pros_1 ){
		this.minne = minne;
		this.nrKjerner=nrKjerner;
		listOfProsessor = new ArrayList<>();
		Prosessor prosessor = new Prosessor(pros_1, klHastighet);
		listOfProsessor.add(prosessor);
	}
	

	public int getMinne(){
		return minne; 
	}
	
	// totalFlops() method, just like to be consistent with naming comvention
	public double getTotalFlops(){

		for(int i=0; i<listOfProsessor.size(); i++){
			totalFlops = totalFlops + listOfProsessor.get(i).getProsessorFlops();
		}
		return totalFlops; 
	}


}

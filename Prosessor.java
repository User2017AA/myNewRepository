public class Prosessor{

	private int antKjerner;
	private double klokkeHastHz;
	private static final int F_P_KLOKKESYKEL = 8;
	private double flops;


	Prosessor(int antKjerner, double klokkeHastHz){
		this.antKjerner = antKjerner;
		this.klokkeHastHz = klokkeHastHz;

		flops = (antKjerner * klokkeHastHz * F_P_KLOKKESYKEL);
		

	}

	public int getAntKjerner(){
		return antKjerner;
	}

	public double getKlokkeHastHz(){
		return klokkeHastHz;
	}

	public double getProsessorFlops(){
		return flops;
	}





}
public class InvalidFractionException extends RuntimeException{

	public InvalidFractionException(){
		this("Invalid Fraction");
	}

	public InvalidFractionException(String m){
		super(m);
	}
}
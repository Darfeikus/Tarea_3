public class InvalidFractionOperationException extends RuntimeException{

	public InvalidFractionOperationException(){
		this("Invalid Fraction");
	}

	public InvalidFractionOperationException(String m){
		super(m);
	}
}
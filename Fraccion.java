/*
	Programa: Clase que crea objetos de tipo Fraccion
	Antonio Diaz Flores
	A01329256
	Oscar Barbosa Aquino
	A01329173
	Fecha: 22/02/18
*/

class Fraccion implements Comparable<Fraccion>{
	private int num;
	private int den;

	/*
		Constructor de la instancia de Fraccion, con dos int de entrada como numerador y denominador
	*/
	Fraccion (int num, int den) {
		this.num = num;
		this.den = den;
		if (den==0)
			throw new InvalidFractionException();
	}

	/*
		Metodo que suma dos fracciones, recibe una Fraccion como entrada y regresa otra
	*/
	Fraccion suma (Fraccion otra) {
		otra = new Fraccion (this.num * otra.den + this.den * otra.num, this.den * otra.den);
		otra.simplificar();
		return otra;
	}

	/*
		Metodo que multiplica dos fracciones, recibe una Fraccion como entrada y regresa otra
	*/
	Fraccion prod (Fraccion otra) {
		otra = new Fraccion (this.num * otra.num, this.den * otra.den);
		otra.simplificar();
		return otra;
	}

	/*
		Metodo que divide dos fracciones, recibe una Fraccion como entrada y regresa otra
	*/
	Fraccion div (Fraccion otra) {
		try{
			otra = new Fraccion (this.den * otra.num,this.num * otra.den);
			otra.simplificar();
			return otra;
		}
		catch(InvalidFractionException e){
			throw new InvalidFractionOperationException("Division entre 0");
		}
		
	}

	/*
		Metodo que simplifica la Fraccion, no recibe nada y no regresa nada
	*/
	void simplificar () {
		if (this.num > this.den)
			for (int i = this.den; i>1; i--) {
				if (num % i == 0 && den % i == 0) {
					num /= i;
					den /= i;
					i = 1;
				}
			}
		else
			for (int i = this.num; i>1; i--) {
				if (den % i == 0 && num % i == 0) {
					den /= i;
					num /= i;
					i = 1;
				}
			}
	}

	/*
		Metodo que define como se imprime una instancia de Fraccion
	*/
	public String toString() {
		return num + " / " + den;
	}

	/*
		Metodo que implementa toString, pero con un parámetro que define los leading spaces en la salida.
	*/
	String toString(int n) {
		return String.format("%" + n + "d / %" + n +"d", num, den);
	}

	/*
		Metodo que verifica la longitud maxima entre el denominador y el numerador de la Fraccion, no recibe nada y regresa un int
	*/
	int maxLength () {
		int len = 0;
		if (String.valueOf(num).length() > len)
			len = String.valueOf(num).length();
		if (String.valueOf(den).length() > len)
			len = String.valueOf(den).length();
		return len;
	}

	int compareTo(Fraccion other){
		Double one = num/den;
		Double two = other.num/other.den;
		if (one>two) 
		 	return 1;
		if (two>one)
			return -1;
		else
			return 0;
	}

}
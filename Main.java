import java.util.Scanner;

class Main{
	
	//method that sorts an array of fractions with selection sort

	static Fraccion[] selectionSort(Fraccion[] fractions){
		for(int j = 0; j<fractions.length;j++){
			int minimumIndex = j;
			int currentInd = j;
			for (int i = j;i<fractions.length-1;i++)
				if (fractions[currentInd].compareTo(fractions[i+1])==-1)
					minimumIndex=currentInd;
				else{
					minimumIndex=i+1;
					currentInd=i+1;
				}
			Fraccion temp = fractions[j];
			fractions[j]=fractions[minimumIndex];
			fractions[minimumIndex]=temp;
		}
		return fractions;
	}

	//method that sorts an array of fractions with insertion sort

	static Fraccion[] insertionSort(Fraccion[] fractions){		
		for(int i = 1;i<fractions.length;i++){
			for(int j = i;j>0;j--)
				if (fractions[j].compareTo(fractions[j-1])==-1){
					Fraccion temp = fractions[j-1];
					fractions[j-1]=fractions[j];
					fractions[j]=temp;
				}
		}
		return fractions;
	}

	//method that sorts an array of fractions with bubble sort

	static Fraccion[] bubbleSort(Fraccion[] fractions){
		for(int j = 0; j<fractions.length-1;j++){
			int maximumIndex = 0;
			int currentBubble = 0;
			for (int i = 0;i<fractions.length-1;i++){
				if (fractions[currentBubble].compareTo(fractions[i+1])==1){
					Fraccion temp = fractions[i+1];
					fractions[i+1]=fractions[currentBubble];
					fractions[currentBubble]=temp;
					maximumIndex=i+1;
					i++;
				}
				else{
					maximumIndex=i+1;
					currentBubble++;
				}
			}
		}
		return fractions;
	}

	//method that sorts an array of fractions with merge sort

	static Fraccion[] mergeSort(Fraccion[] fractions){
		if (fractions.length==1)
			return fractions;
		else{
			Fraccion[] firstHalf = new Fraccion[fractions.length/2];
			Fraccion[] secondHalf = new Fraccion[fractions.length-fractions.length/2];
			for (int i = 0;i<firstHalf.length;i++)
				firstHalf[i]=fractions[i];
			for (int i = 0;i<secondHalf.length;i++)
				secondHalf[i]=fractions[firstHalf.length+i];
			firstHalf=mergeSort(firstHalf);
			secondHalf=mergeSort(secondHalf);
			int index = 0;
			int indexSecondHalf = 0;
			for (int i = 0;i<firstHalf.length;i++) {
				for (int j = indexSecondHalf;j<secondHalf.length;j++)
					if (firstHalf[i].compareTo(secondHalf[j])==-1) {
						fractions[index]=firstHalf[i];
						index++;
						j=secondHalf.length;
					}
					else{
						fractions[index]=secondHalf[j];
						indexSecondHalf++;
						index++;
					}
				if (indexSecondHalf!=secondHalf.length && i==firstHalf.length-1){
					for (int j = indexSecondHalf;j<secondHalf.length; j++) {
						fractions[index]=secondHalf[j];
						index++;
					}
				}
				if (indexSecondHalf==secondHalf.length && i<firstHalf.length){
					for (int j = i;j<firstHalf.length; j++) {
						fractions[index]=firstHalf[j];
						index++;
					}
					i=firstHalf.length;
				}
			}			
		}
		return fractions;
	}

	static Fraccion[] quickSort(Fraccion[] fractions){
		int index = 0;
		int minimumIndex = 0;
		while(index<fractions.length-1){
			for (int i = index;i<fractions.length-1;i++) {
				if (fractions[i].compareTo(fractions[i+1])==-1)
					minimumIndex=i;
				else
					minimumIndex=i+1;
			}
			Fraccion temp = fractions[index];
			fractions[index]=fractions[minimumIndex];
			fractions[minimumIndex]=temp;
			index++;
		}
		return fractions;
	}

	static void printArray(Fraccion[] fractions){
		for (Fraccion x: fractions)
			System.out.println(x);
	}

	static void printArrayline(Fraccion[] fractions){
		System.out.print("[");
		for (Fraccion x: fractions)
			System.out.print(x + " ][ ");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noFractions = s.nextInt();
		Fraccion[] myFractions = new Fraccion[noFractions];
		for(int i = 0; i<noFractions; i++)
			myFractions[i] = new Fraccion(s.nextInt(),s.nextInt());
		System.out.println("selection sort:");
		printArray(selectionSort(myFractions));
		System.out.println("insertion sort:");
		printArray(insertionSort(myFractions));
		System.out.println("bubble sort:");
		printArray(bubbleSort(myFractions));
		System.out.println("merge sort:");
		printArray(mergeSort(myFractions));
		//System.out.println("quick sort:");
		//printArray(quickSort(myFractions));
	}

}
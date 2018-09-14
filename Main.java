import java.util.Scanner;

class Main{
	
	//method that sorts an array of fractions with selection sort

	static Fraccion[] selectionSort(Fraccion[] fractions){
		for(int j = 0; j<fractions.length;j++){
			int minimumIndex = j;
			for (int i = j;i<fractions.length-1;i++)
				if (fractions[minimumIndex].compareTo(fractions[i+1])==1)
					minimumIndex=i+1;
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
		for(int j = 0; j<fractions.length;j++){
			int currentBubble = 0;
			for (int i = 0;i<fractions.length-1;i++){
				if (fractions[currentBubble].compareTo(fractions[i+1])==1){
					Fraccion temp = fractions[i+1];
					fractions[i+1]=fractions[currentBubble];
					fractions[currentBubble]=temp;
					currentBubble++;
				}
				else{
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

	//method that sorts an array of fractions with quick sort

	static Fraccion[] quickSort(Fraccion[] fractions){
		int pivot = fractions.length-1;
		int max = 0;
		if (fractions.length<=1)
			return fractions;
		if (fractions.length==2){
			if (fractions[0].compareTo(fractions[1])==1) {
				Fraccion temp = fractions[1];
				fractions[1]=fractions[0];
				fractions[0]=temp;
			}
			return fractions;
		} 			
		else{
			for (int i =0;i<pivot;i++){
				if (fractions[i].compareTo(fractions[pivot])==-1){
					Fraccion temp = fractions[max];
					fractions[max]=fractions[i];
					fractions[i]=temp;
					max++;
				}
				if (i==pivot-1) {
					Fraccion temp = fractions[max];
					fractions[max]=fractions[pivot];
					fractions[pivot]=temp;
				}
			}
			Fraccion[] firstHalf = new Fraccion[max];
			Fraccion[] secondHalf = new Fraccion[fractions.length-max-1];
			for (int i = 0;i<max;i++)
				firstHalf[i]=fractions[i];
			for (int i = 0;i<secondHalf.length;i++)
				secondHalf[i]=fractions[max+1+i];
			firstHalf = quickSort(firstHalf);
			secondHalf = quickSort(secondHalf);
			for (int i = 0;i<max;i++)
				fractions[i]=firstHalf[i];
			for (int i = 0;i<secondHalf.length;i++)
				fractions[max+1+i]=secondHalf[i];
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
		//System.out.println("selection sort:");
		//printArray(selectionSort(myFractions));
		//System.out.println("insertion sort:");
		//printArray(insertionSort(myFractions));
		//System.out.println("bubble sort:");
		//printArray(bubbleSort(myFractions));
		System.out.println("merge sort:");
		printArray(mergeSort(myFractions));
		//System.out.println("quick sort:");
		//printArray(quickSort(myFractions));
	}

}
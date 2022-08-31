/*CAMPANA DE GAUSS
Descripción: se calculan valores de y correspondientes a los valores de x generados aleatoriamente, con fórmula para curva gaussiana
Desarrollador: Julio César Cárdenas Alvarado
Institución: CUCEA MTI
Realización: 16/10/2021*/

import java.util.Scanner;

public class GaussBell {
	public static void main (String args []) {
		Scanner dataIn = new Scanner(System.in);
		float sum = 0;
		float media = 0;
		float temporal = 0;
		double standardDev = 0;
		boolean repeat = false;
		boolean repeatB = false;
		char option;
		
		System.out.println("Campana de Gauss\n"
						+ "\nSe genera un arreglo aleatorio de X con 50 datos con valores mayores que 40 y menores o iguales a\n"
						+ "300, con la fórmula de campana gaussiana se genera un segundo arreglo para los valores de Y\n");
		do {
			float dataX [] = new float [50];
			float dataY [] = new float [50];
			randomVector(dataX);
			sum = totalSum(dataX, sum);
			media = calcMedia(sum, dataX, media);
			standardDev = calcDev(dataX, media, standardDev);
			gaussBell(dataX, dataY, standardDev, media);
			printXY(dataX, dataY);
			
			do {
				System.out.println("¿Desea hacer un nuevo cálculo? s/n");
				option = dataIn.next().charAt(0);
				if (option == 's') {
					System.out.println();
					repeat = true;
					repeatB = false;
					break;
				}
				else if (option == 'n') {
					System.out.println("Programa terminado. ¡Hasta luego!");
					repeat = false;
					repeatB = false;
					break;
				}
				
				else {
					System.out.println("Opción incorrecta");
					repeatB = true;
					break;
				}
			}
			while (repeatB == true);
		}
		
		while (repeat == true);
	}
	
	public static void printVector(float data []) {
		System.out.print("Los datos ingresados son: ");
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
	}
	
	public static float totalSum (float data [], float sum) {
		sum = 0;
		
		for (int i = 0; i < data.length ; i++) {
			sum = sum + data[i];
		}
		
		return sum;
	}
	
	public static float calcMedia(float sum, float data[], float media) {
		media = sum / data.length;
		return media;
	}
	
	public static double calcDev(float data [], float media, double standardDev) {
		double sum = 0;
		float temporal = 0;
		
		for (int i = 0; i < data.length; i++) {
			temporal = data[i] - media;
			sum = sum + Math.pow(temporal, 2);
		}
		
		double temporal2 = sum / (data.length - 1);
		standardDev = Math.sqrt(temporal2);
		return standardDev;
	}
	
	public static void randomVector (float data[]) {
		for (int i = 0; i < data.length; i++) {
			data[i] = (float) (Math.random()*(300-40+1)+40);
		}
	}
	
	public static void gaussBell (float dataX [], float dataY [], double standardDev, float media) {
		for (int i = 0; i < dataX.length; i++) {
			dataY[i] = (float) Math.pow(((1/Math.sqrt(2*3.141592654)*standardDev) * 2.718281828), -(Math.pow((dataX[i] - media), 2)/(2*Math.pow(media, 2))));
		}
	}
	
	public static void printXY (float dataX[], float dataY[]) {
		System.out.println("Valores de función de campana gaussiana");
		for (int i = 0; i < dataX.length; i++) {
			System.out.println("Valor X" + (i+1) + ": " + dataX[i] + ", valor Y" + (i+1) + ": " + dataY[i]);
		}
		System.out.println();
	}
}

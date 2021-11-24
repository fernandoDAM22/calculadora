/*
 * Enunciado: Hacer una calculadora
 * Autor: Fernando Gil
 * Fecha:10/11/2021
 */
package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculadora {
	private static int operacionPrincipal; // para saber si hay que realizar operaciones aritmeticas o logicas
	private static int numero1; // primer numero de la operacion
	private static int numero2; // segundo numero de la operacion
	private static int respuesta; // aqui se guardan la respuesta del usuario cuando se pregunta si se quiere
									// repetir el programa
	public static int operacion; // aqui se guarda la operacion que se va a realizar
	public static boolean salir; // atributo bandera para poder salir de la ejecucion del programa o repetirlo
	private static boolean logico1 = false;
	private static boolean logico2 = false;
	public static int operacionLogica;

	public static void main(String[] args) throws NumberFormatException, IOException {
		do {
			operacionPrincipal();
			menuPrincipal();
			volverARepetir();// este metodo pregunta si quieres volver a repetir el programa

		} while (repetirPrograma(respuesta)); // con esto se puede repetir el programa

	}// cierre del main

//metodo para realizar la suma
	public static int suma(int numero1, int numero2) {
		return (numero1 + numero2);
	}

//metodo para realizar la resta
	public static int resta(int numero1, int numero2) {
		return (numero1 - numero2);
	}

//metodo para realizar la multiplicacion
	public static int multiplicacion(int numero1, int numero2) {
		return (numero1 * numero2);
	}

//metodo para realizar la division
	public static double division(int numero1, int numero2) {
		double resultadoDivision = 0;
		try {
			resultadoDivision = (double) (numero1 / numero2);
		} catch (ArithmeticException e) {
			System.out.println("Error");
		}
		return resultadoDivision;
	}

//metodo para recibir los valores de los numeros con los que vamos a operar
	public static void recibirValores() throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Escribe el primer numero");
		numero1 = Integer.parseInt(br.readLine());
		System.out.println("Escribe el segundo numero");
		numero2 = Integer.parseInt(br.readLine());
	}

//metodo para saber la operacion que se tiene que realizar
	public static void operacion() throws NumberFormatException, IOException {
		System.out.println("Introduce el numero de la operacion que deseas realizar");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		boolean error = true;

		while (error) {
			try {
				operacion = Integer.parseInt(br.readLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("Error, caracter desconocido");
			}
			catch(IOException io){
				System.out.println(io.getMessage());
			}
		}

	}

//metodo para controlar que no se pueda meter una operacion incorrecta
	public static boolean controlErroresOperacion(int operacion) {
		return (operacion < 1 || operacion > 4);
	}

//metodo para poder repetir el programa
	public static boolean repetirPrograma(int respuesta) {
		return (respuesta == 1);
	}

//metodo donde se encuentra el swich con las operaciones
	public static void calculadora() throws IOException {
		int resultado = 0;
		switch (operacion) {
		case 1:
			recibirValores();
			resultado = suma(numero1, numero2);
			break;

		case 2:
			recibirValores();
			resultado = resta(numero1, numero2);
			break;
		case 3:
			recibirValores();
			resultado = multiplicacion(numero1, numero2);
			break;
		case 4:
			recibirValores();
			resultado=division(numero1,numero2);
			System.out.println(resultado);

			break;
		default:
			System.out.println("El signo introducido no es valido");
			break;
		}
		System.out.println("El resultado es " + resultado);
	}

	// metodo para realizar las operaciones logicas
	public static void menuOperacionesLogicas() throws NumberFormatException, IOException {
		switch (operacionLogica) {
		case 1:
			System.out.println(AND());
			break;
		case 2:
			System.out.println(OR());
			break;
		case 3:
			System.out.println(NOT());
			break;
		case 4:
			System.out.println(AND1simbolo());
			break;
		case 5:
			System.out.println(OR1simbolo());
			break;
		case 6:
			System.out.println(XOR());
			break;
		}

	}

//metodo para realizar el menu principal para poder elegir entre operaciones aritmeticas colo logicas
	public static void operacionPrincipal() throws NumberFormatException, IOException {
		do {
			boolean error = true;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Introduce la operacion que deseas realizar");
			System.out.println("1------Operaciones aritmeticas");
			System.out.println("2------Operaciones logicas");
			while (error) {
				try {
					operacionPrincipal = Integer.parseInt(br.readLine());
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Error, caracter desconocido");
				}
				catch(IOException io) {
					System.out.println(io.getMessage());
				}
				if ((operacionPrincipal < 1 || operacionPrincipal > 2))
					;
				System.out.println("Error, solo se admite 1 o 2");
			}

		} while (operacionPrincipal < 1 || operacionPrincipal > 2);

	}

//metodo para decidir entre operaciones logicas y operaciones aritmeticas
	public static void menuPrincipal() throws NumberFormatException, IOException {
		switch (operacionPrincipal) {
		case 1:
			menuOpciones();
			operacionAritmetica();
			calculadora();
			break;
		case 2:
			menuLogico();
			operacionLogica();
			menuOperacionesLogicas();
		}

	}

//metodo para que el usuario indique si quiere volver a repetir el programa
	public static void volverARepetir() throws NumberFormatException, IOException {
		boolean error = true;

		System.out.println("Quieres hacer otra operacion?");
		System.out.println("1-----si");
		System.out.println("2-----no");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while (error) {
			try {
				respuesta = Integer.parseInt(br.readLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("Error, caracter desconocido");
			}
		}

	}

	// metodo para mostrar las operaciones disponibles
	public static void menuOpciones() {
		System.out.println("Introduce la operacion que deseas realizar");
		System.out.println("1 ----- Suma");
		System.out.println("2 ----- Resta");
		System.out.println("3 ----- Multiplicacion");
		System.out.println("4 ----- Division");
	}

//menu operaciones logicas
	public static void menuLogico() {
		System.out.println("Introduce la operacion que deseas realizar");
		System.out.println("1 -----AND");
		System.out.println("2 ----- OR");
		System.out.println("3 ----- NOT");
		System.out.println("4 ----- AND(|)");
		System.out.println("5 ----- OR(|)");
		System.out.println("6 ----- XOR");
	}

//metodo para realizar la operacion AND
	public static boolean AND() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());

		if (estado == 1) {
			logico1 = true;
		}
		System.out.println("Quieres poner el operando 2 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico2 = true;
		}
		resultadoLogico = (logico1 && logico2);
		return resultadoLogico;
	}

	// metodo para realizar la operacion logica OR
	public static boolean OR() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico1 = true;
		}
		System.out.println("Quieres poner el operando 2 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico2 = true;
		}
		resultadoLogico = (logico1 || logico2);
		return resultadoLogico;
	}

	public static boolean NOT() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado = 0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico1 = true;
		}
		resultadoLogico = (!logico1);
		return resultadoLogico;
	}

//metodo para realizar la operacion AND con un solo simbolo
	public static boolean AND1simbolo() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado;
		Scanner entrada = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		entrada.close();
		if (estado == 1) {
			logico1 = true;
		}
		System.out.println("Quieres poner el operando 2 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico2 = true;
		}
		resultadoLogico = (logico1 & logico2);
		return resultadoLogico;
	}

//metodo para realizar la operacion logica OR con un simbolo
	public static boolean OR1simbolo() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico1 = true;
		}
		System.out.println("Quieres poner el operando 2 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico2 = true;
		}
		resultadoLogico = (logico1 | logico2);
		return resultadoLogico;
	}

//metodo para realizar la operacion logica XOR
	public static boolean XOR() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		int estado;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Quieres poner el operando 1 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico1 = true;
		}
		System.out.println("Quieres poner el operando 2 a true?");
		System.out.println("1----si");
		System.out.println("2-----no");
		estado = Integer.parseInt(br.readLine());
		if (estado == 1) {
			logico2 = true;
		}
		resultadoLogico = (logico1 ^ logico2);
		return resultadoLogico;
	}

	// Menu para saber que operacion logica quiere realizar el usuario
	public static void operacionLogica() throws NumberFormatException, IOException {
		boolean error = true;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while (error) {
			try {
				operacionLogica = Integer.parseInt(br.readLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("Error, caracter no valido");
			}
		}

	}

	public static void operacionAritmetica() throws NumberFormatException, IOException {
		do { // esto es para que no se puede meter un numero que no sea valido
			operacion();
			if (operacion < 1 || operacion > 4) // este mensaje solo sale si el numero no es valido
				System.out.println("error, el numero introducido no es valido, intentelo de nuevo");
		} while (controlErroresOperacion(operacion));
	}

}// cierre de la clase

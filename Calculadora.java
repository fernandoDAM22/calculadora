/*
 * Enunciado: Hacer una calculadora
 * Autor: Fernando Gil
 * Fecha:10/11/2021
 */
package Principal;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Calculadora {
	private static int operacionPrincipal; // para saber si hay que realizar operaciones aritmeticas o logicas
	private static double numero1; // primer numero de la operacion
	private static double numero2; // segundo numero de la operacion
	private static int respuesta; // aqui se guardan la respuesta del usuario cuando se pregunta si se quiere
									// repetir el programa
	public static int operacion; // aqui se guarda la operacion que se va a realizar
	public static boolean salir; // atributo bandera para poder salir de la ejecucion del programa o repetirlo
	private static boolean logico1 = false; // primer operando para las operaciones logicas
	private static boolean logico2 = false; // segundo operando para las operaciones logicas
	public static int operacionLogica; // aqui se guarda la operacion logica que se va a realizar

	public static void main(String[] args) throws NumberFormatException, IOException {
		do {
			operacionPrincipal();
			menuPrincipal();
			volverARepetir();// este metodo pregunta si quieres volver a repetir el programa

		} while (repetirPrograma(respuesta)); // con esto se puede repetir el programa

	}// cierre del main
		// metodo para decidir entre operaciones logicas y operaciones aritmeticas

	public static void menuPrincipal() throws NumberFormatException, IOException {
		switch (operacionPrincipal) {
		case 1:
			operacionAritmetica();
			menuOperacionesAritmeticas();
			break;
		case 2:
			operacionLogica();
			menuOperacionesLogicas();
		}

	}

	public static void menuOperacionesAritmeticas() throws IOException {
		double resultado = 0;
		switch (operacion) {
		case 1:
			recibirValores();
			resultado = suma();
			break;

		case 2:
			recibirValores();
			resultado = resta();
			break;
		case 3:
			recibirValores();
			resultado = multiplicacion();
			break;
		case 4:
			recibirValores();
			resultado = division();
			break;
		default:
			numero1 = Integer.parseInt(JOptionPane.showInputDialog("el signo introducido no es valido"));
			break;
		}
		JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
	}

	public static void menuOperacionesLogicas() throws NumberFormatException, IOException {
		switch (operacionLogica) {
		case 1:
			// System.out.println(AND());
			JOptionPane.showMessageDialog(null, AND());
			break;
		case 2:
			JOptionPane.showMessageDialog(null, OR());
			break;
		case 3:
			JOptionPane.showMessageDialog(null, NOT());
			break;
		case 4:
			JOptionPane.showMessageDialog(null, AND1simbolo());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, OR1simbolo());
			break;
		case 6:
			JOptionPane.showMessageDialog(null, XOR());
			break;
		}

	}

//metodo para realizar la suma
	public static double suma() {
		return (numero1 + numero2);
	}

//metodo para realizar la resta
	public static double resta() {
		return (numero1 - numero2);
	}

//metodo para realizar la multiplicacion
	public static double multiplicacion() {
		return (numero1 * numero2);
	}

//metodo para realizar la division
	public static double division() {
		double resultadoDivision = 0;
		try {
			resultadoDivision = numero1 / numero2;
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		return resultadoDivision;
	}

//metodo para recibir los valores de los numeros con los que vamos a operar
	public static void recibirValores() throws NumberFormatException, IOException {
		boolean error = true;
		while (error) {
			try {
				numero1 = Integer.parseInt(JOptionPane.showInputDialog("introduce el primer numero"));
				error = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
			}
		}
		error = true;
		while (error) {
			try {
				numero2 = Integer.parseInt(JOptionPane.showInputDialog("introduce el segundo numero"));
				error = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
			}
		}

	}

//metodo para saber la operacion que se tiene que realizar
	public static void operacion() throws NumberFormatException, IOException {
		boolean error = true;

		while (error) {
			try {
				operacion = Integer.parseInt(JOptionPane.showInputDialog(
						"introduce la operacion que deseas realizar\n 1-------suma \n 2-------resta \n 3------multiplicacion \n 4------division"));
				error = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
			}
		}

	}

//metodo para controlar que no se pueda meter una operacion incorrecta
	public static boolean controlErroresOperacion(int operacion) {
		return (operacion < 1 || operacion > 4);
	}

//metodo para poder repetir el programa
	public static boolean repetirPrograma(double respuesta2) {
		return (respuesta2 == 1);
	}

//metodo donde se encuentra el swich con las operaciones
//El metodo para recibir valores de las operaciones aritmeticas 

	// metodo para realizar las operaciones logicas

//metodo para realizar el menu principal para poder elegir entre operaciones aritmeticas colo logicas
	public static void operacionPrincipal() throws NumberFormatException, IOException {
		do {
			boolean error = true;
			while (error) {
				try {
					operacionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(
							"introduce la operacion que deseas realizar\n 1------Operaciones aritmeticas\n 2------Operaciones logicas"));
					error = false;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
				}
				if ((operacionPrincipal < 1 || operacionPrincipal > 2))

					JOptionPane.showMessageDialog(null, "Error, solo se admite 1 o 2");
			}

		} while (operacionPrincipal < 1 || operacionPrincipal > 2);

	}

//metodo para que el usuario indique si quiere volver a repetir el programa
	public static void volverARepetir() throws NumberFormatException, IOException {
		do {
			boolean error = true;
			while (error) {
				try {
					respuesta = Integer.parseInt(
							JOptionPane.showInputDialog("Quieres hacer otra operacion\n 1-------si \n 2-------no"));
					error = false;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
				}
				if ((respuesta < 1 || respuesta > 2))

					JOptionPane.showMessageDialog(null, "Error, solo se admite 1 o 2");
			}

		} while (respuesta < 1 || respuesta > 2);

	}

	// metodo para mostrar las operaciones disponibles

//metodo para realizar la operacion AND
	public static boolean AND() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicos();
		resultadoLogico = (logico1 && logico2);
		return resultadoLogico;
	}

	// metodo para realizar la operacion logica OR
	public static boolean OR() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicos();
		resultadoLogico = (logico1 || logico2);
		return resultadoLogico;
	}

	public static boolean NOT() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicosNOT();
		resultadoLogico = (!logico1);
		return resultadoLogico;
	}

//metodo para realizar la operacion AND con un solo simbolo
	public static boolean AND1simbolo() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicos();
		resultadoLogico = (logico1 & logico2);
		return resultadoLogico;
	}

//metodo para realizar la operacion logica OR con un simbolo
	public static boolean OR1simbolo() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicos();
		resultadoLogico = (logico1 | logico2);
		return resultadoLogico;
	}

//metodo para realizar la operacion logica XOR
	public static boolean XOR() throws NumberFormatException, IOException {
		boolean resultadoLogico;
		recibirValoresLogicos();
		resultadoLogico = (logico1 ^ logico2);
		return resultadoLogico;
	}

	// Menu para saber que operacion logica quiere realizar el usuario
	public static void operacionLogica() throws NumberFormatException, IOException {
		boolean error = true;
		while (error) {
			try {
				operacionLogica = Integer.parseInt(JOptionPane.showInputDialog(
						"intruduce la operacion que deseas realizar\n 1-----AND\n 2-----OR \n 3----NOT \n 4 ----AND(&)\n 5----OR(|) \n 6----XOR"));
				error = false;
				if (operacionLogica < 1 || operacionLogica > 7) {
					JOptionPane.showMessageDialog(null, "Error, numero no valido");
					error = true;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, caracter no valido");
			}

		}

	}
	// Metodo para indicar la operacion logica que queremos realizar

	public static void operacionAritmetica() throws NumberFormatException, IOException {
		do { // esto es para que no se puede meter un numero que no sea valido
			operacion();
			if (operacion < 1 || operacion > 4) // este mensaje solo sale si el numero no es valido
				JOptionPane.showMessageDialog(null, "El numero introducido no es valido, intentelo de nuevo");
		} while (controlErroresOperacion(operacion));
	}

	// Metodo para recibir los valores para las operaciones logicas
	public static void recibirValoresLogicos() {
		int estado = 0;
		do {
			try {
				estado = Integer.parseInt(
						JOptionPane.showInputDialog("Quieres poner el primer operando a true?\n 1------si\n2-----no"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error,caracter desconocido");
			}

			if ((estado < 1 || estado > 2))
				JOptionPane.showMessageDialog(null, "Error, solo se admite 1 o 2");
		} while (estado < 1 || estado > 2);

		if (estado == 1) {
			logico1 = true;
		}
		do {
			try {
				estado = Integer.parseInt(
						JOptionPane.showInputDialog("Quieres poner el segundo operando a true?\n 1------si\n2-----no"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, caracter desconocido");
			}

			if ((estado < 1 || estado > 2))
				JOptionPane.showMessageDialog(null, "Error, solo se admite 1 o 2");
		} while (estado < 1 || estado > 2);

		if (estado == 1) {
			logico2 = true;
		}
	}

	// metodo para recibir el unico valor de la operacion NOT
	public static void recibirValoresLogicosNOT() {
		int estado;
		do {
			estado = Integer.parseInt(
					JOptionPane.showInputDialog("Quieres poner el primer operando a true?\n 1------si\n2-----no"));
			if ((estado < 1 || estado > 2))
				JOptionPane.showMessageDialog(null, "Error, solo se admite 1 o 2");
		} while (estado < 1 || estado > 2);

		if (estado == 1) {
			logico1 = true;
		}

	}
}// cierre de la clase

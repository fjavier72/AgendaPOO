package com.cursoceat.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cursoceat.main.Contactos;

public class Menu extends Contactos {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Contactos> agenda = new ArrayList<Contactos>();
	
	public static void miMenu() {
		int opcion;
		
		do {
			System.out.println("\n\t★ Agenda Telefónica ★");
			System.out.println("\t\t1\u27A1 Alta");
			System.out.println("\t\t2\u27A1 Buscar");
			System.out.println("\t\t3\u27A1 Mostrar");
			System.out.println("\t\t4\u27A1 Salir");
			System.out.print("\n\tSu opción es \u27A1 ");
			opcion = input.nextInt();
			input.nextLine();  // Vaciamos el buffer del Scanner
			switch (opcion) {
			case 1 -> alta();
			case 2 -> buscar();
			case 3 -> mostrar();
			case 4 -> System.out.println("\nAplicación terminada...");
			default -> System.err.println("\nERROR. Tu selección es incorrecta...");
			}
		} while (opcion != 4);
	}

	static void alta() {
		String nombre, telefono;
		do {
			System.out.print("Indique el nombre del contacto: ");
			nombre = input.nextLine();
		} while (nombre.isEmpty());
		nombre = pasarMayuscula(nombre);
		do {
			System.out.print("Indique el teléfon del contacto: ");
			telefono = input.nextLine();
			
		} while (!validarTelefono(telefono));
		// Aquí tenemos que crear un objeto y guardar los datos que hemos capturado
		Contactos unCtto = new Contactos(nombre, telefono);
		agenda.add(unCtto);
	}
	
	static void buscar() {
		String nombre;
		boolean encontrado = false;
		do {
			System.out.print("Indique el nombre a buscar: ");
			nombre = input.nextLine();
		} while (nombre.isEmpty());
		nombre = pasarMayuscula(nombre);
		for (Contactos c: agenda) {
			String nombreAgenda = c.getNombre();
			if (nombreAgenda.startsWith(nombre)) {
				System.out.println("\t" + c.getNombre() + "\t(" + c.getTelefono() + ")");
				encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("El contacto buscado no existe");
	}

	static void mostrar() {
		for (Contactos c : agenda) {
			System.out.println("\t" + c.getNombre() + "\t(" + c.getTelefono() + ")");
		}
	}

	// Método que capitaliza las cadenas
	static String pasarMayuscula(String cadena) {
		String[] arraycadenaStrings=cadena.split(" ");
		String temp="";
		for (int i=0; i<arraycadenaStrings.length; i++) {
			arraycadenaStrings[i]=arraycadenaStrings[i].substring(0, 1).toUpperCase()+
					arraycadenaStrings[i].substring(1).toLowerCase();
			temp+=arraycadenaStrings[i]+" ";
		}
		return temp;
	}
	
	// Método que verifica que el teléfono introducido es correcto
	static boolean validarTelefono(String telefono) {
		boolean correcto;
		if ((!telefono.startsWith("9") && !telefono.startsWith("6") && !telefono.startsWith("7")) 
				|| telefono.length()!=9) {
			correcto=false;
		} else 
			correcto=true;
		return correcto;
	}
}

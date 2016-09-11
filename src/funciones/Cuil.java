package funciones;

import java.util.Scanner;

public class Cuil {
	
	private static boolean validarSexo(char sexo) {
		boolean resultado = false;
		
		if (Character.toLowerCase(sexo) == 'f' || Character.toLowerCase(sexo) == 'm') {
			resultado = true;
		}
		return resultado;
	}
	
	private static boolean validarDni(int dni) {
		boolean resultado = false;
		
		if (dni > 999999 && dni < 100000000) {
			resultado = true;
		}
		return resultado;
	}
	
	public static String getCuil(int dni, char sexo) throws Exception {
		String cuil = "";
		int valor1 = 0;
		int valor2 = 0;
		int valor3 = 0;
		int verificador = 0;
		
		if (!validarSexo(sexo)) throw new Exception("Error: Sexo invalido.");
		if (!validarDni(dni)) throw new Exception("Error: Dni invalido.");
		
		if (Character.toLowerCase(sexo) == 'm') {
			cuil = "20";
		}else if (Character.toLowerCase(sexo) == 'f') {
			cuil = "27";
		}
		cuil += "-" + dni;
		valor1 =  (Integer.parseInt(""+cuil.charAt(0)) * 5)
				 +(Integer.parseInt(""+cuil.charAt(1)) * 4) 
				 +(Integer.parseInt(""+cuil.charAt(3)) * 3) 
				 +(Integer.parseInt(""+cuil.charAt(4)) * 2) 
				 +(Integer.parseInt(""+cuil.charAt(5)) * 7) 
				 +(Integer.parseInt(""+cuil.charAt(6)) * 6) 
				 +(Integer.parseInt(""+cuil.charAt(7)) * 5) 
				 +(Integer.parseInt(""+cuil.charAt(8)) * 4) 
				 +(Integer.parseInt(""+cuil.charAt(9)) * 3) 
				 +(Integer.parseInt(""+cuil.charAt(10)) * 2);
		valor2 = valor1 % 11;
		valor3 = 11 - valor2;
		if (valor3 == 11) {
			verificador = 0;
		}else if (valor3 == 10) {
			verificador = 9;
		}else{
			verificador = valor3;
		}
		cuil += "-" + verificador;
		return cuil;
	}
	
	public static void main(String[] args) {
		int dni = 0;
		char sexo = 'q';
		Scanner s = new Scanner(System.in);
		
		while (sexo != 'f' && sexo != 'm' ) {
			System.out.println("Ingrese su sexo [F/M]: ");
			sexo = s.nextLine().toLowerCase().charAt(0);
		}
		while (!validarDni(dni)) {
			System.out.println("Ingrese su numero de D.N.I: ");
			dni = s.nextInt();
		}
		s.close();
		try{
			System.out.println("Su C.U.I.L es " + getCuil(dni, sexo));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

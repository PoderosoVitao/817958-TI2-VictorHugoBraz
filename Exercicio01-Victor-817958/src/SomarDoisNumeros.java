import java.util.*;

class SomarDoisNumeros {

	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		// Declarar Vars
		int num1, num2, soma;
		
		// Ler
		System.out.println("Digite um número");
		num1 = sc.nextInt();
		System.out.println("Digite outro número");
		num2 = sc.nextInt();
		
		// Somar
		
		soma = num1 + num2;
		
		// Mostrar
		
		System.out.println("Soma: "+soma);
	}
	
}

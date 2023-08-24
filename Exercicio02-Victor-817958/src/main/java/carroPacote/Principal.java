package carroPacote;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dado = new DAO();
		
		dado.conectar();
		
		// Menu
		int opcao = -2;
		
		while(opcao != 5)
		{
			showOptions();
			opcao = MyIO.readInt();
			
			switch(opcao) {
			case 1: myList(dado); break;
			case 2: myInsert(dado); break;
			case 3: myDelete(dado); break;
			case 4: myUpdate(dado); break;
			case 5: break;
			default: System.out.println("Opção invalida!");
			}
		}
		
		dado.close();
	}
	
	
	// Metodo que lista elementos
	public static void myList(DAO dado)
	{
		Carro[] todosCarros = dado.getCarros();
		System.out.println("==== Mostrar Carros === ");		
		for(int i = 0; i < todosCarros.length; i++) {
			System.out.println(todosCarros[i].toString());
		}
	}

	// Metodo que insere elemento e coleta informações
	public static void myInsert(DAO dado)
	{
		// Coletar Informações
		System.out.println("Digite o Codigo: ");
		int nCodigo = MyIO.readInt();
		System.out.println("Digite o Nome/Marca: ");
		String nNome = MyIO.readString();
		System.out.println("Digite o tipo de Motor: ");
		String nMotor = MyIO.readString();
		System.out.println("Digite a quantidade de portas: ");
		int nPortas = MyIO.readInt();
		System.out.println("Digite o ano de fabricação: ");
		int nAno = MyIO.readInt();
		
		Carro iCarro = new Carro(nCodigo, nNome, nMotor, nPortas, nAno);
		
		// Inserir
		if(dado.inserirCarro(iCarro) == true) {
			System.out.println("Inserção com sucesso -> " + iCarro.toString());
		}
	}
	
	// Metodo que updata elemento e coleta informações
	public static void myUpdate(DAO dado)
	{
		// Coletar Informações
		System.out.println("Digite o Codigo: ");
		int nCodigo = MyIO.readInt();
		Carro atualCarro = dado.getCarroSingular(nCodigo);
		System.out.println(atualCarro.toString());
		
		int opcaoB = -1;
		
		while(opcaoB != 5)
		{
			
			System.out.println("O que deseja atualizar?");
			System.out.println("1) Nome ");
			System.out.println("2) Motor ");
			System.out.println("3) Portas ");
			System.out.println("4) Ano ");
			System.out.println("5) Sair ");
			
			opcaoB = MyIO.readInt();
			
			switch(opcaoB) {
			case 1: 
				System.out.println("Digite um novo nome: ");
				String newName = MyIO.readString();
				atualCarro.setNome(newName);
				
			case 2: System.out.println("Digite um novo Motor: ");
			String newEngine = MyIO.readString();
			atualCarro.setMotor(newEngine);
			case 3: System.out.println("Digite o número de portas: ");
			int doorAmount = MyIO.readInt();
			atualCarro.setPortas(doorAmount);
			case 4: System.out.println("Digite o ano de fabricação: ");
			int year = MyIO.readInt();
			atualCarro.setAno(year);
			case 5: break;
			default: System.out.println("Opção invalida!");
			}
		}
		
		dado.revisarCarro(atualCarro);
	}
	
	// Metodo que deleta um elemento
	public static void myDelete(DAO dado)
	{
		System.out.println("Digite o Codigo: ");
		int nCodigo = MyIO.readInt();
		Carro atualCarro = dado.getCarroSingular(nCodigo);
		System.out.println(atualCarro.toString());
		char a = 'Z';
		
		while(a != 'Y' && a != 'N')
		{
		System.out.println("Tem certeza que deseja excluir o carro selecionado? Y/N ");
		a = MyIO.readChar();
		}
		
		if(a == 'Y')
		{
			dado.explodirCarro(nCodigo);
		}
	}
	
	public static void showOptions()
	{
		System.out.println("1) Listar ");
		System.out.println("2) Inserir");
		System.out.println("3) Excluir");
		System.out.println("4) Atualizar");
		System.out.println("5) Sair");
	}
}
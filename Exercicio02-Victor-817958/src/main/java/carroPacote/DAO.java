package carroPacote;
import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirCarro(Carro carro) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO carros (codigo, nome, motor, porta, ano) "
					       + "VALUES ("+carro.getCodigo()+ ", '" + carro.getNome() + "', '"  
					       + carro.getMotor() + "', '" + carro.getPortas() + "', '" + carro.getAno() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean revisarCarro(Carro carro) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE carros SET nome = '" + carro.getNome() + "', motor = '"  
				       + carro.getMotor() + "', porta = '" + carro.getPortas() + "', ano = '" + carro.getAno() + "'"
					   + " WHERE codigo = " + carro.getCodigo();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean explodirCarro(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM carros WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Carro[] getCarros() {
		Carro[] carros = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM carros");		
	         if(rs.next()){
	             rs.last();
	             carros = new Carro[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                carros[i] = new Carro(rs.getInt("codigo"), rs.getString("nome"), 
	                		                  rs.getString("motor"), rs.getInt("porta"), rs.getInt("ano"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}

	
	public Carro getCarroSingular(int codigoProc) {
		Carro carroReturn = null;
		 try {
		        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		        ResultSet rs = st.executeQuery("SELECT * FROM carros WHERE codigo = " + codigoProc);
	         if(rs.next()){
	        	 carroReturn = new Carro(rs.getInt("codigo"), rs.getString("nome"),
                         rs.getString("motor"), rs.getInt("porta"), rs.getInt("ano"));
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carroReturn;
	}
	
	public Carro[] getCarros4PTas() {
		Carro[] carros = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM carros WHERE carros.portas = 4");		
	         if(rs.next()){
	             rs.last();
	             carros = new Carro[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                carros[i] = new Carro(rs.getInt("codigo"), rs.getString("nome"), 
      		                  rs.getString("motor"), rs.getInt("porta"), rs.getInt("ano"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
}
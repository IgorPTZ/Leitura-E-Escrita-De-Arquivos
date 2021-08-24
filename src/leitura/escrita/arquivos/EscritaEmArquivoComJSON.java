package leitura.escrita.arquivos;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscritaEmArquivoComJSON {
	
	public static void main(String[] args) {
		
		try {
			Usuario usuario1 = new Usuario("Igor dos Santos Pereira", "rogi.pereira", "teste321");
			
			Usuario usuario2 = new Usuario("Jose dos Santos Pereira", "jose.pereira", "teste321");
			
			Usuario usuario3 = new Usuario("Maria dos Santos Pereira", "maria.pereira", "teste321");
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			usuarios.add(usuario1);
			
			usuarios.add(usuario2);
			
			usuarios.add(usuario3);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String json = gson.toJson(usuarios);
			
			FileWriter fileWriter = new FileWriter("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\usuarios.json");
		
			fileWriter.write(json);
			
			fileWriter.flush();
			
			fileWriter.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}

package leitura.escrita.arquivos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class LeituraEmArquivoComJSON {
	
	public static void main(String[] args) {
		
		try {
			
			FileReader fileReader = new FileReader("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\usuarios.json");
			
			JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			for(JsonElement jsonElement : jsonArray) {
				
				Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
				
				usuarios.add(usuario);
			}
			
			for(Usuario usuario : usuarios) {
				
				System.out.println(usuario);
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}

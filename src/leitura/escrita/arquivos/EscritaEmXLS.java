package leitura.escrita.arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class EscritaEmXLS {
	
	public static void main(String[] args) {
		
		try {
			
			File arquivoXLS = new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.xls");
			
			if(!arquivoXLS .exists()) {
				
				arquivoXLS.createNewFile();
			}
			
			Pessoa pessoa1 = new Pessoa("Igor", "igor.ptw@hotmail.com", 27L);
			
			Pessoa pessoa2 = new Pessoa("Maria", "maria.ptw@hotmail.com", 28L);
			
			Pessoa pessoa3 = new Pessoa("Jose", "jose.ptw@hotmail.com", 29L);
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			pessoas.add(pessoa1);
			
			pessoas.add(pessoa2);
			
			pessoas.add(pessoa3);
			
			//Sera utilizado para escrever na planilha
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); 
			
			// Inicio da criação da planilha
			HSSFSheet linhasDaPlanilha =  hssfWorkbook.createSheet("Planilha de pessoas");
			
			int numeroDaLinha = 0;
			
			for(Pessoa pessoa : pessoas) {
				
				/* Cria uma linha na planilha */
				Row linha = linhasDaPlanilha.createRow(numeroDaLinha++);
				
				
				/* Criação das celulas da linha */
				int numeroDaCelula = 0;
				
				Cell celulaDoNome = linha.createCell(numeroDaCelula++);
				
				celulaDoNome.setCellValue(pessoa.getNome());
				
				Cell celulaDoEmail = linha.createCell(numeroDaCelula++);
				
				celulaDoEmail.setCellValue(pessoa.getEmail());
				
				Cell celulaDaIdade = linha.createCell(numeroDaCelula++);
				
				celulaDaIdade.setCellValue(pessoa.getIdade());
			} // Fim da criação da planilha
			
			FileOutputStream fileOutputStream = new FileOutputStream(arquivoXLS);
			
			hssfWorkbook.write(fileOutputStream); /* Escreve a planilha no arquivo XLS */
			
			fileOutputStream.flush();
			
			hssfWorkbook.close();
			
			fileOutputStream.close();
			
			System.out.println("Planilha criada com sucesso!");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}

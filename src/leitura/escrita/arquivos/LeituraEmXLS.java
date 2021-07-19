package leitura.escrita.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class LeituraEmXLS {
	
	public static void main(String[] args) {
		
		try {
			
			FileInputStream fileInputStream = new FileInputStream(new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.xls"));
		
			// Prepara a entrada do arquivo excel para leitura
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
			
			// Obter a primeira planilha do arquivo XLS (UM arquivo XLS pode ter varias planilhas)
			HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
			
			Iterator<Row> iteratorDeLinhas = planilha.iterator();
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			// Percorre as linhas da planilha
			while(iteratorDeLinhas.hasNext()) { 
				
				Row linha = iteratorDeLinhas.next();
				
				Iterator<Cell> iteratorDeCelulas = linha.iterator();
				
				Pessoa pessoa = new Pessoa();
				
				// Percorre as celulas de uma das linhas da planilha
				while(iteratorDeCelulas.hasNext()) {
					
					Cell celula = iteratorDeCelulas.next();
					
					switch(celula.getColumnIndex()) {
						
						case 0:
							pessoa.setNome(celula.getStringCellValue());
							break;
							
						case 1:
							pessoa.setEmail(celula.getStringCellValue());
							break;
							
						case 2:
							pessoa.setIdade(Double.valueOf(celula.getNumericCellValue()).longValue());
							break;
					}
				}
				
				pessoas.add(pessoa);
			}
			
			hssfWorkbook.close();
			
			fileInputStream.close();
			
			for(Pessoa pessoa : pessoas) {
				
				System.out.println(pessoa);
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}

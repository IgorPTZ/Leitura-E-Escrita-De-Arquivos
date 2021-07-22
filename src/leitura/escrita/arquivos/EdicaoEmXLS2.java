package leitura.escrita.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class EdicaoEmXLS2 {
	
	public static void main(String[] args) {
		
		try {
			File arquivoXLS = new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.xls");
			
			FileInputStream fileInputStream = new FileInputStream(arquivoXLS);
		
			// Prepara a entrada do arquivo excel para leitura
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
			
			// Obter a primeira planilha do arquivo XLS (UM arquivo XLS pode ter varias planilhas)
			HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
			
			Iterator<Row> iteratorDeLinhas = planilha.iterator();
			
			// Percorre as linhas da planilha
			while(iteratorDeLinhas.hasNext()) {
				
				Row linha = iteratorDeLinhas.next();
				
				// Edita uma celula existente
				String valorDaCelula = linha.getCell(3).getStringCellValue();
				
				linha.getCell(3).setCellValue(valorDaCelula + " editado");
			}
			
			fileInputStream.close();
			
			FileOutputStream fileOutputStream = new FileOutputStream(arquivoXLS);
			
			hssfWorkbook.write(fileOutputStream);
			
			hssfWorkbook.close();
			
			fileOutputStream.close();
			
			System.out.println("Planilha atualizada com sucesso!");
		}
		catch(Exception e) {
			
		}
	}
}

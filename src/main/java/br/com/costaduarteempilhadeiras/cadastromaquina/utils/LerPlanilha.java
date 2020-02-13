package br.com.costaduarteempilhadeiras.cadastromaquina.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.platform.commons.function.Try;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class LerPlanilha {
	
	public void leplanilha(){
		String jdbcURL = "jdbc:mysql://localhost:3306/teste";
		String username = "root";
		String password = "123456";

		String excelFilePath = "C:/Users/jose.lazaro.n.silva/Downloads/teste2.xlsx";

		int batchSize = 20;

		Connection connection = null;

		try {
			long start = System.currentTimeMillis();
			
			FileInputStream inputStream = new FileInputStream(excelFilePath);

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO API (name, campo, tipo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);		
			
            int count = 0;
            
            rowIterator.next(); // skip the header row
            
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();
					
					if(!nextCell.getStringCellValue().equals(null) || nextCell.getStringCellValue().length() > 0){

					switch (columnIndex) {
					case 0:
						String name = nextCell.getStringCellValue();
						statement.setString(1, name);
						break;
					case 1:
						String campo = nextCell.getStringCellValue();
						statement.setString(2, campo);
						break;
					case 2:
						String tipo =  nextCell.getStringCellValue();
						statement.setString(3, tipo);
						break;
					 }
					}

				}
				statement.addBatch();
                
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
			   	
			}

			workbook.close();
			
			if(!statement.toString().isEmpty()) {
            // execute the remaining queries
            statement.executeBatch();
			}
            connection.commit();
            connection.close();	
            
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            
		} catch (IOException ex1) {
			System.out.println("Error reading file");
			ex1.printStackTrace();
		} catch (SQLException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		}

	}
}



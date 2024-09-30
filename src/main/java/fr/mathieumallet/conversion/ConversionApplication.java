package fr.mathieumallet.conversion;

import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class ConversionApplication {

	public ConversionApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(ConversionApplication.class, args);

		try {
			InputStream inputFilePath = new FileInputStream("C:\\Users\\Mathieu\\test.docx");
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(inputFilePath);

			Mapper fontMapper = new IdentityPlusMapper();
			wordMLPackage.setFontMapper(fontMapper);

			String outputfilepath = "C:\\Users\\Mathieu\\test.pdf";
			FileOutputStream os = new FileOutputStream(outputfilepath);
			Docx4J.toPDF(wordMLPackage, os);
			os.flush();
			os.close();
			inputFilePath.close();
			System.out.println("Conversion terminée");

		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
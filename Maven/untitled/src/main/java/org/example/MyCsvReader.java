package org.example;
import java.io.File;
import java.io.FileReader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class MyCsvReader {

    public void read(File file) throws Exception {

        String [] record;
        CSVReader csvReader = null;

        try {
            /*
                Build the reader with custom separator. Default is ','
                The default quote character is '"', if you want to use custom, use withQuoteChar(char)
                For example withQuoteChar('\'')
            */
            csvReader = new CSVReaderBuilder(new FileReader(file))
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(';')
                            .build())
                    .build();

            int currentLine = 0;

            while ((record = csvReader.readNext()) != null) {

                System.out.println(
                        String.format(
                                "Line %d Col1: %s Col2: %s Col3: %s",
                                currentLine,
                                record[0],
                                record[1],
                                record[2]
                        )
                );

                currentLine++;
            }
        } finally {
            //Close the reader
            if (csvReader != null) {
                csvReader.close();
            }
        }

    }
}

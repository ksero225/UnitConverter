package com.Unit_Converter.UnitConverter;

import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitConverterApplication implements CommandLineRunner {

    private final PrintConvertedData printConvertedData;

    public UnitConverterApplication(PrintConvertedData printConvertedData) {
        this.printConvertedData = printConvertedData;
    }

    public static void main(String[] args) {
        SpringApplication.run(UnitConverterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------------" + printConvertedData.printData());
    }
}

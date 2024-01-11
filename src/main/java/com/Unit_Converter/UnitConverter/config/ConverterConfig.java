package com.Unit_Converter.UnitConverter.config;

import com.Unit_Converter.UnitConverter.Classes.ConvertLength;
import com.Unit_Converter.UnitConverter.Classes.ConvertWeight;
import com.Unit_Converter.UnitConverter.Classes.PrintConvertedDataImplementation;
import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedData;
import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedLength;
import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedWeight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {
    @Bean
    public PrintConvertedLength convertLength() {
        return new ConvertLength();
    }

    @Bean
    public PrintConvertedWeight convertedWeight() {
        return new ConvertWeight();
    }

    @Bean
    public PrintConvertedData printConvertedData(PrintConvertedLength convertedLength, PrintConvertedWeight convertedWeight) {
        return new PrintConvertedDataImplementation(convertedLength, convertedWeight);
    }
}

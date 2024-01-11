package com.Unit_Converter.UnitConverter.Classes;

import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedData;
import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedLength;
import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedWeight;

public class PrintConvertedDataImplementation implements PrintConvertedData {

    private final PrintConvertedWeight ConvertWeight;
    private final PrintConvertedLength ConvertLength;

    public PrintConvertedDataImplementation(PrintConvertedLength convertedLength, PrintConvertedWeight convertWeight) {
        this.ConvertWeight = convertWeight;
        this.ConvertLength = convertedLength;
    }

    @Override
    public String printData() {
        return String.join(", ", ConvertLength.printData(5, "cm", "in"), ConvertWeight.printData(5, "lb", "kg"));
    }
}

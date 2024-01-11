package com.Unit_Converter.UnitConverter.Classes;

import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedLength;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.Unit_Converter.UnitConverter.Classes.ConvertWeight.getBigDecimal;

public class ConvertLength implements PrintConvertedLength {
    HashMap<String, BigDecimal> unitHashMap = new HashMap<>() {{
        put("cmtoin", new BigDecimal("0.393701"));
        put("cmtoft", new BigDecimal("0.0328084"));
        put("mtoin", new BigDecimal("39.3701"));
        put("mtoft", new BigDecimal("3.28084"));
        put("intocm", new BigDecimal("2.54"));
        put("intom", new BigDecimal("0.0254"));
        put("fttocm", new BigDecimal("30.48"));
        put("fttom", new BigDecimal("0.3048"));
    }};

    private BigDecimal convertData(double dataToConvert, String dataUnit, String dataUnitUserWantToConvertTo) {
        return getBigDecimal(dataToConvert, dataUnit, dataUnitUserWantToConvertTo, unitHashMap);
    }

    @Override
    public String printData(double dataToConvert, String dataUnit, String dataUnitUserWantToConvertTo) {
        if (convertData(dataToConvert, dataUnit, dataUnitUserWantToConvertTo) != null) {
            return String.format("Your data %.2f %s is equal to %.2f %s",
                    dataToConvert, dataUnit,
                    convertData(dataToConvert, dataUnit, dataUnitUserWantToConvertTo),
                    dataUnitUserWantToConvertTo);
        } else {
            return "Provided unit type is no handled";
        }
    }
}

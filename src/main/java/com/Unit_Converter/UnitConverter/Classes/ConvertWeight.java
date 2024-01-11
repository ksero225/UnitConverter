package com.Unit_Converter.UnitConverter.Classes;

import com.Unit_Converter.UnitConverter.Interfaces.PrintConvertedWeight;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class ConvertWeight implements PrintConvertedWeight {

    HashMap<String, BigDecimal> unitHashMap = new HashMap<>() {{
        put("gtolb", new BigDecimal("0.00220462"));
        put("kgtolb", new BigDecimal("2.20462"));
        put("lbtog", new BigDecimal("453.59237"));
        put("lbtokg", new BigDecimal("0.45359237"));
    }};

    private BigDecimal convertData(double dataToConvert, String dataUnit, String dataUnitUserWantToConvertTo) {
        return getBigDecimal(dataToConvert, dataUnit, dataUnitUserWantToConvertTo, unitHashMap);
    }

    static BigDecimal getBigDecimal(double dataToConvert, String dataUnit, String dataUnitUserWantToConvertTo, HashMap<String, BigDecimal> unitHashMap) {
        final String dataUnitToDataUnitUserWantToConvertTo = String.join("", dataUnit, "to", dataUnitUserWantToConvertTo);

        BigDecimal bigDecimalData = new BigDecimal(Double.toString(dataToConvert));
        if (unitHashMap.get(dataUnitToDataUnitUserWantToConvertTo) != null) {
            return bigDecimalData.multiply(unitHashMap.get(dataUnitToDataUnitUserWantToConvertTo));
        }
        return null;
    }

    @Override
    public String printData(double dataToConvert, String dataUnit, String dataUnitUserWantToConvertTo) {
        if (getBigDecimal(dataToConvert, dataUnit, dataUnitUserWantToConvertTo, unitHashMap) != null) {
            return String.format("Your data %.2f %s is equal to %.2f %s",
                    dataToConvert, dataUnit,
                    convertData(dataToConvert, dataUnit, dataUnitUserWantToConvertTo),
                    dataUnitUserWantToConvertTo);
        }
        return null;
    }
}

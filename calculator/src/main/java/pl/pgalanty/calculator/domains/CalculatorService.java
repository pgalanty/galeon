package pl.pgalanty.calculator.domains;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculatorService {


    public BigDecimal calculate(CalculatorDTO calculatorDTO) {

        switch (calculatorDTO.getOperationType()){
            case ADD:
                return calculatorDTO.getA().add(calculatorDTO.getB());
            case SUBTRACT:
                return calculatorDTO.getA().subtract(calculatorDTO.getB());
            case MULTIPLY:
                return calculatorDTO.getA().multiply(calculatorDTO.getB());
            case DIVIDE:
                return calculatorDTO.getA().divide(calculatorDTO.getB());
        }

        return null;
    }


    public Integer calculate(String s) {

        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(time);
        if (matcher.matches()) {
            String hours = matcher.group(1);
            String minutes = matcher.group(2);
            String seconds = matcher.group(3);
            String miliSeconds = matcher.group(4);
            System.out.println(hours + ", " + minutes  + ", " + seconds + ", " + miliSeconds);
        }

        if(s.matches("[\\d]+[+][\\d]+"))
                return 0;
        else
                return 1;


        /*-?\d+(?:\.\d+(?:E\d+)?)?(\s*[-+/\*]\s+-?\d+(?:\.\d+(?:E\d+)?)?)+*/
    }
}

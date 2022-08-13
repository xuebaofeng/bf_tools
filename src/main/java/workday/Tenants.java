package workday;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tenants {

    public static void main(String[] args) {
        String i = "accenture1 accenture2 accenture3 accenture4 accenture5 accenture6 accenture12 accenture17 pwc6 pwc5 td5 accenture12 swift3 ameriprise1 ameriprise4 pru3 usaa1 pimco4";
        List<String> list = Arrays.stream(i.split(" ")).distinct().sorted().collect(Collectors.toList());
        for (String s : list) {
            System.out.print("\""+s+"\",");
        }
    }

}


/*
pwc6
16.7%


pwc5
16.7%


td5
16.7%


accenture12
16.7%


swift3
* */
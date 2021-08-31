package fr.polygones.polytcl.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvParser {

    public static List<String[]> parse(String file, String sep) throws IOException {
        List<String[]> rowList = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine()) != null){
                String[] lineItems = line.split(sep);
                rowList.add(lineItems);
            }
            br.close();
        return rowList;
    }
    public static List<String[]> parse(String file) throws IOException{
        return parse(file,",");
    }

    
    public static String[][] parseStringMatrix(String file, String sep) throws IOException{
        List<String[]> rowList = parse(file, sep);
        String[][] matrix = new String[rowList.size()][];
        for (int i=0; i <rowList.size();i++){
            String[]row = rowList.get(i);
            matrix[i]=row;
        }
        return matrix;
    }
    public static String[][] parseStringMatrix(String file) throws IOException{
        return parseStringMatrix(file, ",");
    }

    
    public static Integer[][] parseIntergerMatrix(String file, String sep) throws IOException{
        List<String[]> rowList = parse(file, sep);
        Integer[][] matrix = new Integer[rowList.size()][];
        for(int i=0;i<rowList.size();i++){
            Integer[] row = ListConverter.stringsToIntegers(rowList.get(i));
            matrix[i] = row;
        }

        return matrix;
    }
}

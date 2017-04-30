package data;

import java.io.IOException;

import data.*;
import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class TestMain {

	public static void main(String[] args) {
		
		ExprParser parser = new ExprParser();
        try {
            Expr expr = parser.build("A3+A2*A1");
            Spreadsheet spreadsheet = new Spreadsheet();
            spreadsheet.instert("A1", "3");
            spreadsheet.instert("A2", "2");
            spreadsheet.instert("A3", "1");
            spreadsheet.instert("A4", "A1+A2");
            spreadsheet.instert("A5", "A4+A3");
            spreadsheet.instert("A6", "A5*2");
            System.out.println(
    				"A1 = " + spreadsheet.value("A1") + " , " 
    				+ "A2 = " + spreadsheet.value("A2") + " , "
    				+ "A3 = " + spreadsheet.value("A3") + " , "
    				+ "A4 = " + spreadsheet.value("A4") + " , "
    				+ "A5 = " + spreadsheet.value("A5") + " , "
    				+ "A6 = " + spreadsheet.value("A6")
            );
            System.out.println(expr);
            System.out.println(expr.value(spreadsheet));
            for(String s : spreadsheet.getSlotSet()){
            	System.out.println(s);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
	}

}

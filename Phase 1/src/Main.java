/*

Farid Afrakhte   990122680092
Zahra Mansouri   980122680051

*/


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Yylex lexer = new Yylex(new FileReader("src/test.txt"));
        while (!lexer.yyatEOF())
            System.out.println(lexer.yylex());
    }
}

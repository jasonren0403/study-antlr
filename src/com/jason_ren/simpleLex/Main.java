package com.jason_ren.simpleLex;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Scanner;

/**
 * 接收expr文件的输入，打印结果。
 */
public class Main {
    public static void main(String[] args) {
        String teststr = "";
        boolean jumpout = false;
        while (!jumpout) {
            System.out.println("Please input string to parse,input an empty line to quit:");
            Scanner in = new Scanner(System.in);
            teststr = in.nextLine();
            if (teststr.length() < 1) {
                jumpout = true;
            }
            else{
                try {
                    ANTLRInputStream input = new ANTLRInputStream(teststr);
                    exprLexer lexer = new exprLexer(input);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    exprParser parser = new exprParser(tokens);
                    ParseTree tree = parser.exprs();
                    Visitor visitor = new Visitor();
                    Double value = visitor.visit(tree);
                    if (value != null)
                        System.out.println(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

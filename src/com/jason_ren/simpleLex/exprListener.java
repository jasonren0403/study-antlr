package com.jason_ren.simpleLex;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exprParser}.
 */
public interface exprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link exprParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(exprParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(exprParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#setExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetExpr(exprParser.SetExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#setExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetExpr(exprParser.SetExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#calcExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalcExpr(exprParser.CalcExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#calcExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalcExpr(exprParser.CalcExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(exprParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(exprParser.FactorContext ctx);
}
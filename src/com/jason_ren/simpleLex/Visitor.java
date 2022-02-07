package com.jason_ren.simpleLex;

/**
 * 重写baseVisitor类，定义语义动作
 */
public class Visitor extends exprBaseVisitor<Double> {

    @Override
    public Double visitExprs(exprParser.ExprsContext ctx) {
        //System.out.println("visit exprs");
        return visit(ctx.getChild(0));
    }

    @Override
    public Double visitSetExpr(exprParser.SetExprContext ctx) {
        Context.getInstance().setContext(ctx.id.getText(), ctx.num.getText());
        System.out.println("Assign operation in current line:"+ctx.id.getText()+" = "+ctx.num.getText());
        return null;
    }

    @Override
    public Double visitCalcExpr(exprParser.CalcExprContext ctx) {
        //System.out.println("visit calc expr");
        int cc = ctx.getChildCount();
        if (cc == 3) {
            switch (ctx.op.getType()) {
                case exprParser.ADD:
                    return visit(ctx.calcExpr(0)) + visit(ctx.calcExpr(1));
                case exprParser.SUB:
                    return visit(ctx.calcExpr(0)) - visit(ctx.calcExpr(1));
                case exprParser.MUL:
                    return visit(ctx.calcExpr(0)) * visit(ctx.calcExpr(1));
                case exprParser.DIV:
                    return visit(ctx.calcExpr(0)) / visit(ctx.calcExpr(1));
            }
        } else if (cc == 1) {
            return visit(ctx.getChild(0));
        }
        throw new RuntimeException();
    }


    @Override
    public Double visitFactor(exprParser.FactorContext ctx) {
        //System.out.println("visit factor");
        int cc = ctx.getChildCount();
        if (cc == 3) {
            return visit(ctx.getChild(1));
        } else if (cc == 2) {
            if (ctx.sign.getType() == exprParser.ADD)
                return Double.valueOf(ctx.getChild(1).getText());
            if (ctx.sign.getType() == exprParser.SUB)
                return -1 * Double.valueOf(ctx.getChild(1).getText());
        } else if (cc == 1) {
            if (ctx.num != null)
                return Double.valueOf(ctx.getChild(0).getText());
            if (ctx.id != null)
                return Context.getInstance().getValue(ctx.id.getText());
        }
        throw new RuntimeException();
    }

}

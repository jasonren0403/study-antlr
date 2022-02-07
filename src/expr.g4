grammar expr;


exprs : setExpr
    | calcExpr
    ;

setExpr : id=ID '=' num=NUMBER ;
calcExpr: calcExpr op=(MUL | DIV) calcExpr
    | calcExpr op=(ADD | SUB) calcExpr
    | factor
    ;

factor: (sign=(ADD | SUB))? num=NUMBER    // 计算因子可以是一个正数或负数
    | id=ID                                // 计算因子可以是一个变量
    ;

WS : [ \t\n\r]+ -> skip ;
ID : [a-zA-Z]+ ;
NUMBER : [0-9]+('.'([0-9]+)?)? ;
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
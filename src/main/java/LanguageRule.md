BNF 规则
{pat}: pat 重复至少 0 次
[pat]: pat 重复 0~1 次
pat1 | pat2 : 与 pat1 或者 pat2 匹配
() 将括号内是为一个完整的模式

整形字面量
NUMBER: 0~9
标识符
IDENTIFIER:
字符串字面量 
STRING:
双目运算符
OP:
换行符
EOL: 

基本构成元素: 表示括号括起的表达式、整形字面量、标识符即变量名、字符串字面量
primary: "(" expr ")" | NUMBER | IDENTIFIER | STRING

因子: 表示一个 primary 或者 primary 之前添加个 -
factor: - primary | primary

表达式expression: 两个 factor 之间夹有一个双目运算符
expr: factor { OP factor }

代码块: 指由{} 括起来的 statement(语句) 序列
statement 之间需要通过 ; 或者 EOF 进行分割
由于支持空语句，statement 需要使用[] 进行声明
block: "{" [statement] { (";" | EOL) [statement]} "}"

simple: expr

语句: if, while 或者是简单表达式语句
statement: "if" expr block ["else" block]       // if-else
          |"while" expr block                   // while 
          |simple

非终结符: 分号或者换行，用于表示一句完整语句
由于 statement 是可选的所以 program 还可以表示空行
program: [statement] (";" | EOL)
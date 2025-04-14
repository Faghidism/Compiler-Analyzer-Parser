/*

Farid Afrakhte   990122680092
Zahra Mansouri   980122680051

*/
%%


%public



%line
%column
%state COMMENT
%unicode
%ignorecase


ALPHA=[A-Za-z]
DIGIT=[0-9]
INTEGER={DIGIT}+
NONNEWLINE_WHITE_SPACE_CHAR=[\ \t\b\012]
NEWLINE=\r|\n|\r\n
WHITE_SPACE_CHAR=[\n\r\ \t\b\012]
STRING_TEXT=(\\\"|[^\n\r\"\\]|\\{WHITE_SPACE_CHAR}+\\)*
COMMENT_TEXT=([^*/\n]|[^*\n]"/"[^*\n]|[^/\n]"*"[^/\n]|"*"[^/\n]|"/"[^*\n])+
Ident = {ALPHA}({ALPHA}|{DIGIT}|_)*
float ={INTEGER}
EndOfLineComment = "//" [^\r\n]* {NEWLINE}
DocumentationComment = "/*" "*"+ [^/*] ~"*/"
%%



<YYINITIAL> {
"abstract"|"continue"|"for"	      |"new"       |"switch"       |
"assert"  |"default" |"goto"      |"package"   |"synchronized" |
"boolean" |"do"      |"if"	      |"private"   |"this" 		   |
"break"	  |"double"  |"implements"|"protected" |"throw"        |
"byte"    |"else"    |"import"    |"public"    |"throws"       |
"case"    |"enum"    |"instanceof"|"return"    |"transient"    |
"catch"   |"extends" |"int"       |"short"	   |"try"          |
"char"    |"final"   |"interface" |"static"    |"void"         |
"class"   |"finally" |"long"      |"strictfp"  |"volatile"     |
"const"	  |"float"   |"native"    |"super"	   |"while" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }

  "," { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  ":" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  ";" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "(" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  ")" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "[" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "]" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "{" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "}" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "." { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "+" { return new Yytoken("keyword",Operators,yyline,yycolumn); }
  "-" { return new Yytoken("keyword",Operators,yyline,yycolumn); }
  "*" { return new Yytoken("keyword",Operators,yyline,yycolumn); }
  "/" { return new Yytoken("keyword",Operators,yyline,yycolumn); }
  "%" { return new Yytoken("keyword",Operators,yyline,yycolumn); }
  "=" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "<>" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "<"  { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "<=" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  ">"  { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  ">=" { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "&"  { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "|"  { return new Yytoken("keyword",yytext(),yyline,yycolumn); }
  "**" { return new Yytoken("keyword",Incremental,yyline,yycolumn); }
  "--" { return new Yytoken("keyword",Incremental,yyline,yycolumn); }
  "++" { return new Yytoken("keyword",Incremental,yyline,yycolumn); }




"println" |"inumber" |"CLEAR"   
{ return new Yytoken("reserved",yytext(),yyline,yycolumn); }

  {NONNEWLINE_WHITE_SPACE_CHAR}+ { }

 

  \"{STRING_TEXT}\" {
    String str =  yytext().substring(1,yylength()-1);
    return new Yytoken("String",str,yyline,yycolumn); 
  }


  {DIGIT}+ { return new Yytoken("number",yytext(),yyline,yycolumn); }                  /* integer nums */

  {Ident} { return new Yytoken("ident",yytext(),yyline,yycolumn); }


{NEWLINE} { }

. { return new Yytoken("Error",yytext(),yyline,yycolumn); }

  
{EndOfLineComment} {}
{DocumentationComment} {}

}
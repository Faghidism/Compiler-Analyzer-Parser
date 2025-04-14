public class Yytoken {
    private String type;
    private int line;
    private int column;
    private String value;


    public Yytoken(String type, String value, int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
        this.value = value;
    }

    public String toString() {
        return type+" found in line "+line+" in col "+column+" with val "+value;
    }
}

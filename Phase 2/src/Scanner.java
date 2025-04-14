import java_cup.runtime.*;

@SuppressWarnings("FallThrough")
public class Scanner extends sym implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int CHARLITERAL = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2, 2
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\10\u2f00\31\u1f00\1\u0100\1\u3000\1\u3100\1\u0100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u3600\1\u3700\1\u3800\1\u3900\1\u3a00"+
    "\1\u0100\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000\3\u1f00"+
    "\1\u4100\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700\1\u4800"+
    "\1\u4900\1\u1f00\1\u4a00\1\u1f00\1\u4b00\1\u4c00\2\u1f00\3\u0100"+
    "\1\u4d00\1\u4e00\1\u4f00\12\u1f00\4\u0100\1\u5000\17\u1f00\2\u0100"+
    "\1\u5100\41\u1f00\2\u0100\1\u5200\1\u5300\3\u1f00\1\u5400\27\u0100"+
    "\1\u5500\2\u0100\1\u5600\45\u1f00\1\u0100\1\u5700\1\u5800\11\u1f00"+
    "\1\u5900\24\u1f00\1\u5a00\1\u5b00\1\u1f00\1\u5c00\1\u5d00\1\u5e00"+
    "\1\u5f00\2\u1f00\1\u6000\5\u1f00\1\u6100\7\u1f00\1\u6200\1\u6300"+
    "\4\u1f00\1\u6400\21\u1f00\246\u0100\1\u6500\20\u0100\1\u6600\1\u6700"+
    "\25\u0100\1\u6800\34\u0100\1\u6900\14\u1f00\2\u0100\1\u6a00\u0b05\u1f00"+
    "\1\u6b00\1\u6c00\u02fe\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\16\0\4\6"+
    "\1\1\1\6\1\7\1\6\1\10\2\6\1\11\1\12"+
    "\1\13\1\14\4\6\1\15\1\16\11\17\1\6\1\20"+
    "\1\21\1\22\1\23\2\6\32\10\1\6\1\24\2\6"+
    "\1\10\1\6\1\10\1\25\1\10\1\26\1\27\1\30"+
    "\1\10\1\31\1\32\2\10\1\33\1\10\1\34\1\35"+
    "\2\10\1\36\1\10\1\37\1\40\1\41\1\42\3\10"+
    "\1\43\1\6\1\44\1\6\6\0\1\45\32\0\2\6"+
    "\4\10\4\6\1\10\2\6\1\0\7\6\1\10\4\6"+
    "\1\10\5\6\27\10\1\6\37\10\1\6\u01ca\10\4\6"+
    "\14\10\16\6\5\10\7\6\1\10\1\6\1\10\21\6"+
    "\160\0\5\10\1\6\2\10\2\6\4\10\1\6\1\10"+
    "\6\6\1\10\1\6\3\10\1\6\1\10\1\6\24\10"+
    "\1\6\123\10\1\6\213\10\1\6\5\0\2\6\246\10"+
    "\1\6\46\10\2\6\1\10\7\6\47\10\7\6\1\10"+
    "\1\6\55\0\1\6\1\0\1\6\2\0\1\6\2\0"+
    "\1\6\1\0\10\6\33\10\5\6\3\10\15\6\6\0"+
    "\5\6\1\10\4\6\13\0\1\6\1\0\3\6\53\10"+
    "\37\0\4\6\2\10\1\0\143\10\1\6\1\10\10\0"+
    "\1\6\6\0\2\10\2\0\1\6\4\0\2\10\12\0"+
    "\3\10\2\6\1\10\17\6\1\0\1\10\1\0\36\10"+
    "\33\0\2\6\131\10\13\0\1\10\16\6\12\0\41\10"+
    "\11\0\2\10\4\6\1\10\5\6\26\10\4\0\1\10"+
    "\11\0\1\10\3\0\1\10\5\0\22\6\31\10\3\0"+
    "\4\6\13\10\65\6\25\10\1\6\10\10\26\6\60\0"+
    "\66\10\3\0\1\10\22\0\1\10\7\0\12\10\2\0"+
    "\2\6\12\0\1\6\20\10\3\0\1\6\10\10\2\6"+
    "\2\10\2\6\26\10\1\6\7\10\1\6\1\10\3\6"+
    "\4\10\2\6\1\0\1\10\7\0\2\6\2\0\2\6"+
    "\3\0\1\10\10\6\1\0\4\6\2\10\1\6\3\10"+
    "\2\0\2\6\12\0\4\10\7\6\2\10\4\6\3\0"+
    "\1\6\6\10\4\6\2\10\2\6\26\10\1\6\7\10"+
    "\1\6\2\10\1\6\2\10\1\6\2\10\2\6\1\0"+
    "\1\6\5\0\4\6\2\0\2\6\3\0\3\6\1\0"+
    "\7\6\4\10\1\6\1\10\7\6\14\0\3\10\1\0"+
    "\13\6\3\0\1\6\11\10\1\6\3\10\1\6\26\10"+
    "\1\6\7\10\1\6\2\10\1\6\5\10\2\6\1\0"+
    "\1\10\10\0\1\6\3\0\1\6\3\0\2\6\1\10"+
    "\17\6\2\10\2\0\2\6\12\0\1\6\1\10\7\6"+
    "\1\10\6\0\1\6\3\0\1\6\10\10\2\6\2\10"+
    "\2\6\26\10\1\6\7\10\1\6\2\10\1\6\5\10"+
    "\2\6\1\0\1\10\7\0\2\6\2\0\2\6\3\0"+
    "\10\6\2\0\4\6\2\10\1\6\3\10\2\0\2\6"+
    "\12\0\1\6\1\10\20\6\1\0\1\10\1\6\6\10"+
    "\3\6\3\10\1\6\4\10\3\6\2\10\1\6\1\10"+
    "\1\6\2\10\3\6\2\10\3\6\3\10\3\6\14\10"+
    "\4\6\5\0\3\6\3\0\1\6\4\0\2\6\1\10"+
    "\6\6\1\0\16\6\12\0\11\6\1\10\6\6\4\0"+
    "\1\6\10\10\1\6\3\10\1\6\27\10\1\6\20\10"+
    "\3\6\1\10\7\0\1\6\3\0\1\6\4\0\7\6"+
    "\2\0\1\6\3\10\5\6\2\10\2\0\2\6\12\0"+
    "\20\6\1\10\3\0\1\6\10\10\1\6\3\10\1\6"+
    "\27\10\1\6\12\10\1\6\5\10\2\6\1\0\1\10"+
    "\7\0\1\6\3\0\1\6\4\0\7\6\2\0\7\6"+
    "\1\10\1\6\2\10\2\0\2\6\12\0\1\6\2\10"+
    "\15\6\4\0\1\6\10\10\1\6\3\10\1\6\51\10"+
    "\2\0\1\10\7\0\1\6\3\0\1\6\4\0\1\10"+
    "\5\6\3\10\1\0\7\6\3\10\2\0\2\6\12\0"+
    "\12\6\6\10\2\6\2\0\1\6\22\10\3\6\30\10"+
    "\1\6\11\10\1\6\1\10\2\6\7\10\3\6\1\0"+
    "\4\6\6\0\1\6\1\0\1\6\10\0\6\6\12\0"+
    "\2\6\2\0\15\6\60\10\1\0\2\10\7\0\4\6"+
    "\10\10\10\0\1\6\12\0\47\6\2\10\1\6\1\10"+
    "\2\6\2\10\1\6\1\10\2\6\1\10\6\6\4\10"+
    "\1\6\7\10\1\6\3\10\1\6\1\10\1\6\1\10"+
    "\2\6\2\10\1\6\4\10\1\0\2\10\6\0\1\6"+
    "\2\0\1\10\2\6\5\10\1\6\1\10\1\6\6\0"+
    "\2\6\12\0\2\6\4\10\40\6\1\10\27\6\2\0"+
    "\6\6\12\0\13\6\1\0\1\6\1\0\1\6\1\0"+
    "\4\6\2\0\10\10\1\6\44\10\4\6\24\0\1\6"+
    "\2\0\5\10\13\0\1\6\44\0\11\6\1\0\71\6"+
    "\53\10\24\0\1\10\12\0\6\6\6\10\4\0\4\10"+
    "\3\0\1\10\3\0\2\10\7\0\3\10\4\0\15\10"+
    "\14\0\1\10\17\0\2\6\46\10\1\6\1\10\5\6"+
    "\1\10\2\6\53\10\1\6\115\10\1\6\4\10\2\6"+
    "\7\10\1\6\1\10\1\6\4\10\2\6\51\10\1\6"+
    "\4\10\2\6\41\10\1\6\4\10\2\6\7\10\1\6"+
    "\1\10\1\6\4\10\2\6\17\10\1\6\71\10\1\6"+
    "\4\10\2\6\103\10\2\6\3\0\40\6\20\10\20\6"+
    "\126\10\2\6\6\10\3\6\u016c\10\2\6\21\10\1\6"+
    "\32\10\5\6\113\10\3\6\13\10\7\6\15\10\1\6"+
    "\4\10\3\0\13\6\22\10\3\0\13\6\22\10\2\0"+
    "\14\6\15\10\1\6\3\10\1\6\2\0\14\6\64\10"+
    "\40\0\3\6\1\10\3\6\2\10\1\0\2\6\12\0"+
    "\41\6\4\0\1\6\12\0\6\6\130\10\10\6\5\10"+
    "\2\0\42\10\1\0\1\10\5\6\106\10\12\6\37\10"+
    "\1\6\14\0\4\6\14\0\12\6\12\0\36\10\2\6"+
    "\5\10\13\6\54\10\4\6\32\10\6\6\12\0\46\6"+
    "\27\10\5\0\4\6\65\10\12\0\1\6\35\0\2\6"+
    "\13\0\6\6\12\0\15\6\1\10\10\6\16\0\102\6"+
    "\5\0\57\10\21\0\7\10\4\6\12\0\21\6\11\0"+
    "\14\6\3\0\36\10\15\0\2\10\12\0\54\10\16\0"+
    "\14\6\44\10\24\0\10\6\12\0\3\6\3\10\12\0"+
    "\44\10\2\6\11\10\107\6\3\0\1\6\25\0\4\10"+
    "\1\0\4\10\3\0\2\10\3\0\6\6\300\10\72\0"+
    "\1\6\5\0\26\10\2\6\6\10\2\6\46\10\2\6"+
    "\6\10\2\6\10\10\1\6\1\10\1\6\1\10\1\6"+
    "\1\10\1\6\37\10\2\6\65\10\1\6\7\10\1\6"+
    "\1\10\3\6\3\10\1\6\7\10\3\6\4\10\2\6"+
    "\6\10\4\6\15\10\5\6\3\10\1\6\7\10\16\6"+
    "\5\0\30\6\2\3\5\0\20\6\2\10\23\6\1\10"+
    "\13\6\5\0\1\6\12\0\1\6\1\10\15\6\1\10"+
    "\20\6\15\10\3\6\40\10\20\6\15\0\4\6\1\0"+
    "\3\6\14\0\21\6\1\10\4\6\1\10\2\6\12\10"+
    "\1\6\1\10\3\6\5\10\6\6\1\10\1\6\1\10"+
    "\1\6\1\10\1\6\4\10\1\6\13\10\2\6\4\10"+
    "\5\6\5\10\4\6\1\10\21\6\51\10\u0177\6\57\10"+
    "\1\6\57\10\1\6\205\10\6\6\4\10\3\0\2\10"+
    "\14\6\46\10\1\6\1\10\5\6\1\10\2\6\70\10"+
    "\7\6\1\10\17\6\1\0\27\10\11\6\7\10\1\6"+
    "\7\10\1\6\7\10\1\6\7\10\1\6\7\10\1\6"+
    "\7\10\1\6\7\10\1\6\7\10\1\6\40\0\57\6"+
    "\1\10\325\6\3\10\31\6\11\10\6\0\1\6\5\10"+
    "\2\6\5\10\4\6\126\10\2\6\2\0\2\6\3\10"+
    "\1\6\132\10\1\6\4\10\5\6\52\10\2\6\136\10"+
    "\21\6\33\10\65\6\306\10\112\6\353\10\25\6\215\10"+
    "\103\6\56\10\2\6\15\10\3\6\20\10\12\0\2\10"+
    "\24\6\57\10\1\0\4\6\12\0\1\6\37\10\2\0"+
    "\120\10\2\0\45\6\11\10\2\6\147\10\2\6\44\10"+
    "\1\6\10\10\77\6\13\10\1\0\3\10\1\0\4\10"+
    "\1\0\27\10\5\0\20\6\1\10\7\6\64\10\14\6"+
    "\2\0\62\10\22\0\12\6\12\0\6\6\22\0\6\10"+
    "\3\6\1\10\1\6\1\10\2\6\12\0\34\10\10\0"+
    "\2\6\27\10\15\0\14\6\35\10\3\6\4\0\57\10"+
    "\16\0\16\6\1\10\12\0\6\6\5\10\1\0\12\10"+
    "\12\0\5\10\1\6\51\10\16\0\11\6\3\10\1\0"+
    "\10\10\2\0\2\6\12\0\6\6\27\10\3\6\1\10"+
    "\3\0\62\10\1\0\1\10\3\0\2\10\2\0\5\10"+
    "\2\0\1\10\1\0\1\10\30\6\3\10\2\6\13\10"+
    "\5\0\2\6\3\10\2\0\12\6\6\10\2\6\6\10"+
    "\2\6\6\10\11\6\7\10\1\6\7\10\1\6\53\10"+
    "\1\6\12\10\12\6\163\10\10\0\1\6\2\0\2\6"+
    "\12\0\6\6\244\10\14\6\27\10\4\6\61\10\4\6"+
    "\u0100\3\156\10\2\6\152\10\46\6\7\10\14\6\5\10"+
    "\5\6\1\10\1\0\12\10\1\6\15\10\1\6\5\10"+
    "\1\6\1\10\1\6\2\10\1\6\2\10\1\6\154\10"+
    "\41\6\153\10\22\6\100\10\2\6\66\10\50\6\15\10"+
    "\3\6\20\0\20\6\20\0\3\6\2\10\30\6\3\10"+
    "\31\6\1\10\6\6\5\10\1\6\207\10\2\6\1\0"+
    "\4\6\1\10\13\6\12\0\7\6\32\10\4\6\1\10"+
    "\1\6\32\10\13\6\131\10\3\6\6\10\2\6\6\10"+
    "\2\6\6\10\2\6\3\10\3\6\2\10\3\6\2\10"+
    "\22\6\3\0\4\6\14\10\1\6\32\10\1\6\23\10"+
    "\1\6\2\10\1\6\17\10\2\6\16\10\42\6\173\10"+
    "\105\6\65\10\210\6\1\0\202\6\35\10\3\6\61\10"+
    "\17\6\1\0\37\6\40\10\15\6\36\10\5\6\46\10"+
    "\5\0\5\6\36\10\2\6\44\10\4\6\10\10\1\6"+
    "\5\10\52\6\236\10\2\6\12\0\6\6\44\10\4\6"+
    "\44\10\4\6\50\10\10\6\64\10\234\6\67\10\11\6"+
    "\26\10\12\6\10\10\230\6\6\10\2\6\1\10\1\6"+
    "\54\10\1\6\2\10\3\6\1\10\2\6\27\10\12\6"+
    "\27\10\11\6\37\10\101\6\23\10\1\6\2\10\12\6"+
    "\26\10\12\6\32\10\106\6\70\10\6\6\2\10\100\6"+
    "\1\10\3\0\1\6\2\0\5\6\4\0\4\10\1\6"+
    "\3\10\1\6\33\10\4\6\3\0\4\6\1\0\40\6"+
    "\35\10\3\6\35\10\43\6\10\10\1\6\34\10\2\0"+
    "\31\6\66\10\12\6\26\10\12\6\23\10\15\6\22\10"+
    "\156\6\111\10\67\6\63\10\15\6\63\10\15\6\3\0"+
    "\65\10\17\0\37\6\12\0\17\6\4\0\55\10\13\0"+
    "\2\6\1\0\22\6\31\10\7\6\12\0\6\6\3\0"+
    "\44\10\16\0\1\6\12\0\20\6\43\10\1\0\2\6"+
    "\1\10\11\6\3\0\60\10\16\0\4\10\5\6\3\0"+
    "\3\6\12\0\1\10\1\6\1\10\43\6\22\10\1\6"+
    "\31\10\14\0\6\6\1\0\101\6\7\10\1\6\1\10"+
    "\1\6\4\10\1\6\17\10\1\6\12\10\7\6\57\10"+
    "\14\0\5\6\12\0\6\6\4\0\1\6\10\10\2\6"+
    "\2\10\2\6\26\10\1\6\7\10\1\6\2\10\1\6"+
    "\5\10\2\6\1\0\1\10\7\0\2\6\2\0\2\6"+
    "\3\0\2\6\1\10\6\6\1\0\5\6\5\10\2\0"+
    "\2\6\7\0\3\6\5\0\213\6\65\10\22\0\4\10"+
    "\5\6\12\0\46\6\60\10\24\0\2\10\1\6\1\10"+
    "\10\6\12\0\246\6\57\10\7\0\2\6\11\0\27\6"+
    "\4\10\2\0\42\6\60\10\21\0\3\6\1\10\13\6"+
    "\12\0\46\6\53\10\15\0\10\6\12\0\66\6\32\10"+
    "\3\6\17\0\4\6\12\0\u0166\6\100\10\12\0\25\6"+
    "\2\10\12\0\50\10\7\0\1\10\4\0\10\6\1\0"+
    "\10\6\1\10\13\0\50\10\2\6\4\10\20\0\46\6"+
    "\71\10\7\6\11\10\1\6\45\10\10\0\1\6\10\0"+
    "\1\10\17\6\12\0\30\6\36\10\2\6\26\0\1\6"+
    "\16\0\111\6\7\10\1\6\2\10\1\6\46\10\6\0"+
    "\3\6\1\0\1\6\2\0\1\6\7\0\1\10\1\0"+
    "\10\6\12\0\246\6\232\10\146\6\157\10\21\6\304\10"+
    "\274\6\57\10\321\6\107\10\271\6\71\10\7\6\37\10"+
    "\1\6\12\0\146\6\36\10\2\6\5\0\13\6\60\10"+
    "\7\0\11\6\4\10\14\6\12\0\11\6\25\10\5\6"+
    "\23\10\160\6\105\10\13\6\1\10\56\0\20\6\4\0"+
    "\15\10\100\6\2\10\36\6\355\10\23\6\363\10\15\6"+
    "\37\10\121\6\u018c\10\4\6\153\10\5\6\15\10\3\6"+
    "\11\10\7\6\12\10\3\6\2\0\1\6\4\0\301\6"+
    "\5\0\3\6\26\0\2\6\7\0\36\6\4\0\224\6"+
    "\3\0\273\6\125\10\1\6\107\10\1\6\2\10\2\6"+
    "\1\10\2\6\2\10\2\6\4\10\1\6\14\10\1\6"+
    "\1\10\1\6\7\10\1\6\101\10\1\6\4\10\2\6"+
    "\10\10\1\6\7\10\1\6\34\10\1\6\4\10\1\6"+
    "\5\10\1\6\1\10\3\6\7\10\1\6\u0154\10\2\6"+
    "\31\10\1\6\31\10\1\6\37\10\1\6\31\10\1\6"+
    "\37\10\1\6\31\10\1\6\37\10\1\6\31\10\1\6"+
    "\37\10\1\6\31\10\1\6\10\10\2\6\151\0\4\6"+
    "\62\0\10\6\1\0\16\6\1\0\26\6\5\0\1\6"+
    "\17\0\120\6\7\0\1\6\21\0\2\6\7\0\1\6"+
    "\2\0\1\6\5\0\325\6\305\10\13\6\7\0\51\6"+
    "\104\10\7\0\5\6\12\0\246\6\4\10\1\6\33\10"+
    "\1\6\2\10\1\6\1\10\2\6\1\10\1\6\12\10"+
    "\1\6\4\10\1\6\1\10\1\6\1\10\6\6\1\10"+
    "\4\6\1\10\1\6\1\10\1\6\1\10\1\6\3\10"+
    "\1\6\2\10\1\6\1\10\2\6\1\10\1\6\1\10"+
    "\1\6\1\10\1\6\1\10\1\6\1\10\1\6\2\10"+
    "\1\6\1\10\2\6\4\10\1\6\7\10\1\6\4\10"+
    "\1\6\4\10\1\6\1\10\1\6\12\10\1\6\21\10"+
    "\5\6\3\10\1\6\5\10\1\6\21\10\104\6\327\10"+
    "\51\6\65\10\13\6\336\10\2\6\u0182\10\16\6\u0131\10"+
    "\37\6\36\10\343\6\1\0\36\6\140\0\200\6\360\0"+
    "\20\6";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[27904];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\1\2\10\1\11\1\12\1\13\1\14\6\4\1\15"+
    "\1\16\1\17\2\20\1\21\2\1\2\22\1\1\1\0"+
    "\1\2\1\23\1\4\1\24\3\4\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\10\25"+
    "\1\0\1\37\3\4\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\4\1\52";

  private static int [] zzUnpackAction() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\162\0\230\0\162\0\276"+
    "\0\162\0\162\0\162\0\344\0\162\0\u010a\0\162\0\162"+
    "\0\162\0\162\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee"+
    "\0\162\0\162\0\u0214\0\162\0\u023a\0\162\0\u0260\0\u0286"+
    "\0\162\0\u02ac\0\u02d2\0\u02f8\0\u031e\0\276\0\u0344\0\276"+
    "\0\u036a\0\u0390\0\u03b6\0\162\0\162\0\162\0\162\0\162"+
    "\0\162\0\162\0\162\0\162\0\162\0\u03dc\0\u0402\0\u0428"+
    "\0\u044e\0\u0474\0\u049a\0\u04c0\0\u04e6\0\u050c\0\276\0\u0532"+
    "\0\u0558\0\u057e\0\162\0\162\0\162\0\162\0\162\0\162"+
    "\0\162\0\162\0\276\0\276\0\u05a4\0\276";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\4\1\5\1\6\1\4\1\7\1\10"+
    "\1\11\1\12\1\13\1\4\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\4\1\10\1\23\1\10\1\24"+
    "\1\10\1\25\1\10\1\26\4\10\1\27\1\30\1\31"+
    "\1\32\1\4\2\33\1\34\2\33\1\35\1\33\1\36"+
    "\14\33\1\37\21\33\2\40\1\41\2\40\1\42\3\40"+
    "\1\4\12\40\1\43\21\40\50\0\1\5\43\0\1\10"+
    "\7\0\1\10\5\0\2\10\5\0\16\10\2\0\1\10"+
    "\14\0\1\44\1\45\46\0\2\16\26\0\1\10\7\0"+
    "\1\10\5\0\2\10\5\0\10\10\1\46\5\10\2\0"+
    "\2\10\7\0\1\10\5\0\2\10\5\0\10\10\1\47"+
    "\5\10\2\0\2\10\7\0\1\10\5\0\2\10\5\0"+
    "\3\10\1\50\12\10\2\0\2\10\7\0\1\10\5\0"+
    "\2\10\5\0\13\10\1\51\2\10\2\0\2\10\7\0"+
    "\1\10\5\0\2\10\5\0\10\10\1\52\5\10\2\0"+
    "\2\10\7\0\1\10\5\0\2\10\5\0\4\10\1\53"+
    "\11\10\2\0\1\10\2\33\1\0\2\33\1\0\1\33"+
    "\1\0\14\33\1\0\21\33\2\0\1\34\43\0\2\54"+
    "\4\0\1\54\1\55\1\54\1\56\12\54\1\57\1\60"+
    "\2\54\1\61\3\54\1\62\1\54\1\63\1\64\5\54"+
    "\12\0\1\65\36\0\1\41\43\0\2\54\4\0\1\54"+
    "\1\66\1\54\1\67\12\54\1\70\1\71\2\54\1\72"+
    "\3\54\1\73\1\54\1\74\1\75\5\54\1\0\14\44"+
    "\1\76\31\44\2\45\1\5\2\45\1\6\40\45\1\10"+
    "\7\0\1\10\5\0\2\10\5\0\11\10\1\77\4\10"+
    "\2\0\2\10\7\0\1\10\5\0\2\10\5\0\6\10"+
    "\1\100\7\10\2\0\2\10\7\0\1\10\5\0\2\10"+
    "\5\0\5\10\1\101\10\10\2\0\2\10\7\0\1\10"+
    "\5\0\2\10\5\0\5\10\1\102\10\10\2\0\1\10"+
    "\11\0\1\103\45\0\1\104\45\0\1\105\45\0\1\106"+
    "\45\0\1\107\45\0\1\110\45\0\1\111\45\0\1\112"+
    "\34\0\14\44\1\76\1\5\30\44\1\10\7\0\1\10"+
    "\5\0\2\10\5\0\6\10\1\113\7\10\2\0\2\10"+
    "\7\0\1\10\5\0\2\10\5\0\1\10\1\114\14\10"+
    "\2\0\2\10\7\0\1\10\5\0\2\10\5\0\6\10"+
    "\1\115\7\10\2\0\2\10\7\0\1\10\5\0\2\10"+
    "\5\0\2\10\1\116\13\10\2\0\1\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1482];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\2\11\1\1\1\11\1\1\3\11\1\1\1\11"+
    "\1\1\4\11\6\1\2\11\1\1\1\11\1\1\1\11"+
    "\2\1\1\11\2\1\1\0\7\1\12\11\10\1\1\0"+
    "\4\1\10\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  /** 
   * assumes correct representation of a long value for 
   * specified radix in scanner buffer from <code>start</code> 
   * to <code>end</code> 
   */
  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i),radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn);
            }
            // fall through
          case 43: break;
          case 2:
            { /* ignore */
            }
            // fall through
          case 44: break;
          case 3:
            { yybegin(STRING); string.setLength(0);
            }
            // fall through
          case 45: break;
          case 4:
            { return symbol(IDENTIFIER, yytext());
            }
            // fall through
          case 46: break;
          case 5:
            { yybegin(CHARLITERAL);
            }
            // fall through
          case 47: break;
          case 6:
            { return symbol(LPAREN);
            }
            // fall through
          case 48: break;
          case 7:
            { return symbol(RPAREN);
            }
            // fall through
          case 49: break;
          case 8:
            { return symbol(INTEGER, Integer.valueOf(yytext()));
            }
            // fall through
          case 50: break;
          case 9:
            { return symbol(SEMICOLON);
            }
            // fall through
          case 51: break;
          case 10:
            { return symbol(LT);
            }
            // fall through
          case 52: break;
          case 11:
            { return symbol(EQ);
            }
            // fall through
          case 53: break;
          case 12:
            { return symbol(GT);
            }
            // fall through
          case 54: break;
          case 13:
            { return symbol(LBRACE);
            }
            // fall through
          case 55: break;
          case 14:
            { return symbol(RBRACE);
            }
            // fall through
          case 56: break;
          case 15:
            { string.append( yytext() );
            }
            // fall through
          case 57: break;
          case 16:
            { throw new RuntimeException("Unterminated string at end of line");
            }
            // fall through
          case 58: break;
          case 17:
            { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString());
            }
            // fall through
          case 59: break;
          case 18:
            { throw new RuntimeException("Unterminated character literal at end of line");
            }
            // fall through
          case 60: break;
          case 19:
            { return symbol(DO);
            }
            // fall through
          case 61: break;
          case 20:
            { return symbol(IF);
            }
            // fall through
          case 62: break;
          case 21:
            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
            }
            // fall through
          case 63: break;
          case 22:
            { string.append( '\"' );
            }
            // fall through
          case 64: break;
          case 23:
            { string.append( '\'' );
            }
            // fall through
          case 65: break;
          case 24:
            { string.append( '\\' );
            }
            // fall through
          case 66: break;
          case 25:
            { string.append( '\b' );
            }
            // fall through
          case 67: break;
          case 26:
            { string.append( '\f' );
            }
            // fall through
          case 68: break;
          case 27:
            { string.append( '\n' );
            }
            // fall through
          case 69: break;
          case 28:
            { string.append( '\r' );
            }
            // fall through
          case 70: break;
          case 29:
            { string.append( '\t' );
            }
            // fall through
          case 71: break;
          case 30:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, yytext().charAt(0));
            }
            // fall through
          case 72: break;
          case 31:
            { return symbol(FOR);
            }
            // fall through
          case 73: break;
          case 32:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\"');
            }
            // fall through
          case 74: break;
          case 33:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\'');
            }
            // fall through
          case 75: break;
          case 34:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\\');
            }
            // fall through
          case 76: break;
          case 35:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\b');
            }
            // fall through
          case 77: break;
          case 36:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\f');
            }
            // fall through
          case 78: break;
          case 37:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\n');
            }
            // fall through
          case 79: break;
          case 38:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\r');
            }
            // fall through
          case 80: break;
          case 39:
            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, '\t');
            }
            // fall through
          case 81: break;
          case 40:
            { return symbol(NULL_LITERAL);
            }
            // fall through
          case 82: break;
          case 41:
            { return symbol(VOID);
            }
            // fall through
          case 83: break;
          case 42:
            { return symbol(WHILE);
            }
            // fall through
          case 84: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   */
  private static String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java Scanner [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Scanner scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Scanner(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}

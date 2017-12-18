/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ksplabs.sveet.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author kpankov
 */
public class SVLanguageHierarchy extends LanguageHierarchy<SVTokenId> {

    private static List<SVTokenId> tokens;
    private static Map<Integer, SVTokenId> idToToken;

    private static void init() {
        tokens = Arrays.asList(new SVTokenId[]{
            new SVTokenId("EOF", "whitespace", 0),
            new SVTokenId("WHITESPACE", "whitespace", 1),
            new SVTokenId("IN_MULTI_LINE_COMMENT", "comment", 2),
            new SVTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new SVTokenId("FORMAL_COMMENT", "comment", 5),
            new SVTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new SVTokenId("ALIAS", "keyword", 8),
            new SVTokenId("ALWAYS", "keyword", 9),
            new SVTokenId("ALWAYS_COMB", "keyword", 10),
            new SVTokenId("ALWAYS_FF", "keyword", 11),
            new SVTokenId("ALWAYS_LATCH", "keyword", 12),
            new SVTokenId("AND", "keyword", 13),
            new SVTokenId("ASSERT", "keyword", 14),
            new SVTokenId("ASSIGN", "keyword", 15),
            new SVTokenId("ASSUME", "keyword", 16),
            new SVTokenId("AUTOMATIC", "keyword", 17),
            new SVTokenId("BEFORE", "keyword", 18),
            new SVTokenId("BEGIN", "block", 19),
            new SVTokenId("BIND", "keyword", 20),
            new SVTokenId("BINS", "keyword", 21),
            new SVTokenId("BINSOF", "keyword", 22),
            new SVTokenId("BIT", "keyword", 23),
            new SVTokenId("BREAK", "keyword", 24),
            new SVTokenId("BUF", "keyword", 25),
            new SVTokenId("BUFIF0", "keyword", 26),
            new SVTokenId("BUFIF1", "keyword", 27),
            new SVTokenId("BYTE", "keyword", 28),
            new SVTokenId("CASE", "keyword", 29),
            new SVTokenId("CASEX", "keyword", 30),
            new SVTokenId("CASEZ", "keyword", 31),
            new SVTokenId("CELL", "keyword", 32),
            new SVTokenId("CHANDLE", "keyword", 33),
            new SVTokenId("CLASS", "keyword", 34),
            new SVTokenId("CLOCKING", "keyword", 35),
            new SVTokenId("CMOS", "keyword", 36),
            new SVTokenId("CONFIG", "keyword", 37),
            new SVTokenId("CONST", "keyword", 38),
            new SVTokenId("CONSTRAINT", "keyword", 39),
            new SVTokenId("CONTEXT", "keyword", 40),
            new SVTokenId("CONTINUE", "keyword", 41),
            new SVTokenId("COVER", "keyword", 42),
            new SVTokenId("COVERGROUP", "keyword", 43),
            new SVTokenId("COVERPOINT", "keyword", 44),
            new SVTokenId("CROSS", "keyword", 45),
            new SVTokenId("DEASSIGN", "keyword", 46),
            new SVTokenId("DEFAULT_WORD", "keyword", 47),
            new SVTokenId("DEFPARAM", "keyword", 48),
            new SVTokenId("DESIGN", "keyword", 49),
            new SVTokenId("DISABLE", "keyword", 50),
            new SVTokenId("DIST", "keyword", 51),
            new SVTokenId("DO", "keyword", 52),
            new SVTokenId("EDGE", "keyword", 53),
            new SVTokenId("ELSE", "keyword", 54),
            new SVTokenId("END", "block", 55),
            new SVTokenId("ENDCASE", "keyword", 56),
            new SVTokenId("ENDCLASS", "keyword", 57),
            new SVTokenId("ENDCLOCKING", "keyword", 58),
            new SVTokenId("ENDCONFIG", "keyword", 59),
            new SVTokenId("ENDFUNCTION", "keyword", 60),
            new SVTokenId("ENDGENERATE", "keyword", 61),
            new SVTokenId("ENDGROUP", "keyword", 62),
            new SVTokenId("ENDINTERFACE", "keyword", 63),
            new SVTokenId("ENDMODULE", "keyword", 64),
            new SVTokenId("ENDPACKAGE", "keyword", 65),
            new SVTokenId("ENDPRIMITIVE", "keyword", 66),
            new SVTokenId("ENDPROGRAM", "keyword", 67),
            new SVTokenId("ENDPROPERTY", "keyword", 68),
            new SVTokenId("ENDSEQUENCE", "keyword", 69),
            new SVTokenId("ENDSPECIFY", "keyword", 70),
            new SVTokenId("ENDTABLE", "keyword", 71),
            new SVTokenId("ENDTASK", "keyword", 72),
            new SVTokenId("ENUM", "keyword", 73),
            new SVTokenId("EVENT", "keyword", 74),
            new SVTokenId("EXPECT", "keyword", 75),
            new SVTokenId("EXPORT", "keyword", 76),
            new SVTokenId("EXTENDS", "keyword", 77),
            new SVTokenId("EXTERN", "keyword", 78),
            new SVTokenId("FINAL", "keyword", 79),
            new SVTokenId("FIRST_MATCH", "keyword", 80),
            new SVTokenId("FOR", "keyword", 81),
            new SVTokenId("FORCE", "keyword", 82),
            new SVTokenId("FOREACH", "keyword", 83),
            new SVTokenId("FOREVER", "keyword", 84),
            new SVTokenId("FORK", "keyword", 85),
            new SVTokenId("FORKJOIN", "keyword", 86),
            new SVTokenId("FUNCTION", "keyword", 87),
            new SVTokenId("GENERATE", "keyword", 88),
            new SVTokenId("GENVAR", "keyword", 89),
            new SVTokenId("HIGHZ0", "keyword", 90),
            new SVTokenId("HIGHZ1", "keyword", 91),
            new SVTokenId("IF", "keyword", 92),
            new SVTokenId("IFF", "keyword", 93),
            new SVTokenId("IFNONE", "keyword", 94),
            new SVTokenId("IGNORE_BINS", "keyword", 95),
            new SVTokenId("ILLEGAL_BINS", "keyword", 96),
            new SVTokenId("IMPORT", "keyword", 97),
            new SVTokenId("INCDIR", "keyword", 98),
            new SVTokenId("INCLUDE", "keyword", 99),
            new SVTokenId("INITIAL", "keyword", 100),
            new SVTokenId("INOUT", "keyword", 101),
            new SVTokenId("INPUT", "keyword", 102),
            new SVTokenId("INSIDE", "keyword", 103),
            new SVTokenId("INSTANCE", "keyword", 104),
            new SVTokenId("INT", "keyword", 105),
            new SVTokenId("INTEGER", "keyword", 106),
            new SVTokenId("INTERFACE", "keyword", 107),
            new SVTokenId("INTERSECT", "keyword", 108),
            new SVTokenId("JOIN", "keyword", 109),
            new SVTokenId("JOIN_ANY", "keyword", 110),
            new SVTokenId("JOIN_NONE", "keyword", 111),
            new SVTokenId("LARGE", "keyword", 112),
            new SVTokenId("LIBLIST", "keyword", 113),
            new SVTokenId("LIBRARY", "keyword", 114),
            new SVTokenId("LOCAL", "keyword", 115),
            new SVTokenId("LOCALPARAM", "keyword", 116),
            new SVTokenId("LOGIC", "keyword", 117),
            new SVTokenId("LONGINT", "keyword", 118),
            new SVTokenId("MACROMODULE", "keyword", 119),
            new SVTokenId("MATCHES", "keyword", 120),
            new SVTokenId("MEDIUM", "keyword", 121),
            new SVTokenId("MODPORT", "keyword", 122),
            new SVTokenId("MODULE", "special", 123),
            new SVTokenId("NAND", "keyword", 124),
            new SVTokenId("NEGEDGE", "keyword", 125),
            new SVTokenId("NEW", "keyword", 126),
            new SVTokenId("NMOS", "keyword", 127),
            new SVTokenId("NOR", "keyword", 128),
            new SVTokenId("NOSHOWCANCELLED", "keyword", 129),
            new SVTokenId("NOT", "keyword", 130),
            new SVTokenId("NOTIF0", "keyword", 131),
            new SVTokenId("NOTIF1", "keyword", 132),
            new SVTokenId("NULL", "keyword", 133),
            new SVTokenId("OR", "keyword", 134),
            new SVTokenId("OUTPUT", "keyword", 135),
            new SVTokenId("PACKAGE", "keyword", 136),
            new SVTokenId("PACKED", "keyword", 137),
            new SVTokenId("PARAMETER", "keyword", 138),
            new SVTokenId("PMOS", "keyword", 139),
            new SVTokenId("POSEDGE", "keyword", 140),
            new SVTokenId("PRIMITIVE", "keyword", 141),
            new SVTokenId("PRIORITY", "keyword", 142),
            new SVTokenId("PROGRAM", "keyword", 143),
            new SVTokenId("PROPERTY", "keyword", 144),
            new SVTokenId("PROTECTED", "keyword", 145),
            new SVTokenId("PULL0", "keyword", 146),
            new SVTokenId("PULL1", "keyword", 147),
            new SVTokenId("PULLDOWN", "keyword", 148),
            new SVTokenId("PULLUP", "keyword", 149),
            new SVTokenId("PULSESTYLE_ONDETECT", "keyword", 150),
            new SVTokenId("PULSESTYLE_ONEVENT", "keyword", 151),
            new SVTokenId("PURE", "keyword", 152),
            new SVTokenId("RAND", "keyword", 153),
            new SVTokenId("RANDC", "keyword", 154),
            new SVTokenId("RANDCASE", "keyword", 155),
            new SVTokenId("RANDSEQUENCE", "keyword", 156),
            new SVTokenId("RCMOS", "keyword", 157),
            new SVTokenId("REAL", "keyword", 158),
            new SVTokenId("REALTIME", "keyword", 159),
            new SVTokenId("REF", "keyword", 160),
            new SVTokenId("REG", "keyword", 161),
            new SVTokenId("RELEASE", "keyword", 162),
            new SVTokenId("REPEAT", "keyword", 163),
            new SVTokenId("RETURN", "keyword", 164),
            new SVTokenId("RNMOS", "keyword", 165),
            new SVTokenId("RPMOS", "keyword", 166),
            new SVTokenId("RTRAN", "keyword", 167),
            new SVTokenId("RTRANIF0", "keyword", 168),
            new SVTokenId("RTRANIF1", "keyword", 169),
            new SVTokenId("SCALARED", "keyword", 170),
            new SVTokenId("SEQUENCE", "keyword", 171),
            new SVTokenId("SHORTINT", "keyword", 172),
            new SVTokenId("SHORTREAL", "keyword", 173),
            new SVTokenId("SHOWCANCELLED", "keyword", 174),
            new SVTokenId("SIGNED", "keyword", 175),
            new SVTokenId("SMALL", "keyword", 176),
            new SVTokenId("SOLVE", "keyword", 177),
            new SVTokenId("SPECIFY", "keyword", 178),
            new SVTokenId("SPECPARAM", "keyword", 179),
            new SVTokenId("STATIC", "keyword", 180),
            new SVTokenId("STRING", "keyword", 181),
            new SVTokenId("STRONG0", "keyword", 182),
            new SVTokenId("STRONG1", "keyword", 183),
            new SVTokenId("STRUCT", "keyword", 184),
            new SVTokenId("SUPER", "keyword", 185),
            new SVTokenId("SUPPLY0", "keyword", 186),
            new SVTokenId("SUPPLY1", "keyword", 187),
            new SVTokenId("TABLE", "keyword", 188),
            new SVTokenId("TAGGED", "keyword", 189),
            new SVTokenId("TASK", "keyword", 190),
            new SVTokenId("THIS", "keyword", 191),
            new SVTokenId("THROUGHOUT", "keyword", 192),
            new SVTokenId("TIME", "keyword", 193),
            new SVTokenId("TIMEPRECISION", "keyword", 194),
            new SVTokenId("TIMEUNIT", "keyword", 195),
            new SVTokenId("TRAN", "keyword", 196),
            new SVTokenId("TRANIF0", "keyword", 197),
            new SVTokenId("TRANIF1", "keyword", 198),
            new SVTokenId("TRI", "keyword", 199),
            new SVTokenId("TRI0", "keyword", 200),
            new SVTokenId("TRI1", "keyword", 201),
            new SVTokenId("TRIAND", "keyword", 202),
            new SVTokenId("TRIOR", "keyword", 203),
            new SVTokenId("TRIREG", "keyword", 204),
            new SVTokenId("TYPE", "keyword", 205),
            new SVTokenId("TYPEDEF", "keyword", 206),
            new SVTokenId("UNION", "keyword", 207),
            new SVTokenId("UNIQUE", "keyword", 208),
            new SVTokenId("UNSIGNED", "keyword", 209),
            new SVTokenId("USE", "keyword", 210),
            new SVTokenId("UWIRE", "keyword", 211),
            new SVTokenId("VAR", "keyword", 212),
            new SVTokenId("VECTORED", "keyword", 213),
            new SVTokenId("VIRTUAL", "keyword", 214),
            new SVTokenId("VOID", "keyword", 215),
            new SVTokenId("WAIT", "keyword", 216),
            new SVTokenId("WAIT_ORDER", "keyword", 217),
            new SVTokenId("WAND", "keyword", 218),
            new SVTokenId("WEAK0", "keyword", 219),
            new SVTokenId("WEAK1", "keyword", 220),
            new SVTokenId("WHILE", "keyword", 221),
            new SVTokenId("WILDCARD", "keyword", 222),
            new SVTokenId("WIRE", "keyword", 223),
            new SVTokenId("WITH", "keyword", 224),
            new SVTokenId("WITHIN", "keyword", 225),
            new SVTokenId("WOR", "keyword", 226),
            new SVTokenId("XNOR", "keyword", 227),
            new SVTokenId("XOR", "keyword", 228),
            new SVTokenId("INTEGER_LITERAL", "number", 229),
            new SVTokenId("DECIMAL_LITERAL", "number", 230),
            new SVTokenId("HEX_LITERAL", "number", 231),
            new SVTokenId("OCTAL_LITERAL", "number", 232),
            new SVTokenId("BINARY_LITERAL", "number", 233),
            new SVTokenId("FLOATING_POINT_LITERAL", "number", 234),
            new SVTokenId("DECIMAL_FLOATING_POINT_LITERAL", "number", 235),
            new SVTokenId("DECIMAL_EXPONENT", "number", 236),
            new SVTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "number", 237),
            new SVTokenId("HEXADECIMAL_EXPONENT", "number", 238),
            new SVTokenId("CHARACTER_LITERAL", "string", 239),
            new SVTokenId("STRING_LITERAL", "string", 240),
            new SVTokenId("IDENTIFIER", "identifier", 241),
            new SVTokenId("LETTER", "string", 242),
            new SVTokenId("PART_LETTER", "string", 243),
            new SVTokenId("LPAREN", "separator", 244),
            new SVTokenId("RPAREN", "separator", 245),
            new SVTokenId("LBRACE", "separator", 246),
            new SVTokenId("RBRACE", "separator", 247),
            new SVTokenId("LBRACKET", "separator", 248),
            new SVTokenId("RBRACKET", "separator", 249),
            new SVTokenId("SEMICOLON", "separator", 250),
            new SVTokenId("COMMA", "separator", 251),
            new SVTokenId("DOT", "separator", 252),
            new SVTokenId("AT", "special", 253),
            new SVTokenId("BLOCKINGASSIGN", "operator", 254),
            new SVTokenId("NONBLOCKINGASSIGN", "operator", 255),
            new SVTokenId("LT", "operator", 256),
            new SVTokenId("BANG", "operator", 257),
            new SVTokenId("TILDE", "operator", 258),
            new SVTokenId("HOOK", "operator", 259),
            new SVTokenId("COLON", "operator", 260),
            new SVTokenId("EQ", "operator", 261),
            new SVTokenId("LE", "operator", 262),
            new SVTokenId("GE", "operator", 263),
            new SVTokenId("NE", "operator", 264),
            new SVTokenId("SC_OR", "operator", 265),
            new SVTokenId("SC_AND", "operator", 266),
            new SVTokenId("INCR", "operator", 267),
            new SVTokenId("DECR", "operator", 268),
            new SVTokenId("PLUS", "operator", 269),
            new SVTokenId("MINUS", "operator", 270),
            new SVTokenId("STAR", "operator", 271),
            new SVTokenId("SLASH", "operator", 272),
            new SVTokenId("BIT_AND", "operator", 273),
            new SVTokenId("BIT_OR", "operator", 274),
            new SVTokenId("BIT_XOR", "operator", 275),
            new SVTokenId("REM", "operator", 276),
            new SVTokenId("LSHIFT", "operator", 277),
            new SVTokenId("PLUSASSIGN", "operator", 278),
            new SVTokenId("MINUSASSIGN", "operator", 279),
            new SVTokenId("STARASSIGN", "operator", 280),
            new SVTokenId("SLASHASSIGN", "operator", 281),
            new SVTokenId("ANDASSIGN", "operator", 282),
            new SVTokenId("ORASSIGN", "operator", 283),
            new SVTokenId("XORASSIGN", "operator", 284),
            new SVTokenId("REMASSIGN", "operator", 285),
            new SVTokenId("LSHIFTASSIGN", "operator", 286),
            new SVTokenId("RSIGNEDSHIFTASSIGN", "operator", 287),
            new SVTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 288),
            new SVTokenId("GRAVE", "special", 289)
        });
        idToToken = new HashMap<Integer, SVTokenId>();
        for (SVTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized SVTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<SVTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<SVTokenId> createLexer(LexerRestartInfo<SVTokenId> info) {
        return new SVLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-systemverilog";
    }

}

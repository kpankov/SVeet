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
public class VerilogLanguageHierarchy extends LanguageHierarchy<VerilogTokenId> {

    private static List<VerilogTokenId> tokens;
    private static Map<Integer, VerilogTokenId> idToToken;

    private static void init() {
        tokens = Arrays.asList(new VerilogTokenId[]{
            new VerilogTokenId("EOF", "whitespace", 0),
            new VerilogTokenId("WHITESPACE", "whitespace", 1),
            new VerilogTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new VerilogTokenId("FORMAL_COMMENT", "comment", 5),
            new VerilogTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new VerilogTokenId("ABSTRACT", "keyword", 8),
            new VerilogTokenId("ASSERT", "keyword", 9),
            new VerilogTokenId("BOOLEAN", "keyword", 10),
            new VerilogTokenId("BREAK", "keyword", 11),
            new VerilogTokenId("BYTE", "keyword", 12),
            new VerilogTokenId("CASE", "keyword", 13),
            new VerilogTokenId("CATCH", "keyword", 14),
            new VerilogTokenId("CHAR", "keyword", 15),
            new VerilogTokenId("MODULE", "keyword", 16),
            new VerilogTokenId("CONST", "keyword", 17),
            new VerilogTokenId("CONTINUE", "keyword", 18),
            new VerilogTokenId("_DEFAULT", "keyword", 19),
            new VerilogTokenId("DO", "keyword", 20),
            new VerilogTokenId("DOUBLE", "keyword", 21),
            new VerilogTokenId("ELSE", "keyword", 22),
            new VerilogTokenId("ENUM", "keyword", 23),
            new VerilogTokenId("EXTENDS", "keyword", 24),
            new VerilogTokenId("FALSE", "keyword", 25),
            new VerilogTokenId("FINAL", "keyword", 26),
            new VerilogTokenId("FINALLY", "keyword", 27),
            new VerilogTokenId("FLOAT", "keyword", 28),
            new VerilogTokenId("FOR", "keyword", 29),
            new VerilogTokenId("GOTO", "keyword", 30),
            new VerilogTokenId("IF", "keyword", 31),
            new VerilogTokenId("IMPLEMENTS", "keyword", 32),
            new VerilogTokenId("IMPORT", "keyword", 33),
            new VerilogTokenId("INSTANCEOF", "keyword", 34),
            new VerilogTokenId("INT", "keyword", 35),
            new VerilogTokenId("INTERFACE", "keyword", 36),
            new VerilogTokenId("LONG", "keyword", 37),
            new VerilogTokenId("NATIVE", "keyword", 38),
            new VerilogTokenId("NEW", "keyword", 39),
            new VerilogTokenId("NULL", "keyword", 40),
            new VerilogTokenId("PACKAGE", "keyword", 41),
            new VerilogTokenId("PRIVATE", "keyword", 42),
            new VerilogTokenId("PROTECTED", "keyword", 43),
            new VerilogTokenId("PUBLIC", "keyword", 44),
            new VerilogTokenId("RETURN", "keyword", 45),
            new VerilogTokenId("SHORT", "keyword", 46),
            new VerilogTokenId("STATIC", "keyword", 47),
            new VerilogTokenId("STRICTFP", "keyword", 48),
            new VerilogTokenId("SUPER", "keyword", 49),
            new VerilogTokenId("SWITCH", "keyword", 50),
            new VerilogTokenId("SYNCHRONIZED", "keyword", 51),
            new VerilogTokenId("THIS", "keyword", 52),
            new VerilogTokenId("THROW", "keyword", 53),
            new VerilogTokenId("THROWS", "keyword", 54),
            new VerilogTokenId("TRANSIENT", "keyword", 55),
            new VerilogTokenId("TRUE", "keyword", 56),
            new VerilogTokenId("TRY", "keyword", 57),
            new VerilogTokenId("VOID", "keyword", 58),
            new VerilogTokenId("VOLATILE", "keyword", 59),
            new VerilogTokenId("WHILE", "keyword", 60),
            new VerilogTokenId("INTEGER_LITERAL", "literal", 61),
            new VerilogTokenId("DECIMAL_LITERAL", "literal", 62),
            new VerilogTokenId("HEX_LITERAL", "literal", 63),
            new VerilogTokenId("OCTAL_LITERAL", "literal", 64),
            new VerilogTokenId("FLOATING_POINT_LITERAL", "literal", 65),
            new VerilogTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 66),
            new VerilogTokenId("DECIMAL_EXPONENT", "number", 67),
            new VerilogTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 68),
            new VerilogTokenId("HEXADECIMAL_EXPONENT", "number", 69),
            new VerilogTokenId("CHARACTER_LITERAL", "literal", 70),
            new VerilogTokenId("STRING_LITERAL", "literal", 71),
            new VerilogTokenId("IDENTIFIER", "identifier", 72),
            new VerilogTokenId("LETTER", "literal", 73),
            new VerilogTokenId("PART_LETTER", "literal", 74),
            new VerilogTokenId("LPAREN", "operator", 75),
            new VerilogTokenId("RPAREN", "operator", 76),
            new VerilogTokenId("LBRACE", "operator", 77),
            new VerilogTokenId("RBRACE", "operator", 78),
            new VerilogTokenId("LBRACKET", "operator", 79),
            new VerilogTokenId("RBRACKET", "operator", 80),
            new VerilogTokenId("SEMICOLON", "operator", 81),
            new VerilogTokenId("COMMA", "operator", 82),
            new VerilogTokenId("DOT", "operator", 83),
            new VerilogTokenId("AT", "operator", 84),
            new VerilogTokenId("ASSIGN", "operator", 85),
            new VerilogTokenId("LT", "operator", 86),
            new VerilogTokenId("BANG", "operator", 87),
            new VerilogTokenId("TILDE", "operator", 88),
            new VerilogTokenId("HOOK", "operator", 89),
            new VerilogTokenId("COLON", "operator", 90),
            new VerilogTokenId("EQ", "operator", 91),
            new VerilogTokenId("LE", "operator", 92),
            new VerilogTokenId("GE", "operator", 93),
            new VerilogTokenId("NE", "operator", 94),
            new VerilogTokenId("SC_OR", "operator", 95),
            new VerilogTokenId("SC_AND", "operator", 96),
            new VerilogTokenId("INCR", "operator", 97),
            new VerilogTokenId("DECR", "operator", 98),
            new VerilogTokenId("PLUS", "operator", 99),
            new VerilogTokenId("MINUS", "operator", 100),
            new VerilogTokenId("STAR", "operator", 101),
            new VerilogTokenId("SLASH", "operator", 102),
            new VerilogTokenId("BIT_AND", "operator", 103),
            new VerilogTokenId("BIT_OR", "operator", 104),
            new VerilogTokenId("XOR", "operator", 105),
            new VerilogTokenId("REM", "operator", 106),
            new VerilogTokenId("LSHIFT", "operator", 107),
            new VerilogTokenId("PLUSASSIGN", "operator", 108),
            new VerilogTokenId("MINUSASSIGN", "operator", 109),
            new VerilogTokenId("STARASSIGN", "operator", 110),
            new VerilogTokenId("SLASHASSIGN", "operator", 111),
            new VerilogTokenId("ANDASSIGN", "operator", 112),
            new VerilogTokenId("ORASSIGN", "operator", 113),
            new VerilogTokenId("XORASSIGN", "operator", 114),
            new VerilogTokenId("REMASSIGN", "operator", 115),
            new VerilogTokenId("LSHIFTASSIGN", "operator", 116),
            new VerilogTokenId("RSIGNEDSHIFTASSIGN", "operator", 117),
            new VerilogTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 118),
            new VerilogTokenId("ELLIPSIS", "operator", 119),
            new VerilogTokenId("RUNSIGNEDSHIFT", "operator", 120),
            new VerilogTokenId("RSIGNEDSHIFT", "operator", 121),
            new VerilogTokenId("GT", "operator", 122)
        });
        idToToken = new HashMap<Integer, VerilogTokenId>();
        for (VerilogTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized VerilogTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<VerilogTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<VerilogTokenId> createLexer(LexerRestartInfo<VerilogTokenId> info) {
        return new VerilogLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-verilog";
    }

}

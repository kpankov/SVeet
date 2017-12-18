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
            new SVTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new SVTokenId("FORMAL_COMMENT", "comment", 5),
            new SVTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new SVTokenId("ABSTRACT", "keyword", 8),
            new SVTokenId("ASSERT", "keyword", 9),
            new SVTokenId("BOOLEAN", "keyword", 10),
            new SVTokenId("BREAK", "keyword", 11),
            new SVTokenId("BYTE", "keyword", 12),
            new SVTokenId("CASE", "keyword", 13),
            new SVTokenId("CATCH", "keyword", 14),
            new SVTokenId("CHAR", "keyword", 15),
            new SVTokenId("MODULE", "keyword", 16),
            new SVTokenId("CONST", "keyword", 17),
            new SVTokenId("CONTINUE", "keyword", 18),
            new SVTokenId("_DEFAULT", "keyword", 19),
            new SVTokenId("DO", "keyword", 20),
            new SVTokenId("DOUBLE", "keyword", 21),
            new SVTokenId("ELSE", "keyword", 22),
            new SVTokenId("ENUM", "keyword", 23),
            new SVTokenId("EXTENDS", "keyword", 24),
            new SVTokenId("FALSE", "keyword", 25),
            new SVTokenId("FINAL", "keyword", 26),
            new SVTokenId("FINALLY", "keyword", 27),
            new SVTokenId("FLOAT", "keyword", 28),
            new SVTokenId("FOR", "keyword", 29),
            new SVTokenId("GOTO", "keyword", 30),
            new SVTokenId("IF", "keyword", 31),
            new SVTokenId("IMPLEMENTS", "keyword", 32),
            new SVTokenId("IMPORT", "keyword", 33),
            new SVTokenId("INSTANCEOF", "keyword", 34),
            new SVTokenId("INT", "keyword", 35),
            new SVTokenId("INTERFACE", "keyword", 36),
            new SVTokenId("LONG", "keyword", 37),
            new SVTokenId("NATIVE", "keyword", 38),
            new SVTokenId("NEW", "keyword", 39),
            new SVTokenId("NULL", "keyword", 40),
            new SVTokenId("PACKAGE", "keyword", 41),
            new SVTokenId("PRIVATE", "keyword", 42),
            new SVTokenId("PROTECTED", "keyword", 43),
            new SVTokenId("PUBLIC", "keyword", 44),
            new SVTokenId("RETURN", "keyword", 45),
            new SVTokenId("SHORT", "keyword", 46),
            new SVTokenId("STATIC", "keyword", 47),
            new SVTokenId("STRICTFP", "keyword", 48),
            new SVTokenId("SUPER", "keyword", 49),
            new SVTokenId("SWITCH", "keyword", 50),
            new SVTokenId("SYNCHRONIZED", "keyword", 51),
            new SVTokenId("THIS", "keyword", 52),
            new SVTokenId("THROW", "keyword", 53),
            new SVTokenId("THROWS", "keyword", 54),
            new SVTokenId("TRANSIENT", "keyword", 55),
            new SVTokenId("TRUE", "keyword", 56),
            new SVTokenId("TRY", "keyword", 57),
            new SVTokenId("VOID", "keyword", 58),
            new SVTokenId("VOLATILE", "keyword", 59),
            new SVTokenId("WHILE", "keyword", 60),
            new SVTokenId("INTEGER_LITERAL", "literal", 61),
            new SVTokenId("DECIMAL_LITERAL", "literal", 62),
            new SVTokenId("HEX_LITERAL", "literal", 63),
            new SVTokenId("OCTAL_LITERAL", "literal", 64),
            new SVTokenId("FLOATING_POINT_LITERAL", "literal", 65),
            new SVTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 66),
            new SVTokenId("DECIMAL_EXPONENT", "number", 67),
            new SVTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 68),
            new SVTokenId("HEXADECIMAL_EXPONENT", "number", 69),
            new SVTokenId("CHARACTER_LITERAL", "literal", 70),
            new SVTokenId("STRING_LITERAL", "literal", 71),
            new SVTokenId("IDENTIFIER", "identifier", 72),
            new SVTokenId("LETTER", "literal", 73),
            new SVTokenId("PART_LETTER", "literal", 74),
            new SVTokenId("LPAREN", "operator", 75),
            new SVTokenId("RPAREN", "operator", 76),
            new SVTokenId("LBRACE", "operator", 77),
            new SVTokenId("RBRACE", "operator", 78),
            new SVTokenId("LBRACKET", "operator", 79),
            new SVTokenId("RBRACKET", "operator", 80),
            new SVTokenId("SEMICOLON", "operator", 81),
            new SVTokenId("COMMA", "operator", 82),
            new SVTokenId("DOT", "operator", 83),
            new SVTokenId("AT", "operator", 84),
            new SVTokenId("ASSIGN", "operator", 85),
            new SVTokenId("LT", "operator", 86),
            new SVTokenId("BANG", "operator", 87),
            new SVTokenId("TILDE", "operator", 88),
            new SVTokenId("HOOK", "operator", 89),
            new SVTokenId("COLON", "operator", 90),
            new SVTokenId("EQ", "operator", 91),
            new SVTokenId("LE", "operator", 92),
            new SVTokenId("GE", "operator", 93),
            new SVTokenId("NE", "operator", 94),
            new SVTokenId("SC_OR", "operator", 95),
            new SVTokenId("SC_AND", "operator", 96),
            new SVTokenId("INCR", "operator", 97),
            new SVTokenId("DECR", "operator", 98),
            new SVTokenId("PLUS", "operator", 99),
            new SVTokenId("MINUS", "operator", 100),
            new SVTokenId("STAR", "operator", 101),
            new SVTokenId("SLASH", "operator", 102),
            new SVTokenId("BIT_AND", "operator", 103),
            new SVTokenId("BIT_OR", "operator", 104),
            new SVTokenId("XOR", "operator", 105),
            new SVTokenId("REM", "operator", 106),
            new SVTokenId("LSHIFT", "operator", 107),
            new SVTokenId("PLUSASSIGN", "operator", 108),
            new SVTokenId("MINUSASSIGN", "operator", 109),
            new SVTokenId("STARASSIGN", "operator", 110),
            new SVTokenId("SLASHASSIGN", "operator", 111),
            new SVTokenId("ANDASSIGN", "operator", 112),
            new SVTokenId("ORASSIGN", "operator", 113),
            new SVTokenId("XORASSIGN", "operator", 114),
            new SVTokenId("REMASSIGN", "operator", 115),
            new SVTokenId("LSHIFTASSIGN", "operator", 116),
            new SVTokenId("RSIGNEDSHIFTASSIGN", "operator", 117),
            new SVTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 118),
            new SVTokenId("ELLIPSIS", "operator", 119),
            new SVTokenId("RUNSIGNEDSHIFT", "operator", 120),
            new SVTokenId("RSIGNEDSHIFT", "operator", 121),
            new SVTokenId("GT", "operator", 122)
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
        return "text/x-verilog";
    }

}

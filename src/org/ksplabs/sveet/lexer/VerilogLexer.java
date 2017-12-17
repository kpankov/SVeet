/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ksplabs.sveet.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.ksplabs.sveet.jcclexer.JavaCharStream;
import org.ksplabs.sveet.jcclexer.JavaParserTokenManager;
import org.ksplabs.sveet.jcclexer.Token;

/**
 *
 * @author kpankov
 */
public class VerilogLexer implements Lexer<VerilogTokenId> {

    private LexerRestartInfo<VerilogTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;

    VerilogLexer(LexerRestartInfo<VerilogTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        javaParserTokenManager = new JavaParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<VerilogTokenId> nextToken() {
        Token token = javaParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(VerilogLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}

/**
 * @author Konstantin Pankov <kspzel@gmail.com>
 * @date 26.02.2019
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
public class SVLexer implements Lexer<SVTokenId> {

    private LexerRestartInfo<SVTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;

    SVLexer(LexerRestartInfo<SVTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        javaParserTokenManager = new JavaParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<SVTokenId> nextToken() {
        Token token = javaParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(SVLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}

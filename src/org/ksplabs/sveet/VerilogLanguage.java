package org.ksplabs.sveet;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;
import org.ksplabs.sveet.lexer.SVTokenId;
import org.ksplabs.sveet.parser.SVParser;

@LanguageRegistration(mimeType = "text/x-verilog")
public class VerilogLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return SVTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Verilog";
    }

    @Override
    public Parser getParser() {
        return new SVParser();
    }

}

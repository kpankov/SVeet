package org.ksplabs.sveet;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.ksplabs.sveet.lexer.SVTokenId;

@LanguageRegistration(mimeType = "text/x-systemverilog")
public class SystemVerilogLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return SVTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "System Verilog";
    }

}

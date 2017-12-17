package org.ksplabs.sveet;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.ksplabs.sveet.lexer.VerilogTokenId;

@LanguageRegistration(mimeType = "text/x-verilog")
public class VerilogLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return VerilogTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Verilog";
    }

}

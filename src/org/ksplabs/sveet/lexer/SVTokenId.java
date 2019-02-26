/**
 * @author Konstantin Pankov <kspzel@gmail.com>
 * @date 26.02.2019
 */

package org.ksplabs.sveet.lexer;

import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.Language;


/**
 *
 * @author kpankov
 */
public class SVTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    SVTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public static Language<SVTokenId> getLanguage() {
        return new SVLanguageHierarchy().language();
    }
}

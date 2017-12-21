/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ksplabs.sveet.parser;

import java.util.Collection;
import java.util.Collections;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.TaskFactory;

/**
 *
 * @author kpankov
 */
@MimeRegistration(mimeType="text/x-verilog",service=TaskFactory.class)
public class SVSyntaxErrorHighlightingTaskFactory extends TaskFactory {
    
    @Override
    public Collection create (Snapshot snapshot) {
        return Collections.singleton (new SVSyntaxErrorHighlightingTask());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ksplabs.sveet;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@Messages({
    "LBL_SystemVerilogHeader_LOADER=Files of SystemVerilogHeader"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_SystemVerilogHeader_LOADER",
        mimeType = "text/x-systemverilog",
        extension = {"svh"}
)
@DataObject.Registration(
        mimeType = "text/x-systemverilog",
        iconBase = "org/ksplabs/sveet/SystemVerilogHeader.png",
        displayName = "#LBL_SystemVerilogHeader_LOADER",
        position = 300
)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-systemverilog/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class SystemVerilogHeaderDataObject extends MultiDataObject {

    public SystemVerilogHeaderDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-systemverilog", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(
            displayName = "#LBL_SystemVerilogHeader_EDITOR",
            iconBase = "org/ksplabs/sveet/SystemVerilogHeader.png",
            mimeType = "text/x-systemverilog",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "SystemVerilogHeader",
            position = 1000
    )
    @Messages("LBL_SystemVerilogHeader_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }

}

package com.plugin.intellj_ide.component;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.extensions.PluginAware;
import com.intellij.openapi.extensions.PluginDescriptor;
import com.plugin.intellj_ide.action.MyAction;
import org.jetbrains.annotations.NotNull;

public class MyPluginComponent implements PluginAware, EditorFactoryListener {

    @Override
    public void editorCreated(EditorFactoryEvent event) {
        ActionManager actionManager = ActionManager.getInstance();
        AnAction myAction = new MyAction();
        actionManager.registerAction("MyPlugin.MyAction", myAction);
        // Register our action with the action manager
        DefaultActionGroup contextMenu = (DefaultActionGroup) actionManager.getAction("EditorPopupMenu");
        contextMenu.add(myAction);
    }

    @Override
    public void setPluginDescriptor(@NotNull PluginDescriptor pluginDescriptor) {

    }
}

package com.plugin.intelljideplugin.component;

import com.intellij.ide.AppLifecycleListener;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.extensions.PluginAware;
import com.intellij.openapi.extensions.PluginDescriptor;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerListener;
import com.plugin.intelljideplugin.action.MyAction;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyPluginComponent implements PluginAware, AppLifecycleListener {
    private static final String MENU_ID = "MyPlugin.Menu";

    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
        ActionManager actionManager = ActionManager.getInstance();
        DefaultActionGroup menu = new DefaultActionGroup("MyPlugin", true);

        AnAction myAction = new MyAction();
        menu.add(myAction);
        actionManager.registerAction(MENU_ID, menu);
    }

    @Override
    public void setPluginDescriptor(@NotNull PluginDescriptor pluginDescriptor) {
        // Register our action with the action manager
        ActionManager actionManager = ActionManager.getInstance();
        AnAction myAction = new MyAction();
        DefaultActionGroup contextMenu = (DefaultActionGroup) actionManager.getAction("EditorPopupMenu");
        contextMenu.add(myAction);
    }
}

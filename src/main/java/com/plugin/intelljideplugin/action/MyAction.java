package com.plugin.intelljideplugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class MyAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // Get the selected element from the context
        PsiElement psiElement = e.getData(LangDataKeys.PSI_ELEMENT);
        if (psiElement != null) {
            // Show a message with the selected element's name
            Project project = psiElement.getProject();
            Messages.showMessageDialog(project, psiElement.getClass().getName(), "Selected Element", Messages.getInformationIcon());
        }
    }
}

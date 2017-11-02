package net.serenitybdd.plugins.jira.guice;

import com.google.inject.name.Names;
import net.serenitybdd.plugins.jira.workflow.ClasspathWorkflowLoader;
import net.thucydides.core.guice.ThucydidesModule;
import net.serenitybdd.plugins.jira.model.IssueTracker;
import net.serenitybdd.plugins.jira.service.JIRAConfiguration;
import net.serenitybdd.plugins.jira.service.JiraIssueTracker;
import net.serenitybdd.plugins.jira.service.SystemPropertiesJIRAConfiguration;
import net.serenitybdd.plugins.jira.workflow.WorkflowLoader;
import net.serenitybdd.plugins.jira.zephyr.client.ZephyrClient;
import net.serenitybdd.plugins.jira.zephyr.client.ZephyrRestClient;

public class ThucydidesJiraModule extends ThucydidesModule {

    @Override
    protected void configure() {
        super.configure();
        bind(IssueTracker.class).to(JiraIssueTracker.class);
        bind(JIRAConfiguration.class).to(SystemPropertiesJIRAConfiguration.class);
        bind(WorkflowLoader.class).to(ClasspathWorkflowLoader.class);
        bind(ZephyrClient.class).to(ZephyrRestClient.class);

        bindConstant().annotatedWith(Names.named("defaultWorkflow")).to("jira-workflow.groovy");
    }
}

package com.epam.support;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.epam.process.PaymentProcessorTest;

public class ICanProcessPayment extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass())));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new PaymentProcessorTest());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("stories/i_can_process_a_payment.story");
    }

}

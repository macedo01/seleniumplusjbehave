import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TrianguloTest extends JUnitStories {

    @Override
    public Configuration configuration() {
        Keywords keywords = new LocalizedKeywords(new Locale("pt"));
        return new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats().withFormats(Format.CONSOLE,
                                Format.TXT, Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new TrianguloSteps());
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
                Arrays.asList("triangulo-steps.story"), Arrays.asList(""));
    }

    public TrianguloTest() {
        EmbedderControls embedderControls = configuredEmbedder().embedderControls();
        embedderControls.useStoryTimeouts("6000");
    }


}

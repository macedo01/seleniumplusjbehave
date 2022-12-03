import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import java.util.Locale;

public abstract class JbehaveAbstract extends JUnitStories {
    @Override
    public Configuration configuration() {
        Keywords keywords = new LocalizedKeywords(new Locale("pt"));
        return new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats().withFormats(Format.CONSOLE,
                                Format.TXT, Format.HTML));
    }
}

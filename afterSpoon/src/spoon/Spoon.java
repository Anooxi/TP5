package spoon;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import spoon.processor.ConstructorProcess;
import spoon.processor.LogProcess;
import spoon.processor.LoggerProcess;
public class Spoon {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(Spoon.class.getName());

    public static void main(String[] args) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("main")
        .what("main")
        .who("" + args.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        Launcher launcher = new Launcher();
        launcher.addInputResource("src");
        launcher.setSourceOutputDirectory("afterSpoon/src");
        // launcher.getEnvironment().setSourceClasspath(new String[]{"target/classes"});
        // launcher.setBinaryOutputDirectory("afterSpoon/classes");
        launcher.getEnvironment().setAutoImports(true);
        launcher.addProcessor(new LoggerProcess());
        launcher.addProcessor(new ConstructorProcess());
        launcher.addProcessor(new LogProcess());
        launcher.run();
    }
}
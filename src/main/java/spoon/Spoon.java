package spoon;

import spoon.processor.ConstructorProcess;
import spoon.processor.LogProcess;
import spoon.processor.LoggerProcess;

public class Spoon {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();

        launcher.addInputResource("src");
        launcher.setSourceOutputDirectory("afterSpoon/src");
        //launcher.getEnvironment().setSourceClasspath(new String[]{"target/classes"});
        //launcher.setBinaryOutputDirectory("afterSpoon/classes");
        launcher.getEnvironment().setAutoImports(true);

        launcher.addProcessor(new LoggerProcess());
        launcher.addProcessor(new ConstructorProcess());
        launcher.addProcessor(new LogProcess());

        launcher.run();
    }
}

package spoon.processor;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtConstructor;
public class ConstructorProcess extends AbstractProcessor<CtConstructor<?>> {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(ConstructorProcess.class.getName());

    @Override
    public void process(CtConstructor<?> ctConstructor) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("process")
        .what("process")
        .who("" + ctConstructor.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        String string = "";
        string = "try {\n" + ((((("fh = new FileHandler(\"logs.xml\");\n" + "} catch ( Exception e ){\n") + "e.printStackTrace();\n") + "}\n") + "fh.setFormatter(new XMLFormatter());\n") + "LOGGER.addHandler(fh);\n");
        CtCodeSnippetStatement constructor = getFactory().Code().createCodeSnippetStatement(string);
        ctConstructor.getBody().addStatement(1, constructor);
    }
}
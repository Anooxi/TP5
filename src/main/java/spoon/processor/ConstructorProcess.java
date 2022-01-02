package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtConstructor;

public class ConstructorProcess extends AbstractProcessor<CtConstructor<?>> {

    @Override
    public void process(CtConstructor<?> ctConstructor) {
        String string = "";

        string = "try {\n" +
                "fh = new FileHandler(\"logs.xml\");\n" +
                "} catch ( Exception e ){\n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "fh.setFormatter(new XMLFormatter());\n" +
                "LOGGER.addHandler(fh);\n";

        CtCodeSnippetStatement constructor = getFactory().Code().createCodeSnippetStatement(string);
        ctConstructor.getBody().addStatement(1, constructor);
    }
}

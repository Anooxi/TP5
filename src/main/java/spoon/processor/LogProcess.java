package spoon.processor;

import logging.LPSBuilder;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtParameter;

import java.util.ArrayList;
import java.util.List;

public class LogProcess extends AbstractProcessor<CtExecutable<?>>{

    @Override
    public void process(CtExecutable<?> ctExecutable) {
        CtCodeSnippetStatement newLog = getFactory().Core().createCodeSnippetStatement();
        StringBuilder stringBuilder = new StringBuilder();
        List<CtParameter<?>> params = ctExecutable.getParameters();
        StringBuilder completeParam = new StringBuilder();
        completeParam.append("\"\"");
        for (CtParameter<?> ctParameter : params) {
            completeParam.append(" + ");
            completeParam.append(ctParameter.getSimpleName() + ".toString()");
        }
        if(!ctExecutable.getClass().getSimpleName().equals("CtConstructorImpl")){
            stringBuilder.append("LPSBuilder lpsBuilder = new LPSBuilder()\n" +
                    ".when(new Date().toString())\n" +
                    ".where(\"" + ctExecutable.getSimpleName() + "\")\n" +
                    ".what(\"" + ctExecutable.getSimpleName() + "\")\n" +
                    ".who(" + completeParam.toString() + ")\n" + // On ne sait pas comment attrapé les paramètres de la classe (ctField)
                    ");\n");
            stringBuilder.append("LOGGER.info(lpsBuilder.build().toString())");
            newLog.setValue(stringBuilder.toString());
            if(ctExecutable.getBody() != null){
                ctExecutable.getBody().insertBegin(newLog);
            }
        }

    }
}

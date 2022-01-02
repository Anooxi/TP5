package spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggerProcess extends AbstractProcessor<CtClass<?>> {
    @Override
    public void process(CtClass<?> ctClass) {
        // LOGGER
        CtTypeReference<Logger> logger = getFactory().Code().createCtTypeReference(Logger.class);
        CtField<Logger> field = getFactory().Core().createField();
        CtCodeSnippetExpression<Logger> code = getFactory().Code().createCodeSnippetExpression("Logger.getLogger(" + ctClass.getSimpleName() + ".class.getName())" );

        field.setType(logger);
        field.addModifier(ModifierKind.PRIVATE);
        field.addModifier(ModifierKind.STATIC);
        field.addModifier(ModifierKind.FINAL);
        field.setSimpleName("LOGGER");
        field.setDefaultExpression(code);

        //FILEHANDLER
        CtTypeReference<FileHandler> handler = getFactory().Code().createCtTypeReference(FileHandler.class);
        CtField<FileHandler> handlerField = getFactory().Core().createField();

        handlerField.setType(handler);
        handlerField.addModifier(ModifierKind.PUBLIC);
        handlerField.addModifier(ModifierKind.STATIC);
        handlerField.setSimpleName("fileHandler");

        ctClass.addFieldAtTop(field);
        ctClass.addFieldAtTop(handlerField);
    }
}

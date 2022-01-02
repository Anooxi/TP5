package spoon.processor;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;
public class LoggerProcess extends AbstractProcessor<CtClass<?>> {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(LoggerProcess.class.getName());

    @Override
    public void process(CtClass<?> ctClass) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("process")
        .what("process")
        .who("" + ctClass.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        // LOGGER
        CtTypeReference<Logger> logger = getFactory().Code().createCtTypeReference(Logger.class);
        CtField<Logger> field = getFactory().Core().createField();
        CtCodeSnippetExpression<Logger> code = getFactory().Code().createCodeSnippetExpression(("Logger.getLogger(" + ctClass.getSimpleName()) + ".class.getName())");
        field.setType(logger);
        field.addModifier(ModifierKind.PRIVATE);
        field.addModifier(ModifierKind.STATIC);
        field.addModifier(ModifierKind.FINAL);
        field.setSimpleName("LOGGER");
        field.setDefaultExpression(code);
        // FILEHANDLER
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
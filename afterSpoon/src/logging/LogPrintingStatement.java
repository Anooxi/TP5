package logging;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import models.User;
public class LogPrintingStatement {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(LogPrintingStatement.class.getName());

    private User who;

    private String when;

    private String where;

    private String what;

    public LogPrintingStatement(LPSBuilder lpsBuilder) {
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
        this.who = lpsBuilder.getWho();
        this.what = lpsBuilder.getWhat();
        this.where = lpsBuilder.getWhere();
        this.when = lpsBuilder.getWhen();
    }

    @Override
    public String toString() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("toString")
        .what("toString")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return (((((((((((("LogPrintingStatement{" + "who='") + who) + '\'') + ", when='") + when) + '\'') + ", where='") + where) + '\'') + ", what='") + what) + '\'') + '}';
    }
}
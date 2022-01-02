package logging;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import models.User;
public class LPSBuilder {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(LPSBuilder.class.getName());

    private User who;

    private String when;

    private String where;

    private String what;

    public LPSBuilder() {
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
    }

    public User getWho() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getWho")
        .what("getWho")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return who;
    }

    public String getWhen() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getWhen")
        .what("getWhen")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return when;
    }

    public String getWhere() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getWhere")
        .what("getWhere")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return where;
    }

    public String getWhat() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getWhat")
        .what("getWhat")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return what;
    }

    public LPSBuilder who(User who) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("who")
        .what("who")
        .who("" + who.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.who = who;
        return this;
    }

    public LPSBuilder when(String when) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("when")
        .what("when")
        .who("" + when.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.when = when;
        return this;
    }

    public LPSBuilder where(String where) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("where")
        .what("where")
        .who("" + where.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.where = where;
        return this;
    }

    public LPSBuilder what(String what) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("what")
        .what("what")
        .who("" + what.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.what = what;
        return this;
    }

    public LogPrintingStatement build() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("build")
        .what("build")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        LogPrintingStatement lps = new LogPrintingStatement(this);
        return lps;
    }
}
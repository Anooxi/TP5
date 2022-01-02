package logging;


import models.User;

public class LogPrintingStatement {
    private User who;
    private String when;
    private String where;
    private String what;

    public LogPrintingStatement(LPSBuilder lpsBuilder){
        this.who = lpsBuilder.getWho();
        this.what = lpsBuilder.getWhat();
        this.where = lpsBuilder.getWhere();
        this.when = lpsBuilder.getWhen();
    }

    @Override
    public String toString() {
        return "LogPrintingStatement{" +
                "who='" + who + '\'' +
                ", when='" + when + '\'' +
                ", where='" + where + '\'' +
                ", what='" + what + '\'' +
                '}';
    }
}

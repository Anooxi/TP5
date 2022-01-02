package logging;

import models.User;

public class LPSBuilder {
    private User who;
    private String when;
    private String where;
    private String what;

    public LPSBuilder(){

    }

    public User getWho() {
        return who;
    }

    public String getWhen() {
        return when;
    }

    public String getWhere() {
        return where;
    }

    public String getWhat() {
        return what;
    }

    public LPSBuilder who(User who){
        this.who = who;
        return this;
    }
    public LPSBuilder when(String when){
        this.when = when;
        return this;
    }
    public LPSBuilder where(String where){
        this.where = where;
        return this;
    }
    public LPSBuilder what(String what){
        this.what = what;
        return this;
    }

    public LogPrintingStatement build(){
        LogPrintingStatement lps = new LogPrintingStatement(this);
        return lps;
    }
}

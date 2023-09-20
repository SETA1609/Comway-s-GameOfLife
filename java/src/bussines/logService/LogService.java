package bussines.logService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.*;

public class LogService implements LogServiceInterface{
    private final Logger lgr;
    private ConsoleHandler ch;
    private FileHandler fh;

    public LogService(Class<?> currentClass)  {
        this.lgr = Logger.getLogger(currentClass.getName());
        LogManager.getLogManager().reset();
        lgr.setLevel(Level.ALL);
        ch= new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        lgr.addHandler(ch);
        try {
            fh = new FileHandler("java/resources/conwayLogs.txt",true);
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.INFO);
            lgr.addHandler(fh);
        }catch (IOException e){
            error("FileHandler funktioniert nicht!");
        }

    }

    @Override
    public void info(String message) {
        LocalDate currentDate =LocalDate.now();
        message= message+currentDate;
        lgr.log(Level.INFO, message);
    }



    @Override
    public void error(String message) {
        LocalDate currentDate =LocalDate.now();
        message= message+currentDate;
        lgr.log(Level.SEVERE, message);
    }
}

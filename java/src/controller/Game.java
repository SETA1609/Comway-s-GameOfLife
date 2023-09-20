package controller;

import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;
import bussines.menuService.MenuService;
import bussines.menuService.MenuServiceInterface;

public class Game implements GameInterface {
    private boolean isRunning;
    private final MenuServiceInterface menuServiceInterface ;
    private final LogServiceInterface logServiceInterface ;

    public Game() {
        menuServiceInterface= new MenuService();
        logServiceInterface= new LogService(Game.class);
        setRunning(true);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        logServiceInterface.info("Program was started at ");
      do {
        menuServiceInterface.getMenu();
        if (!menuServiceInterface.isActive()){
            close();
        }
      }while (isRunning);
    }

    @Override
    public void close() {
        logServiceInterface.info("Program was close at " );
        setRunning(false);
    }
}

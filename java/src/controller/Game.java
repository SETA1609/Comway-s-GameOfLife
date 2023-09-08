package controller;

import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;
import bussines.menuService.MenuService;
import bussines.menuService.MenuServiceInterface;

public class Game implements GameInterface {
    private boolean isRunning;
    private MenuServiceInterface menuServiceInterface = new MenuService();
    private LogServiceInterface logServiceInterface = new LogService();

    public Game() {
        setRunning(true);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void starten() {
      do {
        menuServiceInterface.getMenu();
        if (!menuServiceInterface.isActive()){
            enden();
        }
      }while (isRunning);
    }

    @Override
    public void enden() {
        setRunning(false);
    }
}

package controller;

import bussines.gridService.GridService;
import bussines.gridService.GridServiceInterface;
import bussines.infoService.InfoService;
import bussines.infoService.InfoServiceInterface;
import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;
import bussines.menuService.MenuService;
import bussines.menuService.MenuServiceInterface;

public class Game implements GameInterface {
    private boolean isRunning;
    private GridServiceInterface gridServiceInterface = new GridService();
    private InfoServiceInterface infoServiceInterface = new InfoService();
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

      }while (isRunning);
    }

    @Override
    public void enden() {
        setRunning(false);
    }
}

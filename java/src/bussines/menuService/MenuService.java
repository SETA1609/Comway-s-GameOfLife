package bussines.menuService;

import bussines.gridService.GridService;
import bussines.gridService.GridServiceInterface;
import bussines.infoService.InfoService;
import bussines.infoService.InfoServiceInterface;
import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;

import java.util.Scanner;

public class MenuService implements MenuServiceInterface{

    private InfoServiceInterface infoServiceInterface ;
    private GridServiceInterface gridServiceInterface ;
    private LogServiceInterface logServiceInterface ;
    private boolean isActive;
    public MenuService() {
        infoServiceInterface=new InfoService();
        gridServiceInterface=new GridService();
        logServiceInterface=new LogService();
        isActive=true;
    }

    @Override
    public void getMenu() {
        String[] options={
                "Welcome to Conway's game of life.",
                "Select one of the following options.",
                "1) Start a game of life.",
                "2) Info about the game of life and how to use this program",
                "3) close application",
                "Please give your selection: "
        };

        for (String option:options) {
            System.out.println(option);
        }
        Scanner scanner=new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1", "start" -> System.out.println("play game");
            case "2", "info" -> infoServiceInterface.getInfo();
            case "3", "close" -> setActive(false);
            default -> {
                System.out.println("Invalid input, please try again.");

                infoServiceInterface.getInfo();
            }
        }
    }


    @Override
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

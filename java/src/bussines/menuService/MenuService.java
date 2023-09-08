package bussines.menuService;

import bussines.gridService.GridService;
import bussines.gridService.GridServiceInterface;
import bussines.infoService.InfoService;
import bussines.infoService.InfoServiceInterface;
import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;

import java.util.Scanner;

public class MenuService implements MenuServiceInterface {

    private InfoServiceInterface infoServiceInterface;
    private GridServiceInterface gridServiceInterface;
    private LogServiceInterface logServiceInterface;
    private boolean isActive;

    public MenuService() {
        infoServiceInterface = new InfoService();
        gridServiceInterface = new GridService();
        logServiceInterface = new LogService();
        isActive = true;
    }

    @Override
    public void getMenu() {
        String[] options = {
                "Welcome to Conway's game of life.",
                "Select one of the following options.",
                "1) Start a game of life.",
                "2) Info about the game of life and how to use this program",
                "3) close application",
                "Please give your selection: "
        };

        printOptions(options);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1", "start" -> getGridMenu();
            case "2", "info" -> infoServiceInterface.getGameOfLifeInfo();
            case "3", "close" -> setActive(false);
            default -> {
                infoServiceInterface.getInputInfo();
                System.out.println("start, info or close.");
            }
        }
    }

    private void printOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }


    private void getGridMenu() {

        String[] options = {
                "1) Start a game of life.",
                "2) Start a game of life, multi generation.",
                "3) Information regarding this menu.",
                "4) Return to main menu"
        };
        printOptions(options);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1", "default" -> gridServiceInterface.getGrid();
                case "2", "generations" -> gridServiceInterface.getGridForANumberOfGenerations();
                case "3","info"-> infoServiceInterface.getGridInfo();
                case "4", "return" -> {
                    return;
                }
                default -> {
                    infoServiceInterface.getInputInfo();
                    System.out.println("default, generations, info or return");
                }
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

package bussines.menuService;

import bussines.gridService.GridService;
import bussines.gridService.GridServiceInterface;
import bussines.infoService.InfoService;
import bussines.infoService.InfoServiceInterface;
import bussines.logService.LogService;
import bussines.logService.LogServiceInterface;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MenuService implements MenuServiceInterface {

    private final InfoServiceInterface infoServiceInterface;
    private final GridServiceInterface gridServiceInterface;
    private final LogServiceInterface logServiceInterface;


    private boolean isActive;

    public MenuService() {
        infoServiceInterface = new InfoService();
        gridServiceInterface = new GridService();
        logServiceInterface = new LogService(MenuService.class);
        isActive = true;
    }

    @Override
    public void getMenu() {

        logServiceInterface.info("getMenu was called at " );

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

            case "3", "close" -> {
                logServiceInterface.info("Program was close at " );
                setActive(false);
            }
            default -> {
                logServiceInterface.info("a valid input was given to the program at " );
                infoServiceInterface.getInputInfo();
                System.out.println("start, info or close.");
            }
        }
    }

    private void printOptions(String[] options) {
        logServiceInterface.info("PrintOptions method was call at " );
        for (String option : options) {
            System.out.println(option);
        }
    }


    private void getGridMenu() {
        logServiceInterface.info("GetGridMenu was call at " );
        String[] options = {
                "1) Start a game of life.",
                "2) Start a game of life, multi generation.",
                "3) Information regarding this menu.",
                "4) Return to main menu"
        };


        Scanner scanner = new Scanner(System.in);

        while (true) {
            printOptions(options);
            String input = scanner.nextLine();
            switch (input) {
                case "1", "default" -> gridServiceInterface.startDefaultSimulation();
                case "2", "generations" -> gridServiceInterface.startMultigenerationSimulation();
                case "3", "info" -> infoServiceInterface.getGridInfo();
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

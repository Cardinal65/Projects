import java.io.File;
import java.io.IOException;
import java.lang.Object;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;
import java.util.Set;
import java.lang.String;

import static java.lang.Runtime.*;
import static java.nio.file.Files.isExecutable;
import static java.nio.file.Files.list;

public class GameCenter {

    private static String[] gamesList = new String[50];

    private static final String STEAMPATH = "C:\\Program Files (x86)\\Steam\\steamapps\\common";
    private static final String WIZPATH = "C:\\ProgramData\\KingsIsle Entertainment";

    private static String getType(String path) {
        int startIndex = 0;
        for(int i = 0; i < path.length(); i++) {
            int terminateChar = path.charAt(i);
            if(terminateChar == 46) {
                return path.substring(startIndex);
            } else {
                startIndex++;
            }
        }
        return "";
    }

    private static void execute(String path, String[] list) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] games = new String[10];
        for (int a = 0; a < 9; a++) {
            games[a] = "";
        }
        System.out.print("Which program would you like to run? ");
        String name = in.nextLine();
        int numFiles = 0;
        int num = 0;/*
        File currentDir = new File(path);
        File[] fileList = currentDir.listFiles();*/
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                int lengthOfString = name.length();
                if (lengthOfString <= list[i].length()) {
                    if (name.equals(list[i].substring(0, lengthOfString))) {
                        games[num] = list[i];
                        num++;
                        numFiles++;
                    }
                }
            }
        }
        if (numFiles > 1) {
            for (int j = 0; j < numFiles; j++) {
                System.out.println(j + 1 + ": " + games[j].substring(0, 1).toUpperCase() + games[j].substring(1));
            }
            System.out.print("Which number? ");
            int number = in.nextInt();
            name = games[number - 1];
        } else {
            name = games[0];
        }
        if (name.equals("wizard101") || name.equals("Wizard101")) {
            path = WIZPATH;
        }
        File newDir = new File(path + "\\" + name);
        File[] files = newDir.listFiles();
        for (int k = 0; k < files.length; k++) {
            if (getType(files[k].getName()).equals(".exe")) {
                System.out.println(path + "\\" + name + "\\" + files[k].getName());
                getRuntime().exec(path + "\\" + name + "\\" + files[k].getName(), null, new File(path + "\\" + name));
            }
        }
    }

    public static void printGames(String inputPath) {
        int num = 0;
        File folder = new File(inputPath);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isDirectory()) {
                String path = inputPath + "\\" + listOfFiles[i].getName();
                File currentDir = new File(path);
                File[] fileList = currentDir.listFiles();
                for (int j = 0; j < fileList.length; j++) {
                    if (getType(fileList[j].getName()).equals(".exe")) {
                        System.out.println(listOfFiles[i].getName());
                        gamesList[num] = listOfFiles[i].getName().toLowerCase();
                        num++;
                        break;
                    } else if (fileList[j].isDirectory()) {
                        File file = new File(path + "\\" + fileList[j].getName());
                        File[] newList = file.listFiles();
                        for (int k = 0; k < newList.length; k++) {
                            if (getType(newList[k].getName()).equals(".exe")) {
                                System.out.println(fileList[j].getName());
                                gamesList[num] = fileList[j].getName().toLowerCase();
                                num++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String [] args) throws IOException {

        printGames(STEAMPATH);
        printGames(WIZPATH);

        execute(STEAMPATH, gamesList);
    }
}
package com.billyfebrian.input;

import static com.billyfebrian.constant.CanvasDrawerConstant.Command.PREFIX;
import static com.billyfebrian.constant.CanvasDrawerConstant.Command.QUIT;
import static com.billyfebrian.constant.CanvasDrawerConstant.SPACE;

import com.billyfebrian.handler.CommandHandler;
import com.billyfebrian.handler.CommandHandlerImpl;
import java.util.Scanner;

public class CommandScannerImpl implements CommandScanner {

    private CommandHandler commandHandler;

    public CommandScannerImpl(){
        commandHandler = new CommandHandlerImpl();
    }

    @Override
    public void getCommand() {
        Scanner scanner = new Scanner(System.in);
        String[] commands;

        do {
            System.out.print(PREFIX);
            commands = splitCommands(scanner.nextLine());
            if (!QUIT.equals(commands[0])) {
                commandHandler.handle(commands);
            }
        }while (!commands[0].equals(QUIT));
    }

    private String[] splitCommands(String command){
        return command.split(SPACE);
    }
}

package com.billyfebrian;

import com.billyfebrian.input.CommandScanner;
import com.billyfebrian.input.CommandScannerImpl;

public class Application {

    private static CommandScanner commandScanner;

    public static void main(String[] args) {
        initComponent();
        commandScanner.getCommand();
    }

    private static void initComponent() {
        commandScanner = new CommandScannerImpl();
    }
}

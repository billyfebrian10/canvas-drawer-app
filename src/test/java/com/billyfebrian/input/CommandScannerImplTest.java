package com.billyfebrian.input;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.billyfebrian.handler.CommandHandler;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandScannerImplTest {

    @Mock
    private CommandHandler commandHandler;

    @InjectMocks
    private CommandScannerImpl commandScanner = new CommandScannerImpl();

    @Test
    public void getCommand_expectCallCommandHandler_whenCommandIsNotQ() {
        InputStream inputStream = System.in;
        String input = "C 20 4\nQ";
        ByteArrayInputStream in =  new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        commandScanner.getCommand();
        ArgumentCaptor<String[]> captor = ArgumentCaptor.forClass(String[].class);
        verify(commandHandler).handle(captor.capture());
        System.setIn(inputStream);
    }

    @Test
    public void getCommand_expectCallCommandHandler_whenMultipleCommandIsNotQ() {
        InputStream inputStream = System.in;
        String input = "C 20 4\nL 6 2 6 3\nQ";
        ByteArrayInputStream in =  new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        commandScanner.getCommand();
        ArgumentCaptor<String[]> captor = ArgumentCaptor.forClass(String[].class);
        verify(commandHandler, times(2)).handle(captor.capture());
        System.setIn(inputStream);
    }

}
package com.advaita.reports;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleCapture {

    private ByteArrayOutputStream consoleOutput;
    private PrintStream originalErr;

    public void startCapture() {
        consoleOutput = new ByteArrayOutputStream();
        originalErr = System.err;  // Save the original System.err stream
        System.setErr(new PrintStream(consoleOutput));  // Redirect System.err to consoleOutput
    }

    public String stopCapture() {
        System.setErr(originalErr);  // Restore the original System.err stream
        return consoleOutput.toString();  // Get the captured output as a string
    }
}

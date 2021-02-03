import behaviours.IOutput;
import device_management.Computer;
import device_management.Monitor;
import device_management.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerTest {
    Computer computer;
    Monitor monitor;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        computer = new Computer(8, 512, monitor);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

    @Test
    public void hasOutputDevice(){
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void canOutputDataViaPrinter() {
        Printer printer = new Printer("HP", "SauceInk", 300, 2);
        computer = new Computer(16, 512, printer);
        String outputtedData = computer.outputData("CV");
        assertEquals("printing: CV", outputtedData);
    }

    @Test
    public void canSwitchOutoutDevice() {
        Printer printer = new Printer("HP", "SauceInk", 300, 2);
        computer.setOutputDevice(printer);
        String outputtedData = computer.outputData("CV");
        assertEquals("printing: CV", outputtedData);
    }

}

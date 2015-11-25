package by.pvt.electricdevice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SomeClass {

	public static Logger log = Logger.getLogger(SomeClass.class.getName());

	public void someMethods() {
		log.info("some message");

	}
}

package org.example.filemanager;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class Manager {
    protected String destinationPath;
    protected static Logger logger = Logger.getLogger(Manager.class.getName());

    public void setDestinationPath(String path) {
        destinationPath = path;
    }
}

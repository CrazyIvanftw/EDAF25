package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import data.Slot;

//TODO move to another package
// Moved to data package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    // Object should be a hitherto unimplemented data.Slot
    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                // TODO
                //Slot slot = new Slot();
                //slot.insert(string.substring(i+1, string.length()-i));
                //map.put(string.substring(0, i-1), slot )
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}

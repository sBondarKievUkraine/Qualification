import com.bondar.common.entities.Transaction;
import com.bondar.common.XmlReader;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class XmlReaderTest {

    @Test
    public void readDataFromFileTest() throws IOException, SAXException, ParserConfigurationException {
        XmlReader xmlReader = new XmlReader();
        Document document = null;
        document = xmlReader.readDocFromFile();
        Assert.assertNotEquals(null, document);
    }

    @Test
    public void getListFromFileTest() throws IOException, SAXException, ParserConfigurationException {
        XmlReader xmlReader = new XmlReader();
        List<Transaction> listFromFile = xmlReader.getListFromFile();
        Assert.assertNotEquals(null, listFromFile);
        for (Transaction t : listFromFile) {
            Assert.assertNotEquals(null, t.getCard());
        }
    }
}
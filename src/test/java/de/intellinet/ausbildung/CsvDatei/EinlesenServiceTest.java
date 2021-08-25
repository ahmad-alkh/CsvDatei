
package de.intellinet.ausbildung.CsvDatei;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class EinlesenServiceTest {

    @Test
    public void importCsvTest() throws IOException {
        EinlesenService einlesenService = new EinlesenService();
        List<Person> ergebnis = einlesenService.importCsv("src/test/resources/kunden.csv");
        assertEquals(3, ergebnis.size());
        assertEquals("Hans", ergebnis.get(0).getName());
        assertEquals("Müller", ergebnis.get(0).getVorname());
        assertEquals("Augustinusstr.", ergebnis.get(0).getStrasse());
        assertEquals("9b", ergebnis.get(0).getHausnummer());
        assertEquals("50226", ergebnis.get(0).getPlz());
        assertEquals("Frechen", ergebnis.get(0).getOrt());

        assertEquals("Ahmad", ergebnis.get(1).getName());
        assertEquals("Alk", ergebnis.get(1).getVorname());
        assertEquals("Gottlieb-Daimler-Str.", ergebnis.get(1).getStrasse());
        assertEquals("22", ergebnis.get(1).getHausnummer());
        assertEquals("50226", ergebnis.get(1).getPlz());
        assertEquals("Frechen", ergebnis.get(1).getOrt());

        assertEquals("Wilhemine", ergebnis.get(2).getName());
        assertEquals("Meyer", ergebnis.get(2).getVorname());
        assertEquals("Fürst Albert Boulevard", ergebnis.get(2).getStrasse());
        assertEquals("1", ergebnis.get(2).getHausnummer());
        assertEquals("05523", ergebnis.get(2).getPlz());
        assertEquals("Dresden", ergebnis.get(2).getOrt());
    }

}

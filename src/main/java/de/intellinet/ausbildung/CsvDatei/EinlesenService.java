package de.intellinet.ausbildung.CsvDatei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * 
 */

/**
 * @author aakh1
 *
 */
public class EinlesenService {

	public List<Person> importCsv(String filename) throws IOException {
		List<Person> data = new ArrayList<Person>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filename));
			CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT //
//					.withHeader("name", "vorname", "strasse", "hausnummer", "plz", "ort") //
					.withFirstRecordAsHeader() // hier wird die erste line als Standert Kopf
					.withIgnoreHeaderCase() //
					.withSkipHeaderRecord() //
					.withTrim());

			data = bearbeitungDatei(csvParser);

		} catch (IOException e) {
//				
			throw new RuntimeException("Fehler beim Schliessen des Reader ", e);
		} finally {
			if (br != null)
				br.close();
		}

		return data;
	}

	/**
	 * @param data
	 * @param csvParser
	 * @param csvSplitBy
	 * @throws IOException
	 */
	private List<Person> bearbeitungDatei(CSVParser csvParser) throws IOException {

		List<Person> data = new ArrayList<Person>();

		Person person;
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get("name");
			String vorname = csvRecord.get("vorname");
			String strasse = csvRecord.get("strasse");
			String hausnummer = csvRecord.get("hausnummer");
			String plz = csvRecord.get("plz");
			String ort = csvRecord.get("ort");
			person = new Person();
			person.setName(name);
			person.setVorname(vorname);
			person.setStrasse(strasse);
			person.setHausnummer(hausnummer);
			person.setPlz(plz);
			person.setOrt(ort);

			data.add(person);
		}
		return data;
	}

}

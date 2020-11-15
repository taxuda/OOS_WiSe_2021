package oos.praktikum.NutzerverwaltungOhnePersistenz02;

public interface BenutzerVerwaltung {
    /**
     * Diese Methode eintragt Parameterobjekt in eine Datenhaltung.
     * @param benutzer wird in eine Datenhaltung eingetragen.
     */
    void benutzerEintragen(Benutzer benutzer) throws BenutzerVerwaltungException;

    /**
     * Diese Methode überprüft, ob das Parameterobjekt
     * in der Datenhaltung vorhanden ist.
     * @param benutzer wird überprüft.
     * @return true, falls das Parameterobjekt in der Datenhaltung vorhanden ist
     * sonst false.
     */
    boolean benutzerVorhanden(Benutzer benutzer) throws NumberFormatException;
}

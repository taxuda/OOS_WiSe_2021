package oos.praktikum.NutzerverwaltungOhnePersistenz02;

public interface BenutzerVerwaltung {
    abstract void benutzerEintragen(Benutzer benutzer);
    abstract boolean benutzerVorhanden(Benutzer benutzer);
}

package domein;

import persistentie.PersistentieController;

public class ContinentService {
//    private ContinentService;
    

    private PersistentieController pc;
    private static final int PER_1000_INWONERS = 1000;

    public ContinentService(){
        this(new PersistentieController());
    }
    public ContinentService(PersistentieController _pc){
        pc = _pc;
    }
    
    public double geefGeboorteOverschot(String continent) {
        if (continent == null || continent.trim().isEmpty()) {
            throw new IllegalArgumentException("continent moet ingevuld zijn");
        }
//        PersistentieController persistentieController
//                = new PersistentieController();
        long aantalInwoners = pc.findAantalBewoners(continent);
        if (aantalInwoners <= 0) {
            throw new IllegalArgumentException("geen inwoners gevonden voor gegeven continent");
        }

        long aantalSterfgevallen = pc.findSterfteCijfer(continent);
        if (aantalSterfgevallen < 0) {
            throw new IllegalArgumentException("geen sterfte cijfer gevonden voor gegeven continent");
        }
        long aantalGeboorten = pc.findGeboortecijfers(continent);
    if (aantalGeboorten < 0) {
            throw new IllegalArgumentException("geboorteCijfer kleiner dan nul");
        }
        double geboortecijfer = (double) aantalGeboorten / aantalInwoners * PER_1000_INWONERS;
        double sterftecijfer = (double) aantalSterfgevallen / aantalInwoners * PER_1000_INWONERS;
        
        return geboortecijfer - sterftecijfer;
    }
}

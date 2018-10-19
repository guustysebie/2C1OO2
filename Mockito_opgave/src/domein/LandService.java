package domein;

import persistentie.PersistentieController;

public class LandService {

    private PersistentieController persistentieController;

    public LandService() {  //REFACTORING
        this(new PersistentieController());
    }

    //CONSTRUCTOR INJECTION
    public LandService(PersistentieController persistentieController) {
        this.persistentieController = persistentieController;
    }

    public LandStatistiek geefLandStatistiek(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("code mag niet leeg zijn");
        }

        Land land = persistentieController.findLand(code);
        if (land == null) {
            return null;
        }

        int oppervlakteAlleLanden = persistentieController
                .findOppervlakteAlleLanden();
        double verhouding = (double) (land.getOppervlakte())
                / oppervlakteAlleLanden;
        return new LandStatistiek(code, verhouding);
    }
}

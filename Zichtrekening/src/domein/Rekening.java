/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author dzhem
 */
public class Rekening {
    String rekeningNummer;

    public Rekening(String rekeningNummer) {
        setRekeningNummer(rekeningNummer);
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }

    public void setRekeningNummer(String rekeningNummer) {//(06312512) modulo % (rest waarde) 97 moet getal 3 zijn
        //vb ()%97==g3 
        if(rekeningNummer==null||rekeningNummer.trim().isEmpty()){
            throw new IllegalArgumentException("Rekeningnummer niet ingevuld");
        }
        
        if(!rekeningNummer.matches("\\d{3}-\\d{7}-\\d{2}")){
            throw new IllegalArgumentException();
        }
        String[] parts = rekeningNummer.split("-");
        String getal = parts[0]+parts[1];
        long result = Long.parseLong(getal)%97;
        if(result==Long.parseLong(parts[2])){
            this.rekeningNummer=rekeningNummer;
        }else{
            throw new IllegalArgumentException(result + " was de result en de part 2 is " + parts[2]);
        }
    }
    
    
}

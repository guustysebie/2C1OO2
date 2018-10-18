package domein;

import java.math.BigDecimal;

public class Zichtrekening {

	private BigDecimal saldo = BigDecimal.ZERO;
        
        

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void storten(BigDecimal bedrag) {
		//throw new UnsupportedOperationException();
                if(bedrag == null || bedrag.signum() < 0 )
                {
                    throw new IllegalArgumentException();
                }
                
                    
            
                saldo = saldo.add(bedrag);
	}

}
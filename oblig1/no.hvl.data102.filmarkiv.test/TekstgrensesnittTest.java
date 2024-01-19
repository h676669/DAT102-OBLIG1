import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.klient.Tekstgrensesnitt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TekstgrensesnittTest {
    private Tekstgrensesnitt tekstgr;

    @Test
    public void test2(){
        tekstgr = new Tekstgrensesnitt();
        Film testfilm1 = new Film(10,2012,"test","test","test", Sjanger.TEST);
        tekstgr.skrivUtFilm(testfilm1);

    }
}

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FilmarkivTest {
    @Test
    public void test1() {
        Filmarkiv testFilmer = new Filmarkiv(10);
        Film testfilm1 = new Film(10,2012,"test","test","test");

        testFilmer.leggTilFilm(testfilm1);
    }

}

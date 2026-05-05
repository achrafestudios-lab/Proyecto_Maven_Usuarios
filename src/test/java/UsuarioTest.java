import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class UsuarioTest {

    // ─────────────────────────────────────────
    // TESTS DE USUARIO (CE1–CE3b)
    // ─────────────────────────────────────────

    @Test
    void ts1_registro_valido_CE1_CE5_CE16_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@b.c");
        assertTrue(u.validarRegistro());
    }

    @Test
    void ts2_registro_invalido_CE2_CE5_CE16_CE8() {
        Usuario u = new Usuario("abcd", "aB2c", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts3_registro_invalido_CE3_CE5_CE16_CE8() {
        Usuario u = new Usuario("aaaaabbbbbcccccd", "aB2c", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts4_registro_invalido_CE4_CE5_CE16_CE8() {
        Usuario u = new Usuario(null, "aB2c", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts6_registro_invalido_CE1_CE6_CE16_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 17, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts7_registro_valido_CE1_CE7_CE16_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 19, "a@b.c");
        assertTrue(u.validarRegistro());
    }

    @Test
    void ts12_registro_invalido_CE1_CE5_CE17_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts13_registro_invalido_CE1_CE5_CE18_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@b");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts14_registro_invalido_CE1_CE5_CE19_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts15_registro_invalido_CE1_CE5_CE20_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts16_registro_invalido_CE1_CE5_CE21_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "@");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts17_registro_invalido_CE1_CE5_CE22_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "@a.b");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts18_registro_invalido_CE1_CE5_CE24_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@b.");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts19_registro_invalido_CE1_CE5_CE25_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a.b");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts20_registro_invalido_CE1_CE5_CE26_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, ".a");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts21_registro_invalido_CE1_CE5_CE27_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts22_registro_invalido_CE1_CE5_CE28_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "a@b");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts23_registro_invalido_CE1_CE5_CE29_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, "@.");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts24_registro_invalido_CE1_CE5_CE30_CE8() {
        Usuario u = new Usuario("pepe1", "aB2c", 18, null);
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts25_registro_invalido_CE1_CE5_CE16_CE9() {
        Usuario u = new Usuario("pepe1", "A1", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts26_registro_invalido_CE1_CE5_CE16_CE10() {
        Usuario u = new Usuario("pepe1", "Abc123", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts27_registro_invalido_CE1_CE5_CE16_CE11() {
        Usuario u = new Usuario("pepe1", "abc2", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts28_registro_invalido_CE1_CE5_CE16_CE12() {
        Usuario u = new Usuario("pepe1", "AB1", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts29_registro_invalido_CE1_CE5_CE16_CE13() {
        Usuario u = new Usuario("pepe1", "AbCd", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts30_registro_invalido_CE1_CE5_CE16_CE14() {
        Usuario u = new Usuario("pepe1", "Ab@1", 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts31_registro_invalido_CE1_CE5_CE16_CE15() {
        Usuario u = new Usuario("pepe1", null, 18, "a@b.c");
        assertFalse(u.validarRegistro());
    }
}

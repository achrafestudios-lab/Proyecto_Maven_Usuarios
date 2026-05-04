import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class UsuarioTest {

    // ─────────────────────────────────────────
    // TESTS DE USUARIO (CE1–CE3b)
    // ─────────────────────────────────────────

    @Test
    void ts1_registro_valido_CE1_CE4_CE7_CE18() {
        // todos los campos válidos → validarRegistro() true
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "usuario@gmail.com");
        assertTrue(u.validarRegistro());
    }

    @Test
    void ts2_usuario_demasiado_corto_CE2_CE4_CE7_CE18() {
        // "Al" tiene 2 chars < 5 → validarUsuario() false
        Usuario u = new Usuario("Al", "Abcde1F2", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts3_usuario_demasiado_largo_CE3_CE4_CE7_CE18() {
        // "CarlosAlbertoGarcia" tiene 19 chars > 15 → validarUsuario() false
        Usuario u = new Usuario("CarlosAlbertoGarcia", "Abcde1F2", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts4_usuario_null_CE3b_CE4_CE7_CE18() {
        // usuario null → validarUsuario() false
        Usuario u = new Usuario(null, "Abcde1F2", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    // ─────────────────────────────────────────
    // TESTS DE EDAD (CE5–CE6)
    // ─────────────────────────────────────────

    @Test
    void ts6_edad_menor_de_18_CE1_CE5_CE7_CE18() {
        // edad 15 < 18 → validarEdad() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 15, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts7_edad_negativa_CE1_CE6_CE7_CE18() {
        // edad -1 < 18 → validarEdad() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", -1, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    // ─────────────────────────────────────────
    // TESTS DE CORREO (CE8–CE17b)
    // ─────────────────────────────────────────

    @Test
    void ts12_correo_sin_dominio_CE1_CE4_CE8_CE18() {
        // "usuario@" no tiene nada tras @ → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "usuario@");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts13_correo_sin_punto_CE1_CE4_CE9_CE18() {
        // "usuario@gmail" no tiene punto → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "usuario@gmail");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts14_correo_sin_subdominio_CE1_CE4_CE10_CE18() {
        // "usuario@.com" no tiene nada entre @ y punto → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "usuario@.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts15_correo_sin_arroba_CE1_CE4_CE11_CE18() {
        // "usuario" no tiene @ → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "usuario");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts16_correo_solo_arroba_CE1_CE4_CE12_CE18() {
        // "@" no cumple ninguna parte del patrón → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "@");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts17_correo_sin_parte_local_CE1_CE4_CE13_CE18() {
        // "@gmail.com" no tiene nada antes del @ → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts18_correo_solo_dominio_CE1_CE4_CE14_CE18() {
        // "gmail" no tiene @ ni punto → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "gmail");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts19_correo_sin_extension_CE1_CE4_CE15_CE18() {
        // "gmail." no tiene nada tras el punto → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "gmail.");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts20_correo_sin_arroba_con_punto_CE1_CE4_CE16_CE18() {
        // "gmail.com" tiene punto pero no @ → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, "gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts21_correo_empieza_por_punto_CE1_CE4_CE17_CE18() {
        // ".com" no tiene @ ni parte local → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, ".com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts22_correo_null_CE1_CE4_CE17b_CE18() {
        // correo null → validarCorreo() false
        Usuario u = new Usuario("LuisA", "Abcde1F2", 19, null);
        assertFalse(u.validarRegistro());
    }

    // ─────────────────────────────────────────
    // TESTS DE CONTRASEÑA (CE19–CE24)
    // ─────────────────────────────────────────

    @Test
    void ts23_contrasena_demasiado_corta_CE1_CE4_CE7_CE19() {
        // "Pass123" tiene 7 chars < 8 → validarContrasena() false
        Usuario u = new Usuario("LuisA", "Pass123", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts24_contrasena_un_solo_char_CE1_CE4_CE7_CE20() {
        // "X" tiene 1 char < 8 → validarContrasena() false
        Usuario u = new Usuario("LuisA", "X", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts25_contrasena_caracter_especial_CE1_CE4_CE7_CE21() {
        // "User_99" tiene '_' no alfanumérico → validarContrasena() false
        Usuario u = new Usuario("LuisA", "User_99", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts26_contrasena_sin_mayuscula_CE1_CE4_CE7_CE22() {
        // "pass123" no tiene ninguna mayúscula → validarContrasena() false
        Usuario u = new Usuario("LuisA", "pass123", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts27_contrasena_sin_minuscula_CE1_CE4_CE7_CE23() {
        // "PASS123" no tiene ninguna minúscula → validarContrasena() false
        Usuario u = new Usuario("LuisA", "PASS123", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }

    @Test
    void ts28_contrasena_sin_digito_CE1_CE4_CE7_CE24() {
        // "Password" no tiene ningún dígito → validarContrasena() false
        Usuario u = new Usuario("LuisA", "Password", 19, "usuario@gmail.com");
        assertFalse(u.validarRegistro());
    }
}

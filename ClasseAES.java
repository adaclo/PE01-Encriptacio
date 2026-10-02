import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ClasseAES {
    public String encripta(String missatge, String clau) {
        String res = "";
        try {
            // 1 i 2. Convertir la clau a bytes i crear la clau AES
            byte[] keyBytes = clau.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey =  new SecretKeySpec(keyBytes, "AES");
            
            // 3. Crear i configurar el Cipher en mode d'encriptació
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // 4 i 5. Convertir el missatge a bytes i xifrar-lo
            byte[] missatgeBytes = missatge.getBytes(StandardCharsets.UTF_8);
            byte[] xifratBytes = cipher.doFinal(missatgeBytes);
            
            // 6. Convertir el resultat xifrat a Base64 per retornar un String
            res = Base64.getEncoder().encodeToString(xifratBytes);
        } catch (Exception e) {
            System.out.println("(!) Error en l'encriptació: " + e.getMessage());
        }
        return res;
    }

    public String desencripta(String missatgeXifrat, String clau) {
        String res = "";
        try {
            // 1 i 2. Convertir la clau a bytes i crear la clau AES
            byte[] keyBytes = clau.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            
            // 3. Crear i configurar el Cipher en mode de desencriptació
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // 4 i 5. Convertir el missatge xifrat de Base64 a bytes i desencriptar-lo
            byte[] xifratBytes = Base64.getDecoder().decode(missatgeXifrat);
            byte[] desencriptatBytes = cipher.doFinal(xifratBytes);
            
            // 6. Convertir el resultat desencriptat a String
            res = new String(desencriptatBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("(!) Error en la desencriptació: " + e.getMessage());
        }
        return res;
    }
}

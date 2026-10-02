public class ProgramaPrincipalAES {

    public static void main(String[] args) {
        ProgramaPrincipalAES p = new ProgramaPrincipalAES();
        p.principal();
    }

    public void principal() {
        ClasseAES aes = new ClasseAES();
        String missatgeOriginal = "Aquest és un missatge secret.";
        String clau = "1234567890123456"; // 16 caràcters = 128 bits

        System.out.println("=== TEST CRIPTOGRAFIA AES ===");
        System.out.println("Missatge original: " + missatgeOriginal);
        System.out.println("Clau (16 caràcters): " + clau);

        // encriptar
        String missatgeXifrat = aes.encripta(missatgeOriginal, clau);
        System.out.println("Missatge xifrat (Base64): " + missatgeXifrat);

        // desencriptar
        String missatgeRecuperat = aes.desencripta(missatgeXifrat, clau);
        System.out.println("Missatge recuperat: " + missatgeRecuperat);

        // comprovació
        if (missatgeOriginal.equals(missatgeRecuperat)) {
            System.out.println("\n[RESULTAT] AES ha funcionat correctament!");
        } else {
            System.out.println("\n[RESULTAT] Error en el procés AES.");
        }
    }
}
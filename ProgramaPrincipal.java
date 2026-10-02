public class ProgramaPrincipal {

    public static void main(String[] args) {
        ProgramaPrincipal p = new ProgramaPrincipal();
        p.principal();
    }

    public void principal() {
        ClasseCriptografica c = new ClasseCriptografica();
        String missatge = "HOLA";
        String clau = "4";

        System.out.println("=== TEST CRIPTOGRAFIA (XIFRAT P+K) ===");
        System.out.println("Missatge original: " + missatge);
        System.out.println("Clau utilitzada: " + clau);

        String missatgeEncriptat = c.encripta(missatge, clau);
        System.out.println("Missatge encriptat: " + missatgeEncriptat);

        String missatgeDesencriptat = c.desencripta(missatgeEncriptat, clau);
        System.out.println("Missatge desencriptat: " + missatgeDesencriptat);

        if (missatge.equals(missatgeDesencriptat)) {
            System.out.println("\n[RESULTAT] Procés d'encriptació/desencriptació CORRECTE!");
        } else {
            System.out.println("\n[RESULTAT] Error en el procés.");
        }

        System.out.println("\n--- Prova amb clau incorrecta ---");
        String desencriptatErroni = c.desencripta(missatgeEncriptat, "7");
        System.out.println("Desencriptat amb clau 7: " + desencriptatErroni);
    }
}